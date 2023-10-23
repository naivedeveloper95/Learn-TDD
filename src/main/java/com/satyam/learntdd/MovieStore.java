package com.satyam.learntdd;

import com.satyam.learntdd.model.Movies;

import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.asList;

public class MovieStore {

    List<Movies> moviesList = new LinkedList<>();

    public List<Movies> findByPartialTitle(String partialTitle) throws Exception {
        List<Movies> list = new LinkedList<>();
        return findBy(movie -> movie.getTitle().toLowerCase().contains(partialTitle.toLowerCase()));
    }

    public void add(Movies movie) {
        moviesList.add(movie);
    }

    public List<Movies> findByDirector(String director) throws Exception {
        List<Movies> list = new LinkedList<>();
        return findBy(movie -> movie.getDirector().toLowerCase().equals(director.toLowerCase()));
    }

    public List<Movies> findByReleaseYear(int from, int to) throws Exception {
        List<Movies> list = new LinkedList<>();
        return findBy(movie -> movie.getReleaseYear() >= from && movie.getReleaseYear() <= to);
    }

    private List<Movies> findBy(Predicate predicate) {
        List<Movies> result = new LinkedList<Movies>();
        for (Movies movie : moviesList) {
            if (predicate.matches(movie)) {
                result.add(movie);
            }
        }
        return result;
    }

    interface Predicate {
        boolean matches(Movies movie);
    }
}
