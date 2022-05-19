package co.dev.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/fileUploadServlet")
public class FileUploadServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FileUploadServ() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 이렇게는 안읽어짐 => multipart 로 받은건 multipart 객체로만 읽을 수 있다.
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		
		System.out.println("title: " + title + ", content: " + content);
		
		String saveDir = "upload";
		saveDir = getServletContext().getRealPath(saveDir);
		int maxSize = 1024 * 1024 * 5;
		String encoding = "utf-8";
		
		// multipart
		// request, 저장위치, 최대사이즈, 인코딩, 리네임정책.
		MultipartRequest multi =  new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
		title = multi.getParameter("title");
		content = multi.getParameter("content");
		String profile = multi.getOriginalFileName("profile");
		String fileName = multi.getFilesystemName("profile");
		
		System.out.println("title: " + title + ", content1: " + content + ", profile: " + profile + "filename :" + fileName);
		
	}

}
