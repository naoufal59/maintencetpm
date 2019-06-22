package com.javadev.maintencetpm.service;

import org.springframework.stereotype.Service;

import com.javadev.maintencetpm.dto.DataPointModelDTO;

@Service
public interface DataPointModelService {
	DataPointModelDTO ajouterMttr(DataPointModelDTO p, Long code);
}
