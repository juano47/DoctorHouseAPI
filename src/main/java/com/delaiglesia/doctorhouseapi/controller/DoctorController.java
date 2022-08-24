package com.delaiglesia.doctorhouseapi.controller;

import com.delaiglesia.doctorhouseapi.aspect.CheckFeatureFlag;
import com.delaiglesia.doctorhouseapi.model.Doctor;
import com.delaiglesia.doctorhouseapi.services.DoctorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.concurrent.TimeoutException;

@RestController
@RequestMapping("/doctors")
@RequiredArgsConstructor
@CrossOrigin
//no se puede usar a nivel de Service y ponerlo en false, porque no levanta ya que detecta que no existe el Bean
@ConditionalOnProperty(name = "features.controllers.doctor")
@Log4j2
public class DoctorController {

	//this component is injected using constructor injection but
	//with less boilerplate using the @RequiredArgsConstructor lombok annotation
	private final DoctorService doctorService;

	@GetMapping
	public Page<Doctor> getDoctors(  @PageableDefault(page = 0, size = 20) Pageable pageable) {
		return doctorService.getDoctors(pageable);
	}

	@GetMapping("/{id}")
	@CheckFeatureFlag(flag = "features.endpoints.doctor.getById")
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
