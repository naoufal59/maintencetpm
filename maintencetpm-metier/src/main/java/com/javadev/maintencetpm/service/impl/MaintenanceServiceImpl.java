package com.javadev.maintencetpm.service.impl;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;

import com.javadev.maintencetpm.dto.EquipementDTO;
import com.javadev.maintencetpm.dto.MaintenaceDTO;
import com.javadev.maintencetpm.entites.Maintenace;
import com.javadev.maintencetpm.repository.EquipementRepository;
import com.javadev.maintencetpm.repository.MaintenaceRepository;
import com.javadev.maintencetpm.service.MaintenanceService;
import com.javadev.maintencetpm.transformer.EquipementTransformer;
import com.javadev.maintencetpm.transformer.MaintenceTransformer;


public class MaintenanceServiceImpl implements MaintenanceService {
	@Autowired
	public MaintenaceRepository maintenaceRepository;
	@Autowired
	public EquipementRepository equipementRepository;

	@Transactional
	public List<MaintenaceDTO> listMaintenance() {
		List<Maintenace> maintenace = maintenaceRepository.findAll();
		return new MaintenceTransformer().toDTOList(maintenace);
	}

	@Transactional
	public void validMaintenceDTO(Long maintenceID) {
		new MaintenceTransformer().toDTO(maintenaceRepository.getOne(maintenceID)).setEtat(true);
	}

	@Transactional
	public void rejectMaintenceDTO(Long maintenceID) {
		new MaintenceTransformer().toDTO(maintenaceRepository.getOne(maintenceID)).setEtat(false);
	}

	@Transactional
	public List<MaintenaceDTO> inValideMaintenace() {
		List<Maintenace> maintenaces = maintenaceRepository.findAll();
		List<Maintenace> maintenace = new ArrayList<>();
		for (Maintenace maintenac : maintenaces) {
			if (maintenac.getEtat().equals(false)) {
				maintenace.add(maintenac);
			}
		}
		return new MaintenceTransformer().toDTOList(maintenace);
	}

	@Transactional
	public List<MaintenaceDTO> findByEquipement(EquipementDTO ty) {
		return new MaintenceTransformer()
				.toDTOList(maintenaceRepository.findByEquipement(new EquipementTransformer().toEntity(ty)));
	}

	@Transactional
	public void writeObjectToCSV(PrintWriter writer, List<MaintenaceDTO> maintenaces) {
		try (CSVPrinter csvPrinter = new CSVPrinter(writer,
				CSVFormat.DEFAULT.withHeader("Description", "Comment", "Pilot", "Equipement", "date"));) {
			for (MaintenaceDTO customer : maintenaces) {
				List<? extends Object> data = Arrays.asList(customer.getDescription(), customer.getComment(),
						customer.getPilot(), customer.getEquipement().getNom(), customer.getDatemaintenace());

				csvPrinter.printRecord(data);
			}
			csvPrinter.flush();
		} catch (Exception e) {
			System.out.println("Writing CSV error!");
			e.printStackTrace();
		}
	}

	@Transactional
	public MaintenaceDTO ajouterMainteance(MaintenaceDTO c, Long IdEquipemnet) {
		EquipementDTO eq = new EquipementTransformer().toDTO(equipementRepository.getOne(IdEquipemnet));
		c.setEquipement(eq);
		c.setDatemaintenace(new Date());
		return new MaintenceTransformer().toDTO(maintenaceRepository.save(new MaintenceTransformer().toEntity(c)));
	}

	@Transactional
	public MaintenaceDTO getMaintence(Long id) {

		return new MaintenceTransformer().toDTO(maintenaceRepository.getOne(id));

	}
	
	@Transactional
	public void GotoTheTable(Long id) {
		//AdminControlleur.isGotSomthing=false;
		new MaintenceTransformer().toDTO(maintenaceRepository.getOne(id)).setEtat(true);
		
	}
}
