<%-- No40_JSPSelfCalc
	코드를 입력하는 경우에는 아래와 같이 코드 블럭을 표기해야 한다. 
-->

<%-- No41_CodeBlock
	방법1: y의 값은: <% out.print(y) %>
		=> out.write("y의 값은: ");
		=> out.print(y);
	방법2: y의 값은: <%= y %> 
		=> out.write("y의 값은: ");
		=> out.print(y);
	선언부:
		코드블럭으로 작성할 경우 무조건 service 함수에 들어간다
		메소드 안에서 메소드를 작성하는 것과 같이 오류가 발생한다.
		멤버 메소드를 작성하기 위해서는  !를 포함한 코드블럭을 사용해야 한다.
		<%!
			pubilc int sum(int a, int b) {
				return a + b;
			}
		%>
	Page지시자:
		인코딩 방법, 컨텐츠 타입 등을 지시하는 지시블럭. 코드블럭이라고 칭하지 않는다.
		서블릿에서 사용하던 구문을 그대로 코드블럭으로 사용할 경우 
		서비스의 함수로 들어가기 때문에 정상적으로 작동하지 않는다.
		따라서 Page지시자를 사용하여 다시 작성해주서야 한다.
		<%@ page language="java" contentType="text/html; charset=UTF-8"
			pageEncoding="UTF-8"
		%>
--%>
<%
	int x = 3;
	int y = 4;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SelfCalculator</title>
	<style>	
		.main {
			height: 30pt;
			width: 200pt;
			font-size: 20px;
			text-align: left;
		}
		.main input {
			height: 20pt;
		}
		.btn input {
			font-size: 20px;
			font-weight: bold;
			height: 30pt;
			width: 50pt;
		}
	</style>
</head>
<body>
	<form action="calccookie" method="post">
		<div class="main">
			<label>input: </label>
			<input type="text" name="num" placeholder="type">	
		</div>
		<table class="btn">
			<tr>
				<td><input type="submit" name="oper" value="+"></td>
				<td><input type="submit" name="oper" value="-"></td>
				<td><input type="submit" name="oper" value="*"></td>
				<td><input type="submit" name="oper" value="/"></td>
			</tr>
			<tr>
				<td><input type="submit" name="oper" value="="></td>
				<td><input type="submit" name="oper" value="C"></td>
			</tr>
		</table>
		<br><hr><br>
		<div>
			
			<h1>result: ${1+1}</h1>
		</div>	
	</form>
</body>
</html>