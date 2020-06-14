<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="addSpeedRun" method="post">
			Modo de jogo<br>
			<input type="radio" id="cheats" name="modoJogo" value="cheats" required="required">
			<label for="cheats">Cheats</label><br>
			<input type="radio" id="noCheats" name="modoJogo" value="noCheats">
			<label for="noCheats">No Cheats</label><br><br>
			
			Plataforma<br>
			<input type="radio" id="PC" name="plataforma" value="PC" required="required">
			<label for="PC">PC</label><br>
			<input type="radio" id="Playstation" name="plataforma" value="Playstation">
			<label for="Playstation">Playstation</label><br>
			<input type="radio" id="Switch" name="plataforma" value="Switch">
			<label for="Switch">Switch</label><br>
			<input type="radio" id="Xbox" name="plataforma" value="Xbox">
			<label for="Xbox">Xbox</label><br><br>
			
			Dia realizado<br>
			<input type="date" name="dia" required="required"><br><br>
			
			Tempo realizado<br>
			<input type="datetime" name="tempo" required="required"><br><br>
			
			<input type="submit" name="enviar" value="Enviar" id="btnEnviar">
		</form>
	</div>
</body>
</html>