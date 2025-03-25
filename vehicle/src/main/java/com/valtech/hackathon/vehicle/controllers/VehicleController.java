package com.valtech.hackathon.vehicle.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.hackathon.vehicle.services.VehicleService;
import com.valtech.hackathon.vehicle.vos.VehicleVO;


@RestController
@RequestMapping("/api/v1/vehicles")
public class VehicleController {
	@Autowired
	private VehicleService vehicleService;
	
	@GetMapping("/{id}")
	public VehicleVO getVehicle(@PathVariable("id") long id) {
		return vehicleService.getVehicle(id);
	}

	@GetMapping("/")
	public List<VehicleVO> getAllVehicles(){
		return vehicleService.getAllVehicles();
	}
	
	@PostMapping("/")
	public VehicleVO createVehicle(@RequestBody VehicleVO vo) {
		return vehicleService.saveOrUpdateVehicle(vo);
	}
	
	
	
}
