package controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import entity.Student;
import model.Model;

/**
 * Servlet implementation class updateServlet
 */
@WebServlet("/updateServlet")
@MultipartConfig
public class updateServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8881189065094214147L;
	private static final String PHONE = "^1[3-9]\\d{9}$";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public updateServlet() {
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

		HttpSession session = request.getSession();

		try {
			session.removeAttribute("msg");
			session.removeAttribute("color");
			session.removeAttribute("originalStudent");
			session.removeAttribute("updatedStudent");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		Part part = request.getPart("simg");

		String idString = request.getParameter("sid");
		String sname = request.getParameter("sname");
		String sphone = request.getParameter("sphone");
		String ssex = request.getParameter("ssex");
		String sage = request.getParameter("sage");
		String sclass = request.getParameter("sclass");
		String scollege = request.getParameter("scollege");

		if (!"".equals(scollege) && !"".equals(sclass) && !"".equals(idString) && !"".equals(sname)
				&& !"".equals(sphone) && sphone.matches(PHONE) && !"".equals(ssex) && !"".equals(sage)
				&& idString.matches("^\\d{1,10}$") && sage.matches("^\\d{1,10}$")) {

			Integer sid = Integer.valueOf(idString);

			Student originalStudent = Model.getByID(sid);
			
			
			if (part != null) {
				String serverPath = request.getServletContext().getRealPath("/images/upload/");
				// 获取文件头信息
				String fileHeader = part.getHeader("Content-Disposition");
				// 文件名
				String fileName = fileHeader.substring(fileHeader.lastIndexOf("=") + 2, fileHeader.length() - 1);
				String fileType = fileName.substring(fileName.lastIndexOf("."));
				if(!"".equals(fileName)) {	
					String finalName = UUID.randomUUID() + fileType;
					String dataImgSrc = "./images/upload/"+finalName;
					String filePath = serverPath + finalName;
					Model.updateImg(Integer.valueOf(idString), dataImgSrc);
					part.write(filePath);
					part.delete();
				}
			}
			
			if (originalStudent != null) {
				session.setAttribute("originalStudent", originalStudent);
				Boolean flag = Model.updateByID(sid, sname, sphone, ssex, Integer.parseInt(sage), sclass, scollege,
						null);
				if (flag) {
					Student updatedStudent = Model.getByID(sid);
					session.setAttribute("updatedStudent", updatedStudent);
					session.setAttribute("msg", "用户ID为 " + idString + " 的信息修改成功!");
					session.setAttribute("color", "green");
				} else {
					session.setAttribute("msg", "修改失败， 原因：用户信息与其他用户发生冲突（比如：手机号）！");
					session.setAttribute("color", "red");
				}

			} else {
				session.setAttribute("msg", "修改失败， 原因：用户不存在！");
				session.setAttribute("color", "red");
			}

		} else {
			session.setAttribute("msg", "输入的内容不合法，请仔细检查后重新尝试！");
			session.setAttribute("color", "red");
		}

		response.sendRedirect("updateShow.jsp");

	}

}
