package com.satyam.learntdd;

import com.satyam.learntdd.model.Movies;

import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.asList;

public class MovieStore {

    List<Movies> moviesList = new LinkedList<>();

    public List<Movies> findByPartialTitle(String partialTitle) {
        List<Movies> list = new LinkedList<>();
        for (Movies movies : moviesList) {
            if (movies.title.toLowerCase().contains(partialTitle.toLowerCase())) {
                list.add(movies);
            }
        }
        return list;
    }

    public void add(Movies movie) {
        moviesList.add(movie);
    }

    public List<Movies> findByDirector(String director) {
        List<Movies> list = new LinkedList<>();
        for (Movies movies : moviesList) {
            if (movies.director.toLowerCase().equals(director.toLowerCase())) {
                list.add(movies);
            }
        }
        return list;
    }

    public List<Movies> findByReleaseYear(int from, int to) {
        List<Movies> list = new LinkedList<>();
        for (Movies movies : moviesList) {
            if (movies.releaseYear >= from && movies.releaseYear <= to) {
                list.add(movies);
            }
        }
        return list;
    }
}
