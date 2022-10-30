package com.doctorcattle.cattleservice.controller.request.farm;

import lombok.Data;

@Data
public class IsFarmExistsRequest {
	
	private long farmId;
	private boolean updateLiveStock;

}
