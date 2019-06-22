package com.javadev.maintencetpm.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equipement {
	@Id
	@GeneratedValue
	private Long id;
	private String description;
	private String nom;
	private Boolean etat;
}
