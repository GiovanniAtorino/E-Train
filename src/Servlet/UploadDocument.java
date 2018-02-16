package Servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import Database.DatabaseQuery;


/**
 * UploadDocument è una classe che permetterà di salvare un 
 * file documento nel server e di inserire nel database un tirocinio precedente.
 */
@WebServlet("/UploadDocument")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 100, maxRequestSize = 1024 * 1024
* 100)
public class UploadDocument extends HttpServlet {
  private static final long serialVersionUID = 1L;

  static DatabaseQuery model;

  static {

    model = new DatabaseQuery();
  }
 
  static String return_path = "/GetFileServlet?action=segreteria";
  
  public UploadDocument() {
     super();
  }

  /**
    * Il metodo doPost, tenterà di inserire un documento 
    * come file in una cartella specifica dell'utente che fa richiesta 
    * ed inserire nel database un tirocinio precedente.
 * @throws ServletException 
 * @throws IOException 
  */
  
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	  
	  Part filepart = request.getPart("fileName");
	  
	  if(checkFile(filepart)) {
		 
		  String fileName = getFileName(filepart);
		  
		  String path = request.getServletContext().getRealPath("") + File.separator + "Files" + File.separator;
		  
		  new File(path).mkdir();
		  
		  uploadFile(filepart, fileName, path);
		  try {
			DatabaseQuery.addFile("./Files/" + fileName, fileName);
		  } 
		  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
		  
		  request.getRequestDispatcher(return_path).forward(request, response);
	  }
	 
	  else {
		  /*File non valido*/
	  }
	  
  }
  
  private boolean checkValidExtension(String filename) {
	  String[] split = filename.split("\\.");
	  		  
	  return split[split.length-1].equals("pdf");
  }
  
  private String getFileName(Part filePart) {
	  for(String content: filePart.getHeader("content-disposition").split(";"))
		  if(content.trim().startsWith("filename"))
			return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
	  
	  return null;
  }
  
  private boolean checkFile(Part filepart) {
	  return checkValidExtension(getFileName(filepart));
  }
  
  
  private boolean uploadFile(Part filePart, String fileName, String basePath) {

	    try {
	      InputStream is = null;
	      OutputStream os = null;

	      try {
	        File ofp = new File(basePath + fileName);

	        is = filePart.getInputStream();
	        os = new FileOutputStream(ofp);
	        int read = 0;

	        final byte[] bytes = new byte[1024];
	        while ((read = is.read(bytes)) != -1)
	          os.write(bytes, 0, read);
	      } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	      } finally {
	        if (os != null)
	          os.close();

	        if (is != null)
	          is.close();
	      }

	    } catch (Exception ex) {
	      fileName = "";
	      return false;
	    }

	    return true;
	  }
}