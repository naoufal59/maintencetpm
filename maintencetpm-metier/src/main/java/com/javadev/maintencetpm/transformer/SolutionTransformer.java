package com.javadev.maintencetpm.transformer;

import com.javadev.maintencetpm.dto.SolutionDTO;
import com.javadev.maintencetpm.entites.Solution;

public class SolutionTransformer extends AbstractTransformer<SolutionDTO, Solution> {

	@Override
	public SolutionDTO toDTO(Solution entity) {
		SolutionDTO solutionDTO = new SolutionDTO();
		solutionDTO.setDescription(entity.getDescription());
		solutionDTO.setAnomalie(new AnomalieTransformer().toDTO(entity.getAnomalie()));
		solutionDTO.setPreventive(new PreventiveTransformer().toDTO(entity.getPreventive()));
		solutionDTO.setMaintenace(new MaintenceTransformer().toDTO(entity.getMaintenace()));
		return solutionDTO;
	}

	@Override
	public Solution toEntity(SolutionDTO dto) {
		Solution solution = new Solution();
		solution.setDescription(dto.getDescription());
		solution.setAnomalie(new AnomalieTransformer().toEntity(dto.getAnomalie()));
		solution.setPreventive(new PreventiveTransformer().toEntity(dto.getPreventive()));
		solution.setMaintenace(new MaintenceTransformer().toEntity(dto.getMaintenace()));
		return solution;
	}

}
