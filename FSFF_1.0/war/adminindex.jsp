<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Four Screens Film Festival</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Le styles -->
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/bootstrap-responsive.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/admin.css">

</head>

<body>
	<%@ page import="com.fsff.ui.entity.AdminSession"%>
	<%
		if (request.getSession().getAttribute("ADMINJSESSIONID") == null) {
			response.sendRedirect("/adminlogin.jsp");
		}
	%>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<button type="button" class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="brand" href="adminindex.jsp">FSFF Admin</a>
				<div class="nav-collapse collapse">
					<ul class="nav">
						<li class="active"><a href="adminindex.jsp">Home</a></li>
						<li><a href="createfestival.jsp">Festival</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">Film <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="filmapproval.jsp">Submitted Films</a></li>
								<li class="divider"></li>
								<li><a href="filmapprovalround1.jsp">Round 1</a></li>
								<li><a href="filmapprovalround2.jsp">Round 2</a></li>
								<li><a href="filmapprovalround3.jsp">Round 3</a></li>
							</ul></li>
						<li><a href="editorpicks.jsp">Editor's Picks</a></li>
					</ul>
					<%
						if (request.getSession().getAttribute("ADMINJSESSIONID") != null) {
							AdminSession sessionObject = (AdminSession) request
									.getSession().getAttribute("ADMINJSESSIONID");
							String login = sessionObject.getFirstName();
					%>

					<ul class="nav pull-right">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">Welcome <%=login%> <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a class="active" href="AdminLogOut" name="logout">Logout
								</a></li>
							</ul></li>
					</ul>
					<%
						}
					%>

				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>

	<div class="container">

		<!-- Main hero unit for a primary marketing message or call to action -->
		<div class="hero-unit">
			<p>Place holder for enhancement projects to display stats</p>

		</div>

		<!-- Example row of columns -->

		<div class="stats">
			<script id="indexData" type="text/x-handlebars-template">
		<div class="row">
			<div class="span4">
				<h2>Festival</h2>
				<p>Festival in progress		: {{festivalName}}</p>
				<p>Current round			: {{festivalRound}}</p>
				<p>Submission Start Date	: {{festivalStartDate}}</p>
				<p>Round One Start Date		: {{roundOneStartDate}}</p>
				<p>Round Two Start Date		: {{roundTwoStartDate}}</p>
				<p>Round Three Start Date	: {{roundThreeStartDate}}</p>
				<p>Festival End Date		: {{festivalEndDate}}</p>
			</div>
			<div class="span4">
				<h2>Films</h2>
				<p>Number of films pending approval	:  {{noOfFilmsPendingApproval}}</p>
				<p>Number of films approved			:  {{noOfFilmsApproved}}</p>
				<p>Number of films rejected			:  {{noOfFilmsRejected}}</p>
				<p>
					<a class="btn" href="{{approveURL}}">View details &raquo;</a>
				</p>
			</div>
			<div class="span4">
				<h2>Users</h2>
				<p>Number of registered users	:  {{noOfUsers}}</p>
			</div>
		</div>
			</script>
		</div>
		<hr>

		<footer>
			<p>&copy; Company 2013</p>
		</footer>

	</div>

	<!-- /container -->

	<!-- Le javascript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->

	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script src="http://code.jquery.com/jquery-2.0.3.min.js"></script>
	<script src="lib/jquery.raty.min.js"></script>

	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/boot-business.js"></script>
	<script type="text/javascript" src="js/handlebars.js"></script>
	<script src="js/Adminindex.js"></script>
</body>
</html>
