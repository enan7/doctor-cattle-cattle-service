package com.doctorcattle.cattleservice.entity.animal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Table(name="animals")
@Entity
public class Animal {

	private static final String Prefix = "animal_";
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name=Prefix+"id")
	private Long id;
	
	@Column(name=Prefix+"deviceNumber",unique = true)
	private String deviceNumber;
	
	@Column(name=Prefix+"farmId")
	private Long farmId;
	
	@Column(name=Prefix+"temprature")
	private Double temprature;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDeviceNumber() {
		return deviceNumber;
	}

	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}

	public Long getFarmId() {
		return farmId;
	}

	public void setFarmId(Long farmId) {
		this.farmId = farmId;
	}

	public Double getTemprature() {
		return temprature;
	}

	public void setTemprature(Double temprature) {
		this.temprature = temprature;
	}
	
	
	
}
