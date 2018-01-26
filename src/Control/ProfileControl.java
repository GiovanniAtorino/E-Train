package Control;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import Model.ProfessoreTutorAziendale;
import Model.ProfessoreTutorAziendaleModel;

public class ProfileControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
   static ProfessoreTutorAziendaleModel Tutormodel;
	
	static {
		
		Tutormodel = new ProfessoreTutorAziendaleModel();
		
	}
	String return_path = "/CreateProfile.jsp";
	
	public ProfileControl() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		String action= null;
		if(ServletFileUpload.isMultipartContent(request))
		{
			try
			{
				List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				
				String name_folder = null,dir = null, image_profile = null,nome= null, cognome= null, company = null, indirizzo= null;
				String telefono=null , fax= null, email=null, luogo = null, sitoweb = null , chisono = null;
				 
				int i = 0;
				
				ProfessoreTutorAziendale sessione_teacher = (ProfessoreTutorAziendale) request.getSession().getAttribute("teacher");
				ProfessoreTutorAziendale sessione_tutor = (ProfessoreTutorAziendale) request.getSession().getAttribute("tutor");
				
				for(FileItem item : multiparts)
				{
					if(!item.isFormField())
					{						
						String name = new File(item.getName()).getName();					
						
						
						if(sessione_teacher!=null && i==0)
						{	
							 if(sessione_teacher.getEmail().length()>0)
							 {
								 sessione_teacher.setUsername(sessione_teacher.getUsername().replaceAll("^\\s+", "")); //toglie lo spazio all'inizio
								 sessione_teacher.setUsername(sessione_teacher.getUsername().replaceAll("\\s+$", "")); //toglie lo spazio alla fine
								 name_folder = Folder(sessione_teacher.getUsername(),sessione_teacher.getUsername().length());
								 dir = creaDir(name_folder);
								 i=1;
							 }
						}
						
						if(sessione_tutor!=null && i==0)
						{	
							if(sessione_tutor.getEmail().length()>0)
							{
								sessione_tutor.setUsername(sessione_tutor.getUsername().replaceAll("^\\s+", "")); //toglie lo spazio all'inizio
								sessione_tutor.setUsername(sessione_tutor.getUsername().replaceAll("\\s+$", "")); //toglie lo spazio alla fine
								name_folder = Folder(sessione_tutor.getUsername(),sessione_tutor.getUsername().length());
								dir = creaDir(name_folder);
								i=1;
							}
						}
						
						if(image_profile==null)
							image_profile = "/Tirocinio2.5/Users/TeacherTutor/" + name_folder + "/" + name;
						else
							image_profile = image_profile + name_folder + "/" + name;
						
						item.write(new File(dir + File.separator + name));
					}
					else
					{							
						if ("action".equals(item.getFieldName()))
						{
							action = item.getString();
						}
						 
						if ("first_name".equals(item.getFieldName()))
						{
							nome = item.getString();
						}
						
						if ("last_name".equals(item.getFieldName()))
						{
							cognome = item.getString();
						}
						
						if ("company".equals(item.getFieldName()))
						{
							company = item.getString();
						}
						
						if ("address".equals(item.getFieldName()))
						{
							indirizzo = item.getString();
						}
						
						if ("phone".equals(item.getFieldName()))
						{
							telefono = item.getString();
						}
						
						if ("fax".equals(item.getFieldName()))
						{
							fax = item.getString();
						}
						
						if ("email".equals(item.getFieldName()))
						{
							email = item.getString();
						}
						
						if ("city".equals(item.getFieldName()))
						{
							luogo = item.getString();
						}
						
						if ("website".equals(item.getFieldName()))
						{
							sitoweb = item.getString();
						}

						if ("whoiam".equals(item.getFieldName()))
						{
							chisono = item.getString();
						}
					}
				}
				
				if (action.equalsIgnoreCase("createProfile") || action.equalsIgnoreCase("EditProfile")) {
					
					if(ValidateEmail(email))
					{
						ProfessoreTutorAziendale bean = new ProfessoreTutorAziendale();
						bean.setNome(nome);
						bean.setCognome(cognome);
						if(sessione_teacher!=null)
						{
							bean.setTipo("Professore");
							bean.setUsername(sessione_teacher.getUsername());
						}
						if(sessione_tutor!=null)
						{
							bean.setTipo("Tutor Aziendale");
							bean.setUsername(sessione_tutor.getUsername());
						}
						bean.setCompany(company);
						bean.setIndirizzo(indirizzo);
						bean.setTelefono(telefono);
						bean.setFax(fax);
						bean.setEmail(email);
						bean.setCitta(luogo);
						bean.setSitoweb(sitoweb);
						bean.setChisono(chisono);
						bean.setImmagine_profilo(image_profile);
						Tutormodel.doModifyProfile(bean);
						
						if(action.equalsIgnoreCase("EditProfile"))
						{
							request.setAttribute("message_success_profile", "Profilo Modificato con successo.");							
							return_path = "/EditProfile.jsp";
						}
						else
							request.setAttribute("message_success_profile", "Profilo Creato con successo.");
						
						if(sessione_teacher!=null)
							request.getSession().setAttribute("teacher", Tutormodel.doRetrieveByKey(sessione_teacher.getUsername()));
						if(sessione_tutor!=null)
							request.getSession().setAttribute("tutor", Tutormodel.doRetrieveByKey(sessione_tutor.getUsername()));
					}
					else
					{
						request.setAttribute("email_not_valid_profile", "Email inserita non valida.");
						if(action.equalsIgnoreCase("EditProfile"))
							return_path = "/EditProfile.jsp";
					}
					
				}
			}
			catch(Exception ex)
			{
				request.setAttribute("message_danger_profile", "File upload failed due to : " + ex);
				
				if(action.equalsIgnoreCase("EditProfile"))
					return_path = "/EditProfile.jsp";
			}
		}
		else
		{
			request.setAttribute("message_danger", "Sorry this servlet only handles file upload request.");
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(return_path);
		  
		dispatcher.forward(request, response);
	}
	
	public String Folder(String name,int n)
	{		
		String name_folder = "";
		
		for(int i=0;i<n;i++)
		{						
			String comparison = name.substring(i, i+1);
			
			if((comparison.equalsIgnoreCase(" "))||(comparison.equalsIgnoreCase("*")))
			{	
				name_folder = name_folder + "_";
			}
			else
			{
				name_folder = name_folder + name.substring(i, i+1);
				
			}
		}
		
	 return name_folder;
	}
	
	private static String creaDir(String name_folder)
	  {
		//String Dir = "C:/Users/ciro9/eclipse-workspace/Tirocinio2.5/WebContent/Users/TeacherTutor/" + name_folder;
		String Dir = "C:/apache-tomcat-8.5.11/webapps/Tirocinio2.5/Users/TeacherTutor/" + name_folder;
		
	    new File(Dir).mkdir();
	    return Dir;
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