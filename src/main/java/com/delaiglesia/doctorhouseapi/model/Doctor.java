package com.delaiglesia.doctorhouseapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;


@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private int license;
	private String specialty;
	private int price;
	private int experience;
	private String mainImage;
	private boolean favorite;
	@OneToMany(cascade = {CascadeType.ALL})
	private List<Place> places;
}
