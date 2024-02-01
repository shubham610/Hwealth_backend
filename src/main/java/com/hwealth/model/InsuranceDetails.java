package com.hwealth.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class InsuranceDetails {
	private String insuranceTenure;
	private String insuranceType;

}
