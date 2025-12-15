package dev.ndeekshith.Movies.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import dev.ndeekshith.Movies.model.Movie;
import dev.ndeekshith.Movies.service.SimpleSlugService;
import dev.ndeekshith.Movies.service.SlugService;

@Repository
public class MovieRepository {

    private List<Movie> movies;
    private final SlugService slugService;

    public MovieRepository() {
        this.slugService = new SimpleSlugService();
        this.movies = List.of(
                new Movie(1, "The Shawshank Redemption",slugService.slugify("The Shawshank Redemption"), "Drama", 9.3, LocalDateTime.of(1994, 10, 14, 0, 0)),
                new Movie(2, "The Godfather", slugService.slugify("The Godfather"), "Crime", 9.2, LocalDateTime.of(1972, 3, 24, 0, 0)),
                new Movie(3, "The Dark Knight", slugService.slugify("The Dark Knight"), "Action", 9.0, LocalDateTime.of(2008, 7, 18, 0, 0)),
                new Movie(4, "Pulp Fiction", slugService.slugify("Pulp Fiction"), "Crime", 8.9, LocalDateTime.of(1994, 10, 14, 0, 0)),
                new Movie(5, "The Lord of the Rings: The Return of the King", slugService.slugify("The Lord of the Rings: The Return of the King"), "Action", 8.9,
                        LocalDateTime.of(2003, 12, 17, 0, 0)));
    }

    public List<Movie> getAllMovies() {
        return movies;
    }

    public Movie getMovieById(int id) {
        return movies.stream().filter(movies -> movies.id().equals(id)).findFirst().orElse(null);

    }

}
