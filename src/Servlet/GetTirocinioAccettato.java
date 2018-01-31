package Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Segreteria;
import Bean.Studente;
import Bean.Tirocinio;
import Database.DatabaseQuery;

/**
 * Servlet implementation class GetTirocinioAccettato
 */
@WebServlet("/GetTirocinioAccettato")
public class GetTirocinioAccettato extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTirocinioAccettato() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Studente a = (Studente) session.getAttribute("user_stud");
		
		ArrayList<Tirocinio> t=new ArrayList<>();
		try {

			
		System.out.println("Tir accettato=" +t.get(0).getNomeTirocinio());
		System.out.println("Tir accettato=" +t.get(1).getNomeTirocinio());
		request.setAttribute("tir_accettati", DatabaseQuery.queryGetTirocinioAccettato());
		request.getRequestDispatcher("visualizzaAziendaStudente.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
