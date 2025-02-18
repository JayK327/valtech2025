package com.valtech.training.simple.interest;

import junit.framework.TestCase;

public class SimpleInterestTest extends TestCase {
	
	public void testSimpleInterest() {
		SimpleInterest si=new SimpleInterest();
		assertEquals(500, si.compute(500, 10, 10));
	}
}
