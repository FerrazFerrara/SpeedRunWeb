package br.com.speedrun4.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.speedrun1.apiservices.ServerCommunication;

/**
 * Servlet implementation class LoginUserController
 */
@WebServlet("/LoginUserController")
public class LoginUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServerCommunication contactSV = new ServerCommunication();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginUserController() {
		super();
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
	
	// Pega os dados de login do usuário e verifica no banco de dados em nuvem ContactSV para ver se
	// existe no banco de dados, se não existir ele dispara um alerta falando do erro e recarrega a 
	// página
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("name");
		String password = request.getParameter("password");

		if (contactSV.sendLoginGetter(username, password)) {
			request.getRequestDispatcher("SpeedRunsView.jsp").forward(request, response);
		} else {
			PrintWriter pw=response.getWriter();
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Invalid Username or Password');");
			pw.println("</script>");
			javax.servlet.RequestDispatcher rd= request.getRequestDispatcher("LoginView.jsp");
			rd.include(request, response);
			
		}

	}

}
