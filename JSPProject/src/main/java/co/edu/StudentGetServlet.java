package co.edu;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/StudentGetServlet")
public class StudentGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentGetServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get : cmd => seach

		response.setCharacterEncoding("utf-8");

		String cmd = request.getParameter("cmd");

		if (cmd != null && cmd.equals("search")) {

			String id = request.getParameter("user_id");
			StudentDAO dao = new StudentDAO();
			Student stud = dao.searchStudent(id);
			
			if (stud != null) {
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().println("<head>\r\n"
						+ "	<meta charset=\"UTF-8\">\r\n"
						+ "	<title>form.jsp</title>\r\n"
						+ "</head>");
				response.getWriter().println("<form name='frm' action='StudentGetServlet' method='post'>");
				response.getWriter().println("<h3>학생번호: " + stud.getStudentNo() + "</h3>");
				response.getWriter().println("<h3>학생이름: " + stud.getStudentName() + "</h3>");
				response.getWriter().println("<input type=\"hidden\" name=\"cmd\" value=\"mod\">");
				response.getWriter().println("<input type='hidden' name='user_id' value='"+stud.getStudentNo()+"'>");
				response.getWriter().println("<input type='hidden' name='user_name' value='"+stud.getStudentName()+"'>");
				response.getWriter().println("<h3>eng: <input type='number' name='eng_score' value=" + stud.getEngScore() + "></h3>");
				response.getWriter().println("<h3>kor: <input type='number' name='kor_score' value=" + stud.getKorScore() + "></h3>");
				response.getWriter().println("<input type='submit' value='수정' id='modBtn'>");
				response.getWriter().println("</form>");
			} else {
				response.setContentType("text/html;charset=utf-8");
//				response.getWriter().println("<script>"
//						+ "setTimeout(()=>{"
//						+ "window.location.href = './form.jsp'},1000)"
//						+ "</script>");
				response.sendRedirect("studentList.jsp");
			}


		//if cmd = null => json 諛섑솚
		} else {
			response.setContentType("text/json;charset=utf-8");

			StudentDAO dao = new StudentDAO();
			List<Student> list = dao.studentList();

			Gson gson = new GsonBuilder().create();
			response.getWriter().print(gson.toJson(list));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String cmd = request.getParameter("cmd");
		
		if (cmd != null && cmd.equals("add")) {
			StudentDAO dao = new StudentDAO();
			Student stud = new Student();

			String id = request.getParameter("user_id");
			String name = request.getParameter("user_name");
			String eng = request.getParameter("eng_score");
			String kor = request.getParameter("kor_score");


			stud.setStudentNo(Integer.parseInt(id));
			stud.setStudentName(name);
			stud.setEngScore(Integer.parseInt(eng));
			stud.setKorScore(Integer.parseInt(kor));

			dao.addStudent(stud);

			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println("�엯�젰�꽦怨�! 理쒗걧�셿�궧�솗李�");
//			response.getWriter().println("<script>"
//					+ "setTimeout(()=>{"
//					+ "window.location.href = './form.jsp'},1000)"
//					+ "</script>");
			response.sendRedirect("studentList.jsp");
			
		} else if (cmd != null && cmd.equals("del")) {
			String id = request.getParameter("user_id");

			StudentDAO dao = new StudentDAO();
			dao.removeStudent(id);
			response.getWriter().println("�궘�젣�꽦怨�! 理쒗걧�셿�궧�솗李�");
//			response.getWriter().println("<script>"
//					+ "setTimeout(()=>{"
//					+ "window.location.href = './form.jsp'},1000)"
//					+ "</script>");
			response.sendRedirect("studentList.jsp");
			
		} else if (cmd != null && cmd.equals("mod")) {
			Student stud = new Student();
			
			String id = request.getParameter("user_id");
			String name = request.getParameter("user_name");
			String eng = request.getParameter("eng_score");
			String kor = request.getParameter("kor_score");
			
			stud.setStudentNo(Integer.parseInt(id));
			stud.setStudentName(name);
			stud.setEngScore(Integer.parseInt(eng));
			stud.setKorScore(Integer.parseInt(kor));
			
			StudentDAO dao = new StudentDAO();
			dao.modifyStudent(stud);
			
			response.getWriter().println("�닔�젙�꽦怨�! 理쒗걧�셿�궧�솗李�");
			response.sendRedirect("studentList.jsp");
		}

	}
}
