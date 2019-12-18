package cn.sxt.d;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sxt.db.Dao;
import mybean.data.findradio;

/**
 * Servlet implementation class q
 */
@WebServlet("/zxyy")
public class zxyy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public zxyy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//findradio dataBean=new findradio();
		//request.setAttribute("data",dataBean);
		String findtime="select * from doctor where 是否已占用='no'";
		String nameStr="select distinct 医生姓名 from doctor";
		ArrayList<HashMap<String, Object>> name = Dao.query(nameStr);
		ArrayList<HashMap<String, Object>> shijian = Dao.query(findtime);
		//dataBean.gettime();
		System.out.println(shijian);
		System.out.println(name);
		request.setAttribute("findtime",shijian);
		//JSONObject json=JSONObject.fromObject(shijian);
		String SqlStr="select * from yy";
		ArrayList<HashMap<String, Object>> xinxi = Dao.query(SqlStr);
		System.out.println(xinxi);
		request.setAttribute("name",name);
		request.setAttribute("xinxi", xinxi);
		request.getRequestDispatcher("/zxyy.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
