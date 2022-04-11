package com.delaiglesia.doctorhouseapi.controller;

import com.delaiglesia.doctorhouseapi.model.Place;
import com.delaiglesia.doctorhouseapi.services.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/places")
@RequiredArgsConstructor
@CrossOrigin
public class PlaceController {

	private final PlaceService placeService;

	@GetMapping
	public List<Place> getPlaces() {
		return placeService.getPlaces();
	}
	@GetMapping("/{id}")
	public Place getPlace(@PathVariable Integer id) {
		return placeService.getPlace(id);
	}

	@PostMapping
	public Place createPlace(@RequestBody Place place) {
		return placeService.savePlace(place);
	}

	@PutMapping("/{id}")
	public Place updatePlace(@RequestBody Place place, @PathVariable Integer id) {
		return placeService.updatePlace(place, id);
	}

	@DeleteMapping("/{id}")
	public void deletePlace(@PathVariable Integer id) {
		placeService.deletePlace(id);
	}
}
