<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userLogin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
	
	<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
	
	<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"> </script>
  </head>
  
  <body  style="background-image:url('images/timg.jpg');background-size: cover;  ">
    <div style="float:left;margin-left:100px;margin-top:125px;">
    		<a class="btn btn-default" href="index.jsp" role="button">back</a>
    </div>
    <div style="margin-left:300px;width:700px;opacity:0.9;height:100%;">
    	<div style="height:100px">
    	</div>
    	<div  style="width:500px;margin-left:100px;">
		    <form action="loginServlet" method="post">  
		    	<div class="form-group">
		    		<label for="InputUser">user</label>
		    		<input type="text" name="username" class="form-control" id="InputUser" placeholder="username">
		    	</div>
		    	<div class="form-group">
		    		<label for="InputUserPW">password</label>
		    		<input type="password" name="password" class="form-control" id="InputUserPW">
		    	</div> 
		    	
		  		<input class="btn btn-default" type="submit" value="login" />   
		   		<input class="btn btn-default" type="reset" value="reset" />  
		    
		    </form> 
    	</div>
    </div>
  </body>
</html>
