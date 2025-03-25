package com.valtech.hackathon.vehicle.vos;

import com.valtech.hackathon.vehicle.entities.Vehicle;

public record VehicleVO(long vid,String modelName,String manufacturerName,double mileageAccordingToCompany,long price,String varient) {
	public static VehicleVO from(Vehicle v) {
		if (v == null) {
            return null; 
        }
        return new VehicleVO(
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
