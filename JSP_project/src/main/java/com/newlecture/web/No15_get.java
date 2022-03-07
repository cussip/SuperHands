package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/No15_get")
// 어노테이션을 사용하면 web.xml 문서의 매핑 작성을 생략할 수 있다.
public class No15_get extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		// 브라우저의 자의적인 해석을 막기위해 인코딩 형식과 해석 방식을 문서와 같이 전달	
		
		PrintWriter out = response.getWriter();
		
		/*
		 * Get 요청: 추가적인 옵션을 전달
		 * ex) http://localhost/hello?cnt=3
		 * "hello?cnt=3" : 요청
		 * "?cnt=3": 쿼리스트링 
		 */
		int cnt = Integer.parseInt(request.getParameter("cnt"));
		
		for(int i = 0; i < cnt; i++) {
			out.println((i + 1) + ": (안녕), Hello Servlet!!<br>");			
		}
	}
}
