package com.imdb.jpa.repositories;

import com.imdb.jpa.entities.MovieLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<MovieLanguage, Integer> {
}
