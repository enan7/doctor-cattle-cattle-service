package com.doctorcattle.cattleservice.service.animal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.doctorcattle.cattleservice.adapter.animal.AnimalAdapter;
import com.doctorcattle.cattleservice.dto.animal.AnimalDTO;
import com.doctorcattle.cattleservice.entity.animal.Animal;
import com.doctorcattle.cattleservice.exception.animal.UpdateAnimalDataException;
import com.doctorcattle.cattleservice.exception.farm.FarmNotFoundException;
import com.doctorcattle.cattleservice.repositories.animal.AnimalRepository;
import com.doctorcattle.cattleservice.service.RestTemplateService;

@Service
public class AnimalServiceImpl extends RestTemplateService implements AnimalService {

	@Autowired
	private AnimalRepository animalRepository;

	@Autowired
	private RestTemplate restTemplate;

	public AnimalDTO updateDate(AnimalDTO dto) throws UpdateAnimalDataException {
		if (null == dto.getFarmId()) {
			throw new UpdateAnimalDataException("No Farm Id Found");
		}
		boolean farmExists = getForObject("doctor-cattle-customer-service.herokuapp.com",
				"/api/customer-service/company/farm-exists/" + dto.getFarmId(), Boolean.class);
		if (!farmExists) {
			throw new UpdateAnimalDataException("No Farm Exists With Id : " + dto.getFarmId());
		}
		if (null == dto.getDeviceNumber()) {
			throw new UpdateAnimalDataException("Device Number is required ");
		}
		Animal animal = findByDeviceNumber(dto.getDeviceNumber());
		if (animal == null) {
			animal = new Animal();
		}
		animal.setDeviceNumber(dto.getDeviceNumber());
		animal.setFarmId(dto.getFarmId());
		animal.setTemprature(dto.getTemprature());
		animal = animalRepository.save(animal);
		AnimalAdapter animalAdapter = new AnimalAdapter();
		return animalAdapter.getAnimalDTO(animal);

	}

	public List<AnimalDTO> getLiveStock(Long farmId) throws FarmNotFoundException {
		List<Animal> animals =  animalRepository.findByFarmId(farmId);
		if (null != animals && animals.size() != 0 ) {
			 List<AnimalDTO> animalsDTOS = null;
			AnimalAdapter adapter = new AnimalAdapter();
			animalsDTOS = animals.stream().map(animal->(adapter.getAnimalDTO(animal))).collect(Collectors.toList());
			return animalsDTOS;
		}
		throw new FarmNotFoundException("Unable to found live stock  with farm id : "+farmId);
	}
	
	
	private Animal findByDeviceNumber(String deviceNumber) {
		return animalRepository.findByDeviceNumber(deviceNumber);
	}

	

}
