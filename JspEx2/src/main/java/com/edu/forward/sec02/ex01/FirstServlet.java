package com.edu.forward.sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//-----------------------------------------------------------------------------------------------------------
// redirect 방식으로 다른 서블릿에 데이터 전달하기
//-----------------------------------------------------------------------------------------------------------
// @WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//-----------------------------------------------------------------------------------------------------------
	// protected void doGet(HttpServletRequest request, HttpServletResponse response)
	//-----------------------------------------------------------------------------------------------------------
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// GET 방식을 이용해 이름/값의 쌍으로 데이터를 다른 서블릿으로 전달한다.
		response.sendRedirect("second?name=Gildong");

	} // End - protected void doGet(HttpServletRequest request, HttpServletResponse response)

} // End - public class FirstServlet
