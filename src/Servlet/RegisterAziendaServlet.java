package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Azienda;
import Bean.Studente;
import Database.DatabaseQuery;

/**
 * Servlet implementation class RegisterAziendaServlet
 */
@WebServlet("/RegisterAziendaServlet")
public class RegisterAziendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterAziendaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Email = request.getParameter("azienda_email");
		System.out.println(Email);
		
		String Nome = request.getParameter("azienda_nome"); 
		System.out.println(Nome);
		
		String Sede = request.getParameter("azienda_sede"); 
		System.out.println(Sede);
		
		
		String Password = request.getParameter("azienda_password");
		System.out.println(Password);
		
		
		Azienda a = new Azienda(Nome,Sede,Email,Password);
		System.out.println(a);
		
		try {
			DatabaseQuery.addAzienda(a);
			request.getRequestDispatcher("loginAzienda.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Ignorante di merda");
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
