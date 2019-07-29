package com.arek.MovieCatalogService.controllers;

import com.arek.MovieCatalogService.model.CatalogItem;
import com.arek.MovieCatalogService.model.Movie;
import com.arek.MovieCatalogService.model.Rating;
import com.arek.MovieCatalogService.model.UserRating;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
@AllArgsConstructor
public class MovieCatalogController {

	private static final String MOVIE_RATING_SERVICE = "http://localhost:8083/";
	private final String MOVIE_INFO_SERVICE = "http://localhost:8082/";
	private RestTemplate restTemplate;

	@GetMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable String userId) {

		List<Rating> ratings = restTemplate.getForObject(
				MOVIE_RATING_SERVICE + "user/" + userId,
				UserRating.class
		).getRatings();

		return ratings.stream()
				.map(rating -> {
							Movie movie = restTemplate.getForObject(
									MOVIE_INFO_SERVICE + "movies/" + rating.getMovieId(),
									Movie.class);
							return CatalogItem.of(movie.getName(), "movieDesc", rating.getRating());
						}
				)
				.collect(Collectors.toList());

	}
}
