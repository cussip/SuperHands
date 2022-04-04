package gemo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gemo.GemoService;
import gemo.entity.GemoMemo;
import gemo.entity.GemoSection;

@WebServlet("/gemo/main")
public class Controller extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String section_ = request.getParameter("sect");
		
		GemoService service = new GemoService();		
		List<GemoMemo> memoList = service.getMemoList();
		List<GemoSection> sectionList = service.getSectionList();
		
		request.setAttribute("memolist", memoList);
		request.setAttribute("sectionlist", sectionList);
		
		request
		.getRequestDispatcher("/WEB-INF/gemo.jsp")
		.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

	}
}
