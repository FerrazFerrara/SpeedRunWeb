package br.com.speedrun.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.speedrun.beans.SpeedRunBean;
import br.com.speedrun.bo.SpeedRunBO;

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
			resp.sendRedirect("UserProfileView.jsp");
		} else {
			System.out.println("Não conseguiu acessar esse perfil");
		}
	}
}
