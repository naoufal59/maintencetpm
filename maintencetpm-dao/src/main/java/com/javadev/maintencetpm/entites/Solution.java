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
public class Solution {
	@Id
	@GeneratedValue
	private Long idSolution;
	private String description;
	@ManyToOne
	@JoinColumn(name = "code_anomalie")
	private Anomalie anomalie;
	@ManyToOne
	@JoinColumn(name = "code_preventive")
	private Preventive preventive;
	@ManyToOne
	@JoinColumn(name = "code_main")
	private Maintenace maintenace;
}
