package com.javadev.maintencetpm.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaintenaceDTO {
	private Long idMaintenace;
	private String description;
	private String comment;
	private String pilot;
	private Boolean Etat;
	private Date datemaintenace;
	private EquipementDTO equipement;
}
