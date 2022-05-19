package co.test.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.test.vo.BookVO;

public class BookDAO extends DAO {

	public List<BookVO> bookList() {
		
		conn = getConnect();
		
		String sql = "SELECT *\n"+
				"FROM   book_info\n"+	
				"ORDER  BY 1";
		
		List<BookVO> list = new ArrayList<BookVO>();
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				BookVO vo = new BookVO();
				vo.setBookCode(rs.getString("book_code"));
				vo.setBookTitle(rs.getString("book_title"));
				vo.setBookAuthor(rs.getString("book_author"));
				vo.setBookPress(rs.getString("book_press"));
				vo.setBookPrice(rs.getInt("book_price"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return list;
	}

	public BookVO selectBook(String bookCode) {
		
		conn = getConnect();
		
		String sql = "select * from book_info where book_code = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, bookCode);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				BookVO vo = new BookVO();
				vo.setBookCode(rs.getString("book_code"));
				vo.setBookTitle(rs.getString("book_title"));
				vo.setBookAuthor(rs.getString("book_author"));
				vo.setBookPress(rs.getString("book_press"));
				vo.setBookPrice(rs.getInt("book_price"));
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return null;
	}

	public void insertBook(BookVO book) {

		conn = getConnect();

		String sql = "INSERT INTO book_info\n"+
				"    (book_code\n"+
				"    ,book_title\n"+
				"    ,book_author\n"+
				"    ,book_press\n"+
				"    ,book_price)\n"+
				"VALUES\n"+
				"    (create_bookcode\n"+
				"    ,?\n"+
				"    ,?\n"+
				"    ,?\n"+
				"    ,?)";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, book.getBookTitle());
			psmt.setString(2, book.getBookAuthor());
			psmt.setString(3, book.getBookPress());
			psmt.setInt(4, book.getBookPrice());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
	}

	public void updateBook(BookVO book) {
		
		conn = getConnect();
		
		String sql = "UPDATE book_info\n"+
				"SET\n"+
				"    book_title = ?,\n"+
				"    book_author = ?,\n"+
				"    book_press = ?,\n"+
				"    book_price = ?\n"+
				"WHERE\n"+
				"    book_code = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, book.getBookTitle());
			psmt.setString(2, book.getBookAuthor());
			psmt.setString(3, book.getBookPress());
			psmt.setInt(4, book.getBookPrice());
			psmt.setString(5, book.getBookCode());
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 수정");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
	}

	public void deleteBook(String bookCode) {
		
		conn = getConnect();
		
		String sql = "delete from book_info where book_code = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, bookCode);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
	} 
}
