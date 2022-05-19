package co.edu.student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajax/modStudentServlet")
public class ModStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ModStudentServlet() {
		super();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");

		String sNo = req.getParameter("a");
		String sName = req.getParameter("b");
		String eng = req.getParameter("c");
		String kor = req.getParameter("d");

		Student std = new Student();
		std.setStudentNo(Integer.parseInt(sNo));
		std.setStudentName(sName);
		std.setEngScore(Integer.parseInt(eng));
		std.setKorScore(Integer.parseInt(kor));
		
		StudentDAO dao = new StudentDAO();
		
		boolean success = dao.modifyStudent(std);
		
		System.out.println(std);
		
		if (success) {
			// {"retCode":"Success", "studNo":studentNo, "studName":"studentName",
			// "engScore":engScore, "korScore":korScore}
			
			resp.getWriter().println("{\"retCode\":\"Success\", \"studNo\":" + std.getStudentNo() + ", \"studName\":\""
					+ std.getStudentName() + "\", \"engScore\":" +std.getEngScore() + ", \"korScore\":" + std.getKorScore() + "}");

		} else {
			// {"retCode":"Fail"}
			resp.getWriter().println("{\"retCode\":\"Fail\"}");
		}

	}

}
