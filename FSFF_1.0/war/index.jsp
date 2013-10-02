<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="FSFF | Short description about company">
<meta name="author" content="Your name">
<title>FOUR SCREEN FILM FESTIVAL</title>
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


					<!-- Start: Primary navigation -->
					<div class="nav-collapse collapse">
						<ul class="nav pull-right">
							<li class="active"><a href="#">Home</a></li>
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
									UserSession sessionObject =(UserSession) request.getSession().getAttribute(
											"JSESSION");
									String login = sessionObject.getFirstName();
							%>
							<li><a href="uploadfilm.jsp">UploadFilm</a></li>
							<ul class="nav pull-right">
								<li>Welcome <%=login%>
								</li>
								<li><a class="active" href="LogOut" name="logout">Logout </a></li>
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
	<div class="content">
		<h1 align="center">FOUR SCREENS FILM FESTIVAL</h1>
		<br> <br>
		<!-- Start: slider -->
		<div class="slider">
			<div class="container-fluid">
				<div id="heroSlider" class="carousel slide">
					<div class="carousel-inner">
						<div class="active item">
							<div class="hero-unit">
								<div class="row-fluid">
									<div class="span7 marketting-info">
										<h2>EDITOR'S PICK</h2>
										<p>Film name and description</p>
										<h3>
											<a href="product.html" class="btn btn-primary">view now</a>
										</h3>
									</div>
									<div class="span5">
										<img src="img/placeholder.jpg" class="thumbnail">
									</div>
								</div>
							</div>
						</div>
						<div class="item">
							<div class="hero-unit">
								<div class="row-fluid">
									<div class="span7 marketting-info">
										<h2>EDITOR'S PICK</h2>
										<p>Film name and description</p>
										<h3>
											<a href="service.html" class="btn btn-primary">view now</a>
										</h3>
									</div>
									<div class="span5">
										<img src="img/placeholder.jpg" class="thumbnail">
									</div>
								</div>
							</div>
						</div>
						<div class="item">
							<div class="hero-unit">
								<div class="row-fluid">
									<div class="span7 marketting-info">
										<h2>EDITOR'S PICK</h2>
										<p>Film name and description</p>
										<h3>
											<a href="#" class="btn btn-primary ">View now</a>
										</h3>
									</div>
									<div class="span5">
										<img src="img/placeholder.jpg" class="thumbnail">
									</div>
								</div>
							</div>
						</div>
						<div class="item">
							<div class="hero-unit">
								<div class="row-fluid">
									<div class="span7 marketting-info">
										<h2>EDITOR'S PICK</h2>
										<p>Film name and descritpion</p>
										<h3>
											<a href="#" class="btn btn-primary">View now</a>

										</h3>
									</div>
									<div class="span5">
										<img src="img/placeholder.jpg" class="thumbnail">
									</div>
								</div>
							</div>
						</div>
					</div>
					<a class="left carousel-control" href="#heroSlider"
						data-slide="prev">‹</a> <a class="right carousel-control"
						href="#heroSlider" data-slide="next">›</a>
				</div>
			</div>
		</div>
		<!-- End: slider -->
		<!-- Start: PRODUCT LIST -->
		<div class="container">
			<div class="page-header">
				<h2>About us</h2>
			</div>
			<div class="row-fluid">
				<ul class="thumbnails">
					<li class="span4">
						<div class="thumbnail">
							<img src="img/placeholder-360x200.jpg" alt="product name">
							<div class="caption">
								<h3>Who are we?</h3>
								<p>who are we?</p>
							</div>
							<div class="widget-footer">
								<p>
									<a href="product.html" class="btn btn-primary">Read more</a>
								</p>
							</div>
						</div>
					</li>
					<li class="span4">
						<div class="thumbnail">
							<img src="img/placeholder-360x200.jpg" alt="product name">
							<div class="caption">
								<h3>What do we do?</h3>
								<p>What do we do?</p>
							</div>
							<div class="widget-footer">
								<p>
									<a href="product.html" class="btn btn-primary">Read more</a>
								</p>
							</div>
						</div>
					</li>
					<li class="span4">
						<div class="thumbnail">
							<img src="img/placeholder-360x200.jpg" alt="product name">
							<div class="caption">
								<h3>Contact US</h3>
								<p>Contact US</p>
							</div>
							<div class="widget-footer">
								<p>
									<a href="product.html" class="btn btn-primary">Read more</a>
								</p>
							</div>
						</div>
					</li>
				</ul>
			</div>

		</div>
		<!-- End: PRODUCT LIST -->
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
