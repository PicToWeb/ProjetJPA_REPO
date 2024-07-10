package com.imdb.jpa.services;

import com.imdb.jpa.entities.Country;
import com.imdb.jpa.repositories.CountryRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {

    private final CountryRepository countryRepository;
    @Autowired
    public CountryService(CountryRepository countryRepository) {this.countryRepository = countryRepository;}

    /**
     * countryList to store country data
     */
    List<Country> countryList = new ArrayList<>();

    @PostConstruct
    public void initData() {
        this.countryList = countryRepository.findAll();
    }

    /**
     * Finds a country by its name.
     *
     * @param country country.
     * @return Country object or null if not found.
     */
    public Country findByName(Country country) {
            return countryList.stream().filter(p -> p.getName() != null && p.getName().equals(country.getName())).findFirst().orElse(null);
    }

    public Country existOrAdd(Country country) {
        if (country != null && country.getName() != null) {
            Country countryFound = findByName(country);
            if (countryFound == null) {
                insert(country);
                return country;
            }
            return countryFound;
        }
        return null;
    }

    public void insert(Country country) {
        countryRepository.save(country);
        this.countryList.add(country);
    }

    public void insertList(List<Country> countryList) {
        countryList.forEach(c -> {
            if (!this.countryList.contains(c)) {
                countryRepository.save(c);
                this.countryList.add(c);
            }
        });
    }


}
