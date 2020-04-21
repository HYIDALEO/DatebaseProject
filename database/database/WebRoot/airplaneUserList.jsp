<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="java.util.List" %>  
<%@page import="com.bean.Airplane" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'airplaneList.jsp' starting page</title>
    
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
    	<a class="btn btn-default" href="index.jsp" role="button">back</a>
    </div>
    <div style="float:left;margin-left:200px;margin-top:93px;">
    	<a class="btn btn-primary btn-lg" href="buyTicketList?UID=<%=session.getAttribute("UID")%>" role="button">information</a>
    </div>
    <div style="float:left;margin-left:400px;margin-top:93px;">
    	<a class="btn btn-primary btn-lg" href="personalInformation?UID=<%=session.getAttribute("UID")%>" role="button">Personal</a>
    </div>
    <div style="float:left;margin-left:200px;margin-top:93px;">
    	<a class="btn btn-primary btn-lg" href="Search.jsp?UID=<%=session.getAttribute("UID")%>" role="button">Search</a>
    </div>
  	<div style="width:700px;margin-left:300px;text-align:center;">
    <h1><%=session.getAttribute("UID")%>airplaneList</h1>  
    <table class="table table-hover">  
        <tr>
            <th>ID</th>  
            
            <th>airplaneRoute</th> 
            <th>airplaneDate</th>   
            <th>airplaneFlyTime</th>  
            <th>airplaneLandTime</th>  
            <th>airplanePrice</th>  
            <th>ticketNum</th>  
            
            <th colspan="3">operation</th>  
        </tr>  
        <%  
        	List<Airplane> ss = (List<Airplane>)request.getAttribute("ss");   
            for(Airplane s : ss){  
        %>  
        <tr>  
            <td><%=s.getID() %></td>  
            <td><%=s.getAirplaneRoute() %></td>  
            <td><%=s.getAirplaneDate() %></td>  
            <td><%=s.getAirplaneFlyTime() %></td>  
            <td><%=s.getAirplaneLandTime() %></td>  
            <td><%=s.getAirplanePrice() %></td>  
            <td><%=s.getTicketNum() %></td>  

            <td colspan="3">  
                <a href="bookServlet?ID=<%=s.getID()%>&UID=<%=session.getAttribute("UID")%>&ticketNum=<%=s.getTicketNum()%>" onclick="return confirm('book?')">book</a>  
            	
            </td>  
        </tr>  
        <%   
            }  
        %>  
    </table>  
    
   </div>
  </body>
</html>
