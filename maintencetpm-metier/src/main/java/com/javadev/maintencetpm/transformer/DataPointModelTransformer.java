package com.javadev.maintencetpm.transformer;

import com.javadev.maintencetpm.dto.DataPointModelDTO;
import com.javadev.maintencetpm.entites.DataPointModel;

public class DataPointModelTransformer extends AbstractTransformer<DataPointModelDTO, DataPointModel>  {

	@Override
	public DataPointModelDTO toDTO(DataPointModel entity) {
		DataPointModelDTO pointModel = new DataPointModelDTO();
		pointModel.setSomaine(entity.getWeek());
		pointModel.setMTTR(entity.getMTTR());
		pointModel.setMTRF(entity.getMTRF());
		pointModel.setDisbo(entity.getDisbo());
		pointModel.setEquipement(new EquipementTransformer().toDTO(entity.getEquipement()));
		return pointModel;
	}

	@Override
	public DataPointModel toEntity(DataPointModelDTO dto) {
		DataPointModel model = new DataPointModel();
		model.setWeek(dto.getSomaine());
		model.setMTTR(dto.getMTTR());
		model.setMTRF(dto.getMTRF());
		model.setDisbo(dto.getDisbo());
		model.setEquipement(new EquipementTransformer().toEntity(dto.getEquipement()));
		return model;
	}

}
