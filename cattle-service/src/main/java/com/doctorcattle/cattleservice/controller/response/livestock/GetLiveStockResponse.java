package com.doctorcattle.cattleservice.controller.response.livestock;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.doctorcattle.cattleservice.controller.response.BaseResponse;
import com.doctorcattle.cattleservice.dto.animal.AnimalDTO;

import lombok.Getter;


public class GetLiveStockResponse extends BaseResponse {

	@Getter
	private List<AnimalDTO> animals;
	
	public GetLiveStockResponse(HttpStatus status, String message,List<AnimalDTO> animals) {
		super(status, message);
		this.animals = animals;
	}
	

}
