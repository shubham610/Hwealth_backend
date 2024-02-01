package com.hwealth.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class PersonalDetails {
	private String userName;
	private String userMailId;

}
