package com.delaiglesia.doctorhouseapi.services.impl;

import com.delaiglesia.doctorhouseapi.model.Doctor;
import com.delaiglesia.doctorhouseapi.repository.DoctorRepository;
import com.delaiglesia.doctorhouseapi.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

	//Constructor injection mode
	private final DoctorRepository doctorRepository;
	@Autowired //only use this annotation if exists more than one constructor
	public DoctorServiceImpl(DoctorRepository doctorRepository) {
		this.doctorRepository = doctorRepository;
	}

	public List<Doctor> getDoctors() {
		return doctorRepository.findAll();
	}

	public Doctor getDoctor(int id) throws EntityNotFoundException {
		return doctorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Doctor not found - " + id));
	}

	public Doctor saveDoctor(Doctor doctor){
		if (doctor.getId() != null){
			doctor.setId(null);
		}
		return doctorRepository.save(doctor);
	}

	public Doctor updateDoctor(Doctor doctor, int id) {
		doctorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Doctor not found - " + id));
		doctor.setId(id);
		return doctorRepository.save(doctor);
	}

	public boolean deleteDoctor(int id){
		doctorRepository.deleteById(id);
		return true;
	}
}
