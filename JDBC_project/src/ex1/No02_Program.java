package ex1;

import java.sql.Connection;

public class No02_Program {

	public static void main(String[] args) {
		Connection con;
	}
}
/*	No02_Program
 *	Oracle에서 JDBC를 다운 받는다.
 *		다운로드시에는 Oracle 버전과 JDK 버전을 확인하여 진행한다.
 *	다운로드한 JDBC 파일을 적당한 곳에 위치시킨다
 *	이클립스의 프로젝트에서 BulidPath에서 Libraries 탭으로 이동하여
 *	JDBC(jar) 파일을 add한다					 
 */

/* No03_
 * JDBC를 이용하는 자바 코드	
 * 일반적인 객체 생성방법과 달리 new를 통해서 객체를 생성하지 않음
 * 
 * Class.forName("oracle.jdbc.driver.OracleDriver");
 * 		- 메모리상에 드라이버가 올라감
 * Connection con = DriverManager.getConnection();
 * 		- 연결이 이루어지고 연결이 확립이 되면 객체가 반환		
 * Statement st = con.createStatement();
 * 		- 사용자로부터 요청받은 쿼리를 실행
 * ResultSet rs = st.executeQuery(sql);
 * 		- 쿼리 실행의 결과로 결과 집합을 생성하고,
 * 		- 서버 쪽에 만들어진 결과 집합을 사용할 수 있게 준비.
 * 		- BOF(before of file)에서 EOF(end of file)까지 포인팅 커서의 위치가 움직이며,
 * 		- 레코드를 순서대로 호출한다.
 */








