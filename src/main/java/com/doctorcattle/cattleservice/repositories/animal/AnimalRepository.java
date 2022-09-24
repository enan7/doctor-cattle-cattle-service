package com.doctorcattle.cattleservice.repositories.animal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doctorcattle.cattleservice.entity.animal.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

	public Animal findByDeviceNumber(String deviceNumber);
	
	public List<Animal> findByFarmId(Long farmId);
}
