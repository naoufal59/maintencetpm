package com.javadev.maintencetpm.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.javadev.maintencetpm.dto.SolutionDTO;
import com.javadev.maintencetpm.entites.Anomalie;
import com.javadev.maintencetpm.entites.Maintenace;
import com.javadev.maintencetpm.entites.Preventive;
import com.javadev.maintencetpm.entites.Solution;
import com.javadev.maintencetpm.repository.AnomalieRepository;
import com.javadev.maintencetpm.repository.MaintenaceRepository;
import com.javadev.maintencetpm.repository.PreventiveRepository;
import com.javadev.maintencetpm.repository.SolutionRepository;
import com.javadev.maintencetpm.service.SolutionService;
import com.javadev.maintencetpm.transformer.SolutionTransformer;


public class SolutionServiceImpl implements SolutionService {
	@Autowired
	public SolutionRepository solutionRepository;
	@Autowired
	public PreventiveRepository preventiveRepository;
	@Autowired
	public AnomalieRepository anomalieRepository;
	@Autowired
	public MaintenaceRepository maintenaceRepository;

	@Transactional
	public SolutionDTO addSolution(SolutionDTO c, Long IdPreventive) {
		Preventive eq = preventiveRepository.getOne(IdPreventive);
		Solution solution = new SolutionTransformer().toEntity(c);
		solution.setPreventive(eq);
		Solution add = solutionRepository.save(solution);
		return new SolutionTransformer().toDTO(add);
	}

	@Transactional
	public SolutionDTO addSolutionAnomalie(SolutionDTO c, Long IdAnomalie) {
		Anomalie eq = anomalieRepository.getOne(IdAnomalie);
		Solution solution = new SolutionTransformer().toEntity(c);
		solution.setAnomalie(eq);
		Solution add = solutionRepository.save(solution);
		return new SolutionTransformer().toDTO(add);
	}

	@Transactional
	public SolutionDTO addSolutionMaintenance(SolutionDTO c, Long IdMaintence) {
		Maintenace eq = maintenaceRepository.getOne(IdMaintence);
		Solution solution = new SolutionTransformer().toEntity(c);
		solution.setMaintenace(eq);
		Solution add = solutionRepository.save(solution);
		return new SolutionTransformer().toDTO(add);
	}
}
