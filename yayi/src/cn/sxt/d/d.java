package cn.sxt.d;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import cn.sxt.db.Dao;
import mybean.data.findradio;
/**
 * Servlet implementation class d
 */
@WebServlet("/d")
public class d extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public d() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//findradio dataBean=new findradio();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String findtime="select * from doctor where 是否已占用='no'";
		String title=request.getParameter("title");
		ArrayList<HashMap<String, Object>> shijian = Dao.query(findtime);
		//dataBean.gettime();
		System.out.println(shijian);
		request.setAttribute("findtime",shijian);
		String xiugai=request.getParameter("jieshou");
		//xiugai=new String(xiugai.getBytes("ISO-8859-1"),"UTF-8");
		String[] nametime=xiugai.split(",");
		System.out.println(xiugai);
		System.out.println(nametime[0]);
		String SqlStr="select * from yy where 姓名='"+nametime[0]+"' and 预约时间='"+nametime[1]+"'";
		String nameStr="select distinct 医生姓名 from doctor";
		ArrayList<HashMap<String, Object>> name = Dao.query(nameStr);
		ArrayList<HashMap<String, Object>> xinxi = Dao.query(SqlStr);
		System.out.println(name);
		request.setAttribute("xinxi", xinxi);
		request.setAttribute("name",name);
		request.getRequestDispatcher("/xgyy.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
