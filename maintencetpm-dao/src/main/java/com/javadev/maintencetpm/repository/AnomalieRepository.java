package com.javadev.maintencetpm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javadev.maintencetpm.entites.Anomalie;
import com.javadev.maintencetpm.entites.Equipement;

public interface AnomalieRepository extends JpaRepository<Anomalie, Long> {

	List<Anomalie> findByEquipement(Equipement ty);
}