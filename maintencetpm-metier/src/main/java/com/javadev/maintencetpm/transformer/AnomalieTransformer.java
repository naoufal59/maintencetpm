package com.javadev.maintencetpm.transformer;

import com.javadev.maintencetpm.dto.AnomalieDTO;
import com.javadev.maintencetpm.entites.Anomalie;

public class AnomalieTransformer extends AbstractTransformer<AnomalieDTO, Anomalie> {

	@Override
	public AnomalieDTO toDTO(Anomalie entity) {
		AnomalieDTO anomalieDTO = new AnomalieDTO();
		anomalieDTO.setDescription(entity.getDescription());
		anomalieDTO.setTypeAnomalie(entity.getTypeAnomalie());
		anomalieDTO.setReferrence(entity.getReferrence());
		anomalieDTO.setEtat(entity.getEtat());
		anomalieDTO.setDateAnomalie(entity.getDateanomalie());
        anomalieDTO.setEquipement(new EquipementTransformer().toDTO(entity.getEquipement()));
		return anomalieDTO;
	}

	@Override
	public Anomalie toEntity(AnomalieDTO dto) {
        Anomalie  anomalie = new Anomalie();
        anomalie.setDescription(dto.getDescription());
        anomalie.setTypeAnomalie(dto.getTypeAnomalie());
        anomalie.setReferrence(dto.getReferrence());
        anomalie.setEtat(dto.getEtat());
        anomalie.setDateanomalie(dto.getDateAnomalie());
        anomalie.setEquipement(new EquipementTransformer().toEntity(dto.getEquipement()));
		return anomalie;
	}

}
