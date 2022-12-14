package com.doctorcattle.cattleservice.controller.response;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BaseResponse {
	
	private HttpStatus status;
	private String message;
	
}
