package com.javadev.maintencetpm.service.impl;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;

import com.javadev.maintencetpm.dto.EquipementDTO;
import com.javadev.maintencetpm.dto.PreventiveDTO;
import com.javadev.maintencetpm.entites.Equipement;
import com.javadev.maintencetpm.entites.Preventive;
import com.javadev.maintencetpm.repository.AnomalieRepository;
import com.javadev.maintencetpm.repository.EquipementRepository;
import com.javadev.maintencetpm.repository.PreventiveRepository;
import com.javadev.maintencetpm.service.PreventiveService;
import com.javadev.maintencetpm.transformer.EquipementTransformer;
import com.javadev.maintencetpm.transformer.PreventiveTransformer;


public class PreventiveServiceImpl implements PreventiveService {
	@Autowired
	public PreventiveRepository preventiveRepository;
	@Autowired
	public EquipementRepository equipementRepository;
	@Autowired
	public AnomalieRepository anomalieRepository;
	@Transactional
	public PreventiveDTO create(PreventiveDTO c, Long IdEquipemnet) {
		Preventive preventive = new PreventiveTransformer().toEntity(c);
		Equipement eq = equipementRepository.getOne(IdEquipemnet);
		preventive.setEquipement(eq);
		preventive.setEtat(false);
		preventive.setDate(new Date());
		Preventive preventiveAdd = preventiveRepository.save(preventive);
		PreventiveDTO dto = new PreventiveTransformer().toDTO(preventiveAdd);
		return dto;
	}

	@Transactional
	public List<PreventiveDTO> getAll() {
		List<Preventive> preventives = preventiveRepository.findAll();
		List<Preventive> preven = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		int ordinalDay = cal.get(Calendar.DAY_OF_YEAR);
		int weekDay = cal.get(Calendar.DAY_OF_WEEK) - 1; // Sunday = 0
		int numberOfWeeks = (ordinalDay - weekDay + 10) / 7;
		for (Preventive main : preventives) {
			if (main.getNbSomaime().equals("" + numberOfWeeks) && main.getEtat().equals(false)) {
				preven.add(main);
			}
		}
		List<PreventiveDTO> dtos = new PreventiveTransformer().toDTOList(preven);
		return dtos;
	}

	@Transactional
	public PreventiveDTO getById(Long id) throws Exception {
		if (id == null) {
			throw new Exception("There is no preventive with id null");
		}
		Preventive preventive = preventiveRepository.getOne(id);
		PreventiveDTO dto = new PreventiveTransformer().toDTO(preventive);
		return dto;
	}

	@Transactional
	public List<PreventiveDTO> findByEquipementPreventive(EquipementDTO ty) {
		List<Preventive> preventive = preventiveRepository.findByEquipement(new EquipementTransformer().toEntity(ty));
		List<PreventiveDTO> dtos = new PreventiveTransformer().toDTOList(preventive);
		return dtos;
	}

	@Transactional
	public void GotoTheTablepreventivr(Long id) {
		//AdminControlleur.isGotSomthing = false;
		this.preventiveRepository.getOne(id).setEtat(true);
	}
	
	@Transactional
	public  void writepreventiveObjectToCSV(PrintWriter writer,List<PreventiveDTO> preventives) {
		try (
				CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
	                    .withHeader("la somaine", "Etat", "Action", "Equipement","date"));
		) {
			for (PreventiveDTO customer : preventives) {
				List<? extends Object> data = Arrays.asList(
						customer.getNb_Somaime(),
						customer.getEtat(),
						customer.getAction(),
						customer.getEquipement().getNom(),
						customer.getDate()
					);
				
				csvPrinter.printRecord(data);
			}
			csvPrinter.flush();
		} catch (Exception e) {
			System.out.println("Writing CSV error!");
			e.printStackTrace();
		}
	}
}
