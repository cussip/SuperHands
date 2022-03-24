package com.newlecture.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/No46")
public class No46_MVCmodel2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int num = 0;
		String numStr = request.getParameter("n");
		
		if(numStr != null && !numStr.equals("")) {
			num = Integer.parseInt(numStr);
		}
		
		String result = "";		// Model
		String[] names = { "newlec", "dragon" };
		Map<String, Object> notice = new HashMap<>();
		
		notice.put("id", 1);
		notice.put("title", "EL은 좋아요");
		
		if(num % 2 != 0) { result = "홀수"; } 
		else { result = "짝수"; }
		
		request.setAttribute("result", result);
		request.setAttribute("names", names);
		request.setAttribute("notice", notice);
		
		//redirect : 현재 작업 내용과 상관없이 페이지만 이동
		//forward : 현재 작업한 내용을 이어갈 수 있도록 공유
		RequestDispatcher dispathcher 
				= request.getRequestDispatcher("No49_ELoperator.jsp");
		dispathcher.forward(request, response);
	}
}
