package com.javadev.maintencetpm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SolutionDTO {
	private Long idSolution;
	private String description;
	private AnomalieDTO anomalie;
	private PreventiveDTO preventive;
	private MaintenaceDTO maintenace;
}
