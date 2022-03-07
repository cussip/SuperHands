package com.edu.forward.sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//-----------------------------------------------------------------------------------------------------------
// ServletContext 바인딩 기능
//-----------------------------------------------------------------------------------------------------------
@WebServlet("/cset")
public class SetServletContext extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//-----------------------------------------------------------------------------------------------------------
	// protected void doGet(HttpServletRequest request, HttpServletResponse response)
	//-----------------------------------------------------------------------------------------------------------
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// ServletContext 객체를 가져온다.
		ServletContext context = getServletContext();
		
		List member = new ArrayList();
		member.add("홍길동");
		member.add(30);
		
		// ServletContext 객체에 데이터를 바인딩한다.
		context.setAttribute("member", member);
		
		out.print("<html>");
		out.print("<body>");
		out.print("<h1>홍길동과 30을 설정합니다.</h1>");
		out.print("</body>");
		out.print("</html>");
	} // End - protected void doGet(HttpServletRequest request, HttpServletResponse response)

} // End - public class SetServletContext





