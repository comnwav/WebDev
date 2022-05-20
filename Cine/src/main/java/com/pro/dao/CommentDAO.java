package com.pro.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pro.DAO;
import com.pro.vo.MemberVO;
import com.pro.vo.PageVO;

public class CommentDAO extends DAO {

	public int getRownum(int movieId) {

		conn = getConnect();

		String sql = "select count(*) from info_cmt where movie_id = ?";

		int count = 0;

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, movieId);
			rs = psmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt("count(*)");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return count;
	}

	public void addComment(MemberVO vo) {
		conn = getConnect();
		String sql = "INSERT INTO info_cmt (\n" + "    usr_id,\n" + "    cm_code,\n" + "    cm_cont,\n"
				+ "    cm_date,\n" + "    cm_stars,\n" + "    movie_id\n" + ") VALUES (\n" + "    ?,\n"
				+ "    'cm'||cm_code_seq.nextval,\n" + "    ?,\n" + "    sysdate,\n" + "    ?,\n" + "    ?\n" + ")";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getCmCont());
			psmt.setInt(3, vo.getCmStars());
			psmt.setString(4, vo.getMovieId());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
	}

	public void delComment(String code) {
		conn = getConnect();

		String sql = "delete from info_cmt where cm_code = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, code);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
	}

	public List<MemberVO> listComment(PageVO pv) {
		conn = getConnect();

		List<MemberVO> list = new ArrayList<MemberVO>();

		String sql = "SELECT\n"+
				"    *\n"+
				"FROM\n"+
				"    (\n"+
				"        SELECT\n"+
				"            a.*,\n"+
				"            ROWNUM rn\n"+
				"        FROM\n"+
				"            (\n"+
				"                SELECT\n"+
				"                    *\n"+
				"                FROM\n"+
				"                    info_cmt\n"+
				"                ORDER BY\n"+
				"                    cm_date DESC\n"+
				"            ) a\n"+
				"        WHERE\n"+
				"            ROWNUM <= ?*5 and movie_id = ?\n"+
				"    )\n"+
				"WHERE\n"+
				"    rn > (?-1)*5 and movie_id = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, pv.getPage());
			psmt.setInt(2, pv.getMovieId());
			psmt.setInt(3, pv.getPage());
			psmt.setInt(4, pv.getMovieId());
			rs = psmt.executeQuery();
			while (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("usr_id"));
				vo.setCmCont(rs.getString("cm_cont"));
				vo.setCmDate(rs.getString("cm_date"));
				vo.setCmStars(rs.getInt("cm_stars"));
				vo.setCmCode(rs.getString("cm_code"));
				list.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return list;
	}

}
