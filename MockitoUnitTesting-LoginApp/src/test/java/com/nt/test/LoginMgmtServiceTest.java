package com.nt.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.nt.dao.ILoginDAO;
import com.nt.service.ILoginMgmtService;
import com.nt.service.LoginMgmtServiceImpl;

public class LoginMgmtServiceTest {
	
	private static  ILoginMgmtService loginService;
	private  static  ILoginDAO  loginDAOMock;
	
	@BeforeAll
	public  static void  setupOnce() {
		    // create MOCK / Fake /Dummy object
		  loginDAOMock=Mockito.mock(ILoginDAO.class);  // mock(-) generates InMemory class  implementing 
		                                                                                        // ILoginDAO(I)  having null method definitations for authenticate(-,-) nethod
		  System.out.println(loginDAOMock.getClass()+"   "+Arrays.toString(loginDAOMock.getClass().getInterfaces()));
		  //create SErvie class object
		 loginService=new LoginMgmtServiceImpl(loginDAOMock);
	}
	
	@AfterAll
	public static  void clearOnce() {
		 loginDAOMock=null;
		 loginService=null;
	}
	
	//Test methods
	@Test
	 public void   testLoginWithValidCredentials() {
		 // Provide  Stub (Temporary Functionalaties ) for  DAO's  authenticate method
		   Mockito.when(loginDAOMock.authenticate("raja", "rani")).thenReturn(1);
		   // Unit Testing
		   assertTrue(loginService.login("raja", "rani"));
		 
	 }
	
	@Test
	 public void   testLoginWithInValidCredentials() {
		 // Provide  Stub (Temporary Functionalaties ) for  DAO's  authenticate method
		   Mockito.when(loginDAOMock.authenticate("raja", "rani1")).thenReturn(0);
		   // Unit Testing
		   assertFalse(loginService.login("raja", "rani1"));
	 }
	
	@Test
	 public void   testLoginWithNoCredentials() {
		 assertThrows(IllegalArgumentException.class,()->{ loginService.login("","");} );
	 }
	
	
	@Test
	public void testRegisterWithSpy() {
		ILoginDAO  loginDAOSpy=Mockito.spy(ILoginDAO.class);
		ILoginMgmtService  loginSerivce=new LoginMgmtServiceImpl(loginDAOSpy);
		loginSerivce.registerUser("raja", "admin");
		loginSerivce.registerUser("suresh", "visitor");
		loginSerivce.registerUser("jani", "");
		
		Mockito.verify(loginDAOSpy,Mockito.times(1)).addUser("raja", "admin");		
		Mockito.verify(loginDAOSpy,Mockito.times(0)).addUser("suresh", "visitor");		
		Mockito.verify(loginDAOSpy,Mockito.never()).addUser("jani", "");		
		
		
	}
	
	 
	

}
