package com.imdb.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Movie extends JpaRepository<Movie, Integer> {
}
