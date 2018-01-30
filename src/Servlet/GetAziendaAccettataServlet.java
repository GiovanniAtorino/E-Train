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
import Bean.Tirocinio;
import Database.DatabaseQuery;

/**
 * Servlet implementation class GetAziendaAccettataServlet
 */
@WebServlet("/GetAziendaAccettataServlet")
public class GetAziendaAccettataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAziendaAccettataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Segreteria s = (Segreteria) session.getAttribute("user_segreteria");
		Azienda a=new Azienda();
		ArrayList<Azienda> az=new ArrayList<>();
		try {
			
		
				a=DatabaseQuery.queryGetAziendaByTirocinio();
				System.out.println("Azienda" +a.getNomeA());
				az.add(a);
			
			request.setAttribute("azienda", az);
			request.getRequestDispatcher("visualizzaAziendaSegreteria.jsp").forward(request, response);
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
