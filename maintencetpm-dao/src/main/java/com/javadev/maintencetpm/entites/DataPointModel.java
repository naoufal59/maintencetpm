package com.javadev.maintencetpm.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataPointModel {
	 @Id
     @GeneratedValue
	 private Long id ;
	 private String week;
	 private String MTTR;
	 private String MTRF;
	 private String disbo;
	 @ManyToOne
	 @JoinColumn(name="code_equipement")
	 private Equipement equipement;
}
