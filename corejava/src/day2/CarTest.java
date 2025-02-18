package day2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {
	@Test
	void testClone()throws Exception {
		Car car=new Car("honda_city","VX",2024,7);
		Car car1=(Car)car.clone();
		assertEquals(car,car1);
		assertNotSame(car,car1);
	}

	@Test
	void testToString() {
		Car car=new Car("honda_city","VX",2024,7);
		assertEquals("honda_city VX 2024 7",car.toString());
		car.setVersion(8);
		assertEquals("honda_city VX 2024 8",car.toString());
	}
	@Test
	void testhashcode() {
		Car car=new Car("honda_city","VX",2024,7);
		int hash=car.hashCode();
		System.out.println(car+" "+car.hashCode());
		assertEquals(hash,car.hashCode());
		assertEquals(hash,new Car("honda_city","VX",2024,7).hashCode());
		car.setVersion(8);
		System.out.println(car+" "+car.hashCode());
		assertNotEquals(hash,car.hashCode());
	}

}

//s=s1 >>true
//s =s4>> false until s2 and s3 marked final