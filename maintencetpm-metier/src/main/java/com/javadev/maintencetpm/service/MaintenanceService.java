package com.javadev.maintencetpm.service;

import java.io.PrintWriter;
import java.util.List;

import org.springframework.stereotype.Service;

import com.javadev.maintencetpm.dto.EquipementDTO;
import com.javadev.maintencetpm.dto.MaintenaceDTO;

/**
 * CRUD operations service for Maintenance.
 *
 * @param <MaintenanceDTO>
 */
@Service
public interface MaintenanceService {
	/**
	 * Find all {MaintenaceDTO} in database.
	 */
	List<MaintenaceDTO> listMaintenance();

	/**
	 * valid maintence
	 */
	void validMaintenceDTO(Long maintenceID);

	/**
	 * reject Maintence
	 */
	void rejectMaintenceDTO(Long maintenceID);

	List<MaintenaceDTO> inValideMaintenace();

	/**
	 * Find {MaintenaceDTO}by Equipemt in database.
	 */
	List<MaintenaceDTO> findByEquipement(EquipementDTO ty);

	/**
	 * print the data in file CSV
	 */
	void writeObjectToCSV(PrintWriter writer, List<MaintenaceDTO> maintenaces);

	/**
	 * Save {MaintenaceDTO} entity to database table.
	 */
	MaintenaceDTO ajouterMainteance(MaintenaceDTO c, Long IdEquipemnet);

	/**
	 * get Maintence by id
	 */
	MaintenaceDTO getMaintence(Long id);
	
	void GotoTheTable(Long id) ;
}
