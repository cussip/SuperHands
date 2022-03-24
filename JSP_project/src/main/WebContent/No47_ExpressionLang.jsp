<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- No46_MVCmodel2
		별도의 클래스로 해당 controller 내용을 옮겨서 관리한다.
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
--%>
							<%--VIEW --%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>SpaghettiCode</title> 
</head>
<body>
	<%=request.getAttribute("result")%>&nbsp;입니다.
	<%-- No47_ExpressionLang 
		위의 코드와 같이 MVC model2 방식을 사용해도 자바 코드를 아예 사용하지 않는 것은 아니다.
		때문에 자바코드의 최소화를 위하여 Expression Language가 도입되었고,
		이를 이용하여 아래와 같은 코드로 수정할 수 있다.
	--%>
	${result} 
	<br>
	${names[0]}
	<br>
	${notice.title}
	
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
 <%-- No46_MVCmodel2
 	model1과의 차이:
 		Controller에서 작성한 코드를 물리적으로 분리해놓는 방식으로 코드를 작성
 		
 	model2 방식의 장점: 
	 	1. 자바코드가 분리되어 있기 때문에 사전에 컴파일 가능하다(실행 개선)
	 	2. 사용자의 요청이 있을때 뷰만 서블릿으로 생성되기 때문에 분량이 줄어든다.(메모리 개선)
		 	* 서블릿이 수행할 기능을 별도로 작성해서 관리하며, 필요시에 해당 기능만 호출한다
		 	* view 부분을 Dispather Servlet라고 한다
		 	* controller는 일반 클래스로 생성하여 관리한다. 이를 POJO 클래스라고 한다.
	 	3. 각 부분을 별도로 관리하기 때문에 유지관리에 이점이 있다.
--%>










