package com.delaiglesia.doctorhouseapi.services.impl;

import com.delaiglesia.doctorhouseapi.model.Specialty;
import com.delaiglesia.doctorhouseapi.repository.SpecialtyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
public class SpecialtyService {
	private final SpecialtyRepository specialtyRepository;

	public List<Specialty> getAllSpecialties() {
		return specialtyRepository.findAll();
	}

	public Specialty getSpecialtyById(Integer id) {
		return specialtyRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Specialty not found"));
	}

	public Specialty saveSpecialty(Specialty specialty) {
		if (specialty.getId() != null) {
			specialty.setId(null);
		}
		return specialtyRepository.save(specialty);
	}

	public Specialty updateSpecialty(Specialty specialty, Integer id) {
		specialtyRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Specialty not found"));
		specialty.setId(id);
		return specialtyRepository.save(specialty);
	}

	public boolean deleteSpecialty(Integer id) {
		specialtyRepository.deleteById(id);
		return true;
	}

}
