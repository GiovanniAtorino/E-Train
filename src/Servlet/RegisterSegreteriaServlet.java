package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Azienda;
import Bean.Segreteria;
import Database.DatabaseQuery;

/**
 * Servlet implementation class RegisterSegreteriaServlet
 */
@WebServlet("/RegisterSegreteriaServlet")
public class RegisterSegreteriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterSegreteriaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Email = request.getParameter("segreteria_email");
		System.out.println(Email);
		
		String Nome = request.getParameter("segreteria_nome"); 
		System.out.println(Nome);
		
		String dip = request.getParameter("segreteria_dipartimento"); 
		System.out.println(dip);
		
		String fac = request.getParameter("segreteria_facolta"); 
		System.out.println(fac);
		
		String telefono = request.getParameter("segreteria_telefono"); 
		System.out.println(telefono);
		
		String Password = request.getParameter("segreteria_password");
		System.out.println(Password);
		
		
		Segreteria s = new Segreteria(Nome,dip,fac,telefono,Email,Password);
		System.out.println(s);
		
		try {
			DatabaseQuery.addSegreteria(s);
			request.setAttribute("signup_success", "Registrazione come " + Nome + " effettuata con successo.");
			request.getRequestDispatcher("loginSegreteria.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			request.setAttribute("signup_unsuccess", "Registrazione non avvenuta.");
			request.getRequestDispatcher("registrazioneSegreteriaAdmin.jsp").forward(request, response);
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
