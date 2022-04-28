package com.delaiglesia.doctorhouseapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class DoctorHouseApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorHouseApiApplication.class, args);
	}

}
