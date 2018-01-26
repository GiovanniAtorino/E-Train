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

import Model.Studente;
import Model.StudenteModel;

public class ModifyLinkedinControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static StudenteModel model;
	
	static {
		
			model = new StudenteModel();
		
	}
	
	String return_path = "/PersonalArea.jsp";
	
	public ModifyLinkedinControl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String link = request.getParameter("link");

		try {
			if (link != null) 
			{						
				HttpSession session = request.getSession();
			    
				Studente sessione_student = (Studente) request.getSession().getAttribute("student");
				
				if(sessione_student.getMatricola().length()>0)
				{
					Studente bean = new Studente();
					bean.setLinkedin(link);
					bean.setMatricola(sessione_student.getMatricola());
					model.doModifyLinkedin(bean);	
							
					request.getSession().setAttribute("student", model.doRetrieveByKey(sessione_student.getMatricola()));							
						
					session.setAttribute("Edit_Linkedin", "Il profilo linkedin è stato aggiornato!");
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