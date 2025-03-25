package com.valtech.hackathon.vehicle.entities;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="vehicle-metadata")
public class Vehicle {
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "vehicle_seq")
	@SequenceGenerator(name = "vehicle_seq",sequenceName = "vehicleseq",allocationSize = 1)
	private long vid;
	private String modelName;
	private String manufacturerName;
	private double mileageAccordingToCompany;
	private long price;
	private String varient;
	public Vehicle() {
		
	}
	public Vehicle(String modelName, String manufacturerName, double mileageAccordingToCompany, long price,
			String varient) {
		super();
		this.modelName = modelName;
		this.manufacturerName = manufacturerName;
		this.mileageAccordingToCompany = mileageAccordingToCompany;
		this.price = price;
		this.varient = varient;
	}
	public long getVid() {
		return vid;
	}
	public void setVid(long vid) {
		this.vid = vid;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getManufacturerName() {
		return manufacturerName;
	}
	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}
	public double getMileageAccordingToCompany() {
		return mileageAccordingToCompany;
	}
	public void setMileageAccordingToCompany(double mileageAccordingToCompany) {
		this.mileageAccordingToCompany = mileageAccordingToCompany;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getVarient() {
		return varient;
	}
	public void setVarient(String varient) {
		this.varient = varient;
	}
	@Override
	public String toString() {
		return "Vehicle [vid=" + vid + ", modelName=" + modelName + ", manufacturerName=" + manufacturerName
				+ ", mileageAccordingToCompany=" + mileageAccordingToCompany + ", price=" + price + ", varient="
				+ varient + "]";
	}
	
	
	
	
}
