package com.servlet;

import java.io.IOException;  
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;  
import java.util.ArrayList;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
import com.bean.Student;  
/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        
        // TODO Auto-generated constructor stub
    }
  //重写doGet方法  
  protected void doGet(HttpServletRequest request,    
      HttpServletResponse response) throws ServletException, IOException {    
        
      request.setCharacterEncoding("utf-8");  
        
      //从jsp页面获取要修改的元素的id和各项修改后的值  
      int ID = Integer.valueOf(request.getParameter("ID")); 
      int airplanePrice = 1500;
      String airplaneRoute = request.getParameter("airplaneRoute");  
      String airplaneDate = request.getParameter("airplaneDate");  
      int ticketNum = 300; 
      String airplaneFlyTime = request.getParameter("airplaneFlyTime");  
      String airplaneLandTime = request.getParameter("airplaneLandTime");  
     
        
      try {  
          //先加载lib目录下的java-connect-mysql.jar驱动包  
    	  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");    
          
          //选择驱动类，连接地址、账号密码，连接MySQL  
          String driverClass="com.microsoft.sqlserver.jdbc.SQLServerDriver";  
          String url="jdbc:sqlserver://localhost:1433;databaseName=airplaneDesign";  
          String sqlusername="sa";  
          String sqlpassword="darkbkc";  
          Connection conn = DriverManager.getConnection(url, sqlusername,    
                  sqlpassword);  
            
          //编写SQL语句，这里不要用statement了，换用preparedstatement，因为  
          //preparedstatement可以设置？为形参，然后set各个形参的实际值，statement没有此  
          //功能。最后执行更新语句。  
          //此外，？不要加单双引号，否则报错java.sql.SQLException: Parameter index out of range (0 < 1 ).  
          String sql = "update airplaneList set airplaneRoute = '"+airplaneRoute+"', airplanePrice = "+airplanePrice+", airplaneDate = '"+airplaneDate+"', ticketNum = "+ticketNum+",airplaneFlyTime = '"+airplaneFlyTime+"',airplaneLandTime='"+airplaneLandTime+"' where ID = "+ID+"";    
          
          Statement stat=conn.createStatement();
          stat.executeUpdate(sql);  
            
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
      response.sendRedirect("findAllServlet");  
      /*request.getRequestDispatcher("listStudent.jsp")   
      .forward(request, response); */  
  }    
  
  protected void doPost(HttpServletRequest request,    
          HttpServletResponse response) throws ServletException, IOException {    
      doGet(request, response);    
  }  

}
