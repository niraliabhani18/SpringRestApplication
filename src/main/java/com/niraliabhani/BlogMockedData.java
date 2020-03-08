package com.niraliabhani;

import java.util.ArrayList;
import java.util.List;

/*
singleton class
single instance of class
 */
public class BlogMockedData {

    //List of all movies post
    private List<Movies> moviesList;

    private static BlogMockedData instance;
    public static BlogMockedData getInstance() {
        if(instance == null) {
            instance = new BlogMockedData();
        }
        return instance;
    }

    public BlogMockedData() {
        moviesList = new ArrayList<Movies>();
        moviesList.add(new Movies(1,"Good NEWWZ(2019)","Two couples with the same surnames pursue in-vitro fertilization and wait for their upcoming babies. Trouble ensues when they find that the sperms of each couple have been mixed with each other." +"\n" +
                "IMDB score: 7.8/10" +"\n" +
                "Director: Raj Mehta" +"\n" +
                "Writers: Jyoti Kapoor (story), Jyoti Kapoor (screenplay)" + " \n" +
                "Stars: Akshay Kumar, Kareena Kapoor, Diljit Dosanjh " +"\n"));
        moviesList.add(new Movies(2,"Raazi(2018)","A Kashmiri woman agrees to marry a Pakistani army officer in order to spy on Pakistan during the Indo-Pakistan War of 1971.\n" +
                "IMDB score: 7.3/10\n " +
                "Director: Meghna Gulzar\n" +
                "Writers: Harinder S. Sikka (based on the book 'Calling Sehmat' by), Meghna Gulzar (screenplay) \n" +
                "Stars: Alia Bhatt, Vicky Kaushal, Rajit Kapoor "));
        moviesList.add(new Movies(3,"URI, The Surgical Strike(2019)","Indian army special forces execute a covert operation, avenging the killing of fellow army men at their base by a terrorist group.\n" +
                "IMDB score: 8.3/10\n " +
                "Director: Aditya Dhar\n" +
                "Writer: Aditya Dhar\n" +
                "Stars: Vicky Kaushal, Paresh Rawal, Mohit Raina"));

    }

    //return whole list of movies added
    public List<Movies> fetchMovies() {
        return moviesList;
    }

    //fetch movie with id
    public Movies getMovieById(int id) {

        for(Movies i : moviesList) {
            if(id == i.getId()) {
                return i;
            }
        }
        return null;
    }

    // search movie by text
    public List<Movies> searchMovies(String name) {
        ArrayList<Movies> searchMovies = new ArrayList<Movies>();

        for(Movies i : moviesList) {
            if((i.getTitle().toLowerCase().contains(name.toLowerCase()))||
              (i.getContent().toLowerCase().contains(name.toLowerCase()))) {
                searchMovies.add(i);
            }
        }
        return searchMovies;
    }

    //create new movie blog
    public Movies addNewMovie(int id, String title, String content) {
        Movies movie = new Movies(id,title,content);
        moviesList.add(movie);
        return movie;

    }

    //update movie blog
    public Movies updateMovie(int id, String title, String content) {
        for (Movies i : moviesList) {
            if (i.getId() == id) {
                int movieIndex = moviesList.indexOf(i);
                i.setTitle(title);
                i.setContent(content);
                moviesList.set(movieIndex,i);
                return i;
            }
        }
        return null;
    }

    //delete blog by id
    public boolean deleteMovie(int id) {
        int movieIndex = -1;
        for (Movies i : moviesList) {
            if(i.getId() == id) {
               movieIndex = moviesList.indexOf(i);
               continue;
            }
        }
        if(movieIndex > -1) {
            moviesList.remove(movieIndex);
        }
        return true;
    }

}




