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
 * Servlet implementation class ChongzhiUserServlet
 */
@WebServlet("/ChongzhiUserServlet")
public class ChongzhiUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChongzhiUserServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");  
	        
	      String NAME = request.getParameter("NAME");
	      int money = Integer.valueOf(request.getParameter("money"));  
	      int ID = Integer.valueOf(request.getParameter("ID"));
	      int add = Integer.valueOf(request.getParameter("add"));  
  	      try {  
  	    	  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");    
  	          
  	          String driverClass="com.microsoft.sqlserver.jdbc.SQLServerDriver";  
  	          String url="jdbc:sqlserver://localhost:1433;databaseName=airplaneDesign";  
  	          String sqlusername="sa";  
  	          String sqlpassword="darkbkc";  
  	          Connection conn = DriverManager.getConnection(url, sqlusername,    
  	                  sqlpassword);  
  	          money+=add;
  	          String sql = "update personalList set money = "+money+" where UID = "+ID+"";   
  	          Statement stat=conn.createStatement();
  	          stat.executeUpdate(sql);  
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
