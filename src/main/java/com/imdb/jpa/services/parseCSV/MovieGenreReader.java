package com.imdb.jpa.services.parseCSV;

import com.imdb.jpa.entities.MovieGenre;

import java.util.HashSet;
import java.util.Set;

public abstract class MovieGenreReader {

    /** Static Method used to parse Genre String and insert in Database if Genre is not exist
     * @param genreLine from MovieReaderCsv
     * @return
     */
//    public static Set<MovieGenreRepository> existOrAdd(String genreLine) {
//
//        Set<MovieGenreRepository> genreList = new HashSet<>();
//
//        String[] column = genreLine.split(",");
//
//        for (int i = 0; i < column.length; i++) {
//
//            String genreName = column[i].trim();
//            MovieGenreRepository movieGenre = MOVIE_GENRE_DAO.findByName(genreName);
//
//            if (movieGenre == null) {
//                movieGenre = new MovieGenreRepository(genreName);
//                MOVIE_GENRE_DAO.insert(movieGenre);
//            }
//            genreList.add(movieGenre);
//        }
//        return genreList;
//    }
}
