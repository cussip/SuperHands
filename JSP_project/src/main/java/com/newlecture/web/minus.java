package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/minus")
public class minus extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8"); 
		response.setContentType("text/html; Charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String sn1 = request.getParameter("n1");
		String sn2 = request.getParameter("n2");
		
		int n1 = 0;
		int n2 = 0;
		
		if(!sn1.equals("")) { n1 = Integer.parseInt(sn1); }
		if(!sn2.equals("")) { n2 = Integer.parseInt(sn2); }
		
		if(n1 >= n2) { out.printf("두 수의 차: %s", n1 - n2); }
		else if(n1 < n2) { out.printf("두 수의 차: %s", n2 - n1); }
	}

}
