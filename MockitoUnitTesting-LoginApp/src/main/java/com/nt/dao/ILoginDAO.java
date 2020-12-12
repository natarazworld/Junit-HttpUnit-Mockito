package com.nt.dao;

public interface ILoginDAO {
      public   int  authenticate(String username,String pwd);
      public   int  addUser(String user,String role );
}
