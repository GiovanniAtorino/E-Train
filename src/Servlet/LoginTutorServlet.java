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
import Bean.Tutor;
import Database.DatabaseQuery;

/**
 * Servlet implementation class LoginTutorServlet
 */
@WebServlet("/LoginTutorServlet")
public class LoginTutorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginTutorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("tutor_email"); 
		System.out.print(email);
		
		String Password = request.getParameter("tutor_password");
		System.out.println(Password);
		
		Tutor u=new Tutor();
			 try {
				u = DatabaseQuery.getTutorByEmail(email);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 System.out.println("Hey " +u.getCognomeT());
			if(u!=null)
			{
				System.out.println("Siamo entrati " +u.getCognomeT());
				if(u.getPasswordT().equals(Password))
				{
					
						
						
						HttpSession session = request.getSession();
						session.setAttribute("user_tutor", u);
					
						request.getRequestDispatcher("homelogTutor.jsp").forward(request, response);
						
				}
				else{   }
			} else {   }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
