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
 * Servlet implementation class BuyTicketList
 */
@WebServlet("/BuyTicketList")
public class BuyTicketList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyTicketList() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request,    
            HttpServletResponse response) throws ServletException, IOException {    
    		int UID = Integer.valueOf(request.getParameter("UID"));
            try {  
            	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                
                String driverClass="com.microsoft.sqlserver.jdbc.SQLServerDriver";  
                String url="jdbc:sqlserver://localhost:1433;databaseName=airplaneDesign";  
                String sqlusername="sa";  
                String sqlpassword="darkbkc";  
                Connection conn = DriverManager.getConnection(url, sqlusername,    
                        sqlpassword);  
                
                  
                String sql = "select * from bookTicket where UID = "+ UID +"";    
                Statement statement = conn.createStatement();  
                ResultSet resultSet = statement.executeQuery(sql);  
                List<Airplane> ss = new ArrayList<Airplane>();  
                while(resultSet.next()){  
                	sql = "select * from airplaneList where ID = "+ resultSet.getString("AID") +"";  
                	int num = resultSet.getInt("ticketNum");
                	statement = conn.createStatement();  
                	ResultSet resultS = statement.executeQuery(sql);  
                	if(resultS.next()){
                		Airplane s = new Airplane();  
                    	s.setAirplaneDate(resultS.getString("airplaneDate"));
                    	s.setAirplaneFlyTime(resultS.getString("airplaneFlyTime"));
                    	s.setAirplaneLandTime(resultS.getString("airplaneLandTime"));
                    	s.setAirplanePrice(resultS.getInt("airplanePrice"));
                    	s.setAirplaneRoute(resultS.getString("airplaneRoute"));
                    	s.setID(resultS.getInt("ID"));
                    	s.setTicketNum(num);
                    	ss.add(s);  
                	}
                	
                }
               
                  
                //ArrayList放进request的属性里，这样jsp页面就能request.getAttribute("ss")  
                //拿出ArrayList了。  
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
            request.getRequestDispatcher("buyTicketList.jsp")    
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
