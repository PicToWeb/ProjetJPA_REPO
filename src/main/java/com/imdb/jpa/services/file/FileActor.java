package com.imdb.jpa.services.file;

import com.imdb.jpa.entities.Actor;
import com.imdb.jpa.services.parseCSV.ActorReader;

import java.util.Map;

/**
 * Abstract class used to manage actor file
 */
public abstract class FileActor {

    /**
     * Reads actor data from a CSV file.
     *
     * @param url URL of the CSV file
     * @return Map of actor names to Actor objects
     */
    public static Map<String, Actor> link(String url) {
        return ActorReader.readFile(url);
    }

    /**
     * Adds actor data from a map to the database.
     *
     * @param actorMap Map of actor names to Actor objects
     */
    public static void addCsvToDataBase(Map<String,Actor> actorMap) {

        //ACTOR_DAO.allInsert(actorMap);
    }
}
