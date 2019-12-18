package cn.sxt.d;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;

import cn.sxt.db.Dao;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/register.jsp").forward(request,response);
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
		
		String s = "no";
		String username = new String(request.getParameter("username"));
		String password = new String(request.getParameter("password"));
		String queryUsername= "select * from userlist where username = ?";
		Object[] params = {username};
		ArrayList<HashMap<String, Object>> queryResult = Dao.query(queryUsername, params);
		if(queryResult.size()==0) {
			//将用户名和密码存入数据库
			HashMap<String, Object> user = new HashMap<>();
			user.put("username", username);
			user.put("password", password);
			user.put("ismanager", s);
			Dao.insertObj("userlist", user);
			
			request.setAttribute("text", "注册成功");
			request.setAttribute("urlpath", "login.jsp");
			request.getRequestDispatcher("/info.jsp").forward(request, response);
		}
		else {
			request.setAttribute("text", "该用户已存在，请重新注册");
			request.setAttribute("urlpath", "register.jsp");
			request.getRequestDispatcher("/info.jsp").forward(request, response);
		}
	}

}
