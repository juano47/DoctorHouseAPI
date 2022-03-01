package com.delaiglesia.doctorhouseapi.controller;

import com.delaiglesia.doctorhouseapi.model.Doctor;
import com.delaiglesia.doctorhouseapi.services.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/doctors")
@RequiredArgsConstructor
public class DoctorController {

	//this component is injected using constructor injection but
	//with less boilerplate using the @RequiredArgsConstructor lombok annotation
	private final DoctorService doctorService;

	@GetMapping
	public List<Doctor> getDoctors() {
		return doctorService.getDoctors();
	}

	@GetMapping("/{id}")
	public Doctor getDoctor(@PathVariable int id) throws EntityNotFoundException {
		return doctorService.getDoctor(id);
	}

	@PostMapping
	public Doctor saveDoctor(@RequestBody Doctor doctor){
		return doctorService.saveDoctor(doctor);
	}

	@PutMapping("/{id}")
	public Doctor updateDoctor(@RequestBody Doctor doctor, @PathVariable int id){
		return doctorService.updateDoctor(doctor, id);
	}

	@DeleteMapping("{id}")
	public boolean deleteDoctor(@PathVariable int id){
		return doctorService.deleteDoctor(id);
	}
}
