package com.pro.vo;

public class StarLikeVO {
	
	int movieId;
	int likes;
	int starsAvg;
	String id;
	
	
	public int getMovieId() {
		return movieId;
	}


	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}


	public int getLikes() {
		return likes;
	}


	public void setLikes(int likes) {
		this.likes = likes;
	}


	public int getStarsAvg() {
		return starsAvg;
	}


	public void setStarsAvg(int starsAvg) {
		this.starsAvg = starsAvg;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public StarLikeVO() {
		super();
	}
}
