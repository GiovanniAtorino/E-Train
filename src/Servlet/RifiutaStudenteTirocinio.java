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
import Bean.Segreteria;
import Database.DatabaseQuery;

/**
 * Servlet implementation class RifiutaStudenteTirocinio
 */
@WebServlet("/RifiutaStudenteTirocinio")
public class RifiutaStudenteTirocinio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RifiutaStudenteTirocinio() {
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
		String nomeS=request.getParameter("nomeS");	
		try {
			DatabaseQuery.queryRifiutaTirocinio(nomeS);
			System.out.println("Tirocinio accettato:" +nomeS);
			request.getRequestDispatcher("areaAzienda.jsp").forward(request, response);
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
