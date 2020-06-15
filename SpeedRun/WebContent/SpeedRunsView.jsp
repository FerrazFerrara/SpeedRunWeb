<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="https://fonts.googleapis.com/css?family=Poppins:400,500,600,700" rel="stylesheet">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DarkSouls Speedrun</title>


</head>
<body>

<div class="menu"> <span></span> </div>
<nav id="nav">
		<ul class="main">
		<li><a target="_self" href="">Home</a></li>
		<li><a target="_self" href="RankingView.jsp">Ranking</a></li>
		<li><a target="_blank" href="SupportView.jsp">Support</a></li>
		<li><a target="_self" href="RegisterView.jsp">Register</a></li>
		<li><a target="_self" href="LoginView.jsp">Login</a></li>
		</ul>
</nav>
<div class="overlay"></div>

<script>
$('.menu, .overlay').click(function () {
	$('.menu').toggleClass('clicked');
	
	$('#nav').toggleClass('show');
	
});
</script>
	<div>
		<form action="speedRunsController" method="get">
			<br><input type="submit" value="Buscar SpeedRuns"><br><br><br>
		</form>
	</div>
	
	<div>
		<form action="speedRunsController" method="post">
			<c:forEach items = "${speedRuns}" var="speedrun">
				<div>
					<p>Tempo: ${speedrun.tempo}</p>
					<p>Data: ${speedrun.dia}</p>
					<p>Modo de Jogo: ${speedrun.modoJogo}</p>
					<p>Plataforma: ${speedrun.plataforma}</p>
					<input type="submit" value="Ver Perfil :${speedrun.idUser}" name="btnVerPerfil"><br><br>
				</div><br><br>
			</c:forEach>
		</form>
	</div>
</body>
</html>