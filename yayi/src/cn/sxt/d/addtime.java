package cn.sxt.d;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sxt.db.Dao;

/**
 * Servlet implementation class addtime
 */
@WebServlet("/addtime")
public class addtime extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addtime() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String doctorname=request.getParameter("doctorname");
		String time=request.getParameter("time");
		String sqldoc1="select * from doctor where 医生姓名=? and 在诊时间=?";
		Object[] params1={doctorname,time};
		ArrayList<HashMap<String, Object>> find= Dao.query(sqldoc1,params1);
		HashMap<String, Object> addtime = new HashMap<>();
		addtime.put("医生姓名",doctorname);
		addtime.put("在诊时间",time);
		addtime.put("是否已占用","no");
		if(find.isEmpty()) {
			Dao.insertObj("doctor",addtime);
		}
		else request.setAttribute("find",1);
//Dao.execute(sqldoc1, params1);
		request.getRequestDispatcher("/addtime.jsp").forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
