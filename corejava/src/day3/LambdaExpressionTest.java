package day3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import day2.Car;

class LambdaExpressionTest {

	@Test
	void test() {
		List<Car> cars=new ArrayList<Car>();
		cars.add(Car.builder().make("honda_city").model("VX").year(2024).version(7).build());
		cars.add(new Car("benz","220D",2024,5));
		cars.add(Car.builder().make("honda_city").model("VX").year(2024).version(4).build());
		cars.add(Car.builder().make("honda_city").model("VX").year(2024).version(8).build());
		List<Car> newCars= new ArrayList<Car>();
		for(Car car:cars) {
			if (car.getVersion()>5) {
				newCars.add(car);
			}
		}
		System.out.println(newCars);
		List<Car> myNewCars= cars.stream().filter(car -> car.getVersion()>5).collect(Collectors.toList());
		System.out.println(myNewCars);
		System.out.println(cars.stream().filter(car -> "honda_city".equals(car.getMake())).collect(Collectors.toList()));
		
	    System.out.println(cars.stream().map(car -> car.getMake()).collect(Collectors.toSet()));
	}

}
