package SelfTest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calccookie")
public class CalcCookie extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String num = request.getParameter("num");
		String oper = request.getParameter("oper");		
		String result = "";
		
		Cookie cookies[] = request.getCookies();
		
		if(cookies != null && oper.equals("=")) {	
			int numG = Integer.parseInt(num);
			int numC = 0;
			String operC = "";
			for(Cookie c : cookies) {
				if(c.getName().equals("num")) {
					numC = Integer.parseInt(c.getValue());
					break;
				}
			}
			for(Cookie c : cookies) {
				if(c.getName().equals("oper")) {
					operC = c.getValue();
					break;
				}
			}
			if(operC.equals("+")) {
				result = String.valueOf(numC + numG);	
			} else if(operC.equals("-")) {
				result = String.valueOf(numC - numG);			
			} else if(operC.equals("*")) {
				result = String.valueOf(numC * numG);			
			} else if(operC.equals("/")) {
				result = String.valueOf(numC / numG);			
			} else if(operC.equals("c")) {
				numC = 0;
				operC = "";
				result = "0";
			}			
			Cookie resultCookie = new Cookie("result", result);
			response.addCookie(resultCookie);		
		} else {
			Cookie operCookie = new Cookie("oper", oper);
			Cookie numCookie = new Cookie("num", num);	
			response.addCookie(operCookie);
			response.addCookie(numCookie);				
		}
		response.sendRedirect("/calculator");
	}
}




