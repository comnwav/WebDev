package co.dev.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;

public class MemberInsertControl implements Control {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// multipart : request, saveDir, maxSize, encoding, renamePolicy
		
		String saveDir = "upload";
		saveDir = request.getServletContext().getRealPath(saveDir);
		int maxSize = 1024 * 1024 * 5;
		String encoding = "utf-8";
		MultipartRequest multi =  new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
		
		String id = multi.getParameter("id");
		String name = multi.getParameter("name");
		String pwd = multi.getParameter("pwd");
		String email = multi.getParameter("email");
		String profile = multi.getFilesystemName("profile");
		
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setName(name);
		vo.setPwd(pwd);
		vo.setEmail(email);
		vo.setProfile(profile);
		
		MemberService service = new MemberService();
		service.memberInsert(vo);
		
		request.setAttribute("id", id);
		request.setAttribute("name", name);
		
		request.getRequestDispatcher("memberResult/memberInsertOutput.jsp").forward(request, response);
	}
}
