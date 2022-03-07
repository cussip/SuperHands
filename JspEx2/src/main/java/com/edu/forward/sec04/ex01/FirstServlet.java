package com.edu.forward.sec04.ex01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//-----------------------------------------------------------------------------------------------------------
// HttpServletRequest를 이용한 redirect 포워딩 시 바인딩하기.
//-----------------------------------------------------------------------------------------------------------
// @WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//-----------------------------------------------------------------------------------------------------------
	// protected void doGet(HttpServletRequest request, HttpServletResponse response)
	//-----------------------------------------------------------------------------------------------------------
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		// 웹 브라우저에서 요청한 request 객체에 address 값으로 "서울시 동대문구 관철동"을 바인딩한다.
		request.setAttribute("address", "서울시 동대문구 관철동");
		response.sendRedirect("second");
		
	} // End - protected void doGet(HttpServletRequest request, HttpServletResponse response)

} // End - public class FirstServlet
