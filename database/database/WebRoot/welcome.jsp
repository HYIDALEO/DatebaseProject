<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'welcome.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<style>  
		body {  
		    background-image:url('images/timg.jpg');  
		    background-size: cover;  
		}  
		h1{  
		    margin:150px auto;  
		    text-align: center;  
		}  
		span{  
		    color:red;  
		    font-family:fantasy;  
		}  
		</style>
  </head>
  
  <body>
      
    <h1>welcome<span><%=request.getAttribute("username") %></span>welcome！</h1>  
    <center><p>jump...</p></center>  
    <center><p><%=request.getAttribute("UID") %></p></center>
    <%session.setAttribute("UID",request.getAttribute("UID")); %>
    
    <%response.setHeader("refresh","1;url=findAllUserAirList"); %> 
  
  </body>
</html>
