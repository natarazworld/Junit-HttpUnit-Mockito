package com.nt.service;

public interface ILoginMgmtService {
     public boolean  login(String username,String password);
     public  String  registerUser(String user,String role);
}
