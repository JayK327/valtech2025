package com.valtech.training.simple;

import junit.framework.TestCase;

public class OperationTest extends TestCase {
	 
	 public void testAdd() {
		 assertEquals(5,Operation.ADD.perform(2,3));
	 }
}
