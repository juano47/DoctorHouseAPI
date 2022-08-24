package com.delaiglesia.doctorhouseapi.controller;

import com.delaiglesia.doctorhouseapi.model.Doctor;
import com.delaiglesia.doctorhouseapi.services.DoctorService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.persistence.EntityNotFoundException;
import java.time.Duration;

@RestController
@RequestMapping("/v2/doctors")
@RequiredArgsConstructor
@CrossOrigin
public class DoctorController {

	//this component is injected using constructor injection but
	//with less boilerplate using the @RequiredArgsConstructor lombok annotation
	private final DoctorService doctorService;

	@GetMapping
	@ApiOperation(value = "return the elements AT THE SAME TIME and also it have a delay of 1 second")
	public Flux<Doctor> getDoctors(@PageableDefault(page = 0, size = 20) Pageable pageable) {
		return doctorService.getDoctors(pageable).
				delayElements(Duration.ofMillis(500));
	}

	@GetMapping("/{id}")
	public Mono<ResponseEntity<Doctor>> getDoctor(@PathVariable String id) throws EntityNotFoundException {
		return doctorService.getDoctor(id)
				.map(saveDoctor -> ResponseEntity.ok(saveDoctor))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@PostMapping
	public Mono<Doctor> saveDoctor(@RequestBody Doctor doctor){
		return doctorService.saveDoctor(doctor);
	}

	@PutMapping("/{id}")
	public Mono<ResponseEntity<Doctor>> updateDoctor(@RequestBody Doctor doctor, @PathVariable String id){
		return doctorService.updateDoctor(doctor, id)
				.map(saveDoctor -> ResponseEntity.ok(saveDoctor))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@DeleteMapping("{id}")
	public Mono<ResponseEntity<Void>> deleteDoctor(@PathVariable String id){
		return doctorService.getDoctor(id)
				.flatMap(s ->
						doctorService.deleteDoctor(s)
								.then(Mono.just(ResponseEntity.ok().<Void>build()))
				)
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}

	//messages are Sent to the client as Server Sent Events
	@ApiOperation(value = "return the elements ONE BY ONE and also it have a delay of 1 second")
	@GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Doctor> streamAllMessages(@PageableDefault(page = 0, size = 20) Pageable pageable){
		return doctorService.getDoctors(pageable)
				.delayElements(Duration.ofMillis(500))
				.log("DoctorController.streamAllDoctors");
	}
}
