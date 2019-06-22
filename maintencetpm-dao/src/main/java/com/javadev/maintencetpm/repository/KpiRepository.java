package com.javadev.maintencetpm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javadev.maintencetpm.entites.DataPointModel;

public interface KpiRepository extends JpaRepository<DataPointModel, Long>{

}
