package com.pro.service;

import java.util.List;

import com.pro.dao.CommentDAO;
import com.pro.dao.StarLikeDAO;
import com.pro.vo.MemberVO;
import com.pro.vo.PageVO;
import com.pro.vo.StarLikeVO;

public class InfoService {
	CommentDAO dao = new CommentDAO(); // db CRUD
	StarLikeDAO dao2 = new StarLikeDAO();
	
	public void addComment(MemberVO member) {
		dao.addComment(member);
	}
	
	public List<MemberVO> listComment(PageVO pv) {
		return dao.listComment(pv);
	}
	
	public void delComment(String code) {
		dao.delComment(code);
	}
	
	public int getRownum(int movieId) {
		return dao.getRownum(movieId);
	}
	
	public StarLikeVO getLikes(StarLikeVO slv) {
		return dao2.getLikes(slv);
	}
	
	public StarLikeVO getStarsAvg(StarLikeVO slv) {
		return dao2.getStarsAvg(slv);
	}
}
