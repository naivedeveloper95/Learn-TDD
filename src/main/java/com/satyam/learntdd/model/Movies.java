package com.satyam.learntdd.model;

public class Movies {
    public String title;
    public String director;
    public int releaseYear;

    public Movies(String movie, String director, int releaseYear) {
        this.title = movie;
        this.director = director;
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public int getReleaseYear() {
        return releaseYear;
    }
}
