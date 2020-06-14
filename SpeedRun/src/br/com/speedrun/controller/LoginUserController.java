package br.com.speedrun.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import br.com.speedrun.apiservices.ServerCommunication;
import br.com.speedrun.beans.UsuarioBean;
import br.com.speedrun.bo.ActualUserBO;
import br.com.speedrun.bo.UsuarioBO;

/**
 * Servlet implementation class LoginUserController
 */
@WebServlet("/LoginUserController")
public class LoginUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	ServerCommunication contactSV = new ServerCommunication();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String username = request.getParameter("name");
//		String password = request.getParameter("password");
//		
//		System.out.println(username);
//		System.out.println(password);
//			contactSV.sendGET();
		
//		for(UsuarioBean usuario: usuarioBO.getUsuarioDAO()) {
//			if ((usuario.getLogin().equals(username)) && (usuario.getSenha().equals(password))) {
//				ActualUserBO.realizarLogin(usuario);
//				request.setAttribute("warning", "Logged with success");
//				request.getRequestDispatcher("RankingView.jsp").forward(request, response);
//			} 		
//		}
		
//		request.getRequestDispatcher("LoginUserController").forward(request, response);
	}

}
