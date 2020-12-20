

<%
   //read form data
   String user=request.getParameter("uname").trim();
   String pass=request.getParameter("pwd").trim();
   //form validation
    if(user.length()==0 || user.equals("")  || pass.length()==0 || pass.equals("")){
    	out.print("Provide Credentials");
    	return;
    }
    //write login/autthenticaiton logic
      if(user.equalsIgnoreCase("raja") && pass.equalsIgnoreCase("rani"))
    	  out.print("Valid Credentials");
      else
    	  out.print("InValid Credentials");

%>