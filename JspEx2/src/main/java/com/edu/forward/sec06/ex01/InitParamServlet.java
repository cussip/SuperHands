package com.edu.forward.sec06.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//-----------------------------------------------------------------------------------------------------------
// urlPatterns를 이요하여 매핑 이름을 여러개 설정할 수 있다.
// @WebInitParam을 이용하여 여러 개의 매개 변수를 설정할 수 있다.
//-----------------------------------------------------------------------------------------------------------
@WebServlet(
		urlPatterns = {	"/sInit", "/sInit2"
		}, 
		initParams = { 
				@WebInitParam(name = "email", value = "gildong@gmail.com"), 
				@WebInitParam(name = "tel", value = "010-1234-5678")
		})
public class InitParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//-----------------------------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 설정한 매개변수의 name으로 값을 가져온다.
		String	email	= getInitParameter("email");
		String	tel		= getInitParameter("tel");
		
		out.print("<html>");
		out.print("<body>");
		out.print("<h1>WebServlet 애너테이션을 이용한 서블릿 설정</h1>");
		out.print("<table border=1 cellspacing=0>");
		out.print("<tr>메뉴 목록</tr>");
		out.print("<tr><td><h3>이 메 일 : " + email	+ "</h3></td></tr>");
		out.print("<tr><td><h3>전호번호 : " + tel	+ "</h3></td></tr>");
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");

	}

}








