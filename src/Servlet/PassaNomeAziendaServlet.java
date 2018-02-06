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
 * Servlet implementation class PassaNomeAziendaServlet
 */
@WebServlet("/PassaNomeAziendaServlet")
public class PassaNomeAziendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PassaNomeAziendaServlet() {
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
		String nome=a.getNome();
		String matr= a.getMatricola();
		System.out.println("Matricola "+matr);
		String nomeA;
		try {
			nomeA=DatabaseQuery.GetNomeAzienda(nome);
			String nomeAz=nomeA.toString();
			if (nomeA.isEmpty()) {
				request.setAttribute("nome_azienda", "nulla");
				request.getRequestDispatcher("gestionePresenzeStudente.jsp").forward(request, response);
			}else {
				System.out.println("nome azienda=" +nomeA);
				request.setAttribute("nome_azienda", nomeAz);
				request.getRequestDispatcher("gestionePresenzeStudente.jsp").forward(request, response);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException ex) {
			request.setAttribute("nome_azienda", "nulla");
			request.getRequestDispatcher("gestionePresenzeStudente.jsp").forward(request, response);
			ex.printStackTrace();
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
