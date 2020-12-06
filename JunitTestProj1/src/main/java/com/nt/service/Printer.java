package com.nt.service;

public class Printer {
	private static  Printer INSTANCE;
	private Printer() {
	}
	
	public  static  Printer getInstance() {
		return INSTANCE;
	}

}
