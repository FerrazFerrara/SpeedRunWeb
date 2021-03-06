package br.com.speedrun4.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.speedrun2.beans.SpeedRunBean;
import br.com.speedrun2.beans.UsuarioBean;
import br.com.speedrun3.bo.ActualUserBO;
import br.com.speedrun3.bo.SpeedRunBO;

@WebServlet("/addSpeedRun")
public class AddSpeedRunController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String modoJogo = req.getParameter("modoJogo");
		String plataforma = req.getParameter("plataforma");
		String dia = req.getParameter("dia");
		String tempo = req.getParameter("tempo");
		
		UsuarioBean usuarioAtual = ActualUserBO.getActualUser();
		if(usuarioAtual != null) {
			SpeedRunBean speedrun = new SpeedRunBean(usuarioAtual.getIdUser(), tempo, modoJogo, plataforma, dia);
			if(new SpeedRunBO().addSpeedRun(speedrun)) {
				resp.sendRedirect("");
			} else {
				resp.sendError(0, "Erro ao Adicionar SpeedRun :c, Tente novamente");
			}
		} else {
			resp.sendRedirect("LoginView.jsp");
		}
		
	}
}
