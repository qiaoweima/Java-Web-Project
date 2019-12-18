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
 * Servlet implementation class submit
 */
@WebServlet("/submit")
public class submit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public submit() {
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
		String name=request.getParameter("name");
		String age=request.getParameter("age");
		String sex=request.getParameter("sex");
		String doctor=request.getParameter("doctor");
		String time=request.getParameter("time");
		String beizhu=request.getParameter("beizhu");
		String username= (String) request.getSession().getAttribute("username");
		String sqldoc1="update doctor set 是否已占用='yes' where 医生姓名=? and 在诊时间=?";
		Object[] params1={doctor,time};
		HashMap<String, Object> yuyue = new HashMap<>();
		yuyue.put("姓名",name);
		yuyue.put("性别",sex);
		yuyue.put("年龄",age);
		yuyue.put("预约医生",doctor);
		yuyue.put("预约时间",time);
		yuyue.put("备注",beizhu);
		yuyue.put("预约状态","未接受");
		yuyue.put("账号",username);
		Dao.insertObj("yy",yuyue);
		Dao.execute(sqldoc1, params1);
		request.getRequestDispatcher("/index.jsp").forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
