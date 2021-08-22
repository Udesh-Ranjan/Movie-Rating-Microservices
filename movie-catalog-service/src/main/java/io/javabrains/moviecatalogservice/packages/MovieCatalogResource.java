package io.javabrains.moviecatalogservice.packages;

import io.javabrains.moviecatalogservice.models.CatalogItem;
import io.javabrains.moviecatalogservice.models.Movie;
import io.javabrains.moviecatalogservice.models.Rating;
import io.javabrains.moviecatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    WebClient.Builder webClientBuilder;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") final String userId) {
        System.out.println("the userId : " + userId);
        //UserRating userRating = restTemplate.getForObject("http://localhost:8083/ratingsdata/users/" + userId, UserRating.class);
        UserRating userRating = restTemplate.getForObject("http://ratings-data-service/ratingsdata/users/" + userId, UserRating.class);
        return userRating.getUserRating().stream().map(rating -> {
            /*final Movie movie = restTemplate.getForObject(
                    "http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);*/
            final Movie movie = restTemplate.getForObject(
                    "http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
            /*final Movie movie = webClientBuilder
                    .build()
                    .get()
                    .uri("http://localhost:8082/movies/" + rating.getMovieId())
                    .retrieve()
                    .bodyToMono(Movie.class)
                    .block();*/
            return new CatalogItem(movie.getName(), "desc", rating.getRating());
        }).collect(Collectors.toList());
//        return Collections.singletonList(new CatalogItem("Avengers", "Marvel Studio", 3));
    }
}
