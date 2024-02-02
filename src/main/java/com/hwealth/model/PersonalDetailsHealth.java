package com.hwealth.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class PersonalDetailsHealth {

	private String name;
	private String email;
	private int age;
	
}
