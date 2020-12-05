//BankLoanService.java (Main class/Service class)
package com.nt.service;

public class BankLoanService {

	public  float calcSimpleIntrestAmount(float pAmt,float rate,float time) {
		//System.out.println("BankLoanService.calcSimpleIntrestAmount(-,-,-)");
		if(pAmt<=0 || rate<=0 || time<=0)
			throw new IllegalArgumentException("Invalid inputs");
		/*
		 * try { Thread.sleep(10000); } catch(Exception e) { e.printStackTrace(); }
		 */
		return  pAmt*rate*time/100.0f;
	}
	
	
}
