package Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Bean.FileP;
import Database.DatabaseQuery;

/**
 * Servlet implementation class GetFileServlet
 */
@WebServlet("/GetFileServlet")
public class GetFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetFileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		ArrayList<FileP> pf=new ArrayList<>();
		
		try {
			switch(action) {
				case "studente":
					loadFile(request, pf);
					request.getRequestDispatcher("gestioneFileStudente.jsp").forward(request, response);
					break;
					
	
				case "tutor":
					loadFile(request, pf);
					request.getRequestDispatcher("gestioneFileTutor.jsp").forward(request, response);
					break;
					
	
				case "azienda":
					loadFile(request, pf);
					request.getRequestDispatcher("gestioneFileAzienda.jsp").forward(request, response);
					break;
					
	
				case "segreteria":
					loadFile(request, pf);
					request.getRequestDispatcher("gestioneFileSegreteria.jsp").forward(request, response);
					break;
					
			}
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
	
	private void loadFile(HttpServletRequest request, ArrayList<FileP> pf) throws SQLException {
		pf=DatabaseQuery.getFile();
		request.setAttribute("lista_path", pf);
	}

}
