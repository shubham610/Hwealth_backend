package com.hwealth.model;

import java.sql.Date;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class VehicleInsurance {
	
	@Id
	@GeneratedValue
	private long insuranceId;
	@ManyToOne
	private User user;
	@Embedded
	private PersonalDetails personalDetails;
	@Embedded
	private VehicleDetails vehicleDetails;
	@Embedded
	private InsuranceDetails insuranceDetails;
	private long amount;
	
}
