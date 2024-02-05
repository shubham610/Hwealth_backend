package com.hwealth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hwealth.exception.HealthException;
import com.hwealth.exception.UserException;
import com.hwealth.exception.VehicleException;
import com.hwealth.model.HealthInsurance;
import com.hwealth.model.User;
import com.hwealth.model.VehicleInsurance;
import com.hwealth.service.HealthInsuranceService;
import com.hwealth.service.VehicleInsuranceService;

@RestController
@RequestMapping("/health")
@CrossOrigin("http://localhost:4200/")
public class HealthInsuranceController {
	
	@Autowired
	HealthInsuranceService healthService;
	
	@PostMapping("/add")
	public ResponseEntity<HealthInsurance> addInsurance(@RequestBody HealthInsurance insurance) {
		try {
		return  new ResponseEntity<HealthInsurance> (healthService.addInsurance(insurance),HttpStatus.CREATED);
		}
		catch (HealthException e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		
		
	}
	@GetMapping("/all")
	public ResponseEntity<List<HealthInsurance>> getAllHealthInsurance() {
		try {
		return  new ResponseEntity<List<HealthInsurance>>( healthService.getAllinsurance(),HttpStatus.OK) ;
		}
		catch (HealthException e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<HealthInsurance>> getUserHealthInsurance(@PathVariable("userId") long userId) {
		try {
				
		return  new ResponseEntity<List<HealthInsurance>>(healthService.getAllinsurance().stream().filter(a->a.getUser().getUserId()==userId).toList(),HttpStatus.OK) ;
		}
		catch (VehicleException e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
}
