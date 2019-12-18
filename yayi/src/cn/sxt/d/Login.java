package cn.sxt.d;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpSession;

import cn.sxt.db.Dao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("/login.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		String actor = new String(request.getParameter("radio-enter"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String s1 = "yes";
		String s2 = "no";
		ArrayList<HashMap<String, Object>> queryArr = null;
		String strSql;
		if(actor.equals("manager") ) {
			 strSql = "select * from userlist where username=? and password =? and ismanager =?";
			 Object[] params = {username,password,s1};
			 queryArr = Dao.query(strSql,params);
		}
		if(actor.equals("user") ) {
			 strSql = "select * from userlist where username=? and password =? and ismanager =?";
			 Object[] params = {username,password,s2};
			 queryArr = Dao.query(strSql,params);
		}
				
		if(queryArr.size()==0) {
			HttpSession session = request.getSession();
			session.setAttribute("username", null);
					
			request.setAttribute("text", "ÕËºÅ»òÕßÃÜÂë´íÎó£¬ÇëÖØÐÂµÇÂ½");
			request.setAttribute("urlpath", "login.jsp");
			request.getRequestDispatcher("/info.jsp").forward(request, response);
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			System.out.println(username);
			request.setAttribute("text", "µÇÂ¼³É¹¦");
			if(actor.equals("manager") ) {
				request.setAttribute("urlpath", "adall.jsp");
			}
			if(actor.equals("user") ) {
				request.setAttribute("urlpath", "userindex2.jsp");
			}
			request.getRequestDispatcher("/info.jsp").forward(request, response);
		}
	}

}
