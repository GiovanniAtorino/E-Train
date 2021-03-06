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
import Bean.Presenza;

import Database.DatabaseQuery;

/**
 * Servlet implementation class RegisteraPresenzaServlet
 */
@WebServlet("/RegisteraPresenzaServlet")
public class RegisteraPresenzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisteraPresenzaServlet() {
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
		String matrs=request.getParameter("presenza_matr");
		System.out.println("matr" +matrs);
		String nomet=request.getParameter("presenza_nomet");
		String data= request.getParameter("presenza_data");
		System.out.println("Data" +data);
		
		String orai= request.getParameter("presenza_orai");
		System.out.println("Orai" +orai);
		
		String oraf= request.getParameter("presenza_oraf");
		System.out.println("Ora" +oraf);
		
		Presenza p=new Presenza(matrs,data,orai,oraf,nomet);
		try {
			DatabaseQuery.addPresenza(p);
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
