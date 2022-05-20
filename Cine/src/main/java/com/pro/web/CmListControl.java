package com.pro.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.pro.service.InfoService;
import com.pro.vo.MemberVO;
import com.pro.vo.PageVO;

public class CmListControl implements Control {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PageVO pv = new PageVO();
		
		pv.setPage(Integer.parseInt(request.getParameter("page")));
		pv.setMovieId(Integer.parseInt(request.getParameter("movieId")));
		
		InfoService service = new InfoService();
		List<MemberVO> list = service.listComment(pv);

		PrintWriter out = response.getWriter();

		JSONArray ary = new JSONArray();

		for (MemberVO element : list) {
			
			JSONObject jo = new JSONObject();
			jo.put("id", element.getId());
			jo.put("cmt", element.getCmCont());
			jo.put("stars", element.getCmStars());
			jo.put("date", element.getCmDate().substring(2, 10));
			jo.put("movie_id", element.getMovieId());
			jo.put("code", element.getCmCode());
			
			ary.put(jo);
		}
		out.print(ary);
		out.close();
	}
}
