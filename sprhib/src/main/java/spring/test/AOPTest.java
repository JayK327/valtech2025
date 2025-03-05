package spring.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.ioc.Arithmetic;

class AOPTest {

	@Test
	void test() {
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("aop.xml");
		Arithmetic arith =(Arithmetic)ctx.getBean("arith");
		System.out.println(arith.getClass().getName());
		System.out.println(arith.add(2, 30));
		System.out.println(arith.add(2, -30));
		System.out.println(arith.sub(-32, -30));
		System.out.println(arith.mul(2, 30));
		System.out.println(arith.div(2, 1));

		ctx.close();
	}

}
