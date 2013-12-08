<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="Bootbusiness | Short description about company">
<meta name="author" content="Your name">
<title>Four Screens Film Festival</title>
<!-- Bootstrap -->

<!-- Le styles -->
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/bootstrap-responsive.css" rel="stylesheet">
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<link rel="stylesheet" type="text/css" href="css/admin.css">

</head>
<body>
	<%@ page import="com.fsff.ui.entity.AdminSession"%>
	<%
		if (request.getSession().getAttribute("ADMINJSESSIONID") == null) {
			response.sendRedirect("/adminlogin.jsp");
		}
	%>
	<!-- Start: HEADER -->

	<header>
		<!-- Start: Navigation wrapper -->
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
		<!-- End: Navigation wrapper -->
	</header>
	<!-- End: HEADER -->
	<!-- Start: MAIN CONTENT -->
	<%
		if (request.getAttribute("message") != null) {
			String msg = (String) request.getAttribute("message");
	%>
	<div class="alert fade in" id="display-error" style="display: block;">
		<button type="button" class="close">x</button>
		<div class="container" id="display-message"><%=msg%></div>
	</div>
	<%
		}
	%>
	<div class="content">
		<div class="container">
			<form name="input" id="createfestivalform" class="FilmList"
				action="../createfestival" method="post">
				<fieldset>
					<legend>Create Film Festival</legend>

					<p>
						<span class="label label-default">Year</span> <select
							class="form-control" name="year">
							<option>2013</option>
							<option>2014</option>
							<option>2015</option>
							<option>2016</option>
						</select>
					</p>
					<p>
						<span class="label label-default">Quarter</span> <select
							class="form-control" name="quarter">
							<option>Winter</option>
							<option>Spring</option>
							<option>Summer</option>
							<option>Fall</option>

						</select>
					</p>
					Festival name: <input type="text" name="festivalname"><br>
					<h4>Film Submission:</h4>
					<label for="from" style="display: inline">From &nbsp</label> <input
						type="text" id="from" name="from" style="display: inline" /> <label
						for="to" style="display: inline">&nbsp to &nbsp </label><input
						style="display: inline" type="text" id="to" name="to" />
					<h4>Round1:</h4>
					<label for="from1" style="display: inline">From &nbsp</label><input
						type="text" id="from1" name="from1" style="display: inline" /><label
						for="to1" style="display: inline">&nbsp to &nbsp </label><input
						style="display: inline" type="text" id="to1" name="to1" />
					<h4>Round2:</h4>
					<label for="from2" style="display: inline">From &nbsp</label><input
						type="text" id="from2" name="from2" style="display: inline" /><label
						for="to2" style="display: inline">&nbsp to &nbsp </label><input
						style="display: inline" type="text" id="to2" name="to2" />
					<h4>Round3:</h4>
					<label for="from3" style="display: inline">From &nbsp</label><input
						type="text" id="from3" name="from3" style="display: inline" /><label
						for="to3" style="display: inline">&nbsp to &nbsp </label><input
						style="display: inline" type="text" id="to3" name="to3" /> <br>
					<br>
					<button type="submit" class="btn btn-success" name="Submit"
						value="Submit">Create</button>
				</fieldset>
			</form>
		</div>


	</div>
	<!-- End: MAIN CONTENT -->
	<!-- Start: FOOTER -->
	<footer>
		<div class="container">
			<div class="row">

				<div class="span2">
					<h4>
						<i class="icon-beaker icon-white"></i> About
					</h4>
					<nav>
						<ul class="quick-links">

							<li><a href="news.html">News</a></li>
							<li><a href="events.html">Events</a></li>

						</ul>
					</nav>
				</div>
				<div class="span2">
					<h4>
						<i class="icon-thumbs-up icon-white"></i> Support
					</h4>
					<nav>
						<ul class="quick-links">
							<li><a href="contact_us.html">Contact us</a></li>
							<li><a href="#">Privacy Policy</a></li>
						</ul>
					</nav>

				</div>
				<div class="span3">
					<h4>Get in touch</h4>
					<div class="social-icons-row">
						<a href="#"><i class="icon-twitter"></i></a> <a href="#"><i
							class="icon-facebook"></i></a> <a href="#"><i
							class="icon-google-plus"></i></a>
					</div>
				</div>
			</div>
		</div>
		<hr class="footer-divider">
		<div class="container">
			<p>&copy; 2013-2014- Four Screen Film Festival, Inc. All Rights
				Reserved.</p>
		</div>
	</footer>
	<!-- End: FOOTER -->

	<!--  <script type="text/javascript" src="../js/viewfilm.js"></script>-->
	<script src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/boot-business.js"></script>
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
	<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
	<script>
		$(function() {
			$("#from").datepicker({
				defaultDate : "+1w",
				changeMonth : true,
				numberOfMonths : 3,
				onClose : function(selectedDate) {
					$("#to").datepicker("option", "minDate", selectedDate);
				}
			});
			$("#to").datepicker({
				defaultDate : "+1w",
				changeMonth : true,
				numberOfMonths : 3,
				onClose : function(selectedDate) {
					$("#from").datepicker("option", "maxDate", selectedDate);
				}
			});
		});
		$(function() {
			$("#from1").datepicker({
				defaultDate : "+1w",
				changeMonth : true,
				numberOfMonths : 3,
				onClose : function(selectedDate) {
					$("#to1").datepicker("option", "minDate", selectedDate);
				}
			});
			$("#to1").datepicker({
				defaultDate : "+1w",
				changeMonth : true,
				numberOfMonths : 3,
				onClose : function(selectedDate) {
					$("#from1").datepicker("option", "maxDate", selectedDate);
				}
			});
		});
		$(function() {
			$("#from2").datepicker({
				defaultDate : "+1w",
				changeMonth : true,
				numberOfMonths : 3,
				onClose : function(selectedDate) {
					$("#to2").datepicker("option", "minDate", selectedDate);
				}
			});
			$("#to2").datepicker({
				defaultDate : "+1w",
				changeMonth : true,
				numberOfMonths : 3,
				onClose : function(selectedDate) {
					$("#from2").datepicker("option", "maxDate", selectedDate);
				}
			});
		});
		$(function() {
			$("#from3").datepicker({
				defaultDate : "+1w",
				changeMonth : true,
				numberOfMonths : 3,
				onClose : function(selectedDate) {
					$("#to3").datepicker("option", "minDate", selectedDate);
				}
			});
			$("#to3").datepicker({
				defaultDate : "+1w",
				changeMonth : true,
				numberOfMonths : 3,
				onClose : function(selectedDate) {
					$("#from3").datepicker("option", "maxDate", selectedDate);
				}
			});
		});
	</script>
</body>
</html>
