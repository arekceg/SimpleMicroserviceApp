package com.arek.MovieCatalogService.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class UserRating {
	private String userId;
	private List<Rating> ratings;

	public void initData(String userId){
		this.setUserId(userId);
		this.setRatings(Arrays.asList(
				new Rating("100",3),
				new Rating("200",4)
		));
	}
}
