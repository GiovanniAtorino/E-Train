package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Bean.Studente;

public class DatabaseQuery {

	private static String queryAdd_Studente;
	private static String queryGetStudente;
	
	
	
	public synchronized static boolean addStudente(Studente studente) throws SQLException{
		Connection connection = null;
		PreparedStatement psAddUtente = null;

		try{
			connection = Database.getConnection();
			psAddUtente = connection.prepareStatement(queryAdd_Studente);
			psAddUtente.setString(1, studente.getMatricola());
			psAddUtente.setString(2, studente.getNome());
			psAddUtente.setString(3, studente.getCognome());
			psAddUtente.setString(4, studente.getEmail());
		
			psAddUtente.setString(5, studente.getPassword());
			psAddUtente.setString(6, studente.getDipartimento());
			
			System.out.println(psAddUtente.toString());

			psAddUtente.executeUpdate();

			connection.commit();
			System.out.println("GU Connessione...");
		} finally {
			try{
				if(psAddUtente != null)
					psAddUtente.close();
			} finally {
				Database.releaseConnection(connection);
			}
		}

		return true;}
	public synchronized static Studente getStudenteByEmail(String email) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Studente studente = new Studente();

		try {
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement(queryGetStudente);
			preparedStatement.setString(1, email);

			ResultSet rs = preparedStatement.executeQuery();

			connection.commit();

			while (rs.next()) {
				studente.setEmail(rs.getString("email"));
				studente.setNome(rs.getString("nome"));
				studente.setCognome(rs.getString("cognome"));
				studente.setPassword(rs.getString("password"));
			
				studente.setDipartimento(rs.getString("dipartimento"));
				
				
			}
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				Database.releaseConnection(connection);
			}
		}
		if (studente.getEmail() == null)
			return null;
		else
			return studente;
	}
	
	
	
	
	static {
		queryAdd_Studente = "INSERT INTO studente (matricola, nome, cognome,  email,password,dipartimento) VALUES (?,?,?,?,?,?);";
		queryGetStudente = "SELECT * FROM studente WHERE email=?";
}
}