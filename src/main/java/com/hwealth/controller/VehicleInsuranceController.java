package com.hwealth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hwealth.exception.UserException;
import com.hwealth.exception.VehicleException;
import com.hwealth.model.User;
import com.hwealth.model.VehicleInsurance;
import com.hwealth.service.VehicleInsuranceService;

@RestController
@RequestMapping("/vehicle")
@CrossOrigin("http://localhost:4200/")
public class VehicleInsuranceController {
	
	@Autowired
	VehicleInsuranceService vehicleService;
	
	@PostMapping("/add")
	public ResponseEntity<VehicleInsurance> addInsurance(@RequestBody VehicleInsurance insurance) {
		try {
		return  new ResponseEntity<VehicleInsurance> (vehicleService.addInsurance(insurance),HttpStatus.CREATED);
		}
		catch (VehicleException e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		
		
	}
	@GetMapping("/all")
	public ResponseEntity<List<VehicleInsurance>> getAllVehicleInsurance() {
		try {
		return  new ResponseEntity<List<VehicleInsurance>>( vehicleService.getAllinsurance(),HttpStatus.OK) ;
		}
		catch (VehicleException e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
}
