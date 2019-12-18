package cn.sxt.d;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sxt.db.Dao;

/**
 * Servlet implementation class addlist
 */
@WebServlet("/addlist")
public class addlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addlist() {
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
		String name=request.getParameter("adddoctorname");
		name=new String(name.getBytes("ISO-8859-1"),"UTF-8");
		String time=request.getParameter("adddoctortime");
		time=new String(time.getBytes("ISO-8859-1"),"UTF-8");
		HashMap<String, Object> doctorlist = new HashMap<>();
		doctorlist.put("ҽ������",name);
		doctorlist.put("����ʱ��",time);
		doctorlist.put("�Ƿ���ռ��",0);
		Dao.insertObj("doctor",doctorlist);
		request.getRequestDispatcher("/doctorlist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
