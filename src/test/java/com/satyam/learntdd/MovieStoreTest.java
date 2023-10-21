package com.satyam.learntdd;

import com.satyam.learntdd.model.Movies;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class MovieStoreTest {

    @Test
    public void returnsNoResultWhenNoTitlesPartiallyMatched() throws Exception {
        MovieStore movieStore = new MovieStore();
        List<Movies> result = movieStore.findByPartialTitle("abc");

        assertThat(result.size(), is(0));
    }
}
