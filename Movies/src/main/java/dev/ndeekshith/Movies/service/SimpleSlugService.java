package dev.ndeekshith.Movies.service;

public class SimpleSlugService implements SlugService {

    @Override
    public String slugify(String input) {
        return input.toLowerCase().replaceAll("[^a-zA-Z0-9 ]", "").replaceAll(" ","-");
    }

}
