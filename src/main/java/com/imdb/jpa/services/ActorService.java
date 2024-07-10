package com.imdb.jpa.services;

import com.imdb.jpa.entities.Actor;
import com.imdb.jpa.entities.Address;
import com.imdb.jpa.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ActorService {

    private final ActorRepository actorRepository;
    private final AddressService addressService;

    @Autowired
    public ActorService(ActorRepository actorRepository,AddressService addressService) {
        this.actorRepository = actorRepository;
        this.addressService = addressService;
    }

    public void insert(Map<String,Actor> actorMap) {
        for (Actor a : actorMap.values()) {
            Boolean actor = actorRepository.existsById(a.getId());
            if(Boolean.FALSE.equals(actor)){
                Address address = addressService.existOrAdd(a.getAdress());
                a.setAdress(address);
                actorRepository.save(a);

            }
        }
    }

}
