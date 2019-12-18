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
		String sqldoc1="update doctor set �Ƿ���ռ��='yes' where ҽ������=? and ����ʱ��=?";
		Object[] params1={doctor,time};
		HashMap<String, Object> yuyue = new HashMap<>();
		yuyue.put("����",name);
		yuyue.put("�Ա�",sex);
		yuyue.put("����",age);
		yuyue.put("ԤԼҽ��",doctor);
		yuyue.put("ԤԼʱ��",time);
		yuyue.put("��ע",beizhu);
		yuyue.put("ԤԼ״̬","δ����");
		yuyue.put("�˺�",username);
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
