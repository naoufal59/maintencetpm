package com.javadev.maintencetpm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataPointModelDTO {
	private Long id;
	private String somaine;
	private String MTTR;
	private String MTRF;
	private String disbo;
	private EquipementDTO equipement;
}
