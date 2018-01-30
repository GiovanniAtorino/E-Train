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
import Bean.Studente;
import Bean.Tirocinio;
import Database.DatabaseQuery;

/**
 * Servlet implementation class GetStudenteAccettatoTirocinio
 */
@WebServlet("/GetStudenteAccettatoTirocinio")
public class GetStudenteAccettatoTirocinio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetStudenteAccettatoTirocinio() {
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
		String nomeS=a.getNome();
		System.out.println("nome" +nomeS);
		try {
		String nomet=	DatabaseQuery.GetNomeTirocinio(nomeS);
		System.out.println("nome tir" +nomet);
		ArrayList<Tirocinio> t=DatabaseQuery.GetTirocinioFromNome(nomet);
		System.out.println(t.get(0).getNomeTirocinio());
		request.setAttribute("lista_tir", t);
		request.getRequestDispatcher("visualizzaTirocinioStudente.jsp").forward(request, response);
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
