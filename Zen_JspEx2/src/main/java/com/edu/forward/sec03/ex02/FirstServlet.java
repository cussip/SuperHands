package com.edu.forward.sec03.ex02;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//-----------------------------------------------------------------------------------------------------------
// dispatch를 이용해 GET 방식으로 데이터 전송하기.
//-----------------------------------------------------------------------------------------------------------
// @WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//-----------------------------------------------------------------------------------------------------------
	// protected void doGet(HttpServletRequest request, HttpServletResponse response)
	//-----------------------------------------------------------------------------------------------------------
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		
		RequestDispatcher dispatcher =  request.getRequestDispatcher("second?name=HongGildong");
		dispatcher.forward(request, response);

	} // End - protected void doGet(HttpServletRequest request, HttpServletResponse response)

} // End - public class FirstServlet
