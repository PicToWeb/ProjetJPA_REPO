package com.imdb.jpa.repositories;

import com.imdb.jpa.entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
}
