<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
	int x = 3;
	int y = 4;
	int pagenew = 3;	//page는 이미 jsp에서 생성되어 사용되는 볏이다.
%>
<%-- No42_InnerObject.jsp
	JSP 내장 객체애 대해서 숙지해야 한다
		종류
			request, response (입출력 도구)
			pageContext(내부용), session, application (어플릿케이션, 세션)
			config, out, page (어플릿케이션, 세션 개체)
			
			각 객체의 메소드들을 인지하고 나중에 찾아서 사용할 수 있으면 된다.
 --%>
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