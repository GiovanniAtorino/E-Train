package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ProfessoreTutorAziendaleModel {

	private static DataSource ds;

	static {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/tirocinio2_5");

		} catch (NamingException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}

	private static final String TABLE_NAME = "professore_tutoraziendale";

	
	public synchronized void doSave(ProfessoreTutorAziendale professoreTutor) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "insert into " + ProfessoreTutorAziendaleModel.TABLE_NAME
				+ " (Username, Nome, Cognome,Tipo, Company, Indirizzo, Telefono, Fax, Email, psw, Citta, SitoWeb, ChiSono, Immagine_Profilo) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, professoreTutor.getUsername());
			preparedStatement.setString(2, professoreTutor.getNome());
			preparedStatement.setString(3, professoreTutor.getCognome());
			preparedStatement.setString(4, professoreTutor.getTipo());
			preparedStatement.setString(5, professoreTutor.getCompany());
			preparedStatement.setString(6, professoreTutor.getIndirizzo());
			preparedStatement.setString(7, professoreTutor.getTelefono());
			preparedStatement.setString(8, professoreTutor.getFax());
			preparedStatement.setString(9, professoreTutor.getEmail());
			preparedStatement.setString(10, professoreTutor.getPsw());
			preparedStatement.setString(11, professoreTutor.getCitta());
			preparedStatement.setString(12, professoreTutor.getSitoweb());
			preparedStatement.setString(13, professoreTutor.getChisono());
			preparedStatement.setString(14, professoreTutor.getImmagine_profilo());
			
			preparedStatement.executeUpdate();
			connection.commit();

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
	}

	public synchronized boolean doModify(ProfessoreTutorAziendale professoreTutor) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		int result = 0;
		
		String insertSQL = "UPDATE " + ProfessoreTutorAziendaleModel.TABLE_NAME + " SET Nome = ?, Cognome = ?, Email = ? , psw = ? where Username = ?";
		

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, professoreTutor.getNome());
			preparedStatement.setString(2, professoreTutor.getCognome());
			preparedStatement.setString(3, professoreTutor.getEmail());
			preparedStatement.setString(4, professoreTutor.getPsw());
			preparedStatement.setString(5, professoreTutor.getUsername());
			
			result = preparedStatement.executeUpdate();

			connection.commit();
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return (result != 0);
	}
	
	public synchronized boolean doModifyProfile(ProfessoreTutorAziendale professoreTutor) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		int result = 0;
		
		String insertSQL = "UPDATE " + ProfessoreTutorAziendaleModel.TABLE_NAME + " SET Nome = ?, Cognome = ?, Tipo = ?, Company = ?, Indirizzo = ?, Telefono = ?, Fax = ?, Email = ? , Citta = ?, SitoWeb = ?, ChiSono = ?, Immagine_profilo = ? where Username = ?";
		

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, professoreTutor.getNome());
			preparedStatement.setString(2, professoreTutor.getCognome());
			preparedStatement.setString(3, professoreTutor.getTipo());
			preparedStatement.setString(4, professoreTutor.getCompany());
			preparedStatement.setString(5, professoreTutor.getIndirizzo());
			preparedStatement.setString(6, professoreTutor.getTelefono());
			preparedStatement.setString(7, professoreTutor.getFax());
			preparedStatement.setString(8, professoreTutor.getEmail());
			preparedStatement.setString(9, professoreTutor.getCitta());
			preparedStatement.setString(10, professoreTutor.getSitoweb());
			preparedStatement.setString(11, professoreTutor.getChisono());
			preparedStatement.setString(12, professoreTutor.getImmagine_profilo());
			preparedStatement.setString(13, professoreTutor.getUsername());

			result = preparedStatement.executeUpdate();

			connection.commit();
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return (result != 0);
	}
	
	public synchronized ProfessoreTutorAziendale doRetrieveByKey(String id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ProfessoreTutorAziendale bean = new ProfessoreTutorAziendale();

		String selectSQL = "select * from " + ProfessoreTutorAziendaleModel.TABLE_NAME + " where Username = ?";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, id);

			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				bean.setUsername(rs.getString("Username"));
				bean.setNome(rs.getString("Nome"));
				bean.setCognome(rs.getString("Cognome"));
				bean.setTipo(rs.getString("Tipo"));
				bean.setCompany(rs.getString("Company"));
				bean.setIndirizzo(rs.getString("Indirizzo"));
				bean.setTelefono(rs.getString("Telefono"));
				bean.setFax(rs.getString("Fax"));
				bean.setEmail(rs.getString("Email"));
				bean.setPsw(rs.getString("psw"));
				bean.setCitta(rs.getString("Citta"));
				bean.setSitoweb(rs.getString("SitoWeb"));
				bean.setChisono(rs.getString("ChiSono"));
				bean.setImmagine_profilo(rs.getString("Immagine_Profilo"));
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return bean;
	}

	public synchronized ProfessoreTutorAziendale doRetrieveByInternal(String id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ProfessoreTutorAziendale bean = new ProfessoreTutorAziendale();

		String selectSQL = "select * from " + ProfessoreTutorAziendaleModel.TABLE_NAME + " where Email = ? AND Tipo = ?";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, "Professore");

			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				bean.setUsername(rs.getString("Username"));
				bean.setNome(rs.getString("Nome"));
				bean.setCognome(rs.getString("Cognome"));
				bean.setTipo(rs.getString("Tipo"));
				bean.setCompany(rs.getString("Company"));
				bean.setIndirizzo(rs.getString("Indirizzo"));
				bean.setTelefono(rs.getString("Telefono"));
				bean.setFax(rs.getString("Fax"));
				bean.setEmail(rs.getString("Email"));
				bean.setPsw(rs.getString("psw"));
				bean.setCitta(rs.getString("Citta"));
				bean.setSitoweb(rs.getString("SitoWeb"));
				bean.setChisono(rs.getString("ChiSono"));
				bean.setImmagine_profilo(rs.getString("Immagine_Profilo"));
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return bean;
	}
	
	public synchronized ProfessoreTutorAziendale doRetrieveByExternal(String id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ProfessoreTutorAziendale bean = new ProfessoreTutorAziendale();

		String selectSQL = "select * from " + ProfessoreTutorAziendaleModel.TABLE_NAME + " where Email = ? AND Tipo = ?";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, "Tutor Aziendale");

			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				bean.setUsername(rs.getString("Username"));
				bean.setNome(rs.getString("Nome"));
				bean.setCognome(rs.getString("Cognome"));
				bean.setTipo(rs.getString("Tipo"));
				bean.setCompany(rs.getString("Company"));
				bean.setIndirizzo(rs.getString("Indirizzo"));
				bean.setTelefono(rs.getString("Telefono"));
				bean.setFax(rs.getString("Fax"));
				bean.setEmail(rs.getString("Email"));
				bean.setPsw(rs.getString("psw"));
				bean.setCitta(rs.getString("Citta"));
				bean.setSitoweb(rs.getString("SitoWeb"));
				bean.setChisono(rs.getString("ChiSono"));
				bean.setImmagine_profilo(rs.getString("Immagine_Profilo"));
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return bean;
	}
	
	public synchronized boolean doDelete(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "delete from " + ProfessoreTutorAziendaleModel.TABLE_NAME + " where Username = ?";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, id);

			result = preparedStatement.executeUpdate();
			connection.commit();
			
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return (result != 0);
	}

	
	public synchronized Collection<ProfessoreTutorAziendale> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<ProfessoreTutorAziendale> customers = new LinkedList<ProfessoreTutorAziendale>();

		String selectSQL = "select * from " + ProfessoreTutorAziendaleModel.TABLE_NAME;

		if (order != null && !order.equals("")) {
			selectSQL += " order by " + order;
		}

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				ProfessoreTutorAziendale bean = new ProfessoreTutorAziendale();
				
				bean.setUsername(rs.getString("Username"));
				bean.setNome(rs.getString("Nome"));
				bean.setCognome(rs.getString("Cognome"));
				bean.setTipo(rs.getString("Tipo"));
				bean.setCompany(rs.getString("Company"));
				bean.setIndirizzo(rs.getString("Indirizzo"));
				bean.setTelefono(rs.getString("Telefono"));
				bean.setFax(rs.getString("Fax"));
				bean.setEmail(rs.getString("Email"));
				bean.setPsw(rs.getString("psw"));
				bean.setCitta(rs.getString("Citta"));
				bean.setSitoweb(rs.getString("SitoWeb"));
				bean.setChisono(rs.getString("ChiSono"));
				bean.setImmagine_profilo(rs.getString("Immagine_Profilo"));
				customers.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return customers;
	}
	
	public synchronized Collection<ProfessoreTutorAziendale> doRetrieveAllTeachers(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<ProfessoreTutorAziendale> customers = new LinkedList<ProfessoreTutorAziendale>();

		String selectSQL = "select * from " + ProfessoreTutorAziendaleModel.TABLE_NAME + " where Tipo = ?";

		if (order != null && !order.equals("")) {
			selectSQL += " order by " + order;
		}

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, "Professore");
			
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				ProfessoreTutorAziendale bean = new ProfessoreTutorAziendale();
				
				bean.setUsername(rs.getString("Username"));
				bean.setNome(rs.getString("Nome"));
				bean.setCognome(rs.getString("Cognome"));
				bean.setTipo(rs.getString("Tipo"));
				bean.setCompany(rs.getString("Company"));
				bean.setIndirizzo(rs.getString("Indirizzo"));
				bean.setTelefono(rs.getString("Telefono"));
				bean.setFax(rs.getString("Fax"));
				bean.setEmail(rs.getString("Email"));
				bean.setPsw(rs.getString("psw"));
				bean.setCitta(rs.getString("Citta"));
				bean.setSitoweb(rs.getString("SitoWeb"));
				bean.setChisono(rs.getString("ChiSono"));
				bean.setImmagine_profilo(rs.getString("Immagine_Profilo"));
				customers.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return customers;
	}
	
	public synchronized Collection<ProfessoreTutorAziendale> doRetrieveAllTutor(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<ProfessoreTutorAziendale> customers = new LinkedList<ProfessoreTutorAziendale>();

		String selectSQL = "select * from " + ProfessoreTutorAziendaleModel.TABLE_NAME + " where Tipo = ?";

		if (order != null && !order.equals("")) {
			selectSQL += " order by " + order;
		}

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, "Tutor Aziendale");
			
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				ProfessoreTutorAziendale bean = new ProfessoreTutorAziendale();
				
				bean.setUsername(rs.getString("Username"));
				bean.setNome(rs.getString("Nome"));
				bean.setCognome(rs.getString("Cognome"));
				bean.setTipo(rs.getString("Tipo"));
				bean.setCompany(rs.getString("Company"));
				bean.setIndirizzo(rs.getString("Indirizzo"));
				bean.setTelefono(rs.getString("Telefono"));
				bean.setFax(rs.getString("Fax"));
				bean.setEmail(rs.getString("Email"));
				bean.setPsw(rs.getString("psw"));
				bean.setCitta(rs.getString("Citta"));
				bean.setSitoweb(rs.getString("SitoWeb"));
				bean.setChisono(rs.getString("ChiSono"));
				bean.setImmagine_profilo(rs.getString("Immagine_Profilo"));
				customers.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return customers;
	}
	
	public synchronized ProfessoreTutorAziendale loginProfessoreTutor(String email_username,String psw) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ProfessoreTutorAziendale bean = new ProfessoreTutorAziendale();

		String selectSQL = "SELECT * FROM " + ProfessoreTutorAziendaleModel.TABLE_NAME + " WHERE (Email = ? OR Username = ?) AND psw = ?";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, email_username);
			preparedStatement.setString(2, email_username);
			preparedStatement.setString(3, psw);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			int numeroRighe = 0;
			
			if (rs.last()) 
			{
				// Riprendo il numero di righe
				numeroRighe = rs.getRow();
				
				// Torno alla posizione iniziale, prima della prima righa, operazione non permessa con il ResultSet.TYPE_FORWARD_ONLY
				rs.beforeFirst();
			}
			
			if(numeroRighe==1)
			{
				while (rs.next()) {	
					bean.setUsername(rs.getString("Username"));
					bean.setNome(rs.getString("Nome"));
					bean.setCognome(rs.getString("Cognome"));
					bean.setTipo(rs.getString("Tipo"));
					bean.setCompany(rs.getString("Company"));
					bean.setIndirizzo(rs.getString("Indirizzo"));
					bean.setTelefono(rs.getString("Telefono"));
					bean.setFax(rs.getString("Fax"));
					bean.setEmail(rs.getString("Email"));
					//bean.setPsw(rs.getString("psw"));
					bean.setCitta(rs.getString("Citta"));
					bean.setSitoweb(rs.getString("SitoWeb"));
					bean.setChisono(rs.getString("ChiSono"));
					bean.setImmagine_profilo(rs.getString("Immagine_Profilo"));
				}
			}
			
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return bean;
	}

}

