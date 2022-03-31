package com.newlecture.web.controller.notice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class SelfDataInput  {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("title: ");
		String title = br.readLine();
		
		System.out.println();
		System.out.print("content: ");
		String content = br.readLine();

		String writerId = "newlecking";
		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = " INSERT INTO notice(title, writer_id, content, hit) "
				+ " VALUES( "
				+ "    ?, "
				+ "    ?, "
				+ "    ?, "
				+ "    0 "
				+ ")";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "cussip", "xoch2380");

			for(int i = 0; i < 20; i++) {				
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, title + (i+1));
				st.setString(2, writerId);
				st.setString(3, (i+1) + content);
				ResultSet rs = st.executeQuery();
				rs.close();
				st.close();
			}
					
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
