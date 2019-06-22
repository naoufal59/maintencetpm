package com.javadev.maintencetpm.transformer;

import com.javadev.maintencetpm.dto.MaintenaceDTO;
import com.javadev.maintencetpm.entites.Maintenace;

public class MaintenceTransformer extends AbstractTransformer<MaintenaceDTO, Maintenace> {

	@Override
	public MaintenaceDTO toDTO(Maintenace entity) {
		MaintenaceDTO maintenaceDTO = new MaintenaceDTO();
		maintenaceDTO.setDescription(entity.getDescription());
		maintenaceDTO.setComment(entity.getComment());
		maintenaceDTO.setPilot(entity.getPilot());
		maintenaceDTO.setEtat(entity.getEtat());
		maintenaceDTO.setDatemaintenace(entity.getDatemaintenace());
		maintenaceDTO.setEquipement(new EquipementTransformer().toDTO(entity.getEquipement()));
		return maintenaceDTO;
	}

	@Override
	public Maintenace toEntity(MaintenaceDTO dto) {
		Maintenace maintenace = new Maintenace();
		maintenace.setDescription(dto.getDescription());
		maintenace.setComment(dto.getComment());
		maintenace.setPilot(dto.getPilot());
		maintenace.setEtat(dto.getEtat());
		maintenace.setDatemaintenace(dto.getDatemaintenace());
		maintenace.setEquipement(new EquipementTransformer().toEntity(dto.getEquipement()));
		return maintenace;
	}

}
