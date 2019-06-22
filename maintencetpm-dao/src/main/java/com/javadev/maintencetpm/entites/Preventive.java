package com.javadev.maintencetpm.entites;

import java.util.Date;

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
public class Preventive {
	@Id
	@GeneratedValue
	private Long idPreventive;
	private String nbSomaime;
	private String action;
	private Boolean etat;
	private Date date;
	@ManyToOne
	@JoinColumn(name = "code_equipement")
	private Equipement equipement;
}
