package ex1;

import java.sql.*;

public class No05_DataSelect {

	public static void main(String[] args) throws Exception {
		/* No05_Exciese
		 * 1. 레코드의 모든 컬럼 출력하기 실습
		 * 2. 처음부터 마지막 레코드까지 전부 가져오기
		 */
		
		/* No06
		 * 조회수가 6000 이상인 게시글만 출력
		 * 1. 자바에서 조건을 부여하는 경우
		 * 2. SQL문에서 조건을 부여하는 경우
		 * 
		 * SQL에서 처리하는 것이 속도와 메모리 양측 모두 우위에 있기 떄문에
		 * 필터링, 정렬, 그룹화 등 DB에서 처리할 수 있는 연산은 가능한 DB에서
		 * 처리하는 것을 기본으로 생각해야한다.
		 */
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "SELECT * FROM NOTICE WHERE HIT > 6000";
		// 조회 수가 6000이상인 게시글만 조회
		// 위와 같이 DB에서 처리하도록 SQL을 수정하는 것이 바람직하다
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "cussip", "xoch2380");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		
		while(rs.next()) {
			int id = rs.getInt("ID");
			String title = rs.getString("TITLE");
			String writer_id = rs.getString("WRITER_ID");
			String content = rs.getString("CONTENT");
			Date regdate = rs.getDate("REGDATE");
			int hit = rs.getInt("HIT");
			String files = rs.getString("FILES");
			if(hit >= 6000) {
				// 조회 수가 6000 인상인 게시글만 조회
				// 바람직하지 않은 해결 방법으로 SQL에서 해결해야한다.
				// 위와 같이 필터링 할 경우 모든 게시글을 전부 조회하기 떄문에
				// 속도와 메모리 두 가지 모두의 측면에서 비효율적이다
				// 필터링, 정렬, 그룹화 등의 데이터 연산은 DB에서 처리하는 것을 기본으로 한다.
				System.out.printf("id: %s, writer_id: %s\n"
						+ "제목: %s\n"
						+ "내용: %s\n"
						+ "<< 등록일자: %s 조회수: %s, 첨부파일: %s >>\n\n"
						+ "----------------------------------------\n\n",
						id, writer_id, title, content, regdate, hit, files);
			}
		}
		rs.close();
		st.close();
		con.close();
	}
}
