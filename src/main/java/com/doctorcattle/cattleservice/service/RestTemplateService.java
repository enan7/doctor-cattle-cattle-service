package com.doctorcattle.cattleservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplateService {

//	@Autowired
//	private RestTemplate restTemplate;
//	
	
	private RestTemplate restTemplate;

	public RestTemplateService() {
		restTemplate = new RestTemplate();
	}
	protected <T extends Object> T getForObject(String serviceName,String url,Class<T> returnType) {

		return   (T) restTemplate.getForObject("https://"+serviceName+url, returnType);

	}
	protected <T extends Object> T getForObject(UrlMapper urlMapper,Object parameter,Class<T> returnType) {
		return   (T) restTemplate.getForObject(urlMapper.getUrl()+parameter ,returnType);

	}
	protected <T extends Object> T postForEntity(UrlMapper urlMapper,Object body,Class<T> returnType) {
		return   (T) restTemplate.postForEntity(urlMapper.getUrl(),body ,returnType).getBody();

	}
}
