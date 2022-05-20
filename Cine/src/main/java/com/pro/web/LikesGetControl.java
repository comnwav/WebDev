package com.pro.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.pro.service.InfoService;
import com.pro.vo.StarLikeVO;

public class LikesGetControl implements Control {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		StarLikeVO slv = new StarLikeVO();

		slv.setMovieId(Integer.parseInt(request.getParameter("movieId")));

		InfoService service = new InfoService();

		service.getLikes(slv);

		PrintWriter out = response.getWriter();

		JSONObject jo = new JSONObject();
		jo.put("likes", slv.getLikes());

		out.print(jo);
		out.close();

	}

}
