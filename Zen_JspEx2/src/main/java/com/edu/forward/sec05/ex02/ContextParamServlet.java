package com.edu.forward.sec05.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//-----------------------------------------------------------------------------------------------------------
// 웹 애플리케이션에서 메뉴는 공통으로 사용하는 기능이다.
// web.xml에 설정해 놓고 프로그램 시작 시 초기화할 때 가져와서 사용하면 편리한다.
// 새로운 메뉴 항목이 생성되거나 기존 메뉴 항목을 추가, 삭제할 때도 쉽게 수정할 수가 있다.
//-----------------------------------------------------------------------------------------------------------
@WebServlet("/initMenu")
public class ContextParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//-----------------------------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// ServletContext 객체를 가져온다.
		// 메뉴는 ServletContext 객체를 통해 접근하므로, 모든 웹 브라우저에서 공유하면서 접근할 수 있다.
		ServletContext context = getServletContext();
		String	menu_member	= context.getInitParameter("menu_member");
		String	menu_order	= context.getInitParameter("menu_order");
		String	menu_goods	= context.getInitParameter("menu_goods");
		
		out.print("<html>");
		out.print("<body>");
		out.print("<h1>web.xml에서 메뉴 불러오기</h1>");
		out.print("<table border=1 cellspacing=0>");
		out.print("<tr>메뉴 목록</tr>");
		out.print("<tr><td><h3>" + menu_member	+ "</h3></td></tr>");
		out.print("<tr><td><h3>" + menu_order	+ "</h3></td></tr>");
		out.print("<tr><td><h3>" + menu_goods	+ "</h3></td></tr>");
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
		
	}

}




