<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link
	href="https://fonts.googleapis.com/css2?family=EB+Garamond:ital,wght@1,400;1,500;1,600;1,700;1,800&display=swap"
	rel="stylesheet">
<link href="css/main.css" rel="stylesheet" media="all">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dark Souls Speedrun</title>


</head>
<body>

	<div class="menu">
		<span></span>
	</div>
	<nav id="nav">
	<ul class="main">
		<li><a target="_self" href="">Home</a></li>
		<li><a target="_blank" href="SupportView.jsp">Support</a></li>
		<li><a target="_self" href="RegisterView.jsp">Register</a></li>
		<li><a target="_self" href="LoginView.jsp">Login</a></li>
	</ul>
	</nav>
	<div class="overlay"></div>
	
	<script>
		$('.menu, .overlay').click(function() {
			$('.menu').toggleClass('clicked');

			$('#nav').toggleClass('show');

		});
	</script>

	<div class="wrapper wrapper--w780">
		<div class="card card-3">
			<div class="card-heading"></div>
			<div class="card-body">
				<h2 class="title">Registration Info</h2>
				<form method="POST" action="RegisterUserController">
					<div class="input-group">
						<input class="input--style-3" type="text" required="required" placeholder="Username" pattern=".*\S+.*" title="This field is required"
							name="name">
					</div>

					<div class="input-group">
						<input class="input--style-3" type="password" required="required" placeholder="Password" pattern=".*\S+.*" title="This field is required"
							name="email">
					</div>
					<div class="input-group">
						<input class="input--style-3" type="password"
							required="required" pattern=".*\S+.*" title="This field is required" placeholder="Confirm Password">
					</div>
					<div class="p-t-10">
						<button class="btn btn--pill btn--green" type="submit">Register</button>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>