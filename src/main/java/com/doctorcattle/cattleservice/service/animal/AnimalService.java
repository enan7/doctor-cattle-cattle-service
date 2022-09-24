package com.doctorcattle.cattleservice.service.animal;

import java.util.List;

import com.doctorcattle.cattleservice.dto.animal.AnimalDTO;
import com.doctorcattle.cattleservice.exception.animal.UpdateAnimalDataException;
import com.doctorcattle.cattleservice.exception.farm.FarmNotFoundException;

public interface AnimalService {
	
	public AnimalDTO updateDate(AnimalDTO dto) throws UpdateAnimalDataException;
	
	public List<AnimalDTO> getLiveStock(Long farmId) throws FarmNotFoundException;

}
