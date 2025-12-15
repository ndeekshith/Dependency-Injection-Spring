package dev.ndeekshith.Movies.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import dev.ndeekshith.Movies.model.Movie;

public class MoviecontrollerTest {

	Moviecontroller controller;

	@BeforeEach
	void setup() {
		controller = new Moviecontroller();
	}

	@Test
	void shouldReturnAllMovies() {
		assertEquals(5, controller.getAllMovies().spliterator().getExactSizeIfKnown());
	}

	@Test
	void shouldReturnMovieById() {
		ResponseEntity<Movie> movie = controller.getMovieById(1);
		assertNotNull(movie);
	}

}
