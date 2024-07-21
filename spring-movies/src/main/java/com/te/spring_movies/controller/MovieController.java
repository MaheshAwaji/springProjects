package com.te.spring_movies.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.spring_movies.dto.ActorDto;
import com.te.spring_movies.entity.Actor;
import com.te.spring_movies.entity.Language;
import com.te.spring_movies.entity.Movie;
import com.te.spring_movies.exception.ActorNotFoundException;
import com.te.spring_movies.service.ActorService;
import com.te.spring_movies.service.LanguageService;
import com.te.spring_movies.service.MovieService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/movie")
public class MovieController {
	private final ActorService actorService;
	private final LanguageService languageService;
	private final MovieService movieService;

	@GetMapping("/getActors")
	public List<Actor> getAllActors() {
		return actorService.getActors();

	}

	@GetMapping("/{id}")
	public ResponseEntity<ActorDto> getAllActorById(@PathVariable String id) {
		Optional<ActorDto> actorById = actorService.getActorById(id);
		return new ResponseEntity<ActorDto>(actorById.get(),HttpStatus.OK);
		

	}

	@PostMapping(path = "/addActor")
	public ResponseEntity<ActorDto> addActor(@RequestBody ActorDto actorDto) {
		ActorDto newActor = actorService.addNewActor(actorDto);
		return new ResponseEntity<>(newActor, HttpStatus.CREATED);

	}

	@DeleteMapping(path = "/deleteActor/{id}")
	public ResponseEntity<Void> deleteActor(@PathVariable String id) {
		Boolean deleteActor = actorService.deleteActor(id);
		if (deleteActor) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping(path = "/getLanguages")
	public List<Language> getAllLanguages() {
		return languageService.getAllLanguages();
	}

	@PostMapping("/addLanguage")
	public void addLanguage(@RequestBody Language language) {
		languageService.addNewLanguage(language);

	}

	@PostMapping(path = "/addMovie")
	public void addMovie(@RequestBody Movie movie) {
		movieService.addNewMovie(movie);
	}

}
