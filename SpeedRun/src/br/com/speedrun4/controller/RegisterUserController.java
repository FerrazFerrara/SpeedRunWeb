package br.com.speedrun4.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.speedrun1.apiservices.ServerCommunication;
import br.com.speedrun2.beans.UsuarioBean;
import br.com.speedrun3.bo.UsuarioBO;

/**
 * Servlet implementation class RegisterUserController
 */
@WebServlet("/RegisterUserController")
public class RegisterUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ServerCommunication contactSV = new ServerCommunication();

	/**
	 * Default constructor.
	 */
	public RegisterUserController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	// Pega os dados de Username e Password do usuário e envia ao servidor no Heroku, fazendo método Post
	// para salvar os dados do usuário em nuvem, mostrando alertas se for feito com sucesso e também se tiver erro
	// no cadastramento.
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("Password");
		String confirmedPassword = request.getParameter("confirmedPassword");

		if (password == confirmedPassword) {
			contactSV.sendPOST(username, password);
			PrintWriter pw = response.getWriter();
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Account registered with success');");
			pw.println("</script>");

			request.getRequestDispatcher("LoginView.jsp").forward(request, response);
		} else {
			PrintWriter pw = response.getWriter();
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('The password must be confirmed and be equally');");
			pw.println("</script>");
		}
	}

}
