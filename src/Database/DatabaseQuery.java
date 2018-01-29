package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Bean.Azienda;
import Bean.Segreteria;
import Bean.Studente;
import Bean.Tirocinio;
import Bean.Tutor;

public class DatabaseQuery {
	 static ArrayList<Studente> stu=new ArrayList<>();

	private static String queryAdd_Studente;
	private static String queryGetStudente;
    private static String queryAddAzienda;
    private static String queryGetAzienda;
	private static String queryAdd_Tutor;
	private static String queryGetTutor;
	private static String queryAdd_Segreteria;
	private static String queryGetSegreteria;
	private static String queryAdd_Tirocinio;
	private static String queryGetRichiestaTirocinio;
	private static String queryAccettaTirocinio;
	private static String queryRifiutaTirocinio;
	private static String queryGetTirocinioAccettato;
	private static String queryAddRichiestaTirocinioStudente;
	private static String queryGetRichiestaTirocinioStudente;
	private static String queryAccettaStudenteTirocinio;
	private static String queryRifiutaStudenteTirocinio;
	
	
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
	
	public synchronized static Segreteria getSegreteriaByEmail(String email) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Segreteria seg = new Segreteria();

		try {
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement(queryGetSegreteria);
			preparedStatement.setString(1, email);

			ResultSet rs = preparedStatement.executeQuery();

			connection.commit();

			while (rs.next()) {
				seg.setEmailS(rs.getString("email"));
				seg.setNomeS(rs.getString("nome"));
				seg.setDipartimentoS(rs.getString("dipartimento"));
				seg.setPasswordS(rs.getString("password"));
			
				seg.setFacS(rs.getString("facolta"));
				seg.setNumTS(rs.getString("num_telefono"));
				
			}
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				Database.releaseConnection(connection);
			}
		}
		if (seg.getEmailS() == null)
			return null;
		else
			return seg;
	}
	
	public synchronized static boolean addRichiestaTirocinio(Tirocinio tirocinio) throws SQLException{
		Connection connection = null;
		PreparedStatement psAddUtente = null;

		try{
			connection = Database.getConnection();
			psAddUtente = connection.prepareStatement(queryAdd_Tirocinio);
			psAddUtente.setString(1, tirocinio.getNomeTirocinio());
			psAddUtente.setString(2, tirocinio.getDescrizioneTirocinio());
			psAddUtente.setString(3, tirocinio.getDatainizioTirocinio());
			psAddUtente.setString(4, tirocinio.getDatafineTirocinio());
		
			psAddUtente.setString(5, tirocinio.getNomeaziendaTirocinio());
			
			
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
	
	public synchronized static ArrayList queryGetRichiestaTirocinio() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
        ArrayList<Tirocinio> tir=new ArrayList<>();
		Tirocinio t = new Tirocinio();

		try {
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement(queryGetRichiestaTirocinio);
			

			ResultSet rs = preparedStatement.executeQuery();

			connection.commit();

			while (rs.next()) {
				
				t.setNomeTirocinio(rs.getString("nome"));
				t.setDescrizioneTirocinio(rs.getString("descrizione"));
				t.setDatainizioTirocinio(rs.getString("data_inizio"));
			
				t.setDatafineTirocinio(rs.getString("data_fine"));
				t.setNomeaziendaTirocinio(rs.getString("nome_azienda"));
				
				tir.add(t);
			System.out.println("Database rich tir:" +tir.get(0).getNomeTirocinio());
			}
		
	} finally {
		try {
			if (preparedStatement != null)
				preparedStatement.close();
		} finally {
			Database.releaseConnection(connection);
		}
	}
	return tir;
}

	public synchronized static boolean queryAccettaTirocinio(String nomet) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement(queryAccettaTirocinio);
			preparedStatement.setString(1, nomet);

			 preparedStatement.executeUpdate();

			connection.commit();

			
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				Database.releaseConnection(connection);
			}
		}
		return true;
	
	}
	
	public synchronized static boolean queryRifiutaTirocinio(String nomet) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		

		try {
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement(queryRifiutaTirocinio);
			preparedStatement.setString(1, nomet);

			 preparedStatement.executeUpdate();

			connection.commit();

			
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				Database.releaseConnection(connection);
			}
		}
		return true;
	
	}
	public synchronized static ArrayList queryGetTirocinioAccettato() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
        ArrayList<Tirocinio> tir=new ArrayList<>();
		Tirocinio t = new Tirocinio();

		try {
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement(queryGetTirocinioAccettato);
			

			ResultSet rs = preparedStatement.executeQuery();

			connection.commit();

			while (rs.next()) {
				
				t.setNomeTirocinio(rs.getString("nome"));
				t.setDescrizioneTirocinio(rs.getString("descrizione"));
				t.setDatainizioTirocinio(rs.getString("data_inizio"));
			
				t.setDatafineTirocinio(rs.getString("data_fine"));
				t.setNomeaziendaTirocinio(rs.getString("nome_azienda"));
				
				tir.add(t);
			System.out.println("Database rich tir:" +tir.get(0).getNomeTirocinio());
			}
		
	} finally {
		try {
			if (preparedStatement != null)
				preparedStatement.close();
		} finally {
			Database.releaseConnection(connection);
		}
	}
	return tir;
}
	
	public synchronized static boolean queryAddRichiestaTirocinioStudenteSetNT(String nomeS,String nomeT) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
        System.out.println("nome tirocinio" +nomeT);
        System.out.println("nome nome tirocinio" +nomeS);
		try {
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement("update studente1 set nome_tirocineo="+nomeT+" where nome="+nomeS+";");
			 System.out.println("nome tirocinio" +nomeT);
		        System.out.println("nome nome tirocinio" +nomeS);
			 preparedStatement.executeUpdate();

			connection.commit();

			
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				Database.releaseConnection(connection);
			}
		}
		return true;
	
	}
	
	public synchronized static boolean queryAddRichiestaTirocinioStudenteSetNA(String nomeS,String nomeA) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
        
		try {
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement("update studente1 set nome_azienda="+nomeA+" where nome="+nomeS+";");
			 System.out.println("nome tirocinio" +nomeA);
		        System.out.println("nome nome tirocinio" +nomeS);
			 preparedStatement.executeUpdate();

			connection.commit();

			
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				Database.releaseConnection(connection);
			}
		}
		return true;
	
	}
	
	
	public synchronized static ArrayList GetRichiestaTirocinioStudente(String nomeA) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
       
		Studente studente = new Studente();

		try {
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement(queryGetRichiestaTirocinioStudente);
			preparedStatement.setString(1, nomeA);

			ResultSet rs = preparedStatement.executeQuery();

			connection.commit();

			while (rs.next()) {
				studente.setEmail(rs.getString("email"));
				studente.setNome(rs.getString("nome"));
				studente.setCognome(rs.getString("cognome"));
				studente.setPassword(rs.getString("password"));
				studente.setMatricola(rs.getString("matricola"));
				studente.setDipartimento(rs.getString("dipartimento"));
				
				stu.add(studente);
			
			}
		
	} finally {
		try {
			if (preparedStatement != null)
				preparedStatement.close();
		} finally {
			Database.releaseConnection(connection);
		}
	}
	return stu;
}
	
	public synchronized static boolean AccettaStudenteTirocinio(String nomeS) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement(queryAccettaStudenteTirocinio);
			preparedStatement.setString(1, nomeS);

			 preparedStatement.executeUpdate();

			connection.commit();

			
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				Database.releaseConnection(connection);
			}
		}
		return true;
	
	}
	
	public synchronized static boolean RifiutaStudenteTirocinio(String nomeS) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement(queryRifiutaStudenteTirocinio);
			preparedStatement.setString(1, nomeS);

			 preparedStatement.executeUpdate();

			connection.commit();

			
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				Database.releaseConnection(connection);
			}
		}
		return true;
	
	}
	
	
	static {
		queryAdd_Studente = "INSERT INTO studente1 (matricola, nome, cognome,  email,password,dipartimento) VALUES (?,?,?,?,?,?);";
		queryGetStudente = "SELECT * FROM studente1 WHERE email=?";
		queryAddAzienda="INSERT INTO azienda(nome,sede,email,password) values (?,?,?,?);";
		queryGetAzienda="SELECT * FROM azienda where email=?";
		queryAdd_Tutor = "INSERT INTO tutor (matricola_tutor, nome, cognome,  email,password,nome_azienda) VALUES (?,?,?,?,?,?);";
		queryGetTutor = "SELECT * FROM tutor WHERE email=?";
		queryAdd_Segreteria = "INSERT INTO segreteria (nome, dipartimento,facolta,  email,password,num_telefono) VALUES (?,?,?,?,?,?);";
		queryGetSegreteria = "SELECT * FROM segreteria WHERE email=?";
		queryAdd_Tirocinio = "INSERT INTO tirocineo (nome, descrizione,data_inizio, data_fine,nome_azienda) VALUES (?,?,?,?,?);";
		queryGetRichiestaTirocinio = "SELECT * FROM tirocineo WHERE accettata='no'";
		queryAccettaTirocinio="update tirocineo set accettata='si' where nome=?;";
		queryRifiutaTirocinio="update tirocineo set accettata='no' where nome=?;";
		queryGetTirocinioAccettato = "SELECT * FROM tirocineo WHERE accettata='si'";
		queryGetRichiestaTirocinioStudente="select * from studente1 where nome_azienda=? and accettato='no'";
		queryAccettaStudenteTirocinio="update studente1 set accettato='si' where nome=?;";
		queryRifiutaStudenteTirocinio="update studente1 set accettato='no' where nome=?;";
	}


	


	






}