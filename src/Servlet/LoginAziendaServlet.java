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
import Bean.Studente;
import Database.DatabaseQuery;

/**
 * Servlet implementation class LoginAziendaServlet
 */
@WebServlet("/LoginAziendaServlet")
public class LoginAziendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAziendaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("azienda_email"); 
		System.out.print(email);
		
		String Password = request.getParameter("azienda_password");
		System.out.println(Password);
		
		Azienda a=new Azienda();
			 try {
				a = DatabaseQuery.getAziendaByEmail(email);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 System.out.println("Hey " +a.getNomeA());
			if(a!=null)
			{
				System.out.println("Siamo entrati " +a.getNomeA());
				if(a.getPassA().equals(Password))
				{
					
						
						
						HttpSession session = request.getSession();
						session.setAttribute("user_aziend", a);
					
						request.getRequestDispatcher("areaAzienda.jsp").forward(request, response);
						
				}else {
					request.getRequestDispatcher("errorlog.jsp").forward(request, response);
				}
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
