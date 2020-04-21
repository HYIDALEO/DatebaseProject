<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="java.util.List" %>  
<%@page import="com.bean.User" %> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userList.jsp' starting page</title>
    
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
	    margin:50px auto;  
	    text-align: center;  
	}  
	  
	
	  
	a:link {color:black;}      
	a:visited {color:black;}   
	a:hover {color:#f00;}   
	a:active {color:#f60;}  
	  
	#toAdd{ text-align: center;}  
	  
	</style>  
  </head>
  
  <body>
  	<div style="float:left;margin-left:100px;margin-top:93px;">
    	<a class="btn btn-default" href="welcomeManager.jsp" role="button">back</a>
    </div>
    <div style="width:700px;margin-left:400px;text-align:center;">
    <h1>list</h1>  
    <table class="table table-hover">  
        <tr>
            <th>ID</th>  
            <th>NAME</th> 
            <th colspan="3">operation</th>  
        </tr>  
        <%  List<User> ss = (List<User>)request.getAttribute("ss");   
            for(User s : ss){  
        %>  
        <tr>  
            <td><%=s.getUID() %></td>  
            <td><%=s.getNAME() %></td>  
            <td colspan="3">  
                <a href="userUpdate.jsp?UID=<%=s.getUID()%>&NAME=<%=s.getNAME()%>&PW=<%=s.getPW()%>">change</a>  
                    
                <a href="deleteUserServlet?ID=<%=s.getUID()%>" onclick="return confirm('确定删除')">delete</a>  
            </td>  
        </tr>  
        <%   
            }  
        %>  
    </table>  
    <div id="toAdd"><a href="userAdd.jsp">add</a></div> 
    </div>
  </body>
</html>
