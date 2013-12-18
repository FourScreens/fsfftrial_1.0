<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="Bootbusiness | Short description about company">
<meta name="author" content="Your name">
<title>Four screens film festival</title>
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap responsive -->
<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
<!-- Font awesome - iconic font with IE7 support -->
<link href="css/font-awesome.css" rel="stylesheet">
<link href="css/font-awesome-ie7.css" rel="stylesheet">
<!-- Bootbusiness theme -->
<link href="css/boot-business.css" rel="stylesheet">
</head>
<body>
	<%@ page import="com.fsff.ui.entity.UserSession"%>
	<!-- Start: HEADER -->
	<header>
		<!-- Start: Navigation wrapper -->
		<div class="navbar navbar-fixed-top">
			<div class="navbar-inner">
				<div class="container">
					<a href="#" class="brand brand-bootbus">Four Screens Film
						Festival</a>

					<!-- Start: Primary navigation -->
					<div class="nav-collapse collapse">
						<ul class="nav pull-right">
							<li class="active"><a href="index.jsp">Home</a></li>
							<li><a href="#about">About</a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">View and Vote<b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a href="Comedy.jsp">Comedy</a></li>
									<li><a href="Action.jsp">Action</a></li>
									<li><a href="Drama.jsp">Drama</a></li>
									<li><a href="Romance.jsp">Romance</a></li>
									<li><a href="Thriller.jsp">Thriller</a></li>
									<li><a href="Animation.jsp">Animation</a></li>
									<li><a href="Horror.jsp">Horror</a></li>
								</ul></li>
							<li><a href="uploadfilm.jsp">Enter the Film</a></li>
							<li><a href="Help.jsp">Help</a></li>
							<%
								if (request.getSession().getAttribute("JSESSIONID") == null) {
							%>
							<li><a href="signin.jsp">Sign in</a></li>
						</ul>
						<%
							} else if (request.getSession().getAttribute("JSESSIONID") != null) {
								UserSession sessionObject = (UserSession) request.getSession()
										.getAttribute("JSESSIONID");
								String login = sessionObject.getFirstName();
						%>

						<ul class="nav pull-right">
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">Welcome <%=login%> <b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a class="active" href="LogOut" name="logout">Logout
									</a></li>
								</ul></li>
						</ul>

						<%
							}
						%>

					</div>
				</div>
			</div>
		</div>
		<!-- End: Navigation wrapper -->
	</header>
	<!-- End: HEADER -->
	<!-- Start: MAIN CONTENT -->


	<div class="hero-unit">

		<%
			if (request.getSession().getAttribute("UFILMID") == null) {
				response.sendRedirect("/uploadfilm.jsp");
			} else {
				String filmID = (String) request.getSession().getAttribute(
						"UFILMID");
				String filmName = (String) request.getSession().getAttribute(
						"FILMNAME");
				String item_name = filmName + "-" + filmID;
		%>
		<br> <br> <br>

		<p>Please proceed to pay with your Paypal account. Your film will
			be considered only on successful payment.</p>

		<p>
		<h4>Film Name</h4>
		:
		<code><%=filmName%></code>
		</p>


		<p>
		<h4>Submission ID</h4>
		:
		<code><%=filmID%></code>
		(Use this ID when you send your full length movie.)
		</p>
		<br> <br>
		<form action="https://www.sandbox.paypal.com/cgi-bin/webscr"
			method="post" target="_top">
			<input type="hidden" name="cmd" value="_s-xclick"> <input
				type="hidden" name="hosted_button_id" value="Z3YJAM3BHGQHL">
			<input type="hidden" name="item_name" value="<%=item_name%>">
			<input type="image"
				src="https://www.sandbox.paypal.com/en_US/i/btn/btn_paynow_LG.gif"
				border="0" name="submit"
				alt="PayPal - The safer, easier way to pay online!"> <img
				alt="" border="0"
				src="https://www.sandbox.paypal.com/en_US/i/scr/pixel.gif" width="1"
				height="1">
		</form>

		<%
			}
		%>

	</div>


	<!-- /container -->
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

							<ul>
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
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/boot-business.js"></script>
</body>
</html>
