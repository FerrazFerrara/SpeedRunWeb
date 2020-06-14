package br.com.speedrun4.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.speedrun3.bo.UsuarioBO;

@WebServlet("/editProfileController")
public class EditProfileController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String about = req.getParameter("about");
		String username = req.getParameter("username");
		String twitter = req.getParameter("twitter");
		String facebook = req.getParameter("facebook");
		String instagram = req.getParameter("instagram");
		
		new UsuarioBO().attProfile(about, username, twitter, facebook, instagram);
	}
}
