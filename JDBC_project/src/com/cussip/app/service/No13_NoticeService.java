package com.cussip.app.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.cussip.app.entity.Notice;

public class No13_NoticeService {
	private String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
	private String uid = "cussip";
	private String pwd = "xoch2380";
	private String driver = "oracle.jdbc.driver.OracleDriver";

	public List<Notice> getList(int page, String field, String query) throws ClassNotFoundException, SQLException {
		/* No18_페이징 쿼리 적용하기
		 * 1. SQL문을 페이징 쿼리로 변경
		 * 2. statement 구문을 preparedStatement 구문으로 변경
		 * 3. st.setInt를 사용하여 SQL구문에 변수 대입
		 * 4. page변수를 가공하여 보여줄 리스트의 시작 값과 마지막 값을 추출
		 */
		
		int start = 1 + (page - 1) * 5;	//1, 11, 21, 31
		int end = page * 5;				//10, 20, 30, 40
		
//		String sql = "SELECT * FROM NOTICE";
		String sql = " SELECT * FROM notice_view "
				+ " WHERE " + field + " LIKE ? AND num BETWEEN ? AND ? ";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, pwd);
//		Statement st = con.createStatement();
//		ResultSet rs = st.executeQuery(sql);	
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%" + query + "%");
		st.setInt(2,  start);
		st.setInt(3, end);
		
		ResultSet rs = st.executeQuery();
		List<Notice> list = new ArrayList<Notice>();
		
		while(rs.next()) {
			int id = rs.getInt("ID");
			String title = rs.getString("TITLE");
			String writer_id = rs.getString("WRITER_ID");
			String content = rs.getString("CONTENT");
			Date regdate = rs.getDate("REGDATE");
			int hit = rs.getInt("HIT");
			String files = rs.getString("FILES");
			
			Notice notice = new Notice(
						id,
						title, 
						writer_id,
						content,
						regdate,
						hit, 
						files
					);		
			list.add(notice);
		}
		rs.close();
		st.close();
		con.close();
		
		return list;	
	}
	
	//Scalar 값(=단일 값)을 얻어오는 메소드
	public int getCount(String searchField, String searchWord) throws SQLException, ClassNotFoundException {
		
		int count = 0;
		
		String sql = " SELECT count(" + searchField + ") count "
				+ "FROM notice WHERE " + searchField + " LIKE ?";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, pwd);
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%" + searchWord + "%");
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			count = rs.getInt("count");			
		}

		rs.close();
		st.close();
		con.close();
		
		return count;
	}

	public int insert(Notice notice) throws ClassNotFoundException, SQLException {
		String title = notice.getTitle();
		String writerId = notice.getWriter_id();
		String content = notice.getContent();
		String files = notice.getFiles();
		
		String sql = "INSERT INTO notice ("
				+ "		title,"
				+ "		writer_id,"
				+ "		content,"
				+ "		files"
				+ ") VALUES (?,?,?,?)";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, pwd);
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, title);
		st.setString(2, writerId);
		st.setString(3, content);
		st.setString(4, files);
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();

		return result;
	}
	
	public int update(Notice notice) throws ClassNotFoundException, SQLException {
		
		String sql = " UPDATE notice SET "
				+ " title=?, "
				+ " content=?, "
				+ " files=? "
				+ " WHERE id=? ";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, pwd);		
		PreparedStatement st = con.prepareStatement(sql);
		
		String title = notice.getTitle();
		String content = notice.getContent();
		String files = notice.getFiles();
		int id = notice.getId();
		
		st.setString(1, title);
		st.setString(2, content);
		st.setString(3, files);
		st.setInt(4, id);
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
	
	public int delete(int id) throws ClassNotFoundException, SQLException {
			
		String sql = " Delete notice WHERE id=? ";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, pwd);
		PreparedStatement st = con.prepareStatement(sql);
				
		st.setInt(1, id);
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
} 


