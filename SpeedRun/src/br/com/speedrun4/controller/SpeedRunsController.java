package br.com.speedrun4.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.speedrun2.beans.SpeedRunBean;
import br.com.speedrun2.beans.UsuarioBean;
import br.com.speedrun3.bo.SpeedRunBO;
import br.com.speedrun3.bo.UsuarioBO;

@WebServlet("/speedRunsController")
public class SpeedRunsController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<SpeedRunBean> speedruns = new SpeedRunBO().getSpeedRunDAO();
		
		req.setAttribute("speedRuns", speedruns);
		req.getRequestDispatcher("SpeedRunsView.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("botaoAlugar");
		
		if(new SpeedRunBO().viewSpeedRunOwner(action)) {
			ArrayList<UsuarioBean> users = new UsuarioBO().getUsuarioDAO();
			UsuarioBean user = users.get(SpeedRunBO.idSpeedRunOwner - 1);
			ArrayList<SpeedRunBean> speedruns = new SpeedRunBO().getSpeedRunDAO();
			
			req.setAttribute("instagram", user.getInstagram());
			req.setAttribute("twitter", user.getTwitter());
			req.setAttribute("facebook", user.getYoutube());
			req.setAttribute("username", user.getLogin());
			req.setAttribute("nacionality", user.getPais());
			req.setAttribute("speedRuns", speedruns);
			req.getRequestDispatcher("UserProfileView.jsp").forward(req, resp);
			resp.sendRedirect("UserProfileView.jsp");
		} else {
			System.out.println("Não conseguiu acessar esse perfil");
		}
	}
}
