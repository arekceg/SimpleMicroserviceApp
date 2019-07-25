package com.arek.MovieInfoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/movies")
public class MovieInfoController {

	private Random random = new Random();

	@GetMapping("/{movieId}")
	public Movie getMovieInto(@PathVariable String movieId) {
		return Movie.of(movieId, "TestMovieName" + random.nextInt(100));
	}

}
