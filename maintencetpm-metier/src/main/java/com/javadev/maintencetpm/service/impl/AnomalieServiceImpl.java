package com.javadev.maintencetpm.service.impl;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;

import com.javadev.maintencetpm.dto.AnomalieDTO;
import com.javadev.maintencetpm.dto.EquipementDTO;
import com.javadev.maintencetpm.entites.Anomalie;
import com.javadev.maintencetpm.entites.Equipement;
import com.javadev.maintencetpm.repository.AnomalieRepository;
import com.javadev.maintencetpm.repository.EquipementRepository;
import com.javadev.maintencetpm.service.AnomalieService;
import com.javadev.maintencetpm.transformer.AnomalieTransformer;
import com.javadev.maintencetpm.transformer.EquipementTransformer;


public class AnomalieServiceImpl implements AnomalieService {
	@Autowired
	public AnomalieRepository anomalieRepository;
	@Autowired
	public EquipementRepository equipementRepository;

	@Transactional
	public AnomalieDTO ajouterAnomalie(AnomalieDTO c, Long IdEquipemnet) {
		Anomalie anomalie = new AnomalieTransformer().toEntity(c);
		Equipement eq = equipementRepository.getOne(IdEquipemnet);
		anomalie.setEquipement(eq);
		Random rng = new Random();
		int next = rng.nextInt(100) + 1;
		anomalie.setReferrence("" + next);
		anomalie.setEtat(false);
		anomalie.setDateanomalie(new Date());
		Anomalie anomalieSave = anomalieRepository.save(anomalie);
		AnomalieDTO anomalieDTO = new AnomalieTransformer().toDTO(anomalieSave);
		return anomalieDTO;
	}

	@Transactional
	public List<AnomalieDTO> findByEquipementAnomalie(EquipementDTO ty) {
		List<Anomalie> anomalies = anomalieRepository.findByEquipement(new EquipementTransformer().toEntity(ty));
		List<AnomalieDTO> anomalieDTOs = new AnomalieTransformer().toDTOList(anomalies);
		return anomalieDTOs;
	}

	@Override
	public List<AnomalieDTO> getAll() {
		List<Anomalie> anomalies = anomalieRepository.findAll();
		List<AnomalieDTO> anomalieDTOs = new AnomalieTransformer().toDTOList(anomalies);
		return anomalieDTOs;
	}

	@Transactional
	public List<AnomalieDTO> inValideAnomalie() {
		List<Anomalie> anomalies = anomalieRepository.findAll();
		List<Anomalie> anomalie = new ArrayList<>();
		for (Anomalie main : anomalies) {
			if (main.getEtat().equals(false)) {
				anomalie.add(main);
			}
		}
		List<AnomalieDTO> dtos = new AnomalieTransformer().toDTOList(anomalie);
		return dtos;
	}

	@Transactional
	public AnomalieDTO getById(Long id) throws Exception {
		if (id == null) {
			throw new Exception("There is no anomalie with id null");
		}
		Anomalie anomalie = anomalieRepository.getOne(id);
		AnomalieDTO dto = new AnomalieTransformer().toDTO(anomalie);
		return dto;

	}

	@Transactional
	public void GotoTheTableAnomalie(Long id) {
		// AdminControlleur.isGotSomthing=false;
		this.anomalieRepository.getOne(id).setEtat(true);

	}

//	@Transactional
//	public List<AnomalieDTO> listAnomalie() {
//		return new AnomalieTransformer().toDTOList(anomalieRepository.findAll());
//	}

	@Transactional
	public void writeAnomalieObjectToCSV(PrintWriter writer, List<AnomalieDTO> anomalies) {
		try (CSVPrinter csvPrinter = new CSVPrinter(writer,
				CSVFormat.DEFAULT.withHeader("Description", "Ref", "Type", "Equipement", "date"));) {
			for (AnomalieDTO customer : anomalies) {
				List<? extends Object> data = Arrays.asList(customer.getDescription(), customer.getReferrence(),
						customer.getTypeAnomalie(), customer.getEquipement().getNom(), customer.getDateAnomalie());

				csvPrinter.printRecord(data);
			}
			csvPrinter.flush();
		} catch (Exception e) {
			System.out.println("Writing CSV error!");
			e.printStackTrace();
		}
	}
}
