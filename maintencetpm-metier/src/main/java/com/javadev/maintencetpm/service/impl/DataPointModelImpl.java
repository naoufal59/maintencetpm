package com.javadev.maintencetpm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.javadev.maintencetpm.dto.DataPointModelDTO;
import com.javadev.maintencetpm.entites.Equipement;
import com.javadev.maintencetpm.repository.EquipementRepository;
import com.javadev.maintencetpm.repository.KpiRepository;
import com.javadev.maintencetpm.service.DataPointModelService;
import com.javadev.maintencetpm.transformer.DataPointModelTransformer;

public class DataPointModelImpl implements DataPointModelService {
	@Autowired
	public KpiRepository kpiRepository;

	@Autowired
	public EquipementRepository equipementRepository;

	@Override
	public DataPointModelDTO ajouterMttr(DataPointModelDTO p, Long code) {
		Equipement eq = equipementRepository.getOne(code);
		com.javadev.maintencetpm.entites.DataPointModel dataPointModel = new DataPointModelTransformer().toEntity(p);
		dataPointModel.setEquipement(eq);
		return new DataPointModelTransformer().toDTO(kpiRepository.save(dataPointModel));
	}

}
