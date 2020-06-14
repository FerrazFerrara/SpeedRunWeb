package br.com.speedrun.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.speedrun.beans.UsuarioBean;
import br.com.speedrun.bo.ActualUserBO;
import br.com.speedrun.bo.UsuarioBO;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UsuarioBO usuarioBO = new UsuarioBO();
		String username = req.getParameter("name");
		String password = req.getParameter("password");
		
		for(UsuarioBean usuario: usuarioBO.getUsuarioDAO()) {
			if ((usuario.getLogin().equals(username)) && (usuario.getSenha().equals(password))) {
				ActualUserBO.realizarLogin(usuario);
				req.setAttribute("warning", "Logged with success");
				req.getRequestDispatcher("RankingView.jsp").forward(req, resp);
			} 		
		}
		
		req.getRequestDispatcher("LoginUserController").forward(req, resp);
	}
}
