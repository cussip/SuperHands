package com.newlecture.web.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeCmtView;

public class NoticeService {
	
	public int removeNoticeAll(int[] ids) {
		
		return 0;
	}
	
	public int pubNoticeAll(int[] ids) {
		
		int result = 0;		
		String params = "";
		for(int i = 0; i < ids.length; i++) {
			params += ids[i];
			if(i < ids.length - 1) {
				params += ", ";
			}
		}
		String sql = " UPDATE notice SET pub=1 WHERE id IN (" + params + ") ";	
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con  = DriverManager.getConnection(url, "cussip", "xoch2380");
			Statement st = con.createStatement();
			
			result = st.executeUpdate(sql);

			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int insertNotice(Notice notice) {
		
		int result = 0;		
		
		String sql = " INSERT INTO NOTICE(title, content, writer_id, pub, files) "
				+ " values (?, ?, ?, ?, ?) ";		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con  = DriverManager.getConnection(url, "cussip", "xoch2380");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, notice.getTitle());
			st.setString(2, notice.getContent());
			st.setString(3, notice.getWriterId());
			st.setBoolean(4, notice.getPub());
			st.setString(5, notice.getFiles());
			
			result = st.executeUpdate();

			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int deleteNotcie(int id) {
		
		return 0;
	}
	
	public int updateNotice(Notice notice) {
		
		return 0;
	}
	
	public List<Notice> getNoticeNewestList() {
		
		return null;
	}
	
	
	public List<NoticeCmtView> getNoticeList() {		
		return getNoticeList("title", "", 1);
	}
	
	public List<NoticeCmtView> getNoticeList(int page) {		
		return getNoticeList("title", "", page);
	}
	
	public List<NoticeCmtView> getNoticeList(String field, String query, int page) {

		List<NoticeCmtView> list = new ArrayList<>();
		
		String sql = " SELECT * FROM ( "
				+ "    SELECT ROWNUM NUM, N.* "
				+ "    FROM (SELECT * FROM NOTICE_CMT_VIEW "
				+ "			 WHERE " + field + " LIKE ? "
				+ "			 ORDER BY REGDATE DESC) N "
				+ " ) "
				+ " WHERE NUM BETWEEN ? AND ? ";
		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "cussip", "xoch2380");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%"+query+"%");
			st.setInt(2, 1+(page-1)*10);
			st.setInt(3, page*10);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) { 			
				int id = rs.getInt("id");
				String title = rs.getString("title");
				Date regdate = rs.getDate("regdate");
				String writerId = rs.getString("writer_id");
				String hit = rs.getString("hit");
				String files = rs.getString("files");
				boolean pub = rs.getBoolean("pub");
				int cmt = rs.getInt("cmt");
				
				NoticeCmtView notice = new NoticeCmtView(
						id, 
						title, 
						regdate, 
						writerId, 
						hit, 
						files,
						pub,
						cmt
					);
				list.add(notice);
			}
			
			rs.close();
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public List<NoticeCmtView> getNoticePubList(String field, String query, int page) {
		
		List<NoticeCmtView> list = new ArrayList<>();
		
		String sql = " SELECT * FROM ( "
				+ "    SELECT ROWNUM NUM, N.* "
				+ "    FROM (SELECT * FROM NOTICE_CMT_VIEW "
				+ "			 WHERE " + field + " LIKE ? "
				+ "			 ORDER BY REGDATE DESC) N "
				+ " WHERE pub = 1 "
				+ " ) "
				+ " WHERE NUM BETWEEN ? AND ? ";
		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "cussip", "xoch2380");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%"+query+"%");
			st.setInt(2, 1+(page-1)*10);
			st.setInt(3, page*10);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) { 			
				int id = rs.getInt("id");
				String title = rs.getString("title");
				Date regdate = rs.getDate("regdate");
				String writerId = rs.getString("writer_id");
				String hit = rs.getString("hit");
				String files = rs.getString("files");
				boolean pub = rs.getBoolean("pub");
				int cmt = rs.getInt("cmt");
				
				NoticeCmtView notice = new NoticeCmtView(
						id, 
						title, 
						regdate, 
						writerId, 
						hit, 
						files,
						pub,
						cmt
					);
				list.add(notice);
			}
			
			rs.close();
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public int getNoticeCount() {
		return getNoticeCount("title", "");
	}

	public int getNoticeCount(String field, String query) {
		
		int count = 0;
		
		String sql = " SELECT COUNT(ID) count FROM ( "
				+ "    SELECT ROWNUM NUM, N.* "
				+ "    FROM (SELECT * FROM NOTICE "
				+ "			 WHERE " + field + " LIKE ? "
				+ "			 ORDER BY REGDATE DESC) N "
				+ " ) ";		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "cussip", "xoch2380");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%"+query+"%");
	
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count");				
			}
			
			rs.close();
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public Notice getNotice(int id) {	
		
		Notice notice = null;		
		String sql = " SELECT * FROM notice n "
				+ " WHERE n.id = ? ";
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "cussip", "xoch2380");
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			
			ResultSet rs = st.executeQuery();

			if(rs.next()) { 			
				int nid = rs.getInt("id");
				String title = rs.getString("title");
				Date regdate = rs.getDate("regdate");
				String writerId = rs.getString("writer_id");
				String hit = rs.getString("hit");
				String files = rs.getString("files");
				String content = rs.getString("content");
				boolean pub = rs.getBoolean("pub");

				notice = new Notice(
						nid, 
						title, 
						regdate, 
						writerId, 
						hit, 
						files, 
						content,
						pub
					);
			}
			
			rs.close();
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return notice;
	}
	
	public Notice getNextNotice(int id) {	
		
		Notice notice = null;		
		String sql = " SELECT * FROM notice "
				+ " WHERE id = ( "
				+ "    SELECT id FROM notice "
				+ "    WHERE regdate > (SELECT regdate FROM notice WHERE id=?) "
				+ "    AND ROWNUM = 1 "
				+ " ) ";
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "cussip", "xoch2380");
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			
			ResultSet rs = st.executeQuery();

			if(rs.next()) { 			
				int nid = rs.getInt("id");
				String title = rs.getString("title");
				Date regdate = rs.getDate("regdate");
				String writerId = rs.getString("writer_id");
				String hit = rs.getString("hit");
				String files = rs.getString("files");
				String content = rs.getString("content");
				boolean pub = rs.getBoolean("pub");

				notice = new Notice(
						nid, 
						title, 
						regdate, 
						writerId, 
						hit, 
						files, 
						content,
						pub
					);
			}		
			rs.close();
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return notice;	
	}
	
	public Notice getprevNotice(int id) {
		
		Notice notice = null;		
		String sql = " SELECT * FROM ( "
				+ "    SELECT id FROM notice "
				+ "    WHERE regdate < ( "
				+ "        SELECT regdate FROM notice WHERE id=?) "
				+ "    ORDER BY regdate DESC) "
				+ " WHERE ROWNUM = 1 ";		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "cussip", "xoch2380");
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			
			ResultSet rs = st.executeQuery();

			if(rs.next()) { 			
				int nid = rs.getInt("id");
				String title = rs.getString("title");
				Date regdate = rs.getDate("regdate");
				String writerId = rs.getString("writer_id");
				String hit = rs.getString("hit");
				String files = rs.getString("files");
				String content = rs.getString("content");
				boolean pub = rs.getBoolean("pub");

				notice = new Notice(
						nid, 
						title, 
						regdate, 
						writerId, 
						hit, 
						files, 
						content,
						pub
					);
			}			
			rs.close();
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return notice;
	}
	
	public int deleteNoticeAll(int[] ids) {
		
		int result = 0;		
		String params = "";
		for(int i = 0; i < ids.length; i++) {
			params += ids[i];
			if(i < ids.length - 1) {
				params += ", ";
			}
		}
		
		String sql = " DELETE notice WHERE id IN (" + params + ") ";		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con  = DriverManager.getConnection(url, "cussip", "xoch2380");
			Statement st = con.createStatement();
			
			result = st.executeUpdate(sql);

			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
