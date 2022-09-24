package com.doctorcattle.cattleservice.controller.animal;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doctorcattle.cattleservice.controller.request.UpdateAnimalDataRequest;
import com.doctorcattle.cattleservice.controller.response.animal.UpdateAnimalDataResponse;
import com.doctorcattle.cattleservice.controller.response.livestock.GetLiveStockResponse;
import com.doctorcattle.cattleservice.dto.animal.AnimalDTO;
import com.doctorcattle.cattleservice.exception.animal.UpdateAnimalDataException;
import com.doctorcattle.cattleservice.exception.farm.FarmNotFoundException;
import com.doctorcattle.cattleservice.service.animal.AnimalService;

@RestController
@RequestMapping(value="/api/cattle-service/")
public class AnimalController {
	
	@Autowired
	private AnimalService animalService;
	
	private static final Logger logger = LoggerFactory.getLogger(AnimalController.class);
	
	@PostMapping(value="update-data")
	public ResponseEntity<UpdateAnimalDataResponse> update(@RequestBody UpdateAnimalDataRequest request){
		UpdateAnimalDataResponse  response = null;
		try {
			AnimalDTO animal = animalService.updateDate((AnimalDTO)request);
			if (null != animal) {
				response = new UpdateAnimalDataResponse(HttpStatus.OK, "Data updated successfully");
			}
		} catch (UpdateAnimalDataException e) {
			response = new UpdateAnimalDataResponse(HttpStatus.BAD_REQUEST,e.getMessage());
			logger.error("Exception occured during updation of animal's data "+e);
		} catch (Exception e) {
			response = new UpdateAnimalDataResponse(HttpStatus.INTERNAL_SERVER_ERROR,"Unable to update data please contact your system administrator");
			logger.error("Exception occured during updation of animal's data "+e);
		}
		return new ResponseEntity<UpdateAnimalDataResponse>(response,response.getStatus());
	}

	
	@GetMapping(value="get-live-stock/{farmId}")
	public ResponseEntity<GetLiveStockResponse> getLiveStock(@PathVariable(value="farmId") Long farmId){
		
		GetLiveStockResponse response = null;
		
		try {
		List<AnimalDTO> animals = animalService.getLiveStock(farmId);
		response = new GetLiveStockResponse(HttpStatus.OK,"Live Stock Found ",animals);
		} catch(FarmNotFoundException e) {
			response = new GetLiveStockResponse(HttpStatus.BAD_REQUEST,e.getMessage(), null);
			logger.error(e.getMessage());
		} catch(Exception e) {
			response = new GetLiveStockResponse(HttpStatus.INTERNAL_SERVER_ERROR,"Unable to process request ", null);
			logger.error(e.toString());
		}
		
		return new ResponseEntity<GetLiveStockResponse>(response,response.getStatus());
		
	}
}
