package com.javadev.maintencetpm.service;

import java.io.PrintWriter;
import java.util.List;

import org.springframework.stereotype.Service;

import com.javadev.maintencetpm.dto.EquipementDTO;
import com.javadev.maintencetpm.dto.PreventiveDTO;

/**
 * CRUD operations service for Preventive.
 *
 * @param <PreventiveDTO>
 */
@Service
public interface PreventiveService {
	/**
	 * Save {PreventiveDTO} entity to database table.
	 */
	PreventiveDTO create(PreventiveDTO c, Long IdEquipemnet);

	/**
	 * Find {PreventiveDTo} in database by Equipement.
	 *
	 */
	List<PreventiveDTO> findByEquipementPreventive(EquipementDTO ty);

	/**
	 * Find all {PreventiveDTO} in database.
	 */
	List<PreventiveDTO> getAll();

	/**
	 * Find {PreventiveDTo} in database by id.
	 * 
	 * @throws Exception
	 */
	PreventiveDTO getById(Long id) throws Exception;

	void GotoTheTablepreventivr(Long id);

	/**
	 * print the data in file CSV
	 */
	void writepreventiveObjectToCSV(PrintWriter writer, List<PreventiveDTO> preventives);
}
