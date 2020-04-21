<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
	
	<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
	
	<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"> </script>
  </head>
  
  <body style="background-image:url('images/timg.jpg');background-size: cover;"  >
    <div class="container" >
    	
    	<div style="margin-left:250px;width:700px;opacity:0.7;height:100%;background-color:grey">
    		<div style="width:700px;height:100px;">
    			
    		</div>
    		<div style="width:700px;text-align:center">
    			<h1>Welcome to </h1>
    			<h1>the Flight management system</h1>
    		</div>
    		<div style="width:700px;margin-top:200px;">
	    		<div style="display:inline;margin-left:60px;">
	   				<a class="btn btn-primary btn-lg" href="userLogin.jsp" role="button">User Login</a>
	   			</div>
				<div style="display:inline;margin-left:80px;">
	   				<a class="btn btn-primary btn-lg" href="companyLogin.jsp" role="button">Company Login</a>
	   			</div>
				<div style="display:inline;margin-left:70px;">
	   				<a class="btn btn-primary btn-lg" href="managerLogin.jsp" role="button">Manager Login</a>
	   			</div>
   			</div>
		 </div>
   		
  	</div>
  	
    
  </body>
</html>
