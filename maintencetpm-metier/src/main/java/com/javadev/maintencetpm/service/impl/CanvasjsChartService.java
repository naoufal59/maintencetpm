package com.javadev.maintencetpm.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javadev.maintencetpm.dto.DataPointModelDTO;
import com.javadev.maintencetpm.dto.EquipementDTO;
import com.javadev.maintencetpm.repository.KpiRepository;
import com.javadev.maintencetpm.transformer.DataPointModelTransformer;

public class CanvasjsChartService {

	@Autowired
	public KpiRepository kpiRepository;

	@Transactional
	public Map<String, Double> getCanvasjsChartData() {

		Map<String, Double> map = new LinkedHashMap<String, Double>();
		List<DataPointModelDTO> resultSet = new DataPointModelTransformer().toDTOList(kpiRepository.findAll());

		for (DataPointModelDTO kpi : resultSet) {
			map.put(kpi.getSomaine(), Double.parseDouble(kpi.getMTTR()));
			// System.out.println(map);
		}

		return map;
	}

	@Transactional
	public Map<String, Double> getCanvasjsChartDataChercher(EquipementDTO ty) {

		Map<String, Double> map = new LinkedHashMap<String, Double>();

		List<DataPointModelDTO> resultSet = new DataPointModelTransformer().toDTOList(kpiRepository.findAll());

		for (DataPointModelDTO kpi : resultSet) {
			if (kpi.getEquipement().getId().equals(ty.getId())) {
				map.put(kpi.getSomaine(), Double.parseDouble(kpi.getMTTR()));
			}
		}

		return map;
	}

	@Transactional
	public Map<String, Double> getCanvasjsChartDataMTRF() {

		Map<String, Double> map = new LinkedHashMap<String, Double>();
		List<DataPointModelDTO> resultSet = new DataPointModelTransformer().toDTOList(kpiRepository.findAll());

		for (DataPointModelDTO kpi : resultSet) {
			map.put(kpi.getSomaine(), Double.parseDouble(kpi.getMTRF()));

		}

		return map;
	}

	@Transactional
	public Map<String, Double> getCanvasjsChartDataMTRFChercher(EquipementDTO ty) {

		Map<String, Double> map = new LinkedHashMap<String, Double>();
		List<DataPointModelDTO> resultSet = new DataPointModelTransformer().toDTOList(kpiRepository.findAll());

		for (DataPointModelDTO kpi : resultSet) {
			if (kpi.getEquipement().getId().equals(ty.getId())) {
				map.put(kpi.getSomaine(), Double.parseDouble(kpi.getMTRF()));
			}
		}

		return map;
	}

	@Transactional
	public Map<String, Double> getCanvasjsChartDataDispo() {

		Map<String, Double> map = new LinkedHashMap<String, Double>();
		List<DataPointModelDTO> resultSet = new DataPointModelTransformer().toDTOList(kpiRepository.findAll());

		for (DataPointModelDTO kpi : resultSet) {
			map.put(kpi.getSomaine(), Double.parseDouble(kpi.getDisbo()));

		}

		return map;
	}

	@Transactional
	public Map<String, Double> getCanvasjsChartDataDispoChercher(EquipementDTO ty) {

		Map<String, Double> map = new LinkedHashMap<String, Double>();
		List<DataPointModelDTO> resultSet = new DataPointModelTransformer().toDTOList(kpiRepository.findAll());

		for (DataPointModelDTO kpi : resultSet) {
			if (kpi.getEquipement().getId().equals(ty.getId())) {
				map.put(kpi.getSomaine(), Double.parseDouble(kpi.getDisbo()));
			}
		}

		return map;
	}
}