package com.delaiglesia.doctorhouseapi.services;

import com.delaiglesia.doctorhouseapi.model.Place;
import com.delaiglesia.doctorhouseapi.repository.PlaceRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class PlaceService {

	private final PlaceRepository placeRepository;

	public PlaceService(PlaceRepository placeRepository) {
		this.placeRepository = placeRepository;
	}

	public List<Place> getPlaces() {
		return placeRepository.findAll();
	}

	public Place getPlace(Integer id) {
		return placeRepository.findById(id)
				.orElseThrow(() ->  new EntityNotFoundException("Doctor not found - " + id));
	}

	public Place savePlace(Place place) {
		if (place.getId() != null) {
			place.setId(null);
		}
		return placeRepository.save(place);
	}

	public Place updatePlace(Place place, Integer id) {
		placeRepository.findById(place.getId())
				.orElseThrow(() ->  new EntityNotFoundException("Doctor not found - " + id));
		place.setId(id);
		return placeRepository.save(place);
	}

	public boolean deletePlace(Integer id) {
		placeRepository.deleteById(id);
		return true;
	}
}
