package cn.sxt.d;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sxt.db.Dao;

/**
 * Servlet implementation class delete1
 */
@WebServlet("/delete1")
public class delete1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String res = request.getParameter("quxiao");
		String title=request.getParameter("title");
		res=new String(res.getBytes("ISO-8859-1"),"UTF-8");
		String sql="";
        // res = new String(res.getBytes("gb2312"),"iso-8859-1");
		String s[] = res.split(",");
		if(title.equals("client")|title.equals("manage")) {
			sql = "delete from yy where ����=" + "'" + s[0] + "' and "+"ԤԼʱ��="+"'"+s[1]+"'";
			String sqldoc1="update doctor set �Ƿ���ռ��='no' where ҽ������=" + "'" + s[2] + "' and "+"����ʱ��="+"'"+s[1]+"'";
			Dao.execute(sqldoc1);
		}
		 else {
			 if(title.equals("userlist"))
			 {
				 sql = "delete from userlist where username=" + "'" + s[0] + "' and "+"password="+"'"+s[1]+"'";
				 //String doctorsql="updata doctor set �Ƿ���ռ��= case id"
				 //		+ "when where ҽ������=(select yy.) and ԤԼʱ��=?";
				 String doctorsql="update doctor set �Ƿ���ռ��='no' where ҽ������ in (select ԤԼҽ�� from yy where yy.�˺�='"+s[0]+"')";
				 Dao.execute(doctorsql);
				 String yysql="delete from yy where �˺�='"+s[0]+"'";
				 Dao.execute(yysql);
			 }
			 else if(title.equals("doctorlist"))
			 {
				  sql = "delete from doctor where ҽ������=" + "'" + s[0] + "' and "+"����ʱ��="+"'"+s[1]+"'";
				  String sqldlyy="delete from yy where ԤԼҽ��='"+s[0]+"' and ԤԼʱ��='"+s[1]+"'";
				  Dao.execute(sqldlyy);
			 	}
			 else 
				 {
				 	sql = "delete from yy where ����=" + "'" + s[0] + "' and "+"ԤԼʱ��="+"'"+s[1]+"'";
				 	String sqldoc1="update doctor set �Ƿ���ռ��='no' where ҽ������=" + "'" + s[2] + "' and "+"����ʱ��="+"'"+s[1]+"'";
					Dao.execute(sqldoc1);
				 }
		 }
			 
			Dao.execute(sql);
			
			System.out.println(title);
			if(title.equals("manage"))
				request.getRequestDispatcher("/manage.jsp").forward(request, response);
			else if(title.equals("client"))
				request.getRequestDispatcher("/client.jsp").forward(request, response);
			else if(title.equals("doctorlist"))
				request.getRequestDispatcher("/doctorlist.jsp").forward(request, response);
			else if(title.equals("userlist"))
						request.getRequestDispatcher("/userlist.jsp").forward(request, response);
			else if(title.equals("changeme"))
					request.getRequestDispatcher("/changeme").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
