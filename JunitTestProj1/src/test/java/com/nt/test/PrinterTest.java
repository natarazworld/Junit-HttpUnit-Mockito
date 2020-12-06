package com.nt.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.nt.service.Printer;

public class PrinterTest {
	
	@Test
	public  void  testSingleton() {
		Printer p1=Printer.getInstance();
		Printer p2=Printer.getInstance();
		Assertions.assertNotNull(p1);
		Assertions.assertNotNull(p2); 
	/*	if(p1==null || p2==null)
			Assertions.fail("p1, p2 references must be not null"); */
		Assertions.assertSame(p1, p2);
	}

}
