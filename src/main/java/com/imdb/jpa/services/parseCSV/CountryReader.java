package com.imdb.jpa.services.parseCSV;

import com.imdb.jpa.entities.Country;
import com.imdb.jpa.utils.FileSource;

import java.util.ArrayList;
import java.util.List;

public abstract class CountryReader {

    /**
     * Static Method used to read each lines of Csv file. The first line is removed
     * (header of column) For each line, a Country Object is create and added to a List
     *
     * @param url from Csv file in main/resources
     * @return List of Country
     */
    public static List<Country> readFile(String url) {
        List<Country> countryList = new ArrayList<>();
        List<String> linesList = FileSource.readLinesCsv(url);
        linesList.remove(0);

        for (String line : linesList) {
            String[] column = line.split(";");
            if (column.length <= 2) {
                Country p = new Country();
                String countryName = formatAbvName(column[0]);
                p.setName(countryName);
                p.setUrl(column[1]);
                countryList.add(p);
            }
        }
        return countryList;
    }

    /**
     * Method used to format Uk or USA string
     * @param countryString Country name
     * @return
     */
    public static String formatAbvName(String countryString) {
        if ((countryString == null) || (countryString.length() > 60)) {
            return "";
        }
        String usa = "USA";
        String uk = "UK";
        String countryClean = countryString.replaceAll("\\[.*?\\]", "").trim();

        if (countryClean.equals(usa)) {
            countryClean = "United States";
        } else if (countryClean.equals(uk)) {
            countryClean = "United Kingdom";
        }
        return countryClean;
    }


    /**
     * Static Method used to rename country abbreviations and
     * verify if Country needs to be insert in Database
     *
     * @param countryString
     * @return Country composed by a name and an URL
     */
//    public static Country existOrAdd(String countryString) {
//
//        if ((countryString == null) || (countryString.length() > 60)) {
//            return new Country("", "");
//        }
//
//        String usa = "USA";
//        String uk = "UK";
//        String countryClean = countryString.replaceAll("\\[.*?\\]", "").trim();
//
//        if (countryClean.equals(usa)) {
//            countryClean = "United States";
//        } else if (countryClean.equals(uk)) {
//            countryClean = "United Kingdom";
//        }
//
//        Country countryFind = COUNTRY_DAO.findByName(countryClean);
//
//        if (countryFind == null) {
//            countryFind = new Country(countryClean, "");
//            COUNTRY_DAO.insert(countryFind);
//        }
//
//        return countryFind;
//    }

}
