package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Azienda;
import Bean.Tutor;
import Database.DatabaseQuery;

/**
 * Servlet implementation class RegisterTutorServlet
 */
@WebServlet("/RegisterTutorServlet")
public class RegisterTutorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterTutorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Email = request.getParameter("tutor_email");
		System.out.println(Email);

		int matr= Integer.parseInt(request.getParameter("tutor_matricola"));
		System.out.println(matr);
		String Nome = request.getParameter("tutor_nome"); 
		System.out.println(Nome);
		
		String Cognome = request.getParameter("tutor_cognome"); 
		System.out.println(Cognome);
		
		String nomeazienda= request.getParameter("tutor_nomeazienda");
		System.out.println(nomeazienda);
		String nometirocinio=request.getParameter("tutor_nometirocinio");
		String Password = request.getParameter("tutor_password");
		System.out.println(Password);
		
		
		Tutor t=new Tutor(Nome,matr,Cognome,Email,nomeazienda,nometirocinio,Password);
		System.out.println(t);
		
		
		try {
			DatabaseQuery.addTutor(t);
			request.setAttribute("signup_success", "Registrazione come " + Nome + " " + Cognome + " effettuata con successo.");
			request.getRequestDispatcher("loginTutor.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			request.setAttribute("signup_unsuccess", "Registrazione non avvenuta.");
			request.getRequestDispatcher("registerTutor.jsp").forward(request, response);
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
