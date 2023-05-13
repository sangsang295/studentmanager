package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.alibaba.fastjson.JSON;

import entity.Student;
import model.Model;

/**
 * Servlet implementation class insertByInputServlet
 */
@WebServlet("/insertByInputServlet")
@MultipartConfig
public class insertByInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PHONE = "^1[3-9]\\d{9}$";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertByInputServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		
		HttpSession session = request.getSession();
		
		try {
			session.removeAttribute("student");
			session.removeAttribute("msg");
			session.removeAttribute("color");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		Part part = request.getPart("simg");
	
		String sname = request.getParameter("sname");
		String sphone = request.getParameter("sphone");
		String sage = request.getParameter("sage");
		String ssex = request.getParameter("ssex");
		String sclass = request.getParameter("sclass");
		String scollege = request.getParameter("scollege");
		
		if(!"".equals(sname) && !"".equals(sphone) && !"".equals(ssex) && !"".equals(sage) && sphone.matches(PHONE) && !"".equals(scollege) && !"".equals(sclass)) {
			// 格式正确
			boolean flag = Model.insertstudent(sname, sphone, ssex, Integer.parseInt(sage), sclass, scollege, null);

			if(flag) {
				Student student = Model.getByPhone(sphone);
				if(student != null) {
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
							Model.updateImg(student.getSid(), dataImgSrc);
							part.write(filePath);
							part.delete();
							student.setSimg(dataImgSrc);
							System.out.println(dataImgSrc.length());
						}
					}
					
					List<Student> students = new ArrayList<Student>();
					students.add(student);
					String studentsString = JSON.toJSONString(students);
					session.setAttribute("students", studentsString);
					session.setAttribute("msg", "学生 "+sname+" 添加成功！");
					session.setAttribute("color", "green");
				}
				
			}else {
				session.setAttribute("msg", "学生 "+sname+" 添加失败，原因：学生已存在！");
				session.setAttribute("color", "red");
			}
		}else {
			// 格式错误
			session.setAttribute("msg", "输入内容格式有误，请核对后再次尝试！");
			session.setAttribute("color", "red");
		}
		
		response.sendRedirect("insertShow.jsp");
		
	}

}
