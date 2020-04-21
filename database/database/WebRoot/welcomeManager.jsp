<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'welcomeManager.jsp' starting page</title>
    
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
	<style>  
		body {  
		    background-image:url('images/timg.jpg');  
		    background-size: cover;  
		}  
		h1{  
		    margin:150px 500px;  
		    text-align: center;  
		}  
		span{  
		    color:red;  
		    font-family:fantasy;  
		}  
		</style>
  </head>
  
  <body>
  	<div style="float:left;margin-left:100px;margin-top:93px;">
    	<a class="btn btn-default" href="index.jsp" role="button">back</a>
    </div>
    <h1>welcome<span><%=request.getAttribute("username") %></span>welcome</h1>  
    <center><p>jump...</p></center>  
    <div style="float:left;margin-left:450px;margin-top:93px;">
    	<a class="btn btn-primary btn-lg" href="findUserServlet" role="button">userList</a>
    </div>
    <div style="float:left;margin-left:300px;margin-top:93px;">
    	<a class="btn btn-primary btn-lg" href="findCompanyServlet" role="button">companyList</a>
    </div>
    
  </body>
</html>
