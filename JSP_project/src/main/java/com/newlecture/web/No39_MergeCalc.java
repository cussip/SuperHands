package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/No39")
public class No39_MergeCalc extends HttpServlet {

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
	/* No39_MergeCalc
	 * 기존에 작성한 Calculator.java와 CalcCookie.java를 하나의 문서로 통합한다.
	 * 각각 POST와 GET만을 사용하여 전달하기 때문에 구문하여 통합이 가능하다.
	 * 지금과 같이 따로 분리하여 사용하는 경우 쿠키의 경로를 설정하는 것이 불편하다.
	 */

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// GET은 반드시 대문자로 구분해주어야 한다.
//		if(request.getMethod().equals("GET")) {
//			System.out.println("GET요청 접수");
//		} else if(request.getMethod().equals("POST")) {
//			System.out.println("POST요청 접수");
//		}
		super.service(request, response);
		//요청에 따른 두 함수를 호출하는 역할을 한다.
		//doGet이나 doPost가 오버라이드로 정의되어있지 않으면 오류를 반환한다.
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
	
		PrintWriter out = response.getWriter(); 
		
		Cookie cookies[] = request.getCookies();
		
		String result = "0";
		if(cookies != null) {			
			for(Cookie c : cookies) {
				if(c.getName().equals("result")) {
					result = c.getValue();
				}
			}
		} 
		
		out.printf("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"UTF-8\">\r\n"
				+ "<title>SelfCalculator</title>\r\n"
				+ "	<style>	\r\n"
				+ "		.main {\r\n"
				+ "			height: 30pt;\r\n"
				+ "			width: 200pt;\r\n"
				+ "			font-size: 20px;\r\n"
				+ "			text-align: left;\r\n"
				+ "		}\r\n"
				+ "		.main input {\r\n"
				+ "			height: 20pt;\r\n"
				+ "		}\r\n"
				+ "		.btn input {\r\n"
				+ "			font-size: 20px;\r\n"
				+ "			font-weight: bold;\r\n"
				+ "			height: 30pt;\r\n"
				+ "			width: 50pt;\r\n"
				+ "		}\r\n"
				+ "	</style>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "	<form method=\"post\">\r\n"
				+ "		<div class=\"main\">\r\n"
				+ "			<label>입력: </label>\r\n"
				+ "			<input type=\"text\" name=\"num\" placeholder=\"type\">	\r\n"
				+ "		</div>\r\n"
				+ "		<table class=\"btn\">\r\n"
				+ "			<tr>\r\n"
				+ "				<td><input type=\"submit\" name=\"oper\" value=\"+\"></td>\r\n"
				+ "				<td><input type=\"submit\" name=\"oper\" value=\"-\"></td>\r\n"
				+ "				<td><input type=\"submit\" name=\"oper\" value=\"*\"></td>\r\n"
				+ "				<td><input type=\"submit\" name=\"oper\" value=\"/\"></td>\r\n"
				+ "			</tr>\r\n"
				+ "			<tr>\r\n"
				+ "				<td><input type=\"submit\" name=\"oper\" value=\"=\"></td>\r\n"
				+ "				<td><input type=\"submit\" name=\"oper\" value=\"c\"></td>\r\n"
				+ "			</tr>\r\n"
				+ "		</table>\r\n"
				+ "		<br><hr><br>\r\n"
				+ "		<div>\r\n"
				+ "			<h1>정답: %s</h1>\r\n"
				+ "		</div>	\r\n"
				+ "	</form>\r\n"
				+ "</body>\r\n"
				+ "</html>", result);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String num = request.getParameter("num");
		String oper = request.getParameter("oper");		
		String result = "";
		
		Cookie cookies[] = request.getCookies();
		
		if(cookies != null && oper.equals("=")) {	
			int numG = Integer.parseInt(num);
			int numC = 0;
			String operC = "";
			for(Cookie c : cookies) {
				if(c.getName().equals("num")) {
					numC = Integer.parseInt(c.getValue());
					break;
				}
			}
			for(Cookie c : cookies) {
				if(c.getName().equals("oper")) {
					operC = c.getValue();
					break;
				}
			}
			if(operC.equals("+")) {
				result = String.valueOf(numC + numG);	
			} else if(operC.equals("-")) {
				result = String.valueOf(numC - numG);			
			} else if(operC.equals("*")) {
				result = String.valueOf(numC * numG);			
			} else if(operC.equals("/")) {
				result = String.valueOf(numC / numG);			
			} else if(operC.equals("c")) {
				numC = 0;
				operC = "";
				result = "0";
			}			
			Cookie resultCookie = new Cookie("result", result);
			response.addCookie(resultCookie);		
			resultCookie.setPath("/No39");
			/* No39
			 * 한 경로 안에서 쿠키를 사용하기 때문에 쿠키의 경로를 제한할 수 있다
			 */
		} else {
			Cookie operCookie = new Cookie("oper", oper);
			Cookie numCookie = new Cookie("num", num);	
			operCookie.setPath("/No39");
			numCookie.setPath("/No39");
			response.addCookie(operCookie);
			response.addCookie(numCookie);				
		}
		response.sendRedirect("No39");
	}
}








