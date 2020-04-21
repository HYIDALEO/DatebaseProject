<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userUpdate.jsp' starting page</title>
    
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
	<style type="text/css">  
	body {  
	    background-image:url('images/timg.jpg');  
	    background-size: cover;  
	}  
	h1{  
	    margin:50px auto;  
	    text-align: center;  
	} 
	</style>
  </head>
  
  <body>
  <%
  String NAME = request.getParameter("NAME");
  String PW = request.getParameter("PW");  
  int ID = Integer.valueOf(request.getParameter("UID"));
   %>
   <div style="float:left;margin-left:100px;margin-top:125px;">
    		<a class="btn btn-default" href="welcomeManager.jsp" role="button">back</a>
    </div>
  	<div style="margin-left:350px;width:700px;opacity:0.9;height:100%;">
    	<div style="height:50px">
    	</div>
    	<div  style="width:500px;margin-left:100px;">
    <h1>update</h1>  
    <form action="updateUserServlet" method="post"> 
    	<div class="form-group">
    		<label for="ID">ID</label>
    		<input type="text" name="ID" class="form-control" id="ID" value="<%=ID %>" readonly="readonly">
    	</div> 
		<div class="form-group">
    		<label for="NAME">NAME</label>
    		<input type="text" name="NAME" class="form-control" id="NAME" value="<%=NAME %>">
    	</div>
    	<div class="form-group">
    		<label for="PW">password</label>
    		<input type="password" name="PW" class="form-control" id="PW" value="<%=PW %>">
    	</div>     
     
        <input class="btn btn-default" type="submit" value="submit" />   
		<input class="btn btn-default" type="reset" value="reset" />  
    </form>
    </div>
    </div>
  </body>
</html>
