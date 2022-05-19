package com.pro.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pro.service.InfoService;

public class CmDelControl implements Control {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		String code = request.getParameter("code");
		
		InfoService service = new InfoService();
		
		service.delComment(code);
			
	}

}
