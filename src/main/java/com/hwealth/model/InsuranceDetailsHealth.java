package com.hwealth.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class InsuranceDetailsHealth {
	private String tenure;
	private String type;

}
