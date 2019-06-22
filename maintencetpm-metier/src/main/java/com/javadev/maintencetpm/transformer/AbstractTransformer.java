package com.javadev.maintencetpm.transformer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public abstract class AbstractTransformer<DTO, Entity> {

	abstract DTO toDTO(Entity entity);

	abstract Entity toEntity(DTO dto);

	public List<DTO> toDTOList(List<Entity> entityList) {

		List<DTO> dtoList = new ArrayList<DTO>();

		for (Entity entity : entityList) {
			dtoList.add(toDTO(entity));
		}

		return dtoList;
	}

	public List<Entity> toEntityList(List<DTO> dtoList) {

		List<Entity> entityList = new ArrayList<Entity>();

		for (DTO dto : dtoList) {
			entityList.add(toEntity(dto));
		}

		return entityList;
	}

	public Collection<DTO> toDTOList(Collection<Entity> entityList) {

		Collection<DTO> dtoList = new HashSet<DTO>();

		for (Entity entity : entityList) {
			dtoList.add(toDTO(entity));
		}

		return dtoList;
	}

	public Collection<Entity> toEntityList(Collection<DTO> dtoList) {

		Collection<Entity> entityList = new HashSet<Entity>();

		for (DTO dto : dtoList) {
			entityList.add(toEntity(dto));
		}

		return entityList;
	}
}