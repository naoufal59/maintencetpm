package com.javadev.maintencetpm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javadev.maintencetpm.entites.Equipement;
import com.javadev.maintencetpm.entites.Preventive;

public interface PreventiveRepository extends JpaRepository<Preventive, Long> {

	List<Preventive> findByEquipement(Equipement ty);
}