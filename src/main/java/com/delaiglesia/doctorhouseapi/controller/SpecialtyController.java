package com.delaiglesia.doctorhouseapi.controller;

import com.delaiglesia.doctorhouseapi.model.Specialty;
import com.delaiglesia.doctorhouseapi.services.impl.SpecialtyService;
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
@RequestMapping("/specialties")
@RequiredArgsConstructor
@CrossOrigin
public class SpecialtyController {

	private final SpecialtyService specialtyService;

	@GetMapping
	public List<Specialty> getSpecialties() {
		return specialtyService.getAllSpecialties();
	}

	@GetMapping("/{id}")
	public Specialty getSpecialtyById(@PathVariable Integer id) {
		return specialtyService.getSpecialtyById(id);
	}

	@PostMapping
	public Specialty saveSpecialty(@RequestBody Specialty specialty) {
		return specialtyService.saveSpecialty(specialty);
	}

	@PutMapping("/{id}")
	public Specialty updateSpecialty(@PathVariable Integer id, @RequestBody Specialty specialty) {
		return specialtyService.updateSpecialty(specialty, id);
	}

	@DeleteMapping("/{id}")
	public boolean deleteSpecialty(@PathVariable Integer id) {
		return  specialtyService.deleteSpecialty(id);
	}
}
