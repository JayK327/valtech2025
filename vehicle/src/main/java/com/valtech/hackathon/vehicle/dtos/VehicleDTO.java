package com.valtech.hackathon.vehicle.dtos;

import com.valtech.hackathon.vehicle.entities.Vehicle;

public record VehicleDTO(long vid,String modelName,String manufacturerName,double mileageAccordingToCompany,long price,String varient) {
	public static VehicleDTO from(Vehicle v) {
		if (v == null) {
            return null; 
        }
        return new VehicleDTO(
            v.getVid(),                            
            v.getModelName(),                      
            v.getManufacturerName(),                
            v.getMileageAccordingToCompany(),      
            v.getPrice(),                           
            v.getVarient()                          
        );
	}
	public Vehicle to() {
		Vehicle vehicle = new Vehicle();
        vehicle.setVid(this.vid);                            
        vehicle.setModelName(this.modelName);                
        vehicle.setManufacturerName(this.manufacturerName);  
        vehicle.setMileageAccordingToCompany(this.mileageAccordingToCompany); 
        vehicle.setPrice(this.price);                        
        vehicle.setVarient(this.varient);                   
        return vehicle;
	}
}