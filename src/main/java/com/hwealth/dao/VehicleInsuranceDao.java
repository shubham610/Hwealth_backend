package com.hwealth.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hwealth.model.VehicleInsurance;

@Repository
public interface VehicleInsuranceDao extends JpaRepository<VehicleInsurance, Long>{

}
