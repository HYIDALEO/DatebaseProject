package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteCompanyServlet
 */
@WebServlet("/DeleteCompanyServlet")
public class DeleteCompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCompanyServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request,    
            HttpServletResponse response) throws ServletException, IOException {    
              
            //��jspҳ���ȡҪ�޸ĵ�Ԫ�ص�id�͸����޸ĺ��ֵ  
            int id = Integer.valueOf(request.getParameter("ID"));  
              
            try {  
                //�ȼ���libĿ¼�µ�java-connect-mysql.jar������  
            	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");    
                
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
                String sql = "delete from companyList where CID = "+id+"";    
                Statement stat=conn.createStatement();
                
                stat.executeUpdate(sql);  
                  
                //�ر�����  
                conn.close();    
                  
            } catch (ClassNotFoundException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
              
              
            //��ת����ʾҳ��  
            response.sendRedirect("findCompanyServlet");  
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