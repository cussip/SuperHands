<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<meta charset="UTF-8">
	<title>Gemo</title>
</head>
<body>
	<header class="py-3 mb-3 border-bottom">
		<div class="container-fluid d-grid gap-3 align-item-center" style="gird-template-columns: 1fr 2fr;">
			<div class="dropdown">
				<a href="#" class="d-flex align-items-center col-lg-4 mb-2 mb-lg-0 link-dark text-decoration-none dropdown-toggle" id="dropdownNavLink" data-bs-toggle="dropdown" aria-expanded="false">
          			<svg class="bi me-2" width="40" height="32">
          				<use xlink:href="#bootstrap"></use>
          			</svg>
        		</a>
        		<ul class="dropdown-menu text-small shadow" aria-labelledby="dropdownNavLink" style="">
					<li><a class="dropdown-item active" href="#" aria-current="page">Overview</a></li>
					<li><a class="dropdown-item" href="#">Inventory</a></li>
					<li><a class="dropdown-item" href="#">Customers</a></li>
					<li><a class="dropdown-item" href="#">Products</a></li>
					<li><hr class="dropdown-divider"></li>
					<li><a class="dropdown-item" href="#">Reports</a></li>
					<li><a class="dropdown-item" href="#">Analytics</a></li>
		        </ul>
		    </div>
			<div class="d-flex align-items-center">
		        <form class="w-100 me-3">
		        	<input type="search" class="form-control" placeholder="Search..." aria-label="Search" control-id="ControlID-3">
		        </form>
		        <div class="flex-shrink-0 dropdown">
		          	<a href="#" class="d-block link-dark text-decoration-none dropdown-toggle" id="dropdownUser2" data-bs-toggle="dropdown" aria-expanded="false">
		            	<img src="https://github.com/mdo.png" alt="mdo" width="32" height="32" class="rounded-circle">
		          	</a>
		          	<ul class="dropdown-menu text-small shadow" aria-labelledby="dropdownUser2">
			            <li><a class="dropdown-item" href="#">New project...</a></li>
			            <li><a class="dropdown-item" href="#">Settings</a></li>
			            <li><a class="dropdown-item" href="#">Profile</a></li>
			            <li><hr class="dropdown-divider"></li>
			            <li><a class="dropdown-item" href="#">Sign out</a></li>
		          	</ul>
        		</div>
      		</div>
		</div>
	</header>
	<div class="container-fluid pb-3">
		<div class="d-grid gap-3" style="grid-template-columns: 1fr 2fr;">
		    <div class="bg-light border rounded-3">
		    <br><br><br><br><br><br><br><br><br><br>
		    </div>
	    	<div class="bg-light border rounded-3">
	     	<br><br><br><br><br><br><br><br><br><br>
			</div>
	  	</div>
  	</div>
</body>
</html>