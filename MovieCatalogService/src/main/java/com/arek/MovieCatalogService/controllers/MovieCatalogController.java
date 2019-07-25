package com.arek.MovieCatalogService.controllers;

import com.arek.MovieCatalogService.model.CatalogItem;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

	@GetMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable String userId) {

		return new ArrayList<>() {
			{
				add(CatalogItem.of("Movie1", "Desc1", 5));
				add(CatalogItem.of("Movie2", "Desc2", 9));
				add(CatalogItem.of("Movie3", "Desc4", 3));
			}
		};

	}

}
