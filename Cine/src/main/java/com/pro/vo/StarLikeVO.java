package com.pro.vo;

public class StarLikeVO {
	
	int movieId;
	int likes;
	int indivLike;
	double rating;
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

	public int getIndivLike() {
		return indivLike;
	}

	public void setIndivLike(int indivLike) {
		this.indivLike = indivLike;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
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
