package cn.sxt.d;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class deletenews extends HttpServlet{
    public void init(ServletConfig config) throws ServletException{
    	super.init(config);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	try {
                Class.forName("com.mysql.cj.jdbc.Driver");
    		String user = "root";
    		String password = "123456";
    		String uri = "jdbc:mysql://localhost:3306/"+"ykzs"+"?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false";
    		Connection con = DriverManager.getConnection(uri,user,password);
    		//request.setCharacterEncoding("utf-8");
    		String res = request.getParameter("quxiao");
               // res = new String(res.getBytes("gb2312"),"iso-8859-1");
    		String s[] = res.split(",");
    		String sql = "delete from binfo where 姓名=" + "'" + s[0] + "' and "+"预定时间段="+"'"+s[1]+"'";
    		Statement stm = con.createStatement();
    		stm.execute(sql);
    		stm.close();
    		con.close();
    		request.getRequestDispatcher("client.jsp").forward(request, response);
    	}catch(Exception e) {}
	}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	try {
                Class.forName("com.mysql.cj.jdbc.Driver");
    		String user = "root";
    		String password = "123456";
    		String uri = "jdbc:mysql://localhost:3306/"+"ykzs"+"?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false";
    		Connection con = DriverManager.getConnection(uri,user,password);
    		String res = request.getParameter("jieshou");
    		String s[] = res.split(",");
    		String sql = "update binfo set 预约状态='已预约'  where 姓名 =" + "'" + s[0] + "' and "+"预定时间段="+"'"+s[1]+"'";
    		Statement stm = con.createStatement();
    		stm.execute(sql);
    		stm.close();
    		con.close();
    		request.getRequestDispatcher("client.jsp").forward(request, response);
    	}catch(Exception e) {}
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         
	}

}
