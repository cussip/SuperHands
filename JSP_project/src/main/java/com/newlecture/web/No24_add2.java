package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/No24")
public class No24_add2 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String numArr[] = request.getParameterValues("num");
		/* No24_add2
		 * 여러 개의 파라미터를 전달 받을 때, 동일한 하나의 name으로 전달받는다.
		 * 일반적으로 파라미터의 수가 많아질 경우 각기 다른 name을 부여하고,
		 * 각 각의 변수를 선언하여 파라미터를 입력 받는 과정이 매우 비효율적이기 때문.
		 * 
		 * 동일한 name으로 전달받은 parameter는 배열의 형태로 전달되며
		 * 이떄 'request.getParameterValues()'를 사용하여 전달 받는다.
		 */

		int result = 0;
		
		for(int i = 0; i < numArr.length; i++) {
			int num = Integer.parseInt(numArr[i]);
			result += num;
		}
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>덧셈 계산기</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("</body>");
		out.printf("총합: %d", result);
		out.println("</html>");	
	}
}
