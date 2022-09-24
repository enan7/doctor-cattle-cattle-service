package com.doctorcattle.cattleservice.adapter.animal;

import com.doctorcattle.cattleservice.dto.animal.AnimalDTO;
import com.doctorcattle.cattleservice.entity.animal.Animal;

public class AnimalAdapter {
	
	public AnimalDTO getAnimalDTO (Animal animal) {
		if (null == animal) {
			return null;
		}
		
		AnimalDTO animalDTO = new AnimalDTO();
		
		animalDTO.setDeviceNumber(animal.getDeviceNumber());
		animalDTO.setId(animal.getId());
		animalDTO.setFarmId(animal.getFarmId());
		animalDTO.setTemprature(animal.getTemprature());
		return animalDTO;
	}

	public Animal getAnimal (AnimalDTO animalDto) {
		if (null == animalDto) {
			return null;
		}
		
		Animal animal = new Animal();
		
		animal.setDeviceNumber(animalDto.getDeviceNumber());
		animal.setId(animalDto.getId());
		animal.setFarmId(animalDto.getFarmId());
		animal.setTemprature(animalDto.getTemprature());
		return animal;
	}
}
