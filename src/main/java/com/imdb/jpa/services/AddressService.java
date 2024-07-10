package com.imdb.jpa.services;

import com.imdb.jpa.entities.Address;
import com.imdb.jpa.entities.Country;
import com.imdb.jpa.repositories.AddressRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final CountryService countryService;

    @Autowired
    public AddressService(AddressRepository addressRepository,CountryService countryService) {
        this.addressRepository = addressRepository;
        this.countryService = countryService;
    }

    /**
     * countryList to store country data
     */
    List<Address> addressList = new ArrayList<>();

    @PostConstruct
    public void initData() {
        this.addressList = addressRepository.findAll();
    }

    /**
     * Find an address in addressList by city and state.
     *
     * @param address The address to search for
     * @return The matching address or null if not found
     */
    public Address findByName(Address address) {
        return addressList.stream()
                .filter(l -> l.getCity() !=null && l.getCity().equals(address.getCity()))
                .filter(l -> l.getEtat() !=null && l.getEtat().equals(address.getEtat()))
                .findFirst().orElse(null);
    }

    public Address existOrAdd(Address address) {
        Address addressFound = findByName(address);
        if (addressFound == null) {
            Country country = countryService.existOrAdd(address.getCountry());
            address.setCountry(country);
            insert(address);
            return address;
        }
        return addressFound;
    }

    public void insert(Address address) {
            addressRepository.save(address);
            addressList.add(address);
    }
}
