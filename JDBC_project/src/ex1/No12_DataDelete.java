package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class No12_DataDelete {
	public static void main(String[] args) throws Exception {
			
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = " Delete notice WHERE id=? ";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "cussip", "xoch2380");
		PreparedStatement st = con.prepareStatement(sql);
		
		int id = 50;
		
		st.setInt(1, id);
		st.executeUpdate();
		
		st.close();
		con.close();
	}
}
