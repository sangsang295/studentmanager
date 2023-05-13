package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import entity.Student;
import model.Model;

/**
 * Servlet implementation class insertByExcelServlet
 */
@WebServlet("/insertByExcelServlet")
public class insertByExcelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public insertByExcelServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");

		String studentsString = request.getParameter("students");

		HttpSession session = request.getSession();

		try {
			session.removeAttribute("student");
			session.removeAttribute("msg");
			session.removeAttribute("color");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (!"".equals(studentsString)) {
			JSONArray jsonArray = JSON.parseArray(studentsString);
			List<Student> students = new ArrayList<Student>();
			String msg = "";
			for (Object object : jsonArray) {
				Student student = JSON.toJavaObject(JSON.parseObject(object.toString()), Student.class);
				boolean flag = Model.insertstudent(student.getSname(), student.getSphone(), student.getSsex(), student.getSage(), student.getSclass(), student.getScollege(), null);
				if (flag) {
					msg += student.getSname() + "：添加成功！<br/>";
				}else {
					msg += student.getSname() + "：添加失败, 原因：学生"+student.getSname()+"已存在！<br/>";
				}
				students.add(Model.getByPhone(student.getSphone()));
			}
			String uString = JSON.toJSONString(students);
			session.setAttribute("students", uString);
			session.setAttribute("msg", msg);
			session.setAttribute("color", "black");
		} else {
			session.setAttribute("msg", "数据不能为空！");
			session.setAttribute("color", "red");
		}

		response.sendRedirect("insertShow.jsp");

	}

}
