package cn.sxt.d;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sxt.db.Dao;

/**
 * Servlet implementation class jieshou1
 */
@WebServlet("/jieshou1")
public class jieshou1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public jieshou1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String res = request.getParameter("jieshou");
		String title=request.getParameter("title");
		res=new String(res.getBytes("ISO-8859-1"),"UTF-8");
		String sql;
        // res = new String(res.getBytes("gb2312"),"iso-8859-1");
		String s[] = res.split(",");
		if(title.equals("manage")) {
		sql = "update yy set 预约状态='已预约'  where 姓名=" + "'" + s[0] + "' and "+"预约时间="+"'"+s[1]+"'";}
		else if(title.equals("userlist1"))
				sql=  "update userlist set ismanager=\"yes\"  where username=" + "'" + s[0] + "' and "+"password="+"'"+s[1]+"'";
		else sql= "update userlist set ismanager=\"no\"  where username=" + "'" + s[0] + "' and "+"password="+"'"+s[1]+"'";
		Dao.execute(sql);
		if(title.equals("manage")) {
		request.getRequestDispatcher("/manage.jsp").forward(request, response);}
		else request.getRequestDispatcher("/userlist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
