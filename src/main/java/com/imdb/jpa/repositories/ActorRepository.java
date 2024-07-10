package com.imdb.jpa.repositories;

import com.imdb.jpa.entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {

    Boolean existsById(String id);
}
