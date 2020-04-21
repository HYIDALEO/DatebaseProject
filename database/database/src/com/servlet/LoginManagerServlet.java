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
 * Servlet implementation class LoginManagerServlet
 */
public class LoginManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginManagerServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");  
        
        //�Ȱ������������û����������ó�����   
        String un = request.getParameter("username");  
        String pw = request.getParameter("password");  
          
        //���û������õ�request������������û����ת����ӭ���ߴ���ҳ��ʱ��֪����ʲô  
        request.setAttribute("username", un);  
          
        //��ʱ��ʼ�����ݿ�����Ѱ��û��ͬʱ�����û�����������У��оͶԣ�û�оʹ�  
        //�ȼ���libĿ¼�µ�java-connect-mysql.jar������  
        
            
		try {
			

			 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            //ѡ�������࣬���ӵ�ַ���˺����룬����MySQL  
            String driverClass="com.microsoft.sqlserver.jdbc.SQLServerDriver";  
            String url="jdbc:sqlserver://localhost:1433;databaseName=airplaneDesign";  
            String sqlusername="sa";  
            String sqlpassword="darkbkc";  
            Connection conn = DriverManager.getConnection(url, sqlusername,    
                    sqlpassword);  
			
              
            //��дSQL��䣬���ﲻҪ��statement�ˣ�����preparedstatement����Ϊ  
            //preparedstatement�������ã�Ϊ�βΣ�Ȼ��set�����βε�ʵ��ֵ��statementû�д�  
            //���ܡ����ִ�и�����䡣  
            //���⣬����Ҫ�ӵ�˫���ţ����򱨴�java.sql.SQLException: Parameter index out of range (0 < 1 ).  
            String sql = "select distinct * from admList where NAME = '"+un+"' and PW = '"+pw+"'";    
            
            Statement stat=conn.createStatement();
            ResultSet result=stat.executeQuery(sql);
			
              
            if(result.next()){  
                request.getRequestDispatcher("welcomeManager.jsp").forward(request, response);  
            }else{  
                request.getRequestDispatcher("error.jsp").forward(request, response);  
            }  
            
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
    }    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
