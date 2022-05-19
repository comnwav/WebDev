package co.edu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/edu/info.do")
public class Info extends HttpServlet {
	
	// Info 페이지 요청 -> Init() -> Service() -> Destroy()
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		out.print("<h3>서블릿 페이지</h3>");
		out.print("<h3>안녕하세요</h3>");
		out.print("<a href=\"../index.html\">index</a>");
		
		out.print("<table border=1>\r\n"
				+ "    <thead>\r\n"
				+ "        <tr>\r\n"
				+ "            <th>이름</th>\r\n"
				+ "            <th>직책</th>\r\n"
				+ "        </tr>\r\n"
				+ "    </thead>\r\n"
				+ "    <tbody>\r\n"
				+ "        <tr>\r\n"
				+ "            <td>최규완</td>\r\n"
				+ "            <td>큰 똥쟁이</td>\r\n"
				+ "        </tr>\r\n"
				+ "        <tr>\r\n"
				+ "            <td>권태현</td>\r\n"
				+ "            <td>작은 똥쟁이</td>\r\n"
				+ "        </tr>\r\n"
				+ "    </tbody>\r\n"
				+ "</table>");
	}
	
}
