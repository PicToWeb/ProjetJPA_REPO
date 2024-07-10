package com.imdb.jpa.services.file;

import com.imdb.jpa.entities.Actor;
import com.imdb.jpa.entities.Country;
import com.imdb.jpa.services.ActorService;
import com.imdb.jpa.services.CountryService;
import com.imdb.jpa.services.parseCSV.ActorReader;
import com.imdb.jpa.services.parseCSV.CountryReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ImportFile {

    public final CountryService countryService;
    public final ActorService actorService;

    @Autowired
    public ImportFile(CountryService countryService, ActorService actorService) {
        this.countryService = countryService;
        this.actorService = actorService;
    }

    public void run() {
    countryService.insertList(countryFile("pays.csv"));
    actorService.insert(actorFile("acteurs.csv"));
    }

    public List<Country> countryFile(String url) {
        return CountryReader.readFile(url);
    }
    public Map<String, Actor> actorFile(String url){
        return ActorReader.readFile(url);
    }
}
