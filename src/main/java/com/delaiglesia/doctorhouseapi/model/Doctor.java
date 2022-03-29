package com.delaiglesia.doctorhouseapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@NoArgsConstructor @AllArgsConstructor
@Data
@Document
public class Doctor {
	@Id
	private String id;
	private String name;
	private int license;
	private String specialty;
	private int price;
	private int experience;
	private String mainImage;
	private boolean favorite;
}
