package com.arek.MovieCatalogService.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CatalogItem {

	private String name;
	private String desc;
	private int rating;

	public static CatalogItem of(String name, String desc, int rating){
		return new CatalogItem(name, desc, rating);
	}
}
