package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class No10_DataEdit {
	public static void main(String[] args) throws Exception {
			
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = " UPDATE notice SET "
				+ " title=?, "
				+ " content=?, "
				+ " files=? "
				+ " WHERE id=? ";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "cussip", "xoch2380");
		PreparedStatement st = con.prepareStatement(sql);
		
		String title = "title update";
		String content = "title & content update from JDBC where SQL";
		String files = "not not";
		int id = 102;
		
		st.setString(1, title);
		st.setString(2, content);
		st.setString(3, files);
		st.setInt(4, id);
		
		st.executeUpdate();
		
		st.close();
		con.close();
	}
}
