<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>EL operator</title> 
</head>

<body>
	${param.n > 3} <br>
	${param.n ge 3} <br>
	<%--
		html은 '<', '>'와 같은 기호가 많이 사용되기 때문에
		엄밀한 코드를 위해서 lt, gt, le, ge와 같은 문자기반 연산자를 제공한다
	 --%>
	${empty param.n} <br>
	<%-- param == null || param == '' --%>

	${empty param.n ? 'empty' : param.n} <br>
	<%-- 삼항연산자 사용. 값이 있을 땐 값을, 비었을 때는 empty --%>
	
	${param.n / 2} <br>
	<%-- 정수가 아닌 소수점까지 계산되어서 출력된다. --%>
</body>
</html>

<%-- EL 연산자의 종류
	[] .
	()
	not ! 
	empty
	+
	-
	*
	/ div
	% mod
	< lt
	> gt
	<= le
	>= ge
	== eq
	!= ne
	&& and
	|| or
	? :
--%>










