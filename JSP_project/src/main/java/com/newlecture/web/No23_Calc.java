package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/No23")
public class No23_Calc extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String num1_ = request.getParameter("num1");
		String num2_ = request.getParameter("num2");
		String op = request.getParameter("operator");
		/* No23_Calc
		 * 두 버튼의 작동시 서로 다른 값을 반환하기 위해서 버튼을 구분하기 위한
		 * name을 추가
		 * calc.html의 input에 name="operator"를 추가한 후
		 * value값인 Plus와 Minus를 사용하여 값을 구분하여 전달 받는다.
		 */
		
		int num1 = 0;
		int num2 = 0;
		int result = 0;
		
		if(!num1_.equals("")) { num1 = Integer.parseInt(num1_); }
		if(!num2_.equals("")) { num2 = Integer.parseInt(num2_); }
			
		out.println("<html>");
		out.println("<head>");
		out.println("<title>계산기</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("</body>");
		
		if(op.equals("Plus")) {
			result = num1 + num2;
			out.printf("<h1>'Plus'의 결과: %d</h1>", result);
		} else if(op.equals("Minus")) {
			if(num1 >= num2) { result = num1 - num2; } 
			else if(num1 < num2) { result = num2 - num1; }
			out.printf("<h1>'Minus의 결과: %d</h1>", result);
		}
		out.println("</html>");	
	}
}
