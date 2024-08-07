package com.imdb.jpa.services.parseCSV;

import com.imdb.jpa.entities.Actor;
import com.imdb.jpa.entities.Movie;
import com.imdb.jpa.entities.Role;
import com.imdb.jpa.utils.FileSource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class RoleReader {

    /**
     * Static Method used to read each lines of Csv files
     *
     * First step : Call static Method (readFileToLinkMainCasting)
     * to process castingPrincipal.csv and return a role List
     *
     * Second Step : Loop each lines from roles.csv to call parseStringBeforeAdd Method
     * and return a role Object
     * Third step : Check for each element of roleList if the mainCasingList contains the same role,
     * if it s true, set parameter isPrincipal to true
     * @param url roles.csv
     * @param urlDep castingPrincipal.csv
     * @return List of Role Object whith principal Casting added
     */
//    public static List<Role> readFile(String url, String urlDep) {
//
//        List<Role> roleList = new ArrayList<>();
//        List<String> linesFileList = null;
//
//        List<Role> mainCastingList = readFileMainCasting(urlDep);
//
//        linesFileList = FileSource.readLinesCsv(url);
//        linesFileList.remove(0);
//
//        roleList = linesFileList.parallelStream()
//                .map(line -> parseLine(line))
//                .collect(Collectors.toList());
//
//        System.out.println("Main Cast List processing - merging");
//
//        roleList.forEach(role -> {
//            if (mainCastingList.contains(role)) {
//                role.setPrincipal(true);
//            }
//        });
//        System.out.println("Main Cast List processing - completed");
//        return roleList;
//    }
//
//    /**
//     * Static Method used to parse row from roles.csv
//     * findMovieById Method is called for Movie
//     * findActorById Method is called for Actor
//     *
//     * @param line (row of file)
//     * @return Role Object
//     */
//    public static Role parseLine(String line) {
//
//        String[] column = line.split(";");
//
//        Movie movie = MOVIE_DAO.findMovieById(column[0]);
//        Actor actor = ACTOR_DAO.findById(column[1]);
//        String person = "";
//
//        if (column.length > 2) {
//            person = column[2];
//        }
//
//        Role role = new Role(person, movie, actor);
//
//        return role;
//
//    }
//
//    /**
//     * Static Method used to parse row from castingPrincipal.csv
//     * findMovieById Method is called for Movie
//     * findActorById Method is called for Actor
//     *
//     * @param urlDep castingPrincipal.csv
//     * @return List of Role Object
//     * @throws IOException
//     */
//    public static List<Role> readFileMainCasting(String urlDep) {
//
//        List<Role> mainCastingList = new ArrayList<>();
//        List<String> linesCasting = null;
//
//        linesCasting = FileSource.readLinesCsv(urlDep);
//        linesCasting.remove(0);
//
//        System.out.println("---------------");
//        System.out.println("Main Cast List processing - in progress");
//        System.out.println("---------------");
//
//        for (String c : linesCasting) {
//            String[] column = c.split(";");
//
//            Role role = new Role();
//            Movie movie = MOVIE_DAO.findMovieById(column[0]);
//            Actor actor = ACTOR_DAO.findById(column[1]);
//
//            role.setActor(actor);
//            role.setMovie(movie);
//            mainCastingList.add(role);
//        }
//
//        return mainCastingList;
//    }

}
