package com.pro.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pro.service.InfoService;
import com.pro.vo.StarLikeVO;

public class LikeControl implements Control {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
	
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		StarLikeVO slv = new StarLikeVO();
		
		slv.setMovieId(Integer.parseInt(request.getParameter("movieId")));
		slv.setId(request.getParameter("id"));
		
		
		InfoService service = new InfoService();
	
	}
	
}
