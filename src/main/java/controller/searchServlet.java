package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Student;
import model.Model;

/**
 * Servlet implementation class searchServlet
 */
@WebServlet("/searchServlet")
public class searchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public searchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");

		String keyword = request.getParameter("keyword");

		Student student = null;
		HttpSession session = request.getSession();
		try {
			session.removeAttribute("error");
			session.removeAttribute("color");
			session.removeAttribute("student");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		if (!"".endsWith(keyword) && keyword.matches("^\\d{1,}$") && keyword.length() <= 10) {
			Integer id = Integer.valueOf(keyword);
			student = Model.getByID(id);
			
			if (student != null) {
				session.setAttribute("student", student);
			} else {
				session.setAttribute("error", "Not Found UID = " + keyword + " !");
				session.setAttribute("color", "red");
			}

		} else {
			session.setAttribute("error", "ID¸ñÊ½´íÎó");
			session.setAttribute("color", "red");
		}

		// request.getRequestDispatcher("showstudent.jsp").forward(request, response);
		response.sendRedirect("showStudent.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
