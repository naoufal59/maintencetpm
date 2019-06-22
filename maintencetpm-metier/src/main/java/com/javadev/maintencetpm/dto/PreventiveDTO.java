package com.javadev.maintencetpm.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PreventiveDTO {
	private Long idPreventive;
	private String nb_Somaime;
	private String action;
	private Boolean etat;
	private Date date;
	private EquipementDTO equipement;
    
}
