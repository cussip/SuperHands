package com.newlecture.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/No38")
public class No38_doGetdoPost extends HttpServlet {

	/* No38_doGetdoPost
	 * GET요청과 POST요청을 나누어서 처리해야할 경우
	 * 1. service가 가지고 있는 기능을 사용하는 방법
	 * 		service는 사용자에게 요청이 왔을 때 GET요청과 POST요청을 구분하여
	 * 		doGet이나 doPost를 실행한다.
	 * 		(service는 라우팅과 유사한 역할을 한다고 생각할 수 있다.)
	 * 2. 따라서, doGet이나 doPost를 직접 오버라이드하여 사용하는것도 가능하다.
	 * 		(service없이 doGet이나 doPost만 오버라이드 정의하는것도 가능)
	 * 3. doGet과 doPost외에도 많은 요청이 있지만 거의 사용하지 않는다.
	 */

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// GET은 반드시 대문자로 구분해주어야 한다.
		if(request.getMethod().equals("GET")) {
			System.out.println("GET요청 접수");
		} else if(request.getMethod().equals("POST")) {
			System.out.println("POST요청 접수");
		}
		super.service(request, response);
		//요청에 따른 두 함수를 호출하는 역할을 한다.
		//doGet이나 doPost가 오버라이드로 정의되어있지 않으면 오류를 반환한다.
		
		response.sendRedirect("calculator.html");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet메소드 요청 접수");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost메소드 요청 접수");
	}
}








