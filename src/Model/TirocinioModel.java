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

public class TirocinioModel {

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

	private static final String TABLE_NAME = "tirocinio";

	
	public synchronized void doSave(Tirocinio tirocinio) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "insert into " + TirocinioModel.TABLE_NAME
				+ " (Stato, Tipo, MatricolaStudente, SegreteriaUsername, TutorUsername) values (?, ?, ?, ?, ?)";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			//preparedStatement.setInt(1, tirocinio.getId());
			preparedStatement.setString(1, tirocinio.getStato());
			preparedStatement.setString(2, tirocinio.getTipo());
			preparedStatement.setString(3, tirocinio.getMatricola_studente());
			preparedStatement.setString(4, tirocinio.getSegreteria_username());
			preparedStatement.setString(5, tirocinio.getTutor_username());
			
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

	public synchronized boolean doModify(String stato, int id) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		int result = 0;
		
		String insertSQL = "UPDATE " + TirocinioModel.TABLE_NAME + " SET Stato = ? where id = ?";
		

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, stato);
			preparedStatement.setInt(2, id);
			
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
	
	public synchronized Tirocinio doRetrieveByKey(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Tirocinio bean = new Tirocinio();

		String selectSQL = "select * from " + TirocinioModel.TABLE_NAME + " where id = ?";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				bean.setId(rs.getInt("id"));
				bean.setStato(rs.getString("Stato"));
				bean.setTipo(rs.getString("Tipo"));
				bean.setMatricola_studente(rs.getString("MatricolaStudente"));
				bean.setSegreteria_username(rs.getString("SegreteriaUsername"));
				bean.setTutor_username(rs.getString("TutorUsername"));
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

		String deleteSQL = "delete from " + TirocinioModel.TABLE_NAME + " where id = ?";
		
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

	
	public synchronized Collection<Tirocinio> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<Tirocinio> trainings = new LinkedList<Tirocinio>();

		String selectSQL = "select * from " + TirocinioModel.TABLE_NAME;

		if (order != null && !order.equals("")) {
			selectSQL += " order by " + order;
		}

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Tirocinio bean = new Tirocinio();
				
				bean.setId(rs.getInt("id"));
				bean.setStato(rs.getString("Stato"));
				bean.setTipo(rs.getString("Tipo"));
				bean.setMatricola_studente(rs.getString("MatricolaStudente"));
				bean.setSegreteria_username(rs.getString("SegreteriaUsername"));
				bean.setTutor_username(rs.getString("TutorUsername"));
				trainings.add(bean);
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
		return trainings;
	}
	
	public synchronized Collection<Tirocinio> doRetrieveAllQuestions(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<Tirocinio> trainings = new LinkedList<Tirocinio>();

		String selectSQL ="select * from studente S, tirocinio T, professore_tutoraziendale PT "
				+ "where S.Matricola=T.MatricolaStudente AND PT.Username=T.TutorUsername AND T.Stato = ?";

		if (order != null && !order.equals("")) {
			selectSQL += " order by " + order;
		}

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, "In Attesa");
			
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Tirocinio bean = new Tirocinio();
				
				bean.setId(rs.getInt("id"));
				bean.setStato(rs.getString("Stato"));
				bean.setTipo(rs.getString("T.Tipo"));
				bean.setMatricola_studente(rs.getString("MatricolaStudente"));
				bean.setSegreteria_username(rs.getString("SegreteriaUsername"));
				bean.setTutor_username(rs.getString("TutorUsername"));
				bean.setNomeCognomeStudent(rs.getString("S.Nome") + " " + rs.getString("S.Cognome"));
				bean.setStudent_usename(rs.getString("S.Username"));
				bean.setStudent_email(rs.getString("S.Email"));
				bean.setMatricola_studente(rs.getString("S.Matricola"));
				bean.setNomeCognome(rs.getString("PT.Nome") + " " + rs.getString("PT.Cognome"));
				bean.setTipoTutorProfessore(rs.getString("PT.Tipo"));
				trainings.add(bean);
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
		return trainings;
	}
	
	public synchronized Collection<Tirocinio> doRetrieveAllCompleted(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<Tirocinio> trainings = new LinkedList<Tirocinio>();

		String selectSQL ="select * from studente S, tirocinio T, professore_tutoraziendale PT "
				+ "where S.Matricola=T.MatricolaStudente AND PT.Username=T.TutorUsername AND T.Stato = ?";

		if (order != null && !order.equals("")) {
			selectSQL += " order by " + order;
		}

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, "Completato");
			
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Tirocinio bean = new Tirocinio();
				
				bean.setId(rs.getInt("id"));
				bean.setStato(rs.getString("Stato"));
				bean.setTipo(rs.getString("T.Tipo"));
				bean.setMatricola_studente(rs.getString("MatricolaStudente"));
				bean.setSegreteria_username(rs.getString("SegreteriaUsername"));
				bean.setTutor_username(rs.getString("TutorUsername"));
				bean.setNomeCognomeStudent(rs.getString("S.Nome") + " " + rs.getString("S.Cognome"));
				bean.setStudent_usename(rs.getString("S.Username"));
				bean.setStudent_email(rs.getString("S.Email"));
				bean.setMatricola_studente(rs.getString("S.Matricola"));
				bean.setNomeCognome(rs.getString("PT.Nome") + " " + rs.getString("PT.Cognome"));
				bean.setTipoTutorProfessore(rs.getString("PT.Tipo"));
				trainings.add(bean);
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
		return trainings;
	}
	
	public synchronized Collection<Tirocinio> doRetrieveAllConvalidate(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<Tirocinio> trainings = new LinkedList<Tirocinio>();

		String selectSQL ="select * from studente S, tirocinio T, professore_tutoraziendale PT "
				+ "where S.Matricola=T.MatricolaStudente AND PT.Username=T.TutorUsername AND T.Stato = ?";

		if (order != null && !order.equals("")) {
			selectSQL += " order by " + order;
		}

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, "Convalidato");
			
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Tirocinio bean = new Tirocinio();
				
				bean.setId(rs.getInt("id"));
				bean.setStato(rs.getString("Stato"));
				bean.setTipo(rs.getString("T.Tipo"));
				bean.setMatricola_studente(rs.getString("MatricolaStudente"));
				bean.setSegreteria_username(rs.getString("SegreteriaUsername"));
				bean.setTutor_username(rs.getString("TutorUsername"));
				bean.setNomeCognomeStudent(rs.getString("S.Nome") + " " + rs.getString("S.Cognome"));
				bean.setStudent_usename(rs.getString("S.Username"));
				bean.setStudent_email(rs.getString("S.Email"));
				bean.setMatricola_studente(rs.getString("S.Matricola"));
				bean.setNomeCognome(rs.getString("PT.Nome") + " " + rs.getString("PT.Cognome"));
				bean.setTipoTutorProfessore(rs.getString("PT.Tipo"));
				trainings.add(bean);
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
		return trainings;
	}
	
	public synchronized Collection<Tirocinio> MyTraining(String order, String matricola) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		Collection<Tirocinio> trainings = new LinkedList<Tirocinio>();

		String selectSQL = "select * from tirocinio, professore_tutoraziendale "
				+ "WHERE professore_tutoraziendale.Username=tirocinio.TutorUsername AND tirocinio.MatricolaStudente = ?";

		if (order != null && !order.equals("")) {
			selectSQL += " order by " + order;
		}

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, matricola);
			
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Tirocinio bean = new Tirocinio();
				
				bean.setId(rs.getInt("id"));
				bean.setStato(rs.getString("Stato"));
				bean.setTipo(rs.getString("tirocinio.Tipo"));
				bean.setMatricola_studente(rs.getString("MatricolaStudente"));
				bean.setSegreteria_username(rs.getString("SegreteriaUsername"));
				bean.setTutor_username(rs.getString("TutorUsername"));
				bean.setNomeCognome(rs.getString("Nome") + " " + rs.getString("Cognome"));
				bean.setTipoTutorProfessore(rs.getString("professore_tutoraziendale.Tipo"));
				trainings.add(bean);
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
		return trainings;
	}
	
	public synchronized Collection<Tirocinio> RequestTraining(String order, String username) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		Collection<Tirocinio> trainings = new LinkedList<Tirocinio>();
		
		String selectSQL ="select * from studente S, tirocinio T, professore_tutoraziendale PT "
				+ "where S.Matricola=T.MatricolaStudente AND PT.Username=T.TutorUsername AND T.TutorUsername = ?";

		if (order != null && !order.equals("")) {
			selectSQL += " order by " + order;
		}

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, username);
			
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Tirocinio bean = new Tirocinio();
				
				bean.setId(rs.getInt("id"));
				bean.setStato(rs.getString("Stato"));
				bean.setTipo(rs.getString("T.Tipo"));
				bean.setMatricola_studente(rs.getString("MatricolaStudente"));
				bean.setSegreteria_username(rs.getString("SegreteriaUsername"));
				bean.setTutor_username(rs.getString("TutorUsername"));
				bean.setNomeCognomeStudent(rs.getString("S.Nome") + " " + rs.getString("S.Cognome"));
				bean.setStudent_usename(rs.getString("S.Username"));
				bean.setStudent_email(rs.getString("S.Email"));
				bean.setMatricola_studente(rs.getString("S.Matricola"));
				trainings.add(bean);
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
		return trainings;
	}
}

