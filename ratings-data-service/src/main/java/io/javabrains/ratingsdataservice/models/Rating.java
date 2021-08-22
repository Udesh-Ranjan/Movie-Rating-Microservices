package io.javabrains.ratingsdataservice.models;

public class Rating {
    private String movieId;
    private int rating;

    public Rating(final String movieId, final int rating) {
        this.movieId = movieId;
        this.rating = rating;
    }

    public void setMovieId(final String movieId) {
        this.movieId = movieId;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setRating(final int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }
}
