package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class add extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String num1_ = request.getParameter("num1");
		String num2_ = request.getParameter("num2");
		
		int num1 = 0;
		int num2 = 0;
		
		if(!num1_.equals("")) { num1 = Integer.parseInt(num1_); }
		if(!num2_.equals("")) { num2 = Integer.parseInt(num2_); }
		
		int sum = num1 + num2;
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>덧셈 계산기</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("</body>");
		out.printf("<h1>%d + %d = %d</h1>", num1, num1, sum);
		out.println("</html>");	
	}
}
