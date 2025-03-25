package com.valtech.hackathon.vehicle.services;

import java.util.List;

import com.valtech.hackathon.vehicle.vos.VehicleVO;

public interface VehicleService {

	List<VehicleVO> getAllVehicles();

	VehicleVO saveOrUpdateVehicle(VehicleVO vo);

	VehicleVO getVehicle(long id);

}