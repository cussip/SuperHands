package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/No26")
public class No26_Application extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String v_ = request.getParameter("v");
		String op = request.getParameter("operator");
			
		ServletContext application = request.getServletContext();
		
//		String numArr[] = request.getParameterValues("num");
		/* No24_add2
		 * 여러 개의 파라미터를 전달 받을 때, 동일한 하나의 name으로 전달받는다.
		 * 일반적으로 파라미터의 수가 많아질 경우 각기 다른 name을 부여하고,
		 * 각 각의 변수를 선언하여 파라미터를 입력 받는 과정이 매우 비효율적이기 때문.
		 * 
		 * 동일한 name으로 전달받은 parameter는 배열의 형태로 전달되며
		 * 이떄 'request.getParameterValues()'를 사용하여 전달 받는다.
		 */
		

		/* No26_Application
		 * 상태 유지를 필요로하는 경우의 구현하는 방법 3가지
		 * application, session, cookie
		 * 
		 * 예를 들어, 계산기를 구현하는 경우 하나의 공간에 
		 * "숫자입력 -> 연산자 선택 -> 숫자입력"과 같이
		 * 연속하여 입력하며, 따라서 첫 번째 입력한 숫자가 어딘가에서 저장되어야
		 * 두 번쨰 입력되는 숫자와 연산되는 것이 가능하다.
		 * 
		 * 서블릿 컨텍스트(Context)
		 * 작업 후 메모리에서 즉각 사라져 버리는 결과물을 저장 작업을 통하여 
		 * 데이터를 이어갈 수 있도록 할 수 있으며, 이때 사용하는 저장소가 서블릿 컨텍스트이다.
		 * A라는 서블릿이 작업한 결과물을 B라는 서블릿이 이어서 작업할 수 있도록하는
		 * 상태 저장 공간
		 * 
		 * 사용방법
		 * ServletContext application = request.getServletContext();
		 * application.setAttribute("key", value);
		 * application.getAttribute("key");
		 */
		int v = 0;		
		if(!v_.equals("")) { v = Integer.parseInt(v_); }
		
		// 계산	
		if(op.equals("=")) {
			int result = 0;
			int x = (Integer)application.getAttribute("value");
			int y = v;
			String operator = (String)application.getAttribute("operator");
			
			if(operator.equals("+")) {
				result = x + y;
			} else if(operator.equals("-")) {
				result = x - y;
			}	
			
			out.println("<html>");
			out.println("<head>");
			out.println("<title>계산기</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("</body>");	
			out.printf("<h1>결과: %d</h1>", result);
			out.println("</html>");				
		
		// 저장
		} else {
			application.setAttribute("value", v);
			application.setAttribute("operator", op);			
		}	
	}
}
		