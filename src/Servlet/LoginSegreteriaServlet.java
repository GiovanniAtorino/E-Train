package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Segreteria;
import Bean.Tutor;
import Database.DatabaseQuery;

/**
 * Servlet implementation class LoginSegreteriaServlet
 */
@WebServlet("/LoginSegreteriaServlet")
public class LoginSegreteriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginSegreteriaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("segreteria_email"); 
		System.out.print(email);
		
		String Password = request.getParameter("segreteria_password");
		System.out.println(Password);
		
		Segreteria u=new Segreteria();
			 try {
				u = DatabaseQuery.getSegreteriaByEmail(email);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 System.out.println("Hey " +u.getNomeS());
			if(u!=null)
			{
				System.out.println("Siamo entrati " +u.getNomeS());
				if(u.getPassS().equals(Password))
				{
					
						
						
						HttpSession session = request.getSession();
						session.setAttribute("user_segreteria", u);
					
						request.getRequestDispatcher("homelogSegreteria.jsp").forward(request, response);
						
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
