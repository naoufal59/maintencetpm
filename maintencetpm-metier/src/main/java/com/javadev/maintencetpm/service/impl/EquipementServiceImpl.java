package com.javadev.maintencetpm.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.javadev.maintencetpm.dto.EquipementDTO;
import com.javadev.maintencetpm.entites.Equipement;
import com.javadev.maintencetpm.repository.EquipementRepository;
import com.javadev.maintencetpm.service.EquipementService;
import com.javadev.maintencetpm.transformer.EquipementTransformer;


public class EquipementServiceImpl implements EquipementService {
	@Autowired
	public EquipementRepository equipementRepository;

	@Transactional
	public List<EquipementDTO> findAllEquipement() {
		List<Equipement> dtos = equipementRepository.findAll();
		List<EquipementDTO> equipementDTOs = new EquipementTransformer().toDTOList(dtos);
		return equipementDTOs;
	}

	@Transactional
	public EquipementDTO getEquipement(Long idC) {
		return new EquipementTransformer().toDTO(equipementRepository.getOne(idC));
	}
}
