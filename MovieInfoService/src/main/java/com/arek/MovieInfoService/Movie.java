package com.arek.MovieInfoService;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Movie {
	private String movieId;
	private String name;

	public static Movie of(String movieId,String name){
		return new Movie(movieId,name);
	}
}
