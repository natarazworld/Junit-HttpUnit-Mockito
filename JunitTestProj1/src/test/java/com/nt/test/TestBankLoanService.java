package com.nt.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.MethodName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;

import com.nt.service.BankLoanService;

@DisplayName("TestingBankLoanService class")
//@TestMethodOrder(value =OrderAnnotation.class)  //best
@TestMethodOrder(value =MethodName.class)
//@TestMethodOrder(value =MethodName.class)
//@TestMethodOrder(value=MethodOrderer.DisplayName.class)
//@TestMethodOrder(value=MethodOrderer.Random.class)  //default
public class TestBankLoanService {
	private static BankLoanService service;
	
	@BeforeAll
	public static  void setUpOnce() {
		System.out.println("TestBankLoanService.setUpOnce()");
		service=new BankLoanService();
	}
	
	/*@BeforeEach
	public  void setUp() {
		System.out.println("TestBankLoanService.setUp()");
		service=new BankLoanService();
		
	}*/
	
	@Test
	@DisplayName("testing with small Numbers")
	//@Order(10)
	@Tag("dev")
	  public void testcalcSimpleIntrestAmountWithSmallNumbers() {
		System.out.println("TestBankLoanService.testcalcSimpleIntrestAmountWithSmallNumbers()");
		float actual=service.calcSimpleIntrestAmount(100000,2, 12); //actual result
		  float expected=24000.0f; // through manual calculation
		  assertEquals(expected, actual,"may be results not matching");
	  }
	
	@Test
	@DisplayName("testing with Big Numbers")
	//@Order(2)
	@Tag("uat")
	@Tag("dev")
	  public void testcalcSimpleIntrestAmountWithBiglNumbers() {
		System.out.println("TestBankLoanService.testcalcSimpleIntrestAmountWithBiglNumbers()");
		float actual=service.calcSimpleIntrestAmount(10000000,2, 12); //actual result
		  float expected=2400000.12f; // through manual calculation
		  assertEquals(expected, actual);
		  //assertEquals(expected, actual,"may results not not maching");
		 // assertEquals(expected, actual,0.5,"may results not not maching"); //0.5 is delta value --> the difference that is allowed int results
	  }
	
	@Test
	@DisplayName("testing with Invalid Inputs")
	//@Order(5)
	@Tag("uat")
	  public void testcalcSimpleIntrestAmountWithInvalidInputs() {
		System.out.println("TestBankLoanService.testcalcSimpleIntrestAmountWithInvalidInputs()");
		 assertThrows(IllegalArgumentException.class,
				                 ()-> {    	 service.calcSimpleIntrestAmount(0, 0, 0); } ,
				                 "may exception raised is not matching"
		                         );
	  }
	
	@Test
	@Disabled
	@DisplayName("testing with Timout Period")
	//@Order(0)
	@Tag("dev")
	  public void testcalcSimpleIntrestAmountWithTimer() {
		 BankLoanService service=new BankLoanService();
		 assertTimeout(Duration.ofMillis(20000),
				                   ()->{
				                	   service.calcSimpleIntrestAmount(10000000, 2, 12);
				                   }
				                    );
	  }
	
	@Test
	@DisplayName("testing for No Exceptions")
	//@Order(-10)
	@Tag("uat")
	  public void testcalcSimpleIntrestAmountForNoExceptions(TestInfo info) {
		System.out.println("TestBankLoanService.testcalcSimpleIntrestAmountForNoExceptions()");
		System.out.println(info.getClass()+"  "+info.getTags()+"  "+info.getDisplayName()+"  "+info.getTestMethod().get().getName()+"  "+info.getTestClass().get().getName());
		 assertDoesNotThrow(()->{
			                                      service.calcSimpleIntrestAmount(10000, 2, 12);
			                                       }
		                                    );
	  }
	
/*	@AfterEach
	  public void clear() {
		  System.out.println("TestBankLoanService.clear()");
		  service=null;
	  }*/
	
	@AfterAll
	  public static void clearOnce() {
		  System.out.println("TestBankLoanService.clearOnce()");
		  service=null;
	  }
	
	
	
}
