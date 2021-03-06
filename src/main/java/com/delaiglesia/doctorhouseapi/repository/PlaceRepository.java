package com.delaiglesia.doctorhouseapi.repository;

import com.delaiglesia.doctorhouseapi.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Integer> {
}
