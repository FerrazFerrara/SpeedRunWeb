package br.com.speedrun4.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.speedrun2.beans.UsuarioBean;
import br.com.speedrun3.bo.SpeedRunBO;
import br.com.speedrun3.bo.UsuarioBO;

@WebServlet("/ProfileController")
public class ProfileController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UsuarioBO usuarioBO = new UsuarioBO();
		ArrayList<UsuarioBean> usuarios = usuarioBO.getUsuarioDAO();
		UsuarioBean usuario = new UsuarioBean();
		
		for (UsuarioBean user : usuarios) {
			if(user.getIdUser() == SpeedRunBO.idSpeedRunOwner) {
				usuario = user;
			}
		}
		
		if (usuario.getIdUser() == 0) {
			return;
		}
		
		req.setAttribute("username", usuario.getLogin());
		req.setAttribute("pais", usuario.getPais());
		req.setAttribute("twitter", usuario.getTwitter());
		req.setAttribute("facebook", usuario.getYoutube());
		req.setAttribute("instagram", usuario.getInstagram());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
