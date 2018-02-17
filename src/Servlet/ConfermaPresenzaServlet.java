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

import Bean.Presenza;
import Bean.Studente;
import Database.DatabaseQuery;

/**
 * Servlet implementation class ConfermaPresenzaServlet
 */
@WebServlet("/ConfermaPresenzaServlet")
public class ConfermaPresenzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfermaPresenzaServlet() {
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
		String m=a.getMatricola();
		ArrayList<Presenza> p=new ArrayList<>();
		try {
			p=DatabaseQuery.getPresenzaByM(m);
			System.out.println("Pres" +p.get(0).getNometP());
			request.setAttribute("list_pre", p);
			request.getRequestDispatcher("gestionePresenzeStudente.jsp").forward(request, response);
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
