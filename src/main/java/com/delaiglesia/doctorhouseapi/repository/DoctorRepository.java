package com.delaiglesia.doctorhouseapi.repository;

import com.delaiglesia.doctorhouseapi.model.Doctor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Flux;

public interface DoctorRepository extends ReactiveSortingRepository<Doctor, String> {
	Flux<Doctor> findAllByIdNotNull(final Pageable page);
}
