package com.imdb.jpa.repositories;

import com.imdb.jpa.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}
