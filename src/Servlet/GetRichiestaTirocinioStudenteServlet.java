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

import Bean.Azienda;
import Bean.Segreteria;
import Bean.Studente;
import Database.DatabaseQuery;

/**
 * Servlet implementation class RichiestaTirocinioStudenteServlet
 */
@WebServlet("/GetRichiestaTirocinioStudenteServlet")
public class GetRichiestaTirocinioStudenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetRichiestaTirocinioStudenteServlet() {
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
		String nomeA=a.getNomeA();
		ArrayList<Studente> stud=new ArrayList<>();
		try {
		stud=DatabaseQuery.GetRichiestaTirocinioStudente(nomeA);
		System.out.println("Richiesta studenti" +stud.get(0).getCognome());
		request.setAttribute("rich_studenti", stud);
		request.getRequestDispatcher("visualizzaPartecipantiAzienda.jsp").forward(request, response);
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
