package com.te.spring_movies.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.spring_movies.entity.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {
	
	Optional<Language> findByName(String name);

}
