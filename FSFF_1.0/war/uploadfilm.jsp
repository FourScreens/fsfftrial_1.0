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
					<!-- Below button used for responsive navigation -->
					<button type="button" class="btn btn-navbar" data-toggle="collapse"
						data-target=".nav-collapse">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<!-- Start: Primary navigation -->
					<div class="nav-collapse collapse">
						<ul class="nav pull-right">
							<li><a href="index.jsp">Home</a></li>
							<li><a href="#about">About</a></li>
							<li><a href="contact_us.html">Contact us</a></li>
							<li><a href="#comedy">Comedy</a></li>
							<li><a href="#action">Action</a></li>
							<li><a href="#drama">Drama</a></li>
							<li><a href="#Romance">Romance</a></li>
							<li><a href="#thriller">Thriller</a></li>
							<li><a href="#Animation">Animation</a></li>
							<li><a href="#Horror">Horror</a></li>
							<%
								if (request.getSession().getAttribute("JSESSION") != null) {
									UserSession sessionObject = (UserSession) request.getSession()
											.getAttribute("JSESSION");
									String login = sessionObject.getFirstName();
							%>
							<li><a href="uploadfilm.jsp">UploadFilm</a></li>
							<ul class="nav pull-right">
								<li>Welcome <%=login%>
								</li>
								<li><a class="active" href="LogOut">Logout </a></li>
							</ul>
							<%
								} else {
							%>
							<li><a href="signin.jsp">Sign in</a></li>
							<%
								}
							%>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<!-- End: Navigation wrapper -->
	</header>
	<!-- End: HEADER -->
	<!-- Start: MAIN CONTENT -->
	<div class="container">

		<form name="userInfoForm" action="SubmitFilmServlet" method="post">
			<fieldset>
				<legend> Film Information </legend>
				<div>

					<label>Film Name*:&nbsp; <input type="text"
						id="inputFilmName" name="filmName" required="required"
						autofocus="autofocus">
					</label>
				</div>
				<div>
					<label name="Category">Category*:&nbsp; <select
						name="genre">
							<option value="Comedy">Comedy</option>
							<option value="Romance">Romance</option>
							<option value="Horror">Horror</option>
							<option value="Thriller">Thriller</option>
							<option value="Adventure">Adventure</option>
							<option value="Sci-fi">Sci-fi</option>
							<option value="Documentary">Documentary</option>
							<option value="Animation">Animation</option>
							<option value="Sports">Sports</option>
					</select>
					</label>
				</div>
				<div>
					<label for="Cast">Cast:&nbsp; <input
						style="display: inline;" type="text" id="Cast" name="Cast"
						placeholder="Director, Actors">
					</label>
				</div>
				<div>
					<label for="2 minute clip">2 minute clip*:&nbsp; <input
						style="display: inline;" type="text" id="2 minute clip"
						name="roundOneClip">
					</label>
				</div>
				<div>
					<label for="5 minute clip">5 minute clip*:&nbsp; <input
						style="display: inline;" type="text" id="5 minute clip"
						name="roundTwoClip">
					</label>
				</div>
				<div>
					<label for="10 minute clip">10 minute clip*:&nbsp; <input
						style="display: inline;" type="text" id="10 minute clip"
						name="roundThreeClip">
					</label>
				</div>
				<div>
					<label for="term">Terms and Condition</label>
					<textarea col="60" rows="10" name="Terms">
        fill in!!
      </textarea>
					<br> <input type="radio" name="Agree"> I Agree to the
					Terms and Condition<br>
					<br>
				</div>

				<button class="btn btn-large btn-primary" type="submit">Upload</button>
			</fieldset>

		</form>
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
