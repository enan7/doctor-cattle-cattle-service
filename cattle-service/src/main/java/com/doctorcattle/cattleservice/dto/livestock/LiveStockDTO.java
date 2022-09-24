package com.doctorcattle.cattleservice.dto.livestock;

import java.util.List;

import com.doctorcattle.cattleservice.dto.animal.AnimalDTO;

import lombok.Data;

@Data
public class LiveStockDTO {

	private List<AnimalDTO> animals;
}
