package com.delaiglesia.doctorhouseapi.services;

import com.delaiglesia.doctorhouseapi.model.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityNotFoundException;

public interface DoctorService {
	Page<Doctor> getDoctors(Pageable pageable);

	Doctor getDoctor(int id) throws EntityNotFoundException;

	Doctor saveDoctor(Doctor doctor);

	Doctor updateDoctor(Doctor doctor, int id);

	boolean deleteDoctor(int id);
}
