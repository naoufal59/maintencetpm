package com.javadev.maintencetpm.transformer;

import com.javadev.maintencetpm.dto.PreventiveDTO;
import com.javadev.maintencetpm.entites.Preventive;

public class PreventiveTransformer extends AbstractTransformer<PreventiveDTO, Preventive> {

	@Override
	public PreventiveDTO toDTO(Preventive entity) {
		PreventiveDTO preventiveDTO = new PreventiveDTO();
		preventiveDTO.setNb_Somaime(entity.getNbSomaime());
		preventiveDTO.setAction(entity.getAction());
		preventiveDTO.setEtat(entity.getEtat());
		preventiveDTO.setDate(entity.getDate());
		preventiveDTO.setEquipement(new EquipementTransformer().toDTO(entity.getEquipement()));
		return preventiveDTO;
	}

	@Override
	public Preventive toEntity(PreventiveDTO dto) {
		Preventive preventive = new Preventive();
		preventive.setNbSomaime(dto.getNb_Somaime());
		preventive.setAction(dto.getAction());
		preventive.setEtat(dto.getEtat());
		preventive.setDate(dto.getDate());
		preventive.setEquipement(new EquipementTransformer().toEntity(dto.getEquipement()));
		return preventive;
	}

}
