package dev.ndeekshith.Movies.model;

import java.time.LocalDateTime;

public record Movie(
        Integer id,
        String name,
        String genre,
        Double rating,
        LocalDateTime releaseDate) {

}
