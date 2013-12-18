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
					<label for="Description">Description:&nbsp; <input
						style="display: inline;" type="text" id="Description"
						name="Description" placeholder="Description">
					</label>
				</div>
				<div>
					<label for="Cast">Cast:&nbsp; <input
						style="display: inline;" type="text" id="cast" name="cast"
						placeholder="Cast">
					</label>
				</div>
				<div>
					<label for="Director">Director:&nbsp; <input
						style="display: inline;" type="text" id="director" name="director"
						placeholder="Director">
					</label>
				</div>
				<div>
					<label for="Producer">Producer:&nbsp; <input
						style="display: inline;" type="text" id="producer" name="producer"
						placeholder="Producer">
					</label>
				</div>
				<div>
					<label for="Writer">Writer:&nbsp; <input
						style="display: inline;" type="text" id="writer" name="writer"
						placeholder="Writer">
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
					Terms and Condition<br> <br>
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
