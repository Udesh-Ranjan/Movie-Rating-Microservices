package io.javabrains.ratingsdataservice.resources;

import io.javabrains.ratingsdataservice.models.Rating;
import io.javabrains.ratingsdataservice.models.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("ratingsdata")
public class RatingResource {
    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") final String movieId) {
        return new Rating(movieId, 2);
    }

    @RequestMapping("users/{userId}")
    public UserRating getUserRating(@PathVariable("userId") final String userId) {
        List<Rating> ratings = Arrays.asList(new Rating("superman", 2), new Rating("rider", 3));
        UserRating userRating = new UserRating();
        userRating.setUserRating(ratings);
        return userRating;
    }
}
