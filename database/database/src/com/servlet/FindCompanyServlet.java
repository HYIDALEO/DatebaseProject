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

import com.bean.Company;

/**
 * Servlet implementation class FindCompanyServlet
 */
@WebServlet("/FindCompanyServlet")
public class FindCompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindCompanyServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request,    
            HttpServletResponse response) throws ServletException, IOException {    
              
            try {  
                //先加载lib目录下的java-connect-mysql.jar驱动包  
            	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                
                //选择驱动类，连接地址、账号密码，连接MySQL  
                String driverClass="com.microsoft.sqlserver.jdbc.SQLServerDriver";  
                String url="jdbc:sqlserver://localhost:1433;databaseName=airplaneDesign";  
                String sqlusername="sa";  
                String sqlpassword="darkbkc";  
                Connection conn = DriverManager.getConnection(url, sqlusername,    
                        sqlpassword);  
                  
                  
                //编写SQL语句，执行，拿到结果集  
                String sql = "select * from companyList";    
                Statement statement = conn.createStatement();  
                ResultSet resultSet = statement.executeQuery(sql);  
                  
                //把结果集的东西倒进ArrayList  
                List<Company> ss = new ArrayList<Company>();  
                while(resultSet.next()){  
                	Company s = new Company();  
                	
                	s.setNAME(resultSet.getString("NAME"));
                	s.setPW(resultSet.getString("PW"));
                	s.setCID(resultSet.getInt("CID"));
                      
                    //后台打印，试看有没有拿到  
                    String ms = resultSet.getInt("CID")+"";
                    System.out.println(ms);
                      
                    ss.add(s);  
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
            request.getRequestDispatcher("companyList.jsp")    
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
