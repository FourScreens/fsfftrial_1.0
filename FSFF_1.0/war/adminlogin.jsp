<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Login page - Four Screens Film Festival</title>
<!-- Le styles -->
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/bootstrap-responsive.min.css" rel="stylesheet">

<link rel="stylesheet" href="../css/adminlogin.css">
<link rel="shortcut icon" href="favicon.ico">

</head>

<body>
	<%@ page import="com.fsff.ui.entity.UserSession"%>
	<%
		if (request.getSession().getAttribute("ADMINJSESSIONID") != null) {
			response.sendRedirect("/adminindex.jsp");
		}
	%>
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand" href="index.jsp"><img src="logo.png"
					alt="Four Screens Film Festival"></a>
			</div>
		</div>
	</div>

	<div class="container">
		<div id="login-wraper">
			<form class="form login-form" action="AdminLoginServlet"
				method="post">
				<legend>
					<span class="blue">FSFF Admin Login</span>
				</legend>
				<div class="body">
					<label>Username</label> <input type="text" name="username"
						placeholder="Username" required="required"> <label>Password</label>
					<input type="password" name="password" placeholder="Password"
						required="required">

				</div>
				<div class="footer">
					<label class="checkbox inline"> <input type="checkbox"
						id="inlineCheckbox1" value="option1"> Remember me
					</label>

					<button type="submit" class="btn btn-success">Login</button>
				</div>
			</form>
			<%
				if (request.getAttribute("errorMessage") != null) {
					String errorMessage = (String) request
							.getAttribute("errorMessage");
			%>
			<div class="alert alert-danger fade in">
				<button type="button" class="close" data-dismiss="alert"
					aria-hidden="true">&times;</button>
				<h4><%=errorMessage%></h4>
				<p>Check your login credentials</p>
			</div>
			<%
				}
			%>
		</div>

	</div>


</body>
<!-- Le javascript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="../js/jquery.js"></script>
<script src="../js/bootstrap.js"></script>
</html>
