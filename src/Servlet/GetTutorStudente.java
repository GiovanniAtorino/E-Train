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

import Bean.Studente;
import Bean.Tutor;
import Database.DatabaseQuery;

/**
 * Servlet implementation class GetTutorStudente
 */
@WebServlet("/GetTutorStudente")
public class GetTutorStudente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTutorStudente() {
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
		ArrayList<Tutor> t=new ArrayList<>();
		try {
			String nomet=DatabaseQuery.GetNomeTirocinioByM(a.getMatricola());
			System.out.println("nome tirocinio" +nomet);
		t=	DatabaseQuery.GetTutorStudente(nomet);
		System.out.println("nome t" +t.get(0).getNomeT());
		request.setAttribute("tutor", t);
		request.getRequestDispatcher("visualizzaTutorStudente.jsp").forward(request, response);
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
