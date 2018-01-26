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

public class SegreteriaModel {

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

	private static final String TABLE_NAME = "segreteria";

	
	public synchronized void doSave(Segreteria segreteria) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "insert into " + SegreteriaModel.TABLE_NAME
				+ " (Username, Email, psw) values (?, ?, ?)";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, segreteria.getUsername());
			preparedStatement.setString(2, segreteria.getEmail());
			preparedStatement.setString(3, segreteria.getPsw());
			
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

	
	public synchronized Segreteria doRetrieveByKey(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Segreteria bean = new Segreteria();

		String selectSQL = "select * from " + SegreteriaModel.TABLE_NAME + " where Username = ?";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				bean.setUsername(rs.getString("Username"));
				bean.setEmail(rs.getString("Email"));
				bean.setPsw(rs.getString("psw"));
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

		String deleteSQL = "delete from " + SegreteriaModel.TABLE_NAME + " where Username = ?";
		
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

	
	public synchronized Collection<Segreteria> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<Segreteria> customers = new LinkedList<Segreteria>();

		String selectSQL = "select * from " + SegreteriaModel.TABLE_NAME;

		if (order != null && !order.equals("")) {
			selectSQL += " order by " + order;
		}

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Segreteria bean = new Segreteria();
				
				bean.setUsername(rs.getString("Username"));
				bean.setEmail(rs.getString("Email"));
				bean.setPsw(rs.getString("psw"));
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
	
	public synchronized Segreteria loginSegreteria(String email,String psw) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Segreteria bean = new Segreteria();

		String selectSQL = "SELECT * FROM " + SegreteriaModel.TABLE_NAME + " WHERE Email = ? AND psw = ?";

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
					bean.setUsername(rs.getString("Username"));
					bean.setEmail(rs.getString("Email"));
					//bean.setPsw(rs.getString("psw"));
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

