package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class No08_DataInput {
	public static void main(String[] args) throws Exception {
		
		/* No08_데이터 입력을 위한 쿼리문 준비하기
		 * 테이블의 내용을 입력 받을 시 사용자가 입력해야 할 값(title, content 등)과 
		 * 그렇지 않은 값(hit, regdate 등)을 구분해야 한다.
		 * 
		 * INSERT INTO notice (id, title, writer_id, content, regdate, hit, files) 
	     * VALUES (:v0, :v1, :v2, :v3, :v4, :v5, :v6);
		
		 * hit와, regdate는 시스템에서 주어지는 값으로 사용자가 직접 입력할 필요가 없다.
		 * id 또한 시스템에서 부여되는 값으로 중복없이 순서대로 자동 입력되도록 설정해야 한다
		
		 * SELECT notice_id_seq_02.next_val FROM DUAL;
		 *	// 시퀀스로 부여된 숫자를 불러오는 구문
		 *	// 불러올 때 마다 다음 숫자로 넘어가며, rollback을 사용해도 지나간 숫자는
		 *	// 다시 생성되지 않는다
		 */
		String title = "Test2 title";
		String writerId = "ishcjswo";
		String content = "Test content input JDBC";
		String files = "";
		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		/* No09_PreparedStatement
		 * 
		 * String sql = "INSERT INTO notice ("
		 *		+ "		title,"
		 *		+ "		writer_id,"
		 *		+ "		content,"
		 *		+ "		files"
		 *		+ ") VALUES (
		 *		+ "		'" + title + "',"
		 *		+ "		'" + writerId + "',"
		 *		+ "		'" + content + "',"
		 *		+ "		'" + files + "',"
		 *		+)";
		 *
		 *	밸류 값을 입력하는 쿼리문이 복잡하며, 실수를 유발할 여지가 높음
		 *	이를 극복하기 위하여 PreparedStatement를 사용한다.
		 */
		String sql = "INSERT INTO notice ("
				+ "		title,"
				+ "		writer_id,"
				+ "		content,"
				+ "		files"
				+ ") VALUES (?,?,?,?)";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "cussip", "xoch2380");
//		Statement st = con.createStatement();
		// 결과 집합을 사용할 때 사용하는 명령어
		// statement는 st.ex...(sql)의 형태로 실행할때 쿼리문을 넘긴다

		PreparedStatement st = con.prepareStatement(sql);
		// PreparedStatement는 statement의 기능을 다 가지고 있으면서,
		// values(?)의 '?'안에 값을 채울 수 있는 기능을 가지고 있다.
		// (statement 자체적으로 쿼리문을 가지고 있을 수 있으며 값을 세팅할 수 있다.)
		st.setString(1, title);
		st.setString(2, writerId);
		st.setString(3, content);
		st.setString(4, files);
		
//		ResultSet rs = st.executeQuery(sql);
		// 결과 집합을 사용할 때 사용하는 명령어
		// PreparedStatement에 sql을 직접 입력하여서 사용하기 때문에 sql을 포함할 필요가 없다.
		int result = st.executeUpdate();
			// INSERT, UPDATE, DELETE 등의 조작을 사용할 때는 
			// executeUpdate 명령어를 사용한다.
		System.out.println(result);
			// result는 조건 검사를 위해 사용하며, 작업이 완료되었을 경우 1을 출력
		
		st.close();
		con.close();
	}
}
