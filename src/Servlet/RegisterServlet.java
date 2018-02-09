package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Studente;
import Database.DatabaseQuery;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Email = request.getParameter("studente_email");
		System.out.println(Email);
		
		String Nome = request.getParameter("studente_nome"); 
		System.out.println(Nome);
		
		String Cognome = request.getParameter("studente_cognome");
		System.out.println(Cognome);
		
		String Password = request.getParameter("studente_password");
		System.out.println(Password);
		
		String Matricola = request.getParameter("studente_matricola");
		System.out.println(Matricola);
		
		
		
		String Dipartimento = request.getParameter("studente_dipartimento");
		System.out.println(Dipartimento);
	
		
		
		Studente u = new Studente(Matricola, Nome, Cognome, Email,Password,Dipartimento);
		System.out.println(u);
		
		try {
			DatabaseQuery.addStudente(u);
			request.getRequestDispatcher("loginStudente.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			request.getRequestDispatcher("errorreg.jsp").forward(request, response);
			e.printStackTrace();
		}
		} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
