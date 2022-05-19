package co.dev.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {

	HashMap<String, Control> list = null;
	
	String charset = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		
		System.out.println("start of init");
		
		charset = config.getInitParameter("charset");
		// HashMap<String keys, String values> or HashMap<String keys, integer values>
		// HashMap은 key/value 조합으로 key를 index로 이용한다.
		list = new HashMap<String, Control>();
		
		list.put("/memberInsert.do", new MemberInsertControl());
		list.put("/memberUpdate.do", new MemberUpdateControl());
		list.put("/memberList.do", new MemberListControl());
		list.put("/memberSearch.do", new MemberSearchControl());
		
		System.out.println("end of init");
		
		// json 관련 등록
		list.put("/memberListJson.do", new MemberListJson());
		list.put("/memberInsertJson.do", new MemberInsertJson());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding(charset);
		
		// "Uniform Resource Identifier"의 약자로서, 
		// 인터넷에 존재하는 각종 정보들의 유일한 이름이나 위치를 표시하는 식별자이다
		// 통합지원식별자
		
		String uri = req.getRequestURI();
		String context = req.getContextPath();
		String path = uri.substring(context.length());
		
		System.out.println(list);
		System.out.println(uri);
		System.out.println(context);
		System.out.println(path);

		Control exeCon = list.get(path);
		exeCon.execute(req, resp);
	}
	
	@Override
	public void destroy() {
		System.out.println("Servlet has been destroyed");
	}
}
