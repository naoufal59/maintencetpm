package com.javadev.maintencetpm.entites;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Maintenace {
	@Id
	@GeneratedValue
	private Long idMaintenace;
	@Lob
	private String description;
	private String comment;
	private String pilot;
	private Boolean Etat;
	private Date datemaintenace;
	@ManyToOne
	@JoinColumn(name = "code_equipement")
	private Equipement equipement;
}
