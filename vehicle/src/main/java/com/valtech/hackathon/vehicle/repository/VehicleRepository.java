package com.valtech.hackathon.vehicle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.hackathon.vehicle.entities.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>  {

}