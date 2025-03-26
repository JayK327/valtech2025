package com.valtech.hackathon.vehicle.services;

import java.util.List;

import com.valtech.hackathon.vehicle.dtos.VehicleDTO;

public interface VehicleService {

	List<VehicleDTO> getAllVehicles();

	VehicleDTO saveOrUpdateVehicle(VehicleDTO vo);

	VehicleDTO getVehicle(long id);

}