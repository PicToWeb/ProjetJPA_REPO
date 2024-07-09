package com.imdb.jpa.repositories;

import com.imdb.jpa.entities.Producer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProducerRepository extends JpaRepository<Producer, Integer> {
}