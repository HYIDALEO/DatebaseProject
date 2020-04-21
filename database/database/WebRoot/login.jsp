<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="java.sql.DriverManager" %> 
<%@ page import="java.sql.*" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">  
	 
	</style>  
  </head>
  
  <body>
    <h1>welcome</h1>  
    
    <form action="loginServlet" method="post">  
    <span class="item">user</span>   
    <input type="text" name="username" /></span><br><br>  
    <span class="item">password</span>   
    <input type="text" name="password" /></span><br><br><br>  
    <div id="btn">   
    <input type="submit" value="login" />   
    <input type="reset" value="reset" />  
    </div>  
    </form> 
    
    <form action="loginCompanyServlet" method="post">  
    <span class="item">company</span>   
    <input type="text" name="username" /></span><br><br>  
    <span class="item">password</span>   
    <input type="text" name="password" /></span><br><br><br>  
    <div id="btn">   
    <input type="submit" value="login" />   
    <input type="reset" value="reset" />  
    </div>  
    </form> 
    
    <form action="loginManagerServlet" method="post">  
    <span class="item">manager</span>   
    <input type="text" name="username" /></span><br><br>  
    <span class="item">password</span>   
    <input type="text" name="password" /></span><br><br><br>  
    <div id="btn">   
    <input type="submit" value="login" />   
    <input type="reset" value="reset" />  
    </div>  
    </form> 
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery-3.2.1.js"></script>
  </body>
</html>
