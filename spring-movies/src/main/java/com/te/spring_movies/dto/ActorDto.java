package com.te.spring_movies.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActorDto {
	private Integer actorId;
	private String name;
	private String dob;
	private List<MovieDto> movies;

}
