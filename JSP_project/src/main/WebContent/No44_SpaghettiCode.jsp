<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	int num = 0;
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>SpaghettiCode</title>
</head>
<%
	String numStr = request.getParameter("n");
	if(numStr != null && !numStr.equals("")) {
		num = Integer.parseInt(numStr);
	}
%>
<body>
	<% if(num % 2 != 0) { %> 
	홀수입니다.
	<% } else { %>
	짝수입니다.
	<% } %>
</body>
</html>

<%-- 
	코드가 여러 곳에 분산되어 있더라도 작동에는 문제가 없다
	그러나 단순한 코드조차 위처럼 나누어 배치해두면 추후 유지보수나 개선 등의 작업이 필요한 상황에
	가독성이 낮아 코드를 파악하기 매우 어렵다.
	
	이를 개선하기 위해 코드를 한곳에 모아두는 방식의 작업이 필요하다.
--%>









