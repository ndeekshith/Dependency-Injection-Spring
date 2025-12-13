package dev.ndeekshith.Movies.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;

import java.util.List;

import dev.ndeekshith.Movies.model.Movie;
import dev.ndeekshith.Movies.repository.MovieRepository;

@RestController
@RequestMapping("api/movies")
public class Moviecontroller {

    private final MovieRepository movieRepository;

    public Moviecontroller() {
        this.movieRepository = new MovieRepository();
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieRepository.getAllMovies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Integer id) {
        Movie movie = movieRepository.getMovieById(id);
        if (movie == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movie);
    }
}
