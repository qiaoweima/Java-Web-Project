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
 * Servlet implementation class updata
 */
@WebServlet("/updata")
public class updata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updata() {
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
		String oldname=request.getParameter("oldname");
		String oldtime=request.getParameter("oldtime");
		String olddoctor=request.getParameter("olddoctor");
		String sql="update yy set ����=?,�Ա�=?,����=?,ԤԼҽ��=?,ԤԼʱ��=?,��ע=?,ԤԼ״̬=? where ����=? and ԤԼʱ��=?";
		Object[] params={name,sex,age,doctor,time,beizhu,"δ����",oldname,oldtime};
		Dao.execute(sql,params);
		String sqldoc1="update doctor set �Ƿ���ռ��='yes' where ҽ������=? and ����ʱ��=?";
		System.out.println(olddoctor.equals(doctor));
		System.out.println(olddoctor);
		if(!olddoctor.equals(doctor)||!oldtime.equals(time))
		{
			String sqldoc2="update doctor set �Ƿ���ռ��='no' where ҽ������=? and ����ʱ��=?";
			 Object[] params2={olddoctor,oldtime};
			 Dao.execute(sqldoc2,params2);
		}
		Object[] params1={doctor,time};
		/*HashMap<String, Object> yuyue = new HashMap<>();
		yuyue.put("����",name);
		yuyue.put("�Ա�",sex);
		yuyue.put("����",age);
		yuyue.put("ԤԼҽ��",doctor);
		yuyue.put("ԤԼʱ��",time);
		yuyue.put("��ע",beizhu);
		yuyue.put("ԤԼ״̬",0);*/
		//Dao.execute(sql,params);
		Dao.execute(sqldoc1,params1);
		//Dao.insertObj("yy",yuyue);
		//for(doctor.equals("��ѡ��")|time.equals("��ѡ��"))
			//request.getRequestDispatcher("/xgyy.jsp").forward(request, response);
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
