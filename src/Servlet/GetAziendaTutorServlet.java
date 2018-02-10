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
import Bean.Tutor;
import Database.DatabaseQuery;

/**
 * Servlet implementation class GetAziendaTutorServlet
 */
@WebServlet("/GetAziendaTutorServlet")
public class GetAziendaTutorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAziendaTutorServlet() {
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
	System.out.println("nome az" +nomea);
	String nomet=t.getNomeTirocinioT();
	System.out.println("nome t" +nomet);
	Azienda a=new Azienda();
		try {
			a=DatabaseQuery.getAziendaByTirocinio(nomet);
			request.setAttribute("azienda", a);
			request.getRequestDispatcher("visualizzaAziendaTutor.jsp").forward(request, response);
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
