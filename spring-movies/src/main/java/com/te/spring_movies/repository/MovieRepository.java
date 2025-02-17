package com.te.spring_movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.spring_movies.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>   {

}
