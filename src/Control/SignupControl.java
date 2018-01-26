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
import Model.Studente;
import Model.ProfessoreTutorAziendale;

import Model.StudenteModel;
import Model.ProfessoreTutorAziendaleModel;

public class SignupControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static StudenteModel model;
	
	static {
		
			model = new StudenteModel();
		
	}
	
   static ProfessoreTutorAziendaleModel Tutormodel;
	
	static {
		
		Tutormodel = new ProfessoreTutorAziendaleModel();
		
	}
	String return_path = "/Signup.jsp";
	
	public SignupControl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		try {
			if (action != null) 
			{
  			  if (action.equalsIgnoreCase("insert")) 
				{
					
					return_path = "/Signup.jsp";
					
					String email = request.getParameter("email");
					
					String first_name = request.getParameter("first_name");
					int n = first_name.length();
					first_name = UPPER(first_name,n);
					
					String last_name = request.getParameter("last_name");
					n = last_name.length();
					last_name = UPPER(last_name,n);
					
					String matricola = request.getParameter("matricola");
					String username = request.getParameter("username");
					
					String psw = request.getParameter("psw");
					
					psw = md5.hashCode(psw, "MD5"); 	
					
					HttpSession session = request.getSession();
				    
					if(ValidateEmail(email))
					{
						if(IsStudent(email))
						{
							if(matricola=="")
							{
								session.setAttribute("matricola_vuota", "Sei uno studente, la matricola � necessaria!");
							}
							else
							{
								Studente bean = new Studente();
								bean.setMatricola(matricola);
								bean.setNome(first_name);
								bean.setCognome(last_name);
								bean.setEmail(email);
								bean.setUsername(username);
								bean.setPsw(psw);
								model.doSave(bean);	
								
								session.setAttribute("register_completed", email);
								session.setAttribute("register_completed_as_student_tutor_teacher", "uno Studente");
							}
						}
						else
						{
							if(IsTeacher(email))
							{
								ProfessoreTutorAziendale bean = new ProfessoreTutorAziendale();
								bean.setTipo("Professore");
								bean.setNome(first_name);
								bean.setCognome(last_name);
								bean.setEmail(email);
								bean.setUsername(username);
								bean.setPsw(psw);
								Tutormodel.doSave(bean);
								
								session.setAttribute("register_completed", email);
								session.setAttribute("register_completed_as_student_tutor_teacher", "un Professore");
							}
							else
							{
								ProfessoreTutorAziendale bean = new ProfessoreTutorAziendale();
								bean.setTipo("Tutor Aziendale");
								bean.setNome(first_name);
								bean.setCognome(last_name);
								bean.setEmail(email);
								bean.setUsername(username);
								bean.setPsw(psw);
								Tutormodel.doSave(bean);
								
								session.setAttribute("register_completed", email);
								session.setAttribute("register_completed_as_student_tutor_teacher", "un Tutor Aziendale");
							}
						}
					}
					else
						session.setAttribute("email_not_valid", "Email inserita \"" + email + "\" NON � valida!");
				}
			}
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
			
			String email = request.getParameter("email");
			HttpSession session = request.getSession();
		    				      
		    session.setAttribute("register_fault", email);		      
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
	
	public String UPPER(String first_name,int n)
	{
		int UPPER_first_letter = 1;
		String upper = null;
		for(int i=0;i<n;i++)
		{						
			String comparison = first_name.substring(i, i+1);
			
			if((comparison.replace(" ", "").length())==0)
			{	
				if(upper!=null) 
					upper = upper + " ";
				
				UPPER_first_letter = 1;
			}
			else
			{
				if(UPPER_first_letter==1)
					if(upper==null) 
					     upper = first_name.substring(i, i+1).toUpperCase();
					else
						 upper = upper + first_name.substring(i, i+1).toUpperCase();
				else 
					upper = upper + first_name.substring(i, i+1);
				
				UPPER_first_letter = 0;
			}
		}
		
	 return upper;
	}
}