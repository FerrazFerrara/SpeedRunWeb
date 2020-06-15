<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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