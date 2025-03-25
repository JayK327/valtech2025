package com.valtech.hackathon.vehicle.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.hackathon.vehicle.entities.Vehicle;

public interface VehicleRepo extends JpaRepository<Vehicle, Long>  {

}
