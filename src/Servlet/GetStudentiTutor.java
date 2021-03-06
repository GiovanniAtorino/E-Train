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
 * Servlet implementation class GetStudentiTutor
 */
@WebServlet("/GetStudentiTutor")
public class GetStudentiTutor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetStudentiTutor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Tutor t = (Tutor) session.getAttribute("user_tutor");
	String nomea=t.getNomeAT();
	String m1=t.getMatricolaT();
	System.out.println("nome az" +nomea);
	String nomet=t.getNomeTirocinioT();
	System.out.println("nome t" +nomet);
		try {
			ArrayList<Studente> s=DatabaseQuery.GetStudenteTutorStud( m1);
			System.out.println("Stud"+ s.get(0).getCognome());
			request.setAttribute("lista_stud", s);
			request.getRequestDispatcher("visualizzaStudenteTutor.jsp").forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch( IndexOutOfBoundsException ex){
			request.getRequestDispatcher("visualizzaStudenteTutor.jsp").forward(request, response);
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
