package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/No34")
public class No34_Calc3 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
		/* No36_계산기 서블릿 완성하기
		 * 입력받은 데이터를 가공하여 쿠키에 저장하고
		 * No35_CalcPage.java로 redirect하여 화면에 출력한다 
		 */
		Cookie[] cookies = request.getCookies();
		
		String value = request.getParameter("value");
		String operator = request.getParameter("operator");
		String dot = request.getParameter("dot");	
	
		String exp = "";
		if(cookies != null) {			
			for(Cookie c : cookies) {				
				if(c.getName().equals("exp")) {
					exp = c.getValue();
					break;
				}
			}
		}
		if(operator != null && operator.equals("=")) {
			ScriptEngine engine = new ScriptEngineManager().getEngineByName("graal.js");
			try { 
				exp = String.valueOf(engine.eval(exp));
			} catch (ScriptException e) {
				e.printStackTrace();
			}		
		} else if(operator != null && operator.equals("C")) {
			exp = "";
			//쿠키가 비위진게 아닌 빈 문자열로 대체된 상태
			/* No37_쿠키 삭제
			 * 현재 표현된 값을 삭제하고 쿠키의 유효기간을 종료해주어야 한다.
			 * 내용만 삭제하면 쿠키가 빈 문자열로 남아있는 상태가 됨에 유의해야 하낟.
			 */
		} else {			
			exp += (value == null) ? "" : value;
			exp += (operator == null) ? "" : operator;
			exp += (dot == null) ? "" : dot;
		}
		
		Cookie expCookie = new Cookie("exp", exp);
		if(operator != null && operator.equals("C")) {
			expCookie.setMaxAge(0);
			//쿠키의 유효기간을 0으로 처리하여 쿠키 자체를 소멸시킨다.
		}
		response.addCookie(expCookie);
		response.sendRedirect("No35");
	}
}
		