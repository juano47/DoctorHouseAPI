package com.delaiglesia.doctorhouseapi.services;

import com.delaiglesia.doctorhouseapi.model.Doctor;
import com.delaiglesia.doctorhouseapi.repository.DoctorRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.persistence.EntityNotFoundException;

@Service
@Log4j2
public class DoctorService {

	//Constructor injection mode
	private final DoctorRepository doctorRepository;
	@Autowired //only use this annotation if exists more than one constructor
	public DoctorService(DoctorRepository doctorRepository) {
		this.doctorRepository = doctorRepository;
	}

	public Flux<Doctor> getDoctors(Pageable pageable) {
		return doctorRepository.findAllByIdNotNull(pageable);
	}

	public Mono<Doctor> getDoctor(String id) throws EntityNotFoundException {
		return doctorRepository.findById(id);
	}

	public Mono<Doctor> saveDoctor(Doctor doctor){
		if (doctor.getId() != null){
			doctor.setId(null);
		}
		return doctorRepository.save(doctor);
	}

	public Mono<Doctor> updateDoctor(Doctor doctor, String id) {
		return doctorRepository.findById(id)
				.flatMap(updateDoctor -> {
					updateDoctor.setName(doctor.getName());
					updateDoctor.setLicense(doctor.getLicense());
					updateDoctor.setSpecialty(doctor.getSpecialty());
					updateDoctor.setPrice(doctor.getPrice());
					updateDoctor.setExperience(doctor.getExperience());
					updateDoctor.setMainImage(doctor.getMainImage());
					updateDoctor.setFavorite(doctor.isFavorite());
					return doctorRepository.save(updateDoctor);
				});
	}

	public Mono<Void> deleteDoctor(Doctor doctor){
		return doctorRepository.delete(doctor);
	}
}
