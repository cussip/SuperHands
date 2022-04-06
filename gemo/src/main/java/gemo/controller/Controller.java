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

@WebServlet("/main")
public class Controller extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String section_ = request.getParameter("sect");
		String memo_ = request.getParameter("mem");
		
		String section = "1";
		if(section_ != null && !section_.equals("")) {
			section = section_;
		}
		
		String memo = "1";
		if(memo_ != null && !memo_.equals("")) {
			memo = memo_;
		}
		
		GemoService service = new GemoService();		
		List<GemoMemo> memoList = service.getMemoList(Integer.parseInt(section));
		List<GemoSection> sectionList = service.getSectionList();
		String content = service.getMemoContent(Integer.parseInt(memo));
		
		request.setAttribute("memolist", memoList);
		request.setAttribute("sectionlist", sectionList);
		request.setAttribute("content", content);
		
		request
		.getRequestDispatcher("/WEB-INF/gemo.jsp")
		.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

	}
}
