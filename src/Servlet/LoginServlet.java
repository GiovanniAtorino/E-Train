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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("studente_email"); 
		System.out.print(email);
		
		String Password = request.getParameter("studente_password");
		System.out.println(Password);
		
		try {
		Studente u=new Studente();
			 u = DatabaseQuery.getStudenteByEmail(email);
			 System.out.println("Hey " +u.getCognome());
			if(u!=null)
			{
				System.out.println("Siamo entrati " +u.getCognome());
				if(u.getPassword().equals(Password))
				{
					
						HttpSession session = request.getSession();
						session.setAttribute("user_stud", u);
					
						request.getRequestDispatcher("areaStudente.jsp").forward(request, response);
						
				}
				else {
					request.setAttribute("login_unsuccess", "Login errato password o email errati.");
					request.getRequestDispatcher("loginStudente.jsp").forward(request, response);
				}
			} else {   }
			
			} catch (SQLException e) {
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
