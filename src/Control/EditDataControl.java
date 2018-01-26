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

public class EditDataControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static StudenteModel model;
	
	static {
		
			model = new StudenteModel();
		
	}
	
   static ProfessoreTutorAziendaleModel Tutormodel;
	
	static {
		
		Tutormodel = new ProfessoreTutorAziendaleModel();
		
	}
	String return_path = "/EditData.jsp";
	
	public EditDataControl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		try {
			if (action != null) 
			{
  			  if (action.equalsIgnoreCase("editData")) 
				{
					
					return_path = "/EditData.jsp";
					
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
				    
					Studente sessione_student = (Studente) request.getSession().getAttribute("student");
					ProfessoreTutorAziendale sessione_teacher = (ProfessoreTutorAziendale) request.getSession().getAttribute("teacher");
					ProfessoreTutorAziendale sessione_tutor = (ProfessoreTutorAziendale) request.getSession().getAttribute("tutor");
					
					int control_student = 0;
					int control_teacher = 0;
					int control_tutor = 0;
					
					if(ValidateEmail(email))
					{
						if(IsStudent(email))
						{
							if(sessione_student!=null)
							{
								if(sessione_student.getMatricola().length()>0)
								{
									control_student = 1;
								}
							}
							else
							{
								if(sessione_teacher!=null)
								{
									if(sessione_teacher.getUsername().length()>0)
									{
										session.setAttribute("email_not_ok", "Se vuoi modificare l'email, quest'ultima deve essere di tipo Professore.");
									}
								}
								else
								{
									session.setAttribute("email_not_ok", "Se vuoi modificare l'email, quest'ultima deve essere di tipo Tutor Aziendale.");
								}
							}
						}
						else
							if(IsTeacher(email))
							{
								if(sessione_teacher!=null)
								{
									if(sessione_teacher.getUsername().length()>0)
									{
										control_teacher = 1;
									}
								}
								else
								{
									if(sessione_student!=null)
									{
										if(sessione_student.getMatricola().length()>0)
										{
											session.setAttribute("email_not_ok", "Se vuoi modificare l'email, quest'ultima deve essere di tipo Studente.");
										}
									}
									else
									{
										session.setAttribute("email_not_ok", "Se vuoi modificare l'email, quest'ultima deve essere di tipo Tutor Aziendale.");
									}
								}
							}
							else
							{
								if(sessione_tutor!=null)
								{
									if(sessione_tutor.getUsername().length()>0)
									{
										control_tutor = 1;
									}
								}
								else
								{
									if(sessione_student!=null)
									{
										if(sessione_student.getMatricola().length()>0)
										{
											session.setAttribute("email_not_ok", "Se vuoi modificare l'email, quest'ultima deve essere di tipo Studente.");
										}
									}
									else
									{
										session.setAttribute("email_not_ok", "Se vuoi modificare l'email, quest'ultima deve essere di tipo Professore.");
									}
								}
							}
						
						if(control_student==1)
						{
							if(matricola=="")
							{
								session.setAttribute("vuota", "Sei uno studente, la matricola è necessaria!");
							}
							else
							{
								if(sessione_student.getMatricola().length()>0)
									if(sessione_student.getMatricola().equalsIgnoreCase(matricola))
									{
										Studente bean = new Studente();
										bean.setMatricola(matricola);
										bean.setNome(first_name);
										bean.setCognome(last_name);
										bean.setEmail(email);
										bean.setUsername(username);
										bean.setPsw(psw);
										model.doModify(bean);	
										
										request.getSession().setAttribute("student", model.doRetrieveByKey(sessione_student.getMatricola()));
										
										session.setAttribute("editdata_completed", email);
										session.setAttribute("editdata_completed_as_student_tutor_teacher", "uno Studente");
									}
									else
									{
										session.setAttribute("not_equals", "La matricola inserita non risulta essere uguale a \"" + sessione_student.getMatricola() + "\"");
									}
							}
						}
						else
						{
							if(control_teacher==1)
							{
								if(username=="")
								{
									session.setAttribute("vuota", "Sei un professore, la username è necessaria!");
								}
								else
								if(sessione_teacher.getUsername().length()>0)
									if(sessione_teacher.getUsername().equalsIgnoreCase(username))
									{
										ProfessoreTutorAziendale bean = new ProfessoreTutorAziendale();
										bean.setTipo("Professore");
										bean.setNome(first_name);
										bean.setCognome(last_name);
										bean.setEmail(email);
										bean.setUsername(username);
										bean.setPsw(psw);
										Tutormodel.doModify(bean);
										
										request.getSession().setAttribute("teacher", Tutormodel.doRetrieveByKey(sessione_teacher.getUsername()));
										
										session.setAttribute("editdata_completed", email);
										session.setAttribute("editdata_completed_as_student_tutor_teacher", "un Professore");
									}
									else
									{
										session.setAttribute("not_equals", "La username inserita non risulta essere uguale a \"" + sessione_teacher.getUsername() + "\"");
									}
							}
							else
							if(control_tutor==1)
							{
								if(username=="")
								{
									session.setAttribute("vuota", "Sei un Tutor Aziendale, la username è necessaria!");
								}
								else
								if(sessione_tutor.getUsername().length()>0)
									if(sessione_tutor.getUsername().equalsIgnoreCase(username))
									{
										ProfessoreTutorAziendale bean = new ProfessoreTutorAziendale();
										bean.setTipo("TutorAziendale");
										bean.setNome(first_name);
										bean.setCognome(last_name);
										bean.setEmail(email);
										bean.setUsername(username);
										bean.setPsw(psw);
										Tutormodel.doModify(bean);
										
										request.getSession().setAttribute("tutor", Tutormodel.doRetrieveByKey(sessione_tutor.getUsername()));
										
										session.setAttribute("editdata_completed", email);
										session.setAttribute("editdata_completed_as_student_tutor_teacher", "un Tutor Aziendale");
									}
									else
									{
										session.setAttribute("not_equals", "La username inserita non risulta essere uguale a \"" + sessione_tutor.getUsername() + "\"");
									}
							}
						}
					}
					else
						session.setAttribute("email_not_valid", "Email inserita \"" + email + "\" NON è valida!");
				}
			}
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
			
			String email = request.getParameter("email");
			HttpSession session = request.getSession();
		    				      
		    session.setAttribute("editdata_fault", email);		      
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