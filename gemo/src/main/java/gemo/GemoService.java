package gemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import gemo.entity.GemoMemo;
import gemo.entity.GemoSection;

public class GemoService {

	public List<GemoMemo> getMemoList(int section) {
		
		List<GemoMemo> list = new ArrayList<>();
		
		String sql = " SELECT m.section_id, m.id, m.title, m.content FROM memo m "
				+ " INNER JOIN section s "
				+ " ON m.section_id = s.id "
				+ " WHERE m.section_id = ? ";		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "cussip", "xoch2380");
			PreparedStatement st = con.prepareStatement(sql);	
			st.setInt(1, section);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {				
				int sectionId = rs.getInt("section_id");
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				
				GemoMemo memo = new GemoMemo(
						sectionId, 
						id,
						title, 
						content
						);
				list.add(memo);
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

	public List<GemoSection> getSectionList() {

		List<GemoSection> list = new ArrayList<>();
		
		String sql = " SELECT * FROM section ";		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "cussip", "xoch2380");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {				
				String title = rs.getString("title");
				int id = rs.getInt("id");
				int noteId = rs.getInt("note_id");
				
				GemoSection section = new GemoSection (
						title,
						id,
						noteId
						);
				list.add(section);
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

	public String getMemoContent(int memo) {
		
		String content = "";	
		String sql = " SELECT content FROM memo WHERE id = ? ";
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "cussip", "xoch2380");
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, memo);
			
			ResultSet rs = st.executeQuery();
			content = rs.getString("content");
			
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}				
		return content;
	}

}
