package day2;

import java.util.Objects;

public class Car implements Cloneable {
	private String make;
	private String model;
	private int year;
	private int version;
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public Car() {
		
		// TODO Auto-generated constructor stub
	}
	public Car(String make, String model, int year, int version) {
		this.make = make;
		this.model = model;
		this.year = year;
		this.version = version;
	}
	
	public static CarBuilder builder() {
		return new CarBuilder(new Car());
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
			return super.clone();
	}
	
@Override
public String toString() {
	// TODO Auto-generated method stub
	//return make+" "+model+" "+year+" "+version;
	return new StringBuilder()
			.append(make)
			.append(" ")
			.append(model)
			.append(" ")
			.append(year)
			.append(" ")
			.append(version)
			.toString();
}



@Override
public int hashCode() {
	return toString().concat("car").hashCode();
}

@Override
public boolean equals(Object obj) {
	//if Obj is car
	if (!(obj instanceof Car)) return false;
	Car car=(Car)obj;
	//compare Obj with this
	return year==car.year && version==car.version && make.equals(car.make) && model.equals(car.model) ;
}
public static void main(String[] args) {
	Car honda=new Car("honda_city","VX",2024,7);
	System.out.println(honda.toString());
}

public static class CarBuilder{
	private Car car;
	public CarBuilder(Car car) {
		this.car=car;
	}
	public Car build() {
		return car;  
	}

	public CarBuilder make(String make) {
		car.setMake(make);
		return this;
	}
	public CarBuilder model(String model) {
		car.setModel(model);
		return this;
	}
	public CarBuilder year(int year) {
		car.setYear(year);
		return this;
	}
	public CarBuilder version(int version) {
		car.setVersion(version);
		return this;
	}
}

}
