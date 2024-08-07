package com.imdb.jpa.services.parseCSV;

import com.imdb.jpa.entities.Actor;
import com.imdb.jpa.entities.Address;
import com.imdb.jpa.utils.Convert;
import com.imdb.jpa.utils.FileSource;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ActorReader {

    /**
     * Static Method used to read each lines of Csv file. The first line is removed
     * (header of column) For each line, a parsing Method is called
     * (parseStringBeforeAdd)
     *
     * @param url from Csv file in main/resources
     * @return HashMap <String,Actor>The key of HashMap corresponding to Actor id
     */
    public static Map<String, Actor> readFile(String url) {
        Map<String, Actor> actorMap = new HashMap<>();
        List<String> linesList = null;

        linesList = FileSource.readLinesCsv(url);
        linesList.remove(0);

        for (String data : linesList) {
            Actor actor = parseLine(data);
            actorMap.put(actor.getId(), actor);
        }
        return actorMap;
    }

    /**
     * Static Method used to parse a line received from readFileToMap Method
     * birthdayDate call a static Method from Convert to transform "String to "LocalDate"
     * adress column call a static Method from AdressReaderCsv to parse and
     * transform "String" in "Adress" Object
     *
     * @param line from readFileToMap Method
     * @return Actor Object
     */
    public static Actor parseLine(String line) {
        String[] column = line.split(";", -1);
        Actor actor = new Actor();
        String id = column[0];
        String name = column[1];
        LocalDate birthdayDate = null;
        try {
            if (column[2].split(" ").length == 3) {
                birthdayDate = Convert.UsDate(column[2]);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            birthdayDate=null;
        }
        Address birthplace = AddressReader.parseLine(column[3]);

        String size = null;
        if(column[4].length() < 7) {
            size = column[4].replace("m", "").trim();
        }
        String url = column[5];

        actor.setId(id);
        actor.setIdentite(name);
        actor.setSize(size);
        actor.setUrl(url);
        actor.setBirthdayDate(birthdayDate);
        actor.setAdress(birthplace);
        return actor;
    }
}
