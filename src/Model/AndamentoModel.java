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

public class AndamentoModel {

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

	private static final String TABLE_NAME = "andamento";

	
	public synchronized void doSave(Andamento andamento) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "insert into " + AndamentoModel.TABLE_NAME
				+ " (DataT, Ora_Inizio, Ora_Fine,TirocinioID) values (?, ?, ?, ?)";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, andamento.getDataT());
			preparedStatement.setString(2, andamento.getOra_inizio());
			preparedStatement.setString(3, andamento.getOra_fine());
			preparedStatement.setInt(4, andamento.getTirocinioID());
			
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

	public synchronized boolean doModify(Andamento andamento) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		int result = 0;
		
		String insertSQL = "UPDATE " + AndamentoModel.TABLE_NAME + " SET DataT = ?, Ora_Inizio = ?, Ora_Fine = ? where id = ?";
		

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, andamento.getDataT());
			preparedStatement.setString(2, andamento.getOra_inizio());
			preparedStatement.setString(3, andamento.getOra_fine());
			preparedStatement.setInt(4, andamento.getId());
			
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
	
	public synchronized Andamento doRetrieveByKey(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Andamento bean = new Andamento();

		//String selectSQL = "select * from " + AndamentoModel.TABLE_NAME + " where id = ?";
		
		String selectSQL ="select * from studente S, tirocinio T, andamento A, professore_tutoraziendale PT "
				+ "where S.Matricola=T.MatricolaStudente AND T.id=A.TirocinioID AND PT.Username=T.TutorUsername AND A.id = ?";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				bean.setId(rs.getInt("A.id"));
				bean.setDataT(rs.getString("DataT"));
				bean.setOra_inizio(rs.getString("Ora_Inizio"));
				bean.setOra_fine(rs.getString("Ora_Fine"));
				bean.setTirocinioID(rs.getInt("TirocinioID"));
				bean.setNomeCognomeStudent(rs.getString("S.Nome") + " " + rs.getString("S.Cognome"));
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

		String deleteSQL = "delete from " + AndamentoModel.TABLE_NAME + " where id = ?";
		
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

	
	public synchronized Collection<Andamento> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<Andamento> customers = new LinkedList<Andamento>();

		String selectSQL = "select * from " + AndamentoModel.TABLE_NAME;

		if (order != null && !order.equals("")) {
			selectSQL += " order by " + order;
		}

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Andamento bean = new Andamento();
				
				bean.setId(rs.getInt("id"));
				bean.setDataT(rs.getString("DataT"));
				bean.setOra_inizio(rs.getString("Ora_Inizio"));
				bean.setOra_fine(rs.getString("Ora_Fine"));
				bean.setTirocinioID(rs.getInt("TirocinioID"));
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
	
	public synchronized Collection<Andamento> RequestTrend(String order, int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		Collection<Andamento> trend = new LinkedList<Andamento>();
		
		String selectSQL ="select * from studente S, tirocinio T, andamento A, professore_tutoraziendale PT "
				+ "where S.Matricola=T.MatricolaStudente AND T.id=A.TirocinioID AND PT.Username=T.TutorUsername AND A.TirocinioID = ?";

		if (order != null && !order.equals("")) {
			selectSQL += " order by " + order;
		}

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);
			
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Andamento bean = new Andamento();
				
				bean.setId(rs.getInt("A.id"));
				bean.setDataT(rs.getString("DataT"));
				bean.setOra_inizio(rs.getString("Ora_Inizio"));
				bean.setOra_fine(rs.getString("Ora_Fine"));
				bean.setTirocinioID(rs.getInt("TirocinioID"));
				bean.setNomeCognome(rs.getString("PT.Nome") + " " + rs.getString("PT.Cognome"));
				bean.setNomeCognomeStudent(rs.getString("S.Nome") + " " + rs.getString("S.Cognome"));
				trend.add(bean);
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
		return trend;
	}
}

