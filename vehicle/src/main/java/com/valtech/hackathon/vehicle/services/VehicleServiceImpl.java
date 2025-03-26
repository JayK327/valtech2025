package com.valtech.hackathon.vehicle.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.hackathon.vehicle.dtos.VehicleDTO;
import com.valtech.hackathon.vehicle.entities.Vehicle;
import com.valtech.hackathon.vehicle.repository.VehicleRepository;


@Service
@Transactional(propagation = Propagation.REQUIRED)
public class VehicleServiceImpl implements VehicleService {
	@Autowired
	private VehicleRepository vehicleRepo;
	
	
	@Override
	public List<VehicleDTO> getAllVehicles(){
		return vehicleRepo.findAll().stream().map(l->VehicleDTO.from(l)).collect(Collectors.toList());
	}

	@Override
	public VehicleDTO saveOrUpdateVehicle(VehicleDTO vo) {
		Vehicle v=vo.to();
		v= vehicleRepo.save(v);
		return VehicleDTO.from(v);
	}
	@Override   
	public VehicleDTO getVehicle(long id) {
		return VehicleDTO.from(vehicleRepo.getReferenceById(id));
	}
	
	
}