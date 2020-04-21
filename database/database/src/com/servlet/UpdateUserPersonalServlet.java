package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateUserPersonalServlet
 */
@WebServlet("/UpdateUserPersonalServlet")
public class UpdateUserPersonalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserPersonalServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request,    
  	      HttpServletResponse response) throws ServletException, IOException {    
  	        
  	      request.setCharacterEncoding("utf-8");  
  	        
  	      String NAME = request.getParameter("NAME");
  	      String PW = request.getParameter("PW");  
  	      int ID = Integer.valueOf(request.getParameter("ID"));
  	     
  	        
  	      try {  
  	    	  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");    
  	          
  	          String driverClass="com.microsoft.sqlserver.jdbc.SQLServerDriver";  
  	          String url="jdbc:sqlserver://localhost:1433;databaseName=airplaneDesign";  
  	          String sqlusername="sa";  
  	          String sqlpassword="darkbkc";  
  	          Connection conn = DriverManager.getConnection(url, sqlusername,    
  	                  sqlpassword);  
  	            
  	          String sql = "update userList set NAME = '"+NAME+"', PW = '"+PW+"' where ID = "+ID+"";    
  	          
  	          Statement stat=conn.createStatement();
  	          stat.executeUpdate(sql);  
  	          sql = "update personalList set NAME = '"+NAME+"', PW = '"+PW+"' where UID = "+ID+"";  
  	          stat=conn.createStatement();
	          stat.executeUpdate(sql);
  	          //πÿ±’¡¨Ω”  
  	          conn.close();    
  	            
  	      }  catch (ClassNotFoundException e) {
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  			} catch (SQLException e) {
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  			}
  	        
  	      request.setAttribute("username", NAME);
  	      request.setAttribute("UID", ID);
  	      request.getRequestDispatcher("updateJump.jsp")    
  	      .forward(request, response);   
  	  }   

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
