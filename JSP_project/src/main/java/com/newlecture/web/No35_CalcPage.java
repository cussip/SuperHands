package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/No35")
public class No35_CalcPage extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
		
		/* No36_계산기 서블릿 완성하기
		 * 동적인 페이지 구현
		 * No35_Calc3.java에서 구현된 데이터를 쿠키로 받아와서 페이지로 출력하는 역할
		 */
		Cookie[] cookies = request.getCookies(); 
		String exp = "0";
		if(cookies != null) {			
			for(Cookie c : cookies) {				
				if(c.getName().equals("exp")) {
					exp = c.getValue();
					break;
				}
			}
		}
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		 
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("	<meta charset=\"UTF-8\">");
		out.write("	<title>calc.html</title>");
		out.write("	<style>");
		out.write("		input {");
		out.write("			width: 50px;");
		out.write("			height: 50px;");
		out.write("		}");
		out.write("		.output {");
		out.write("			height: 50px;");
		out.write("			background: #e9e9e9;");
		out.write("			font-size: 24px;");
		out.write("			font-weight: bold;");
		out.write("			text-align: right;");
		out.write("			padding: 0px 5px;");	
		out.write("		}");
		out.write("	</style>");
		out.write("</head>");
		out.write("<body>");
		out.write("	<form action=\"No34\" method=\"post\">");
		out.write("	<table>");
		out.write("		<tr>");
		out.printf("		<td class=\"output\" colspan=\"4\">%s</td>", exp);
		// html에서는 "3+4"로 출력되는 것을 동적으로 계산하여 표현할 수 있음
		out.write("		</tr>");
		out.write("		<tr>");
		out.write("			<td><input type=\"submit\" name=\"operator\" value=\"CE\"></td>");
		out.write("			<td><input type=\"submit\" name=\"operator\" value=\"C\"></td>");
		out.write("			<td><input type=\"submit\" name=\"operator\" value=\"BS\"></td>");
		out.write("			<td><input type=\"submit\" name=\"operator\" value=\"/\"></td>");
		out.write("		</tr>");
		out.write("		<tr>");
		out.write("			<td><input type=\"submit\" name=\"value\" value=\"7\"></td>");
		out.write("			<td><input type=\"submit\" name=\"value\" value=\"8\"></td>");
		out.write("			<td><input type=\"submit\" name=\"value\" value=\"9\"></td>");
		out.write("			<td><input type=\"submit\" name=\"operator\" value=\"*\"></td>");
		out.write("		</tr>");
		out.write("		<tr>");
		out.write("			<td><input type=\"submit\" name=\"value\" value=\"4\"></td>");
		out.write("			<td><input type=\"submit\" name=\"value\" value=\"5\"></td>");
		out.write("			<td><input type=\"submit\" name=\"value\" value=\"6\"></td>");
		out.write("			<td><input type=\"submit\" name=\"operator\" value=\"-\"></td>");
		out.write("		</tr>");
		out.write("		<tr>");
		out.write("			<td><input type=\"submit\" name=\"value\" value=\"1\"></td>");
		out.write("			<td><input type=\"submit\" name=\"value\" value=\"2\"></td>");
		out.write("			<td><input type=\"submit\" name=\"value\" value=\"3\"></td>");
		out.write("			<td><input type=\"submit\" name=\"operator\" value=\"+\"></td>");
		out.write("		</tr>");
		out.write("		<tr>");
		out.write("			<td></td>");
		out.write("			<td><input type=\"submit\" name=\"value\" value=\"0\"></td>");
		out.write("			<td><input type=\"submit\" name=\"dot\" value=\".\"></td>");
		out.write("			<td><input type=\"submit\" name=\"operator\" value=\"=\"></td>");
		out.write("		</tr>");
		out.write("	</table>");
		out.write("	</form>");
		out.write("</body>");
		out.write("</html>");
	}
}
		