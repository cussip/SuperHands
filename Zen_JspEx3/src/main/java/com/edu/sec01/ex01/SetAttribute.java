package com.edu.sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//-----------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------
@WebServlet("/set")
public class SetAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//-----------------------------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String	ctxMsg	= "context에 바인딩이 되었습니다.";
		String	sesMsg	= "session에 바인딩이 되었습니다.";
		String	reqMsg	= "request에 바인딩이 되었습니다.";
		
		// HttpServletContext 객체, HttpSession 객체, HttpServletRequest 객체를 구한 후 속성을 바인딩한다.
		ServletContext	ctx		= getServletContext();
		HttpSession		session	= request.getSession();
		
		ctx.setAttribute	("context", ctxMsg);
		session.setAttribute("session", sesMsg);
		request.setAttribute("request", reqMsg);
		
		out.print("바인딩을 실행합니다.");
		
//		response.sendRedirect("/get");
		// request로 값 넘어가지 않음
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("get");
		dispatcher.forward(request, response);
		// request로 값 넘어감
	}

}




