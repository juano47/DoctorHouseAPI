package com.delaiglesia.doctorhouseapi.services;

import com.delaiglesia.doctorhouseapi.model.Doctor;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface DoctorService {
	List<Doctor> getDoctors();

	Doctor getDoctor(int id) throws EntityNotFoundException;

	Doctor saveDoctor(Doctor doctor);

	Doctor updateDoctor(Doctor doctor, int id);

	boolean deleteDoctor(int id);
}
