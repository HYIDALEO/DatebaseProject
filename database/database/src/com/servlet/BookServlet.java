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

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request,    
            HttpServletResponse response) throws ServletException, IOException {    
              
            //从jsp页面获取要修改的元素的id和各项修改后的值  
            int id = Integer.valueOf(request.getParameter("ID"));  
            int ticketNum = Integer.valueOf(request.getParameter("ticketNum")); 
            int UID = Integer.valueOf(request.getParameter("UID"));
            ticketNum--;
            System.out.println(UID);
            try {  
            	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");    
                
                String driverClass="com.microsoft.sqlserver.jdbc.SQLServerDriver";  
                String url="jdbc:sqlserver://localhost:1433;databaseName=airplaneDesign";  
                String sqlusername="sa";  
                String sqlpassword="darkbkc";  
                Connection conn = DriverManager.getConnection(url, sqlusername,    
                        sqlpassword);  
                   
               
                String sql = "update airplaneList set ticketNum = "+ticketNum+" where ID = "+id+"";
                
                Statement stat=conn.createStatement();
                
                stat.executeUpdate(sql);  
                sql ="select * from bookTicket where UID = "+UID+" and AID = "+id+"";
                stat=conn.createStatement();
                ResultSet result = stat.executeQuery(sql);  
                
                if(result.next()){
                	ticketNum = result.getInt("ticketNum");
                	ticketNum++;
                	stat=conn.createStatement();
                	sql = "update bookTicket set ticketNum = "+ticketNum+" where AID = "+id+" and UID = "+UID+"";
                	stat.executeUpdate(sql);  
                }else{
                	stat=conn.createStatement();
                	sql = "insert into bookTicket (AID,UID,ticketNum) values ("+id+","+UID+","+1+")"; 
                	stat.executeUpdate(sql);  
                }
                
                //关闭连接  
                conn.close();    
                  
            } catch (ClassNotFoundException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
              
              
            response.sendRedirect("findAllUserAirList");  
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
