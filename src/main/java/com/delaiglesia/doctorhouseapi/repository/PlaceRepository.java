package com.delaiglesia.doctorhouseapi.repository;

import com.delaiglesia.doctorhouseapi.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Integer> {
}
