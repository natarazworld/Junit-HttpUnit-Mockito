package com.nt.test;

import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MockVsSpyTest {
	
	@Test
	public void  testList() {
		List<String> listMock=Mockito.mock(ArrayList.class);  //Mock
		//List<String> listSpy=Mockito.spy(ArrayList.class); //Spy  (or)  
		List<String> listSpy=Mockito.spy(new ArrayList()); //Spy  (or)
		listMock.add("table");
		Mockito.when(listMock.size()).thenReturn(10);  //stub on Mock obj
		listSpy.add("table");
		Mockito.when(listSpy.size()).thenReturn(10);  //stub on Spy obj
		System.out.println(listMock.size()+"  "+listSpy.size());
	}
	

}
