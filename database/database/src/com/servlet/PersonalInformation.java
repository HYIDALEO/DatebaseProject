package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Personal;

/**
 * Servlet implementation class PersonalInformation
 */
@WebServlet("/PersonalInformation")
public class PersonalInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonalInformation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request,    
    	      HttpServletResponse response) throws ServletException, IOException {    
    	      
    	      request.setCharacterEncoding("utf-8");  
    	      int UID = Integer.valueOf(request.getParameter("UID"));
    	     
    	        
    	      try {  
    	    	  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");    
    	          String driverClass="com.microsoft.sqlserver.jdbc.SQLServerDriver";  
    	          String url="jdbc:sqlserver://localhost:1433;databaseName=airplaneDesign";  
    	          String sqlusername="sa";  
    	          String sqlpassword="darkbkc";  
    	          Connection conn = DriverManager.getConnection(url, sqlusername,    
    	                  sqlpassword);  
    	            
    	          String sql = "select * from personalList where UID = "+ UID +"";    
    	          System.out.println(UID);
    	          Statement statement = conn.createStatement();  
                  ResultSet resultSet = statement.executeQuery(sql);
                  Personal p = new Personal();
    	          if(resultSet.next()){
    	        	 p.setUID(resultSet.getInt("UID")); 
    	        	 request.setAttribute("UID",resultSet.getInt("UID"));
    	        	 p.setNAME(resultSet.getString("NAME"));
    	        	 request.setAttribute("NAME",resultSet.getString("NAME"));
    	        	 p.setMoney(resultSet.getInt("money"));
    	        	 request.setAttribute("money", resultSet.getInt("money"));
    	        	 p.setPW(resultSet.getString("PW"));
    	        	 request.setAttribute("PW", resultSet.getString("PW"));
    	          }
    	          request.setAttribute("ss", p);  
                  statement.close();  
    	          //关闭连接  
    	          conn.close();    
    	            
    	      }  catch (ClassNotFoundException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			} catch (SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    	        
    	        
    	      //跳转到显示页面  
    	      request.getRequestDispatcher("personalInformation.jsp").forward(request, response);
    	      /*request.getRequestDispatcher("listStudent.jsp")   
    	      .forward(request, response); */  
    	  }    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
