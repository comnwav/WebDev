package com.pro.dao;

import java.sql.SQLException;

import com.pro.DAO;
import com.pro.vo.StarLikeVO;

public class StarLikeDAO extends DAO {

	public StarLikeVO getStarsAvg(StarLikeVO slv) {

		conn = getConnect();

		String sql = "select avg(cm_stars) from info_cmt where movie_id = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, slv.getMovieId());
			rs = psmt.executeQuery();
			if (rs.next()) {
				slv.setStarsAvg(rs.getInt("avg(cm_stars)"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return slv;
	}

	public StarLikeVO getLikes(StarLikeVO slv) {
		conn = getConnect();

		String sql = "select count(*) from info_like where movie_id = ? and like_bool = 1";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, slv.getMovieId());
			rs = psmt.executeQuery();
			if (rs.next()) {
				slv.setLikes(rs.getInt("count(*)"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return slv;
	}

	public StarLikeVO getIndivLike(StarLikeVO slv) {
		conn = getConnect();

		String sql = "select like_bool from info_like where movie_id = ? and usr_id = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, slv.getMovieId());
			psmt.setString(2, slv.getId());
			rs = psmt.executeQuery();
			if (rs.next()) {
				slv.setIndivLike(rs.getInt("like_bool"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return slv;
	}

	public void like(StarLikeVO slv) {
		conn = getConnect();

		String sql = "UPDATE info_like\n"+
				"SET\n"+
				"    like_bool = 1\n"+
				"WHERE\n"+
				"        usr_id = ?\n"+
				"    AND movie_id = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, slv.getId());
			psmt.setInt(2, slv.getMovieId());
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
	}
	
	public void unLike(StarLikeVO slv) {
		conn = getConnect();

		String sql = "UPDATE info_like\n"+
				"SET\n"+
				"    like_bool = 0\n"+
				"WHERE\n"+
				"        usr_id = ?\n"+
				"    AND movie_id = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, slv.getId());
			psmt.setInt(2, slv.getMovieId());
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
	}

}
