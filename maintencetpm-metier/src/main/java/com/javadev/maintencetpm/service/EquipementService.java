package com.javadev.maintencetpm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.javadev.maintencetpm.dto.EquipementDTO;

/**
 * CRUD operations service for Equipement.
 *
 * @param <EquipementDTO>
 */
@Service
public interface EquipementService {
	/**
	 * Find all {EquipementDTO} in database.
	 */
	List<EquipementDTO> findAllEquipement();

	/**
	 * Find {EquipementDTO} in database by id.
	 * 
	 */
	EquipementDTO getEquipement(Long idC);
}
