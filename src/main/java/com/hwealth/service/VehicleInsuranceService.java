package com.hwealth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hwealth.dao.VehicleInsuranceDao;
import com.hwealth.exception.UserException;
import com.hwealth.exception.VehicleException;
import com.hwealth.model.User;
import com.hwealth.model.VehicleInsurance;

@Service
public class VehicleInsuranceService {
	
	@Autowired
	VehicleInsuranceDao vehicleDao;
	
	public VehicleInsurance addInsurance(VehicleInsurance insurance) {
		return vehicleDao.save(insurance);
	}
	public List<VehicleInsurance> getAllinsurance() {
		if (vehicleDao.findAll().size() == 0)
			throw new VehicleException("Vehicle Insurance list is empty");
		else
			return vehicleDao.findAll();
	}
}
