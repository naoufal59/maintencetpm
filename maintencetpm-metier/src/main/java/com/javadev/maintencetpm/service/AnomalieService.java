package com.javadev.maintencetpm.service;

import java.io.PrintWriter;
import java.util.List;

import org.springframework.stereotype.Service;

import com.javadev.maintencetpm.dto.AnomalieDTO;
import com.javadev.maintencetpm.dto.EquipementDTO;

/**
 * CRUD operations service for Preventive.
 *
 * @param <AnomalieDTO>
 */
@Service
public interface AnomalieService {
	/**
	 * Save {AnomalieDTO} entity to database table.
	 */
	AnomalieDTO ajouterAnomalie(AnomalieDTO c, Long IdEquipemnet);

	/**
	 * Find {AnomalieDTO} in database by Equipement.
	 *
	 */
	List<AnomalieDTO> findByEquipementAnomalie(EquipementDTO ty);

	/**
	 * Find all {AnomalieDTO} in database.
	 */
	List<AnomalieDTO> getAll();

	/**
	 * check anomalie
	 */
	List<AnomalieDTO> inValideAnomalie();

	/**
	 * Find {AnomalieDTO} in database by id.
	 * 
	 * @throws Exception
	 */
	AnomalieDTO getById(Long id) throws Exception;

	void GotoTheTableAnomalie(Long id);

	/**
	 * print the data in file CSV
	 */
	void writeAnomalieObjectToCSV(PrintWriter writer, List<AnomalieDTO> anomalies);
}
