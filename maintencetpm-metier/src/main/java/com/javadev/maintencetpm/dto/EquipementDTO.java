package com.javadev.maintencetpm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipementDTO {
	private Long id;
	private String description;
	private String nom;
	private Boolean etat;
}
