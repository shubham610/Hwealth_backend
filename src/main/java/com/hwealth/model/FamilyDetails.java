package com.hwealth.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Embeddable
@Data
public class FamilyDetails {
	private int numChild;
	private int numAdult;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Child> childs;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Adult> adults;

}
