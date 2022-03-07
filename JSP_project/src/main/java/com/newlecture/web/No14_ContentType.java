package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/No14_ContentType")
//어노테이션을 사용하면 web.xml 문서의 매핑 작성을 생략할 수 있다.
public class No14_ContentType extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		// 브라우저의 자의적인 해석을 막기위해 인코딩 형식과 해석 방식을 문서와 같이 전달	
		
		PrintWriter out = response.getWriter();
		
		for(int i = 0; i < 100; i++) {
			out.println((i + 1) + ": (안녕), Hello Servlet!!<br>");			
		}
	}
}
