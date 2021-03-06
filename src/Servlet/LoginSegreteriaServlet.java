package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Segreteria;
import Bean.Tutor;
import Database.DatabaseQuery;

/**
 * Servlet implementation class LoginSegreteriaServlet
 */
@WebServlet("/LoginSegreteriaServlet")
public class LoginSegreteriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginSegreteriaServlet() {
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
		String email = request.getParameter("segreteria_email");
		System.out.println(email);

		String Password = request.getParameter("segreteria_password");
		System.out.println(Password);

		Segreteria u = new Segreteria();
		try {
			u = DatabaseQuery.getSegreteriaByEmail(email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println("Hey " +u.getNomeS());
		if (u != null) {
			System.out.println("DOPO IF U");
			if (u.getPassS().equals(Password)) {

				System.out.println("Siamo entrati " + u.getNomeS());

				HttpSession session = request.getSession();
				session.setAttribute("user_segreteria", u);

				request.getRequestDispatcher("areaSegreteria.jsp").forward(request, response);

			} else {
				System.out.println("DOPO ELSE");
				request.setAttribute("messaggio", "Login errato password o email errati.");
				request.getRequestDispatcher("loginSegreteria.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("messaggio", "Login errato password o email errati.");
			request.getRequestDispatcher("loginSegreteria.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
