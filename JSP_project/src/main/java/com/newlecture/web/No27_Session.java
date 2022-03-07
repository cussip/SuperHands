package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/No27")
public class No27_Session extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String v_ = request.getParameter("v");
		String op = request.getParameter("operator");
			
//		ServletContext application = request.getServletContext();
		HttpSession session = request.getSession();
		
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
		
		/* No27_Session
		 * session은 현재 접속한 사용자를 의미한다는 점에서 application과 차이
		 * application은 사용자가 변경되어도 내용이 유지되지만
		 * session은 사용자가 바뀌면 저장된 내용을 사용할 수 없음
		 * 
		 * 동일한 웹브라우저일 경우 동일한 프로세스에서 스래드로 관리되기 때문에
		 * 동일한 사용자로 인식함
		 *  
		 * 사용방법 (application과 동일)
		 * HttpSession session = request.getSession();
		 * session.setAttribute("key", value);
		 * session.getAttribute("key");
		 * 
		 * NO28
		 * WAS는 내부에 application 공간과 session 공간을 가지고 있다.
		 * session은 SID(Session ID)를 가지고 있어야 접근이 가능하며 
		 * SID는 브라우저가 최초에 WAS에 접근하면 발급된다.
		 * 브라우저를 닫으면 SID는 사라진다.
		 * 동일한 SID로 접근하면 같은 사용자가 접근한 것으로 인식하기 때문에 보안상 관리가 필요
		 * Session에는 타임아웃을 설정하는 것이 가능하다(기본 30분)
		 */
		int v = 0;		
		if(!v_.equals("")) { v = Integer.parseInt(v_); }
		
		// 계산	
		if(op.equals("=")) {
			int result = 0;
//			int x = (Integer)application.getAttribute("value");
			int x = (Integer)session.getAttribute("value");
			int y = v;
//			String operator = (String)application.getAttribute("operator");
			String operator = (String)session.getAttribute("operator");
			
			if(operator.equals("+")) {
				result = x + y;
			} else if(operator.equals("-")) {
				result = x - y;
			}	
			
			out.println("<html>");
			out.println("<head>");
			out.println("<title>No27_session.java</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("</body>");	
			out.printf("<h1>결과: %d</h1>", result);
			out.println("</html>");				
		
		// 저장
		} else {
//			application.setAttribute("value", v);
//			application.setAttribute("operator", op);	
			session.setAttribute("value", v);
			session.setAttribute("operator", op);	
		}	
	}
}
		