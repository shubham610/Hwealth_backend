package com.hwealth.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class VehicleDetails {
	
	private String vehicleModel;
	private String vehicleType;
	private String vehicleRegistrationNo;
	private String vehicleRegistrationDate;

}
