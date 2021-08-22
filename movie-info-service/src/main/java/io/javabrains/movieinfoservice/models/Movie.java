package io.javabrains.movieinfoservice.models;

public class Movie {
    private String movieId;
    private String name;

    public Movie() {
    }

    public Movie(final String movieId, final String name) {
        this.movieId = movieId;
        this.name = name;
    }

    public void setMovieId(final String movieId) {
        this.movieId = movieId;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieName(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
