package com.newlecture.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
/* No20_Filter
 * 서블릿 필터
 * WAS와 Servlet의 통신 사이(request, response)에 개입하여 내용을 변경하거나
 * 실행 여부를 결정하거나 권한을 제어하는 등의 작업을 담당
 * request와 response 양방향에 모두 개입 가능
 * 어노테이션으로 구현 @WebFilter("url")
 */
public class No20_Filter implements Filter {

	@Override
	public void doFilter(ServletRequest request
			, ServletResponse response
			, FilterChain chain) throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8");
		// 서블릿에 전달하기 전에 인코딩을 적용한다.
		
		chain.doFilter(request, response); 
		/* chain.doFilter(request, response)
		 * 요청과 서블릿 사이의 흐름을 연결해주는 구문
		 * chain의 위치 전후로 서블릿 실행 전에 적용 해야하는 부분과
		 * 서블릿이나 필터가 실행된 후에 작업 해야하는 부분을 구분할 수 있따.
		 */
	}

}
