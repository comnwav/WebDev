package com.pro.vo;

public class MemberVO {
	
	String id;
	String cmCode;
	String cmCont;
	int cmStars;
	String cmDate;
	String movieId;
	
	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCmCode() {
		return cmCode;
	}

	public void setCmCode(String cmCode) {
		this.cmCode = cmCode;
	}

	public String getCmCont() {
		return cmCont;
	}

	public void setCmCont(String cmCont) {
		this.cmCont = cmCont;
	}

	public int getCmStars() {
		return cmStars;
	}

	public void setCmStars(int cmStars) {
		this.cmStars = cmStars;
	}
	
	public String getCmDate() {
		return cmDate;
	}

	public void setCmDate(String cmDate) {
		this.cmDate = cmDate;
	}

	public MemberVO() {
		super();
	}
	
}
