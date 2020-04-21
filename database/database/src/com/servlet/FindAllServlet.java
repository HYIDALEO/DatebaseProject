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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Airplane; 
public class FindAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindAllServlet() {
      //  super();
        // TODO Auto-generated constructor stub
    }

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
                String sql = "select * from airplaneList";    
                Statement statement = conn.createStatement();  
                ResultSet resultSet = statement.executeQuery(sql);  
                  
                //�ѽ�����Ķ�������ArrayList  
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
            request.getRequestDispatcher("airplaneList.jsp")    
            .forward(request, response);   
        }    
        
        protected void doPost(HttpServletRequest request,    
                HttpServletResponse response) throws ServletException, IOException {    
            doGet(request, response);    
        }    
}
