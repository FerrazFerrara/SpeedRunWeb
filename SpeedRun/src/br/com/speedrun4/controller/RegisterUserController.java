package br.com.speedrun4.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.speedrun2.beans.UsuarioBean;
import br.com.speedrun3.bo.UsuarioBO;

/**
 * Servlet implementation class RegisterUserController
 */
@WebServlet("/RegisterUserController")
public class RegisterUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsuarioBO usuarioBO = new UsuarioBO();
    /**
     * Default constructor. 
     */
    public RegisterUserController() {
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
		String username = request.getParameter("username");
		String password = request.getParameter("Password");
		String confirmedPassword = request.getParameter("confirmedPassword");
		
		if (confirmedPassword.equals(password)) {
			System.out.println("Error here");
			usuarioBO.addUsuario(new UsuarioBean(username, password));
			request.getRequestDispatcher("").forward(request, response);
		} else {
			request.getRequestDispatcher("").forward(request, response);
		}
	}

}
