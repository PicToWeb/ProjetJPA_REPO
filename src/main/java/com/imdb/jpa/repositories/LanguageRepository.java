package com.imdb.jpa.repositories;

import com.imdb.jpa.entities.MovieLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<MovieLanguage, Integer> {
}
