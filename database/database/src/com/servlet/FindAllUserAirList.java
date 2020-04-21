package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Airplane;

/**
 * Servlet implementation class FindAllUserAirList
 */
@WebServlet("/FindAllUserAirList")
public class FindAllUserAirList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindAllUserAirList() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request,    
            HttpServletResponse response) throws ServletException, IOException {    
    		
            try {  
                
            	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                
                String driverClass="com.microsoft.sqlserver.jdbc.SQLServerDriver";  
                String url="jdbc:sqlserver://localhost:1433;databaseName=airplaneDesign";  
                String sqlusername="sa";  
                String sqlpassword="darkbkc";  
                Connection conn = DriverManager.getConnection(url, sqlusername,    
                        sqlpassword);  
                  
                  
                
                String sql = "select * from airplaneList";    
                Statement statement = conn.createStatement();  
                ResultSet resultSet = statement.executeQuery(sql);  
                
                
                
                List<Airplane> ss = new ArrayList<Airplane>();  
                while(resultSet.next()){  
                	Airplane s = new Airplane();  
                	s.setAirplaneDate(resultSet.getString("airplaneDate"));
                	s.setAirplaneFlyTime(resultSet.getString("airplaneFlyTime"));
                	s.setAirplaneLandTime(resultSet.getString("airplaneLandTime"));
                	s.setAirplanePrice(resultSet.getInt("airplanePrice"));
                	s.setAirplaneRoute(resultSet.getString("airplaneRoute"));
                	s.setID(resultSet.getInt("ID"));
                	s.setTicketNum(resultSet.getInt("ticketNum"));
                    
                    
                    String ms = resultSet.getInt("ID")+"";
                    System.out.println(ms);
                      
                    ss.add(s);  
                }  
                  
             
                request.setAttribute("ss", ss);    
                statement.close();  
                  
            } catch (ClassNotFoundException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
              
              
            //跳转到显示页面  
            request.getRequestDispatcher("airplaneUserList.jsp")    
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
