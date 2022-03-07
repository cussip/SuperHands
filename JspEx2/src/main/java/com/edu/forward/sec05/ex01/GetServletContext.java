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
// ServletContext에 바인딩된 데이터는 모든 서블릿(사용자)이 접근할 수 있다.
// 웹 애플리케이션에서 모든 사용자가 공통으로 사용하는 데이터는 
//    ServletContext에 바인딩해 놓고 사용하면 편리하다.
//-----------------------------------------------------------------------------------------------------------
@WebServlet("/cget")
public class GetServletContext extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//-----------------------------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// ServletContext 객체를 가져온다.
		ServletContext context = getServletContext();
		
		List member = (ArrayList) context.getAttribute("member");
		String	name	= (String)  member.get(0);
		int		age		= (Integer) member.get(1);
	
		out.print("<html>");
		out.print("<body>");
		out.print("<h1>ServletContext에서 바인딩된 데이터 가져오기.</h1>");
		out.print("<h2>이름 : " + name + "</h2>");
		out.print("<h2>나이 : " + age  + "</h2>");
		out.print("</body>");
		out.print("</html>");
	}

}
