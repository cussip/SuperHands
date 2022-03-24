<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%							//Controller
	int num = 0;
	String numStr = request.getParameter("n");
	
	if(numStr != null && !numStr.equals("")) {
		num = Integer.parseInt(numStr);
	}
	
	String result = "";		// Model
	
	if(num % 2 != 0) { result = "홀수"; } 
	else { result = "짝수"; }
%>
							<%--VIEW --%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>SpaghettiCode</title> 
</head>
<body>
	<%=result%>&nbsp;입니다.
</body>
</html>

<%-- No44_SpaghettiCode
	코드가 여러 곳에 분산되어 있더라도 작동에는 문제가 없다
	그러나 단순한 코드조차 위처럼 나누어 배치해두면 추후 유지보수나 개선 등의 작업이 필요한 상황에
	가독성이 낮아 코드를 파악하기 매우 어렵다.
	
	이를 개선하기 위해 코드를 한곳에 모아두는 방식의 작업이 필요하다.
--%>
<%-- No45_MVCmodel1
	코드블럭을 최소화한다.(추가적인 변수가 필요할 수 있다. = model)
	최대한 많은 코드를 상단에 배치한 후 따로 생성한 변수를 통하여 필요한 값만
	적절한 위치에 값만 배치한다
	
	MVC 모델1
		Model
			출력할 데이터(VIEW에 사용하기 위해 특수하게 생성한 변수)		
		View
			출력을 담당할 코드를 모아서 배치한 부분(HTML)
		Controller
			입력과 제어를 담당할 코드를 모아서 배치한 부분(JAVA)	
 --%>










