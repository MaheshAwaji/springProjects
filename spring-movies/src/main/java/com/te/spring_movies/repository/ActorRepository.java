package com.te.spring_movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.spring_movies.entity.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {

}
