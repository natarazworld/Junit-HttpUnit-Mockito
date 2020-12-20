package com.nt.test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebForm;
import com.meterware.httpunit.WebResponse;

public class LoginTests {
   private static WebConversation conversation;
	@BeforeAll
	public  static void  setUpOnce() {
		conversation=new WebConversation();
	}
	
	@Test
	public    void   testWithValidCredentials() throws Exception {
		//get  response by geneating request to index.html 
		WebResponse response=conversation.getResponse("http://localhost:3030/HttpUnitLogingWebApp/index.html");
		//get access to the form from the response 
		WebForm  form=response.getForms()[0];
		//set request param values to the form object
		form.setParameter("uname","raja");
		form.setParameter("pwd","rani");
		//submit the form and get the reponse
		WebResponse response1=form.submit();
		//get actual output from response1 obj
		String actual=response1.getText().trim();
		//perform assertion  (compare atual results with expected results)
		assertEquals("Valid Credentials",actual);
	}
	
	
	@Test
	public    void   testWithInValidCredentials() throws Exception {
		//get  response by geneating request to index.html 
				WebResponse response=conversation.getResponse("http://localhost:3030/HttpUnitLogingWebApp/index.html");
				//get access to the form from the response 
				WebForm  form=response.getForms()[0];
				//set request param values to the form object
				form.setParameter("uname","raja");
				form.setParameter("pwd","rani1");
				//submit the form and get the reponse
				WebResponse response1=form.submit();
				//get actual output from response1 obj
				String actual=response1.getText().trim();
				//perform assertion  (compare atual results with expected results)
				assertEquals("InValid Credentials",actual);
	}
	
	
	@Test
	public    void   testWithNoCredentials() throws Exception {
		//get  response by geneating request to index.html 
		WebResponse response=conversation.getResponse("http://localhost:3030/HttpUnitLogingWebApp/index.html");
		//get access to the form from the response 
		WebForm  form=response.getForms()[0];
		//set request param values to the form object
		form.setParameter("uname","");
		form.setParameter("pwd","");
		//submit the form and get the reponse
		WebResponse response1=form.submit();
		//get actual output from response1 obj
		String actual=response1.getText().trim();
		//perform assertion  (compare atual results with expected results)
		assertEquals("Provide Credentials",actual);
	}
	
	
	
	@AfterAll
	public  static void  cleanOnce() {
		conversation=null;
	}
	
}
