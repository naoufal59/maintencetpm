package com.javadev.maintencetpm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javadev.maintencetpm.entites.Equipement;
import com.javadev.maintencetpm.entites.Maintenace;

public interface MaintenaceRepository  extends JpaRepository<Maintenace, Long>  {
	
	List<Maintenace> findByEquipement(Equipement ty);
}