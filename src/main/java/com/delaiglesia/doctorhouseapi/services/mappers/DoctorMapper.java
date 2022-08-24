package com.delaiglesia.doctorhouseapi.services.mappers;

import com.delaiglesia.doctorhouseapi.controller.DoctorDto;
import com.delaiglesia.doctorhouseapi.model.Doctor;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public class DoctorMapper {

	List<DoctorDto> doctorDtoList(List<Doctor> doctors) {
		return null;
	}
}
