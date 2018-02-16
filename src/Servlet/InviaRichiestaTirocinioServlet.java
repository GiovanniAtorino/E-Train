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
import Bean.Tirocinio;
import Database.DatabaseQuery;

/**
 * Servlet implementation class InviaRichiestaTirocinioServlet
 */
@WebServlet("/InviaRichiestaTirocinioServlet")
public class InviaRichiestaTirocinioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InviaRichiestaTirocinioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Azienda a = (Azienda) session.getAttribute("user_aziend");
	    String nomea= a.getNomeA();
	    String nome = request.getParameter("tirocinio_nome");
		System.out.println(nome);
		
		String descrizione = request.getParameter("tirocinio_descrizione"); 
		System.out.println(descrizione);
		
		String datai = request.getParameter("tirocinio_datai"); 
		System.out.println(datai);
		
		
		String dataf = request.getParameter("tirocinio_dataf");
		System.out.println(dataf);
		
		Tirocinio t=new Tirocinio(nome,descrizione,datai,dataf,nomea);
	    
	    try {
			if (DatabaseQuery.addRichiestaTirocinio(t)) {
				System.out.println("Ok");
				request.getRequestDispatcher("areaAzienda.jsp").forward(request, response);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Richiesta non inviata");
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
