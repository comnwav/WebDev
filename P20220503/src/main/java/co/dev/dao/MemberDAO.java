package co.dev.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.dev.DAO;
import co.dev.vo.MemberVO;

public class MemberDAO extends DAO {
	
	public void updateMember(MemberVO vo) {
		conn = getConnect();
		String sql = "update member set name= ?, pwd = ?, email = ? where id = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getName());
			psmt.setString(2, vo.getPwd());
			psmt.setString(3, vo.getEmail());
			psmt.setString(4, vo.getId());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 수정");	
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	public void deleteMember(String id) {
		conn = getConnect();
		String sql = "delete from member where id = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제");	
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	public MemberVO searchMember(String id) {
		conn = getConnect();
		String sql = "select * from member where id = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setPwd(rs.getString("pwd"));
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}
	
	public void insertMember(MemberVO member) {
		conn = getConnect();
		String sql = "insert into member(id, name, pwd, email, profile) values(?,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getId());
			psmt.setString(2, member.getName());
			psmt.setString(3, member.getPwd());
			psmt.setString(4, member.getEmail());
			psmt.setString(5, member.getProfile());
			
			int r = psmt.executeUpdate();
			
			System.out.println(r + "건 입력");	
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	public List<MemberVO> listMember() {
		conn = getConnect();
		String sql = "select * from member order by id";
		
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setEmail(rs.getString("email"));
				vo.setName(rs.getString("name"));
				vo.setPwd(rs.getString("pwd"));
				vo.setProfile(rs.getString("profile"));
				list.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return list;
	}
}
