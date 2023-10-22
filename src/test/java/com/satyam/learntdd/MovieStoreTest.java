package com.satyam.learntdd;

import com.satyam.learntdd.model.Movies;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;

public class MovieStoreTest {
    private final MovieStore movieStore = new MovieStore();

    private final Movies harryPorter = new Movies("Harry Porter", "Rowling", 2000);
    private final Movies starWars = new Movies("Star Wars", "Shwimmer", 1999);
    private final Movies starTrek = new Movies("Star Trek", "Shwimmer", 2002);
    private final Movies shawshankRedemption = new Movies("Shawshank Redemption", "Bob", 2001);
    private final Movies takeThat = new Movies("Take That", "Shwimmer", 2010);

    @BeforeEach
    void setUp() throws Exception {
        movieStore.add(harryPorter);
        movieStore.add(shawshankRedemption);
        movieStore.add(starTrek);
        movieStore.add(starWars);
        movieStore.add(takeThat);
    }

    @Test
    public void returnsNoResultWhenNoTitlesPartiallyMatched() throws Exception {
        MovieStore movieStore = new MovieStore();
        List<Movies> result = movieStore.findByPartialTitle("abc");

        assertThat(result.size(), is(0));
    }

    @Test
    public void findsMoviesWhenTitlesArePartiallyMatched() throws Exception {
        List<Movies> result = movieStore.findByPartialTitle("tar");

        assertThat(result.size(), is(2));
        assertThat(result, contains(starTrek, starWars));
    }

    @Test
    public void findsMoviesWhenDirectorExactlyMatches() throws Exception {
        List<Movies> result = movieStore.findByDirector("Shwimmer");

        assertThat(result.size(), is(3));
        assertThat(result, contains(starTrek, starWars, takeThat));
    }

    @Test
    public void findsMoviesWhenReleaseYearIsInRange() throws Exception {
        List<Movies> result = movieStore.findByReleaseYear(1999, 2000);

        assertThat(result.size(), is(2));
        assertThat(result, contains(harryPorter, starWars));
    }
}
