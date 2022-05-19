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

		String sql = "select count(*) from info_like where movie_id = ?";

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

}
