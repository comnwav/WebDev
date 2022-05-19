package co.dev.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;

public class MemberInsertJson implements Control {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/json;charset=utf-8");

		boolean isMulti = ServletFileUpload.isMultipartContent(request);

		MemberVO vo = new MemberVO();
		
		if (isMulti) { // 멀티파트 요청
			String saveDir = "upload";
			saveDir = request.getServletContext().getRealPath(saveDir);
			int maxSize = 1024 * 1024 * 5;
			String encoding = "utf-8";
			MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, encoding,
					new DefaultFileRenamePolicy());

			String id = multi.getParameter("id");
			String name = multi.getParameter("name");
			String pwd = multi.getParameter("pwd");
			String email = multi.getParameter("email");
			String profile = multi.getFilesystemName("profile");

			vo.setId(id);
			vo.setName(name);
			vo.setPwd(pwd);
			vo.setEmail(email);
			vo.setProfile(profile);

			MemberService service = new MemberService();
			service.memberInsert(vo);

		} else { // key=value$key2=value2...
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String pwd = request.getParameter("pwd");
			String email = request.getParameter("email");

			
			vo.setId(id);
			vo.setName(name);
			vo.setPwd(pwd);
			vo.setEmail(email);

			MemberService service = new MemberService();
			service.memberInsert(vo);

		}
		
		// json 형태의 결과 반환
		Gson gson = new GsonBuilder().create();
		response.getWriter().print(gson.toJson(vo));

	}

}
