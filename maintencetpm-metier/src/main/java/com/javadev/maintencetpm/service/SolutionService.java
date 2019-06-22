package com.javadev.maintencetpm.service;

import org.springframework.stereotype.Service;

import com.javadev.maintencetpm.dto.SolutionDTO;

/**
 * CRUD operations service for Solution.
 *
 * @param <SolutionDTO>
 */
@Service
public interface SolutionService {
	/**
	 * Save {SolutionDTO} bind to {Preventive} entity to database table.
	 */
	SolutionDTO addSolution(SolutionDTO c, Long IdPreventive);

	/**
	 * Save {SolutionDTO} bind to {Anomalie} entity to database table.
	 */
	SolutionDTO addSolutionAnomalie(SolutionDTO c, Long IdAnomalie);

	/**
	 * Save {SolutionDTO} bind to {Maintence} entity to database table.
	 */
	SolutionDTO addSolutionMaintenance(SolutionDTO c, Long IdMaintence);
}
