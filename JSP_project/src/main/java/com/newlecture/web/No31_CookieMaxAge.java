package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/No31")
public class No31_CookieMaxAge extends HttpServlet {

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
			
			valueCookie.setPath("/");
			operatorCookie.setPath("/");
			/* No30_CookiePath
			 * 특정 경로로 접근할 때만 쿠키를 전달할 수 있도록 제한할 수 있다.
			 * 효과적으로 쿠키를 사용할 수 있도록 하기 위하여 사용
			 */
			
			valueCookie.setMaxAge(60 * 60 * 24);
			operatorCookie.setMaxAge(60 * 60 * 24);
			/* No31_CookieMaxAge
			 * 쿠키의 기본적인 생존 주기는 브라우저의 생존주기와 같다.
			 * 기간을 설정하여 브라우저가 닫혀도 쿠키가 일정기간 생존하도록 설정 할 수 있다.
			 * 임시 공간에 쿠키의 내용을 저장하는 구조로 되어있다.
			 * 초 단위로 설정하며, 직관 적으로  알 수 있도록 곱 연산으로 입력하는 것이 일반적이다.
			 * ex) 60 * 60 * 24 = 1일
			 */			
			response.addCookie(valueCookie);
			response.addCookie(operatorCookie);
			
			/* application, session, cookie 정리
			 * application
			 * 		사용범위: 전역 범위에서 사용하는 저장공간
			 * 		생명주기: WAS가 시작해서 종료할 떄 까지
			 * 		저장위치: WAS서버의 메모리
			 * session
			 * 		사용범위: 세션 범위에서 사용하는 저장공간
			 * 		생명주기: 세션이 시작해서 종료할 떄 까지
			 * 		저장위치: WAS서버의 메모리
			 * cookie
			 *		사용범위: 웹 브라우저 별 별조 지정 path 범주 공간
			 * 		생명주기: 브라우저에 전달한 시간부터 만료시간까지
			 * 		저장위치: 웹 브라우저의 메모리 또는 파일
			 * 
			 * 장기간의 저장을 목적으로 한다면 쿠키를 사용
			 * 특정 서블릿(특정 범위, 특정 URL)에서만 사용되는 데이터는 쿠키를 사용
			 */
		
		}	
	}
}
		