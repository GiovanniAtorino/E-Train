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

public class StudenteModel {

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

	private static final String TABLE_NAME = "studente";

	
	public synchronized void doSave(Studente studente) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "insert into " + StudenteModel.TABLE_NAME
				+ " (Matricola, Nome, Cognome, Email, Username, psw, linkedin, link_curriculum) values (?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, studente.getMatricola());
			preparedStatement.setString(2, studente.getNome());
			preparedStatement.setString(3, studente.getCognome());
			preparedStatement.setString(4, studente.getEmail());
			preparedStatement.setString(5, studente.getUsername());
			preparedStatement.setString(6, studente.getPsw());
			preparedStatement.setString(7, studente.getLinkedin());
			preparedStatement.setString(8, studente.getLink_curriculum());
			
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

	public synchronized boolean doModify(Studente studente) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		int result = 0;
		
		String insertSQL = "UPDATE " + StudenteModel.TABLE_NAME + " SET Nome = ?, Cognome = ?, Email = ?, Username = ? ,psw = ? where Matricola = ?";
		

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, studente.getNome());
			preparedStatement.setString(2, studente.getCognome());
			preparedStatement.setString(3, studente.getEmail());
			preparedStatement.setString(4, studente.getUsername());
			preparedStatement.setString(5, studente.getPsw());
			preparedStatement.setString(6, studente.getMatricola());
			
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
	
	public synchronized boolean doModifyLinkedin(Studente studente) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		int result = 0;
		
		String insertSQL = "UPDATE " + StudenteModel.TABLE_NAME + " SET linkedin = ? where Matricola = ?";
		

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, studente.getLinkedin());
			preparedStatement.setString(2, studente.getMatricola());
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
	
	public synchronized boolean doModifyCurriculum(Studente studente) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		int result = 0;
		
		String insertSQL = "UPDATE " + StudenteModel.TABLE_NAME + " SET link_curriculum = ? where Matricola = ?";
		

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, studente.getLink_curriculum());
			preparedStatement.setString(2, studente.getMatricola());
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
	
	public synchronized Studente doRetrieveByKey(String id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Studente bean = new Studente();

		String selectSQL = "select * from " + StudenteModel.TABLE_NAME + " where Matricola = ?";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, id);

			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				bean.setMatricola(rs.getString("Matricola"));
				bean.setNome(rs.getString("Nome"));
				bean.setCognome(rs.getString("Cognome"));
				bean.setEmail(rs.getString("Email"));
				bean.setUsername(rs.getString("Username"));
				bean.setPsw(rs.getString("psw"));
				bean.setLinkedin(rs.getString("linkedin"));
				bean.setLink_curriculum(rs.getString("link_curriculum"));
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

		String deleteSQL = "delete from " + StudenteModel.TABLE_NAME + " where Matricola = ?";
		
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

	
	public synchronized Collection<Studente> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<Studente> customers = new LinkedList<Studente>();

		String selectSQL = "select * from " + StudenteModel.TABLE_NAME;

		if (order != null && !order.equals("")) {
			selectSQL += " order by " + order;
		}

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Studente bean = new Studente();
				
				bean.setMatricola(rs.getString("Matricola"));
				bean.setEmail(rs.getString("Email"));
				bean.setNome(rs.getString("Nome"));
				bean.setCognome(rs.getString("Cognome"));
				bean.setUsername(rs.getString("Username"));
				bean.setLinkedin(rs.getString("linkedin"));
				bean.setLink_curriculum(rs.getString("link_curriculum"));
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
	
	public synchronized Studente loginStudente(String email,String psw) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Studente bean = new Studente();

		String selectSQL = "SELECT * FROM " + StudenteModel.TABLE_NAME + " WHERE Email = ? AND psw = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, psw);
			
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
					bean.setMatricola(rs.getString("Matricola"));
					bean.setEmail(rs.getString("email"));
					bean.setNome(rs.getString("Nome"));
					bean.setCognome(rs.getString("Cognome"));
					bean.setUsername(rs.getString("Username"));
					bean.setPsw(rs.getString("psw"));
					bean.setLinkedin(rs.getString("linkedin"));
					bean.setLink_curriculum(rs.getString("link_curriculum"));
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

