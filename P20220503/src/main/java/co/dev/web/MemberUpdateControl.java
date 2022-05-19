package co.dev.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;

public class MemberUpdateControl implements Control {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");

		if (id.isEmpty() || name.isBlank() || pwd.isBlank() || email.isBlank()) {
			request.setAttribute("error", "모든 항목을 입력하세요");
			request.getRequestDispatcher("memberView/memberUpdate.jsp").forward(request, response);
			return;
		}
		
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setName(name);
		member.setPwd(pwd);
		member.setEmail(email);

		MemberService service = new MemberService();
		service.memberUpdate(member);
		
		request.setAttribute("id", id);
		
		request.getRequestDispatcher("memberResult/memberUpdateOutput.jsp").forward(request, response);
	}

}
