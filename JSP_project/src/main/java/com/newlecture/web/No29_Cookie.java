package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/No29")
public class No29_Cookie extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String v_ = request.getParameter("v");
		String op = request.getParameter("operator");
			
//		ServletContext application = request.getServletContext();
//		HttpSession session = request.getSession();
		Cookie[] cookies = request.getCookies();
	
//		String numArr[] = request.getParameterValues("num");
				
		/* No29_Cookie
		 * session이나 application과 다르게 사용자(클라이언트)가 가지고 다니는 값
		 * 서버 쪽 공간: application: 공용 공간, session: 개인 공간, 
		 * 클라이언트 쪽 공간: cookie: 가지고 다니는 공간
		 * 
		 * 쿠키 저장하기
		 * Cookie cookie = new Cookie("c", String.valueOf(result);
		 * response.addCookie(cookie);
		 * 
		 * 쿠키 읽기, 쿠키는 배열로 전달 받는다.
		 * Cookie[] cookies = request.getCookies(); 
		 *  
		 */
		
		int v = 0;		
		if(!v_.equals("")) { v = Integer.parseInt(v_); }
		
		// 계산	
		if(op.equals("=")) {
			int result = 0;
//			int x = (Integer)application.getAttribute("value");
//			int x = (Integer)session.getAttribute("value");
			
//			String operator = (String)application.getAttribute("operator");
//			String operator = (String)session.getAttribute("operator");

			int x = 0;
			int y = v;
			String operator = "";
			for(Cookie c : cookies) {				
				if(c.getName().equals("value")) {
					x = Integer.parseInt(c.getValue());
					break;
				}
			}
			for(Cookie c : cookies) {				
				if(c.getName().equals("operator")) {
					operator = c.getValue();
					break;
				}
			}
				
			if(operator.equals("+")) {
				result = x + y;
			} else if(operator.equals("-")) {
				result = x - y;
			}	
			
			out.println("<html>");
			out.println("<head>");
			out.println("<title>No27_session.java</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("</body>");	
			out.printf("<h1>결과: %d</h1>", result);
			out.println("</html>");				
		
		// 저장
		} else {
//			application.setAttribute("value", v);
//			application.setAttribute("operator", op);	
//			session.setAttribute("value", v);
//			session.setAttribute("operator", op);	
			Cookie valueCookie = new Cookie("value", String.valueOf(v));
			Cookie operatorCookie = new Cookie("operator", op);
			response.addCookie(valueCookie);
			response.addCookie(operatorCookie);
		
		}	
	}
}
		




