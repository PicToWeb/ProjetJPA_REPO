package com.imdb.jpa.services.parseCSV;

import com.imdb.jpa.entities.MovieLanguage;

public abstract class LanguageReader {

    /**
     * Static Method used to verify if Language needs to be insert in Database
     *
     * @param languageReceive from MovieReaderCsv
     * @return movieLanguage MovieLanguage Object
//     */
//    public static MovieLanguage existOrAdd(String languageReceive) {
//
//        MovieLanguage movieLanguage = LANGUAGE_DAO.findByName(languageReceive.trim());
//
//        if (movieLanguage == null) {
//            movieLanguage = new MovieLanguage(languageReceive.trim());
//            LANGUAGE_DAO.insert(movieLanguage);
//        }
//
//        return movieLanguage;
//    }
}
