package com.te.spring_movies.service;

import org.springframework.stereotype.Service;

import com.te.spring_movies.entity.Movie;
import com.te.spring_movies.repository.MovieRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieService {
	private final MovieRepository movieRepository;
	public void addNewMovie(Movie movie) {
		movieRepository.save(movie);
		
	}

}
