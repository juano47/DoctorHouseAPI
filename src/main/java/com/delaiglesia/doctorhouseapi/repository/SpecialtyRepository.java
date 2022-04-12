package com.delaiglesia.doctorhouseapi.repository;

import com.delaiglesia.doctorhouseapi.model.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialtyRepository extends JpaRepository<Specialty, Integer> {

}

