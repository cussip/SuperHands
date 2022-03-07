package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/No19")
// 어노테이션을 사용하면 web.xml 문서의 매핑 작성을 생략할 수 있다.
public class No19_KorLangIssue extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
//		request.setCharacterEncoding("UTF-8");
		/* No20_CharacterEncodingFilter
		 * No20_CharacterEncodingFilter.java 에서 필터 형태로 구현
		 */
		
		/* No19_KorLangIssue
		 * 톰캣 서버에서 읽어들이는 방식을 UTF-8로 설정하여야 한글이 정상적으로 출력 가능
		 * 톰캣 서버의 설정을 조정하는 것도 가능하지만, 서버를 여러 웹이 공유할 가능성이
		 * 있으므로 추천하지 않음
		 * PrintWriter out = response.getWriter(); 전에 입력해주어야 한다.
		 */
		
		PrintWriter out = response.getWriter();
		
		/* No18_post
		 * 요청 해야 할 내용이 많을 때, 일정한 양식을 통하여 내용을 취합하여 전달
		 * 입력 폼을 받기위한 get 요청
		 * 입력 폼에 내용을 입력하여 post 요청
		 * 
		 * html 문서에 method를 post로 지정.
		 * post 입력 후 등록울 진행할 경우 모든 내용이 쿼리스트링에 기록되어 넘어가서
		 * url이 길어지는 문제가 있으며, url에 표현하지 못하는 기호 등이 있을 경우 
		 * 추가적인 문제가 발생할 수 있음.
		 * 보안에도 취약
		 */
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		out.println(title);
		out.println(content);
			
	}
}
