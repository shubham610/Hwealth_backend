package com.hwealth.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data

public class User {
	
	@Id
	@GeneratedValue
	private long userId;
	private String userName;
	private long userPhoneNo;
	private String userPassword;

}
