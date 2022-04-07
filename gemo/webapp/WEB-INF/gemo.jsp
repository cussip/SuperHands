<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<!DOCTYPE html>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<meta charset="UTF-8">
	<title>Gemo</title>
	<style>
		.sectionspace {
			background-color: purple;
			display: flex;
			padding: 2px;
		}
		a {
			text-decoration: none;
			text-align: center;
		}
		textarea {
			text-align: left;
		}
	</style>
</head>
<body>
	<header class="py-3 mb-3 border-bottom">
		<div class="container-fluid d-grid gap-3 align-item-center" style="gird-template-columns: 1fr 2fr;">
			<div class="d-flex align-items-center">
		        <form class="w-50 me-3">
		        	<input type="search" class="form-control" placeholder="Search..." aria-label="Search" control-id="ControlID-3">
		        </form>
      		</div>
		</div>
	</header>
	s
	<!-- 섹션 분류 공간 -->
	<form action="/main/gemo" method="get">
		<div class="sectionspace">
			<c:forEach var="s" items="${sectionlist}">
				<a class="form-control" type="button" href="?sect=${s.id}">${s.title}</a>
			</c:forEach>
		</div>
	</form>
	
	<!-- 메모 분류 공간 -->
	<div class="memospace">
		<div class="d-grid gap-3" style="grid-template-columns: 1fr 2fr; height: 500px">
		    <table class="form-control">
		    	<c:forEach var="m" items="${memolist}">
			    	<tr>
			    		<td>
			    			<a class="form-control" type="button" href="?sect=${m.sectionId}&mem=${m.id}">${m.title}</a>
			    		</td>
					</tr> 			 
  			    </c:forEach>  			      			      			      			    
		    </table>
		    
		    <!-- 메모 내용 입력 공간 -->   
	    	<textarea class="form-control bg-light border rounded-3">${content}</textarea>
	  	</div>
  	</div>
</body>
</html>