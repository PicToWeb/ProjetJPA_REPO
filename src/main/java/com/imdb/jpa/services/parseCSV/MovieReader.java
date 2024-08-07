package com.imdb.jpa.services.parseCSV;

import com.imdb.jpa.entities.*;
import com.imdb.jpa.utils.FileSource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service
public abstract class MovieReader {

    /**
     * Static Method used to read each lines of Csv files
     *
     * First step : Call static Method (readFileToMapMovieReal) to process
     * film_realisateurs.csv and return a HashMap<id_movie,id_producer>
     * HashMap<id_movie,id_producer> (producerMoviesMap) Second Setp :
     * Second Step : Loop each lines from films.csv to return a Movie Object Third
     * step : Always in the loop, call a method to findProducerForMovie Four step:
     * add id_movie and movie in the return HashMap
     *
     * @param url    films.csv
     * @param urlDep film_realisateurs.csv
     * @return HashMap<String, Movie> whith producer added to movie
     */
//    public static HashMap<String, Movie> readFile(String url, String urlDep) {
//
//        HashMap<String, Movie> movieMap = new HashMap<>();
//        List<String> linesMovieList = null;
//
//        HashMap<String, String> producerMoviesMap = readFileToMapFilmReal(urlDep);
//
//        linesMovieList = FileSource.readLinesCsv(url);
//        linesMovieList.remove(0);
//
//        for (String movieData : linesMovieList) {
//            Movie movie = parseLine(movieData);
//            movie = findProducerForMovie(producerMoviesMap, movie);
//
//            movieMap.put(movie.getId(), movie);
//        }
//
//        return movieMap;
//
//    }
//
//    /**
//     * Static Method used to parse each rows of films.csv Static Methods are called
//     * for Adress, MovieLanguage, Country and MovieGenreRepository
//     *
//     * @param line (a row of Csv file)
//     * @return Movie Object
//     */
//    public static Movie parseLine(String line) {
//
//        String[] column = line.split(";", -1);
//        Movie movie = new Movie();
//
//        String id = column[0];
//        String name = column[1];
//        String yearTrim = column[2].trim();
//
//        int year = 0;
//        if (yearTrim.length() > 4) {
//            year = Integer.parseInt(column[2].substring(yearTrim.length() - 4));
//        } else if (yearTrim.length() == 4) {
//            year = Integer.parseInt(yearTrim);
//        }
//
//        Double rating = 0.0;
//        if (!column[3].isEmpty()) {
//            rating = Double.parseDouble(column[3].replaceAll(",", "."));
//        }
//
//        String url = column[4];
//        Address filmAdress = AddressReader.parseLineReverse(column[5]);
//        MovieLanguage movieLanguage = LanguageReader.existOrAdd(column[7]);
//        String resume = column[8];
//
//        Country country;
//        if (column.length < 11) {
//            country = CountryReader.existOrAdd(column[9]);
//        } else {
//            country = CountryReader.existOrAdd(column[10]);
//        }
//
//        Set<MovieGenreRepository> movieGenres = MovieGenreReader.existOrAdd(column[6]);
//        if (!movieGenres.isEmpty()) {
//            movie.setGenres(movieGenres);
//        }
//
//        movie.setId(id);
//        movie.setName(name);
//        movie.setYear(year);
//        movie.setRating(rating);
//        movie.setUrl(url);
//        movie.setResume(resume);
//        movie.setAdress(filmAdress);
//        movie.setLanguage(movieLanguage);
//        movie.setCountry(country);
//
//        return movie;
//    }
//
//    /**
//     * Static Method used to read film_realisateurs.csv and create a
//     * HashMap<id_movie, id_producer> Loop is used to split and add data
//     *
//     * @param urlDep film_realisateurs.csv
//     * @return HashMap<id_movie, id_producer>
//     * @throws IOException
//     */
//    public static HashMap<String, String> readFileToMapFilmReal(String urlDep) {
//
//        HashMap<String, String> producerMoviesMap = new HashMap<>();
//        List<String> linesProducerList = null;
//
//        linesProducerList = FileSource.readLinesCsv(urlDep);
//        linesProducerList.remove(0);
//
//        for (String prodMovieData : linesProducerList) {
//            String[] column = prodMovieData.split(";");
//            producerMoviesMap.put(column[0], column[1]);
//        }
//
//        return producerMoviesMap;
//    }
//
//    /**
//     * Static Method used to find the producer of the movie received First step :
//     * find the producer from HashMap value received as parameter Second step : loop
//     * HashMap key with movie id to set producer to the movie
//     *
//     * @param producerMoviesMap
//     * @param movie             from loop of (readFileToMap)
//     * @return movie (with the producer -> ready to persist)
//     */
//    public static Movie findProducerForMovie(HashMap<String, String> producerMoviesMap, Movie movie) {
//
//        Producer producer = PRODUCER_DAO.findById(producerMoviesMap.values().iterator().next());
//
//        Iterator<String> keyReal = producerMoviesMap.keySet().iterator();
//        while (keyReal.hasNext()) {
//            String cleJoin = keyReal.next();
//
//            if (movie.getId().equals(cleJoin) && producer != null) {
//
//                movie.addProducer(producer);
//            }
//        }
//        return movie;
//
//    }
}
