package com.javadev.maintencetpm.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnomalieDTO {
	private Long idAnomalie;
	private String description;
	private String typeAnomalie;
	private String Referrence;
	private Boolean etat;
	private Date dateAnomalie;
	private EquipementDTO equipement;
}
