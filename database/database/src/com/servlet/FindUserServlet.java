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

import com.bean.User;

/**
 * Servlet implementation class FindUserServlet
 */
@WebServlet("/FindUserServlet")
public class FindUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindUserServlet() {
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request,    
            HttpServletResponse response) throws ServletException, IOException {    
              
            try {  
                //�ȼ���libĿ¼�µ�java-connect-mysql.jar������  
            	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                
                //ѡ�������࣬���ӵ�ַ���˺����룬����MySQL  
                String driverClass="com.microsoft.sqlserver.jdbc.SQLServerDriver";  
                String url="jdbc:sqlserver://localhost:1433;databaseName=airplaneDesign";  
                String sqlusername="sa";  
                String sqlpassword="darkbkc";  
                Connection conn = DriverManager.getConnection(url, sqlusername,    
                        sqlpassword);  
                  
                  
                //��дSQL��䣬ִ�У��õ������  
                String sql = "select * from userList";    
                Statement statement = conn.createStatement();  
                ResultSet resultSet = statement.executeQuery(sql);  
                  
                //�ѽ�����Ķ�������ArrayList  
                List<User> ss = new ArrayList<User>();  
                while(resultSet.next()){  
                	User s = new User();  
                	
                	s.setNAME(resultSet.getString("NAME"));
                	s.setPW(resultSet.getString("PW"));
                	s.setUID(resultSet.getInt("ID"));
                      
                    //��̨��ӡ���Կ���û���õ�  
                    String ms = resultSet.getInt("ID")+"";
                    System.out.println(ms);
                      
                    ss.add(s);  
                }  
                  
                //ArrayList�Ž�request�����������jspҳ�����request.getAttribute("ss")  
                //�ó�ArrayList�ˡ�  
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
              
              
            //��ת����ʾҳ��  
            request.getRequestDispatcher("userList.jsp")    
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
