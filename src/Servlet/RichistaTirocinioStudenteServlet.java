package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Studente;
import Database.DatabaseQuery;


/**
 * Servlet implementation class RichistaTirocinioStudenteServlet
 */
@WebServlet("/RichistaTirocinioStudenteServlet")
public class RichistaTirocinioStudenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RichistaTirocinioStudenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Studente u = (Studente) session.getAttribute("user_stud");
		
		String nome=u.getNome();
		String action = request.getParameter("action");
		if (action != null) {
			
		        String nomea=request.getParameter("action");
				String	 nomet= request.getParameter("nomet");
				System.out.println("Invio Richista a" +nomea +nomet);
				try {
					DatabaseQuery.queryAddRichiestaTirocinioStudenteSetNT(nome,nomet);
					DatabaseQuery.queryAddRichiestaTirocinioStudenteSetNA(nome,nomea);
					
					System.out.println("Richista inviata=" +nomea +nomet);
					request.getRequestDispatcher("areaStudente.jsp").forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
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
