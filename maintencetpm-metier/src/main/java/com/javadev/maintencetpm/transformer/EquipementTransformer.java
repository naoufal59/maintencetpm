package com.javadev.maintencetpm.transformer;

import com.javadev.maintencetpm.dto.EquipementDTO;
import com.javadev.maintencetpm.entites.Equipement;

public class EquipementTransformer extends AbstractTransformer<EquipementDTO, Equipement> {

	@Override
	public EquipementDTO toDTO(Equipement entity) {
		EquipementDTO dto = new EquipementDTO();
		dto.setDescription(entity.getDescription());
		dto.setNom(entity.getNom());
		dto.setEtat(entity.getEtat());
		return dto;
	}

	@Override
	public Equipement toEntity(EquipementDTO dto) {
		Equipement equipement = new Equipement();
		equipement.setDescription(dto.getDescription());
		equipement.setNom(dto.getNom());
		equipement.setEtat(dto.getEtat());
		return equipement;
	}

}
