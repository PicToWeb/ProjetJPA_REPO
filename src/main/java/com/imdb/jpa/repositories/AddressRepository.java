package com.imdb.jpa.repositories;

import com.imdb.jpa.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {
}
