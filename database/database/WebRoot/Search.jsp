<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Search.jsp' starting page</title>
    
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
  
    <div style="float:left;margin-left:100px;margin-top:125px;">
    		<a class="btn btn-default" href="backButton?UID=<%=session.getAttribute("UID") %>" role="button">back</a>
    </div>
    <div style="margin-left:350px;width:700px;opacity:0.9;height:100%;">
    <div  style="width:500px;margin-left:100px;">
   
    
    <form action="searchServlet" method="post"> 
    	
    	<div class="form-group">
    		<label for="UID">UID</label>
    		<input type="text" name="UID" class="form-control" hidden="true" id="UID" value="<%=request.getParameter("UID") %>" readonly="readonly">
    	</div> 
		<div class="form-group">
    		<label for="airplaneRoute">airplaneRoute</label>
    		<input type="text" name="airplaneRoute" hidden="true" class="form-control" id="airplaneRoute">
    	</div>
    	
        <input class="btn btn-default" type="submit" value="submit" />   
		<input class="btn btn-default" type="reset" value="reset" />  
    </form>
    </div>
    </div>
  </body>
</html>
