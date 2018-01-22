package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Bean.Azienda;
import Bean.Studente;

public class DatabaseQuery {

	private static String queryAdd_Studente;
	private static String queryGetStudente;
    private static String queryAddAzienda;
    private static String queryGetAzienda;
	
	
	
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
	
	public static boolean addAzienda(Azienda a) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement psAddAzienda = null;
        
		try{
			connection = Database.getConnection();
			psAddAzienda = connection.prepareStatement(queryAddAzienda);
			psAddAzienda.setString(1, a.getNomeA());
			psAddAzienda.setString(2, a.getSedeA());
			psAddAzienda.setString(3, a.getEmailA());
			psAddAzienda.setString(4, a.getPassA());
		
		
			

			psAddAzienda.executeUpdate();

			connection.commit();
			System.out.println("GU Connessione...");
		} finally {
			try{
				if(psAddAzienda != null)
					psAddAzienda.close();
			} finally {
				Database.releaseConnection(connection);
			}
		}

		return true;}
		
	public synchronized static Azienda getAziendaByEmail(String email) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Azienda azienda = new Azienda();

		try {
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement(queryGetAzienda);
			preparedStatement.setString(1, email);

			ResultSet rs = preparedStatement.executeQuery();

			connection.commit();

			while (rs.next()) {
				azienda.setEmailA(rs.getString("email"));
				azienda.setNomeA(rs.getString("nome"));
				azienda.setSedeA(rs.getString("sede"));
				azienda.setPasswordA(rs.getString("password"));
			
			
				
				
			}
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				Database.releaseConnection(connection);
			}
		}
		if (azienda.getEmailA() == null)
			return null;
		else
			return azienda;
	}
	
	
	
	
	static {
		queryAdd_Studente = "INSERT INTO studente (matricola, nome, cognome,  email,password,dipartimento) VALUES (?,?,?,?,?,?);";
		queryGetStudente = "SELECT * FROM studente WHERE email=?";
		queryAddAzienda="INSERT INTO azienda(nome,sede,email,password) values (?,?,?,?);";
		queryGetAzienda="SELECT * FROM azienda where email=?";
}









}