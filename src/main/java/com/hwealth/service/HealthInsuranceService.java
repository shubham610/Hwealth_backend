package com.hwealth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hwealth.dao.HealthInsuranceDao;
import com.hwealth.dao.VehicleInsuranceDao;
import com.hwealth.exception.HealthException;
import com.hwealth.exception.UserException;
import com.hwealth.exception.VehicleException;
import com.hwealth.model.HealthInsurance;
import com.hwealth.model.User;
import com.hwealth.model.VehicleInsurance;

@Service
public class HealthInsuranceService {
	
	@Autowired
	HealthInsuranceDao healthDao;
	
	public HealthInsurance addInsurance(HealthInsurance insurance) {
		return healthDao.save(insurance);
	}
	public List<HealthInsurance> getAllinsurance() {
		if (healthDao.findAll().size() == 0)
			throw new HealthException("Vehicle Insurance list is empty");
		else
			return healthDao.findAll();
	}
}
