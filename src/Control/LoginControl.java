package Control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.md5;
import Model.ProfessoreTutorAziendaleModel;
import Model.SegreteriaModel;
import Model.StudenteModel;

public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	String return_path = "/index.jsp";
	
	public LoginControl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		
		StudenteModel model = null;
	    ProfessoreTutorAziendaleModel Tutormodel = null;
	    SegreteriaModel segreteriaModel = null;
	    
		try {
			if (action != null) {
				
				if (action.equalsIgnoreCase("login"))
					{
						String email = request.getParameter("email");
						String psw = request.getParameter("psw");
						
						psw = md5.hashCode(psw, "MD5");
						
						request.removeAttribute("student");
						request.removeAttribute("teacher");
						request.removeAttribute("tutor");
						
						if(ValidateEmail(email))
						{
							if(email.equalsIgnoreCase("segreteria@segreteria.unisa.it"))
							{
								segreteriaModel = new SegreteriaModel();
								request.getSession().setAttribute("segreteria", segreteriaModel.loginSegreteria(email,psw));
							}
							else
							{	
								if(IsStudent(email))
								{
									model = new StudenteModel();
									request.getSession().setAttribute("student", model.loginStudente(email,psw));
								}
								else
								{
									
									if(IsTeacher(email))
									{
										Tutormodel = new ProfessoreTutorAziendaleModel();
										request.getSession().setAttribute("teacher", Tutormodel.loginProfessoreTutor(email,psw));
									}
									else
									{
										Tutormodel = new ProfessoreTutorAziendaleModel();
										request.getSession().setAttribute("tutor", Tutormodel.loginProfessoreTutor(email,psw));
									}
								}
							}
						}
						else
						{
							HttpSession session_login = request.getSession();
							session_login.setAttribute("email_not_valid", "Email inserita \"" + email + "\" NON è valida!");
						}
							
						return_path = "/Login.jsp";			    
					}
			}
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());	      
		}	
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(return_path);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	public boolean ValidateEmail(String email)
	{
		Pattern pattern = Pattern.compile("[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}");
		Matcher matcher = pattern.matcher(email);
		 
		if(matcher.matches())
			return true;
		else
			return false;	
	}
	
	public boolean IsStudent(String email)
	{
		Pattern pattern = Pattern.compile("[a-zA-Z0-9._%-]+@[studenti]+\\.[unisa]+\\.[a-zA-Z]{2,4}");
		Matcher matcher = pattern.matcher(email);
		 
		if(matcher.matches())
			return true;
		else
			return false;	
	}
	public boolean IsTeacher(String email)
	{
		Pattern pattern = Pattern.compile("[a-zA-Z0-9._%-]+@[unisa]+\\.[a-zA-Z]{2,4}");
		Matcher matcher = pattern.matcher(email);
		 
		if(matcher.matches())
			return true;
		else
			return false;	
	}
}