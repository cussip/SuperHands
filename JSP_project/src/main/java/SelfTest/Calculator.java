package SelfTest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculator")
public class Calculator extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
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
				+ "	<form action=\"calccookie\" method=\"post\">\r\n"
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
}






