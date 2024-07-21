package com.te.spring_movies.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer movieId;
	private String title;
	private String industry;
	private LocalDate releaseYear;
	private Integer imdbRating;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Language language;
	
	@ManyToMany(mappedBy = "movies",cascade = CascadeType.ALL)
	private List<Actor> actors;

}
