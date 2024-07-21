package com.te.spring_movies.dto;

import java.time.LocalDate;
import java.util.List;

import com.te.spring_movies.entity.Language;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {
	private Integer movieId;
	private String title;
	private String industry;
	private LocalDate releaseYear;
	private Integer imdbRating;
	private Language language;
//	private List<ActorDto> actors;

}
