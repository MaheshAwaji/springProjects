package com.te.spring_movies.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.te.spring_movies.entity.Language;
import com.te.spring_movies.repository.LanguageRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LanguageService {
   private final LanguageRepository languageRepository;
	public List<Language> getAllLanguages() {
		return languageRepository.findAll();
	}
	public void addNewLanguage(Language language) {
		Optional<Language> languageByName = languageRepository.findByName(language.getName());
		
		if (languageByName.isPresent()) {
			throw new IllegalStateException("Language "+language.getName()+" already Exists");
		}else {
			languageRepository.save(language);
		}
	}

}
