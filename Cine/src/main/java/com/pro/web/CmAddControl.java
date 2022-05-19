package com.pro.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pro.service.InfoService;
import com.pro.vo.MemberVO;

public class CmAddControl implements Control {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		String comment = request.getParameter("comment");
		String stars = request.getParameter("stars");
		String movieId = request.getParameter("movieId");

		System.out.println(stars);

		MemberVO vo = new MemberVO();
		vo.setId("testId");
		vo.setCmCont(comment);
		vo.setCmStars(Integer.parseInt(stars));
		vo.setMovieId(movieId);

		InfoService service = new InfoService();
		service.addComment(vo);

	}

}
