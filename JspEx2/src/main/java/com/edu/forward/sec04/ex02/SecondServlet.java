package com.edu.forward.sec04.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//-----------------------------------------------------------------------------------------------------------
// public class SecondServlet
//-----------------------------------------------------------------------------------------------------------
@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//-----------------------------------------------------------------------------------------------------------
	// protected void doGet(HttpServletRequest request, HttpServletResponse response)
	//-----------------------------------------------------------------------------------------------------------
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String address = (String) request.getAttribute("address");
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>주소 : " + address + "</h1>");
		out.println("<h2>dispatch를 이용한 바인딩!</h2>");
		out.println("</body>");
		out.println("</html>");
	
	} // End - protected void doGet(HttpServletRequest request, HttpServletResponse response)

} // End - public class SecondServlet
