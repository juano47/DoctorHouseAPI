package com.delaiglesia.doctorhouseapi.repository;

import com.delaiglesia.doctorhouseapi.model.Doctor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface DoctorRepository extends ReactiveMongoRepository<Doctor, String> { }
