package dev.ndeekshith.Movies.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import dev.ndeekshith.Movies.model.Movie;
import dev.ndeekshith.Movies.repository.MovieRepository;

@ExtendWith(MockitoExtension.class)
class MoviecontrollerTest {

	@InjectMocks
	Moviecontroller controller;

	@Mock
	MovieRepository movieRepository;

	List<Movie> movies;

	@BeforeEach
	void setup() {
		movies = List.of(
			new Movie(1, "The Shawshank Redemption", "the-shawshank-redemption", "Drama", 9.3, LocalDateTime.of(1994, 10, 14, 0, 0)),
			new Movie(2, "The Godfather", "the-godfather", "Crime", 9.2, LocalDateTime.of(1972, 3, 24, 0, 0)),
			new Movie(3, "The Dark Knight", "the-dark-knight", "Action", 9.0, LocalDateTime.of(2008, 7, 18, 0, 0)),
			new Movie(4, "Pulp Fiction", "pulp-fiction", "Crime", 8.9, LocalDateTime.of(1994, 10, 14, 0, 0)),
			new Movie(5, "The Lord of the Rings: The Return of the King", "the-lord-of-the-rings-the-return-of-the-king", "Action", 8.9, LocalDateTime.of(2003, 12, 17, 0, 0))
		);
	}

	@Test
	void shouldReturnAllMovies() {
		when(movieRepository.getAllMovies()).thenReturn(movies);
		List<Movie> result = controller.getAllMovies();
		assertEquals(5, result.size());
		verify(movieRepository).getAllMovies();
	}

	@Test
	void shouldReturnMovieById() {
		Movie expectedMovie = movies.get(0);
		when(movieRepository.getMovieById(1)).thenReturn(expectedMovie);
		ResponseEntity<Movie> response = controller.getMovieById(1);
		assertNotNull(response);
		assertEquals(200, response.getStatusCode().value());
		assertEquals(expectedMovie, response.getBody());
		verify(movieRepository).getMovieById(1);
	}

}
