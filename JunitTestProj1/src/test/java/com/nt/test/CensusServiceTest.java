package com.nt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.nt.service.CensusService;

public class CensusServiceTest {
	
	/*@RepeatedTest(value = 10, name="execution of {displayName} - {currentRepetition}/{totalRepetitions}")
	@DisplayName("testing data export")
	public void   testexportData() {
		System.out.println("CensusServiceTest.testexportData()");
		CensusService service=new CensusService();
		Assertions.assertEquals("data exported",service.exportData());
	}*/
	
	/*@ParameterizedTest
	@ValueSource(ints = {10,21,34,56,11,78})
	public  void   testIsOdd(int n) {
		System.out.println("CensusServiceTest.testIsOdd()");
		CensusService   service=new CensusService();
		Assertions.assertTrue(service.isOdd(n));
	}*/
	
/*	@ParameterizedTest
	@ValueSource(strings = {"raja","rani"})
	public  void   testSayHello(String user) {
		System.out.println("CensusServiceTest.testIsOdd()");
		CensusService   service=new CensusService();
		assertEquals("hello:"+user, service.sayHello(user));
	} */
	
	@ParameterizedTest
	//@ValueSource(strings = {"","  ","k"})
	//@EmptySource
	//@NullSource
	@NullAndEmptySource
	public  void   testisEmpty(String data) {
		System.out.println("CensusServiceTest.testisEmpty()");
		CensusService   service=new CensusService();
		Assertions.assertTrue(service.isEmpty(data));
	} 

}
