package com.arek.MovieCatalogService.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Movie {
	private String movieId;
	private String name;

	public static Movie of(String movieId,String name){
		return new Movie(movieId,name);
	}
}
