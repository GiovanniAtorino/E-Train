package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Bean.Azienda;
import Bean.Segreteria;
import Bean.Studente;
import Bean.Tutor;

public class DatabaseQuery {

	private static String queryAdd_Studente;
	private static String queryGetStudente;
    private static String queryAddAzienda;
    private static String queryGetAzienda;
	private static String queryAdd_Tutor;
	private static String queryGetTutor;
	private static String queryAdd_Segreteria;
	
	
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
	
	public static boolean addTutor(Tutor t) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement psAddTutor = null;
        
		try{
			connection = Database.getConnection();
			psAddTutor = connection.prepareStatement(queryAdd_Tutor);
			psAddTutor.setString(1, t.getMatricolaT());
			psAddTutor.setString(2, t.getNomeT());
			psAddTutor.setString(3, t.getCognomeT());
			psAddTutor.setString(4, t.getEmailT());
			psAddTutor.setString(5, t.getPasswordT());
			psAddTutor.setString(6, t.getNomeAT());
		
			

			psAddTutor.executeUpdate();

			connection.commit();
			System.out.println("GU Connessione...");
		} finally {
			try{
				if(psAddTutor != null)
					psAddTutor.close();
			} finally {
				Database.releaseConnection(connection);
			}
		}

		return true;}
	public synchronized static Tutor getTutorByEmail(String email) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Tutor tutor = new Tutor();

		try {
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement(queryGetStudente);
			preparedStatement.setString(1, email);

			ResultSet rs = preparedStatement.executeQuery();

			connection.commit();

			while (rs.next()) {
				tutor.setEmailT(rs.getString("email"));
				tutor.setNomeT(rs.getString("nome"));
				tutor.setCognomeT(rs.getString("cognome"));
				tutor.setPasswordT(rs.getString("password"));
			
				tutor.setMatricolaT(rs.getString("matricola_tutor"));
				tutor.setNomeAT(rs.getString("nome_azienda"));
				
			}
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				Database.releaseConnection(connection);
			}
		}
		if (tutor.getEmailT() == null)
			return null;
		else
			return tutor;
	}
	
	public synchronized static boolean addSegreteria(Segreteria segreteria) throws SQLException{
		Connection connection = null;
		PreparedStatement psAddUtente = null;

		try{
			connection = Database.getConnection();
			psAddUtente = connection.prepareStatement(queryAdd_Segreteria);
			psAddUtente.setString(1, segreteria.getNomeS());
			psAddUtente.setString(2, segreteria.getDipartimentoS());
			psAddUtente.setString(3, segreteria.getFacS());
			psAddUtente.setString(4, segreteria.getEmailS());
		
			psAddUtente.setString(5, segreteria.getPassS());
			psAddUtente.setString(6, segreteria.getNumTS());
			
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
	
	static {
		queryAdd_Studente = "INSERT INTO studente (matricola, nome, cognome,  email,password,dipartimento) VALUES (?,?,?,?,?,?);";
		queryGetStudente = "SELECT * FROM studente WHERE email=?";
		queryAddAzienda="INSERT INTO azienda(nome,sede,email,password) values (?,?,?,?);";
		queryGetAzienda="SELECT * FROM azienda where email=?";
		queryAdd_Tutor = "INSERT INTO tutor (matricola_tutor, nome, cognome,  email,password,nome_azienda) VALUES (?,?,?,?,?,?);";
		queryGetTutor = "SELECT * FROM tutor WHERE email=?";
		queryAdd_Segreteria = "INSERT INTO segreteria (nome, dipartimento,facolta,  email,password,numero_telefono) VALUES (?,?,?,?,?,?);";
}


	









}