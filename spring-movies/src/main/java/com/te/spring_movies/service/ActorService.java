package com.te.spring_movies.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.te.spring_movies.dto.ActorDto;
import com.te.spring_movies.dto.MovieDto;
import com.te.spring_movies.entity.Actor;
import com.te.spring_movies.entity.Language;
import com.te.spring_movies.entity.Movie;
import com.te.spring_movies.repository.ActorRepository;
import com.te.spring_movies.repository.LanguageRepository;
import com.te.spring_movies.repository.MovieRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ActorService {
	private final ActorRepository actorRepository;
	private final MovieRepository movieRepository;
	private final LanguageRepository languageRepository;

	public List<Actor> getActors() {
		return actorRepository.findAll();
	}

	public ActorDto addNewActor(ActorDto actorDto) {
		Actor actor = new Actor();
		List<Movie> movies = new ArrayList<>();

		actor.setActorId(actorDto.getActorId());
		actor.setDob(actorDto.getDob());
		actor.setName(actorDto.getName());

		for (MovieDto movieDto : actorDto.getMovies()) {

			Movie movie = new Movie();
			movie.setTitle(movieDto.getTitle());
			movie.setImdbRating(movieDto.getImdbRating());
			movie.setIndustry(movieDto.getIndustry());
			
			movie.setMovieId(movieDto.getMovieId());
			movie.setReleaseYear(movieDto.getReleaseYear());

			Language language=languageRepository.findByName(movieDto.getLanguage().getName()).
					orElseGet(()->{
						Language newLanguage=new Language();
						newLanguage.setName(movieDto.getLanguage().getName());
						return languageRepository.save(newLanguage);
						
					});
//			Language language=new Language();
//			language.setName(movieDto.getLanguage().getName());
//			languageRepository.save(language);
			
			movie.setLanguage(language);
			
			
			movieRepository.save(movie);
			movies.add(movie);

		}

		actor.setMovies(movies);
		actorRepository.save(actor);
		return actorDto;

	}

	public Boolean deleteActor(String id) {
		boolean actorExist = actorRepository.existsById(Integer.parseInt(id));
		if (actorExist) {
			actorRepository.deleteById(Integer.parseInt(id));
			return true;
			
		} else {
			return false;
		}

	}

	public Optional<ActorDto> getActorById(String id) {
		Optional<Actor> actor = actorRepository.findById(Integer.parseInt(id));
		ActorDto actorDto=new ActorDto();
		List<MovieDto> movies=new ArrayList<>();
		actorDto.setActorId(actor.get().getActorId());
		actorDto.setDob(actor.get().getDob());
		actorDto.setName(actor.get().getName());
		for(Movie movie:actor.get().getMovies()) {
			MovieDto movieDto=new MovieDto();
			BeanUtils.copyProperties(movie, movieDto);
			movies.add(movieDto);
		}
		actorDto.setMovies(movies);
		return Optional.ofNullable(actorDto);
		
	}

}
