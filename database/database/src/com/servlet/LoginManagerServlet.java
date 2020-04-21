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
        
        //先把浏览器输入的用户名、密码拿出来。   
        String un = request.getParameter("username");  
        String pw = request.getParameter("password");  
          
        //把用户名设置到request的属性里，这样得会儿跳转到欢迎或者错误页面时好知道叫什么  
        request.setAttribute("username", un);  
          
        //此时开始在数据库中搜寻有没有同时满足用户名、密码的行，有就对，没有就错：  
        //先加载lib目录下的java-connect-mysql.jar驱动包  
        
            
		try {
			

			 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
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
