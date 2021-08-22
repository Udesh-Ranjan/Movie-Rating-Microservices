package io.javabrains.movieinfoservice.resources;

import io.javabrains.movieinfoservice.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/movies")
public class MovieResource {
    @RequestMapping("{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") final String movieId) {
        List<Movie> movies = Stream.of(
                new Movie("superman", "Superman vs Batman"),
                new Movie("avenger", "Avenger the age of ultron"),
                new Movie("rider", "Ghost Rider"))
                .collect(Collectors.toList());
        return movies.stream().filter(movie -> movie.getMovieId().equals(movieId)).findFirst().get();
    }
}
