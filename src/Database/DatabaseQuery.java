package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Bean.Azienda;

import Bean.FileP;
import Bean.Presenza;
import Bean.RichiestaStudente;
import Bean.Segreteria;
import Bean.Studente;
import Bean.Tirocinio;
import Bean.Tutor;

public class DatabaseQuery {
	 static ArrayList<Studente> stu=new ArrayList<>();
		ArrayList<Tirocinio> tir=new ArrayList<>();

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
	private static String queryAdd_Presenza;
	private static String queryGetNomeAzienda;
	private static String queryGetTirocinioFromNome;
	private static String queryGetNomeTirocinio;
	private static String queryGetAziendaFromTirocinio;
	private static String queryGetAziendaByTirocinio;
	private static String queryAddRichiestaStudente;
	private static String queryGetRichiestaStudenteT;
	private static String queryRicercaStudente;
	private static String queryGetTirocinioFromStudente;
	private static String queyAddFile;
	private static String queryGetFile;
	private static String queryGetStudenteTutor;
	private static String queryGetAziendaTutor;
	private static String queryUpdateStudenteRichiesta;
	private static String queryGetTutorStudente;
	private static String queryGetNomeTirociniobyma;
	private static String queryAddTutorStudente;
	private static String queryGetStudenteTutorStud;
	private static String queryGetTutorAll;
	private static String queryGetPresenzaAll;
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
				studente.setMatricola(rs.getString("matricola"));
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
			psAddTutor.setString(7, t.getNomeTirocinioT());
			

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
			preparedStatement = connection.prepareStatement(queryGetTutor);
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
				tutor.setNomeTT(rs.getString("nome_tirocineo"));
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
		try {
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement(queryGetTirocinioAccettato);
			
           
			ResultSet rs = preparedStatement.executeQuery();

			connection.commit();

			while (rs.next()) {
				 Tirocinio t = new Tirocinio();
				 t.setNomeTirocinio(rs.getString("nome"));
					t.setDescrizioneTirocinio(rs.getString("descrizione"));
					t.setDatainizioTirocinio(rs.getString("data_inizio"));
			
					t.setDatafineTirocinio(rs.getString("data_fine"));
					t.setNomeaziendaTirocinio(rs.getString("nome_azienda"));
				
					tir.add(t);
				
			
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
	
	public synchronized static boolean addPresenza(Presenza pre) throws SQLException{
		Connection connection = null;
		PreparedStatement psAddUtente = null;

		try{
			connection = Database.getConnection();
			psAddUtente = connection.prepareStatement(queryAdd_Presenza);
			psAddUtente.setString(1, pre.getMatricolaP());
			psAddUtente.setString(2, pre.getData());
			psAddUtente.setString(3, pre.getOraInzio());
			psAddUtente.setString(4, pre.getOrafine());
		
			
			
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
	
	public synchronized static String GetNomeAzienda(String nomeS) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
         String nomeAzienda = null;
		

		
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement(queryGetNomeAzienda);
			preparedStatement.setString(1, nomeS);
			ResultSet rs = preparedStatement.executeQuery();

			connection.commit();

			while (rs.next()) {
				nomeAzienda=rs.getString("nome_azienda");
				
				
			
		}
		System.out.println("nome az" +nomeAzienda);
			return nomeAzienda;
	}
	
	public synchronized static ArrayList GetTirocinioFromNome(String nome) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
        ArrayList<Tirocinio> tir=new ArrayList<>();
		Tirocinio t = new Tirocinio();

		try {
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement(queryGetTirocinioFromNome);
			preparedStatement.setString(1, nome);

			ResultSet rs = preparedStatement.executeQuery();

			connection.commit();

			while (rs.next()) {
				
				t.setNomeTirocinio(rs.getString("nome"));
				t.setDescrizioneTirocinio(rs.getString("descrizione"));
				t.setDatainizioTirocinio(rs.getString("data_inizio"));
			
				t.setDatafineTirocinio(rs.getString("data_fine"));
				t.setNomeaziendaTirocinio(rs.getString("nome_azienda"));
				
				tir.add(t);
			
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
	
	public synchronized static String GetNomeTirocinio(String nomeS) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
         String nomet = null;
		

		
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement(queryGetNomeTirocinio);
			preparedStatement.setString(1, nomeS);
			ResultSet rs = preparedStatement.executeQuery();

			connection.commit();

			while (rs.next()) {
				nomet=rs.getString("nome_tirocineo");
				
				
			
		}
		
			return nomet;
	}
	
	
	public synchronized static Azienda getAziendaByTirocinio(String nomet) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Azienda azienda = new Azienda();

		try {
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement(queryGetAziendaFromTirocinio);
			preparedStatement.setString(1, nomet);

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
	
	public synchronized static Azienda queryGetAziendaByTirocinio() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Azienda azienda = new Azienda();

		try {
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement(queryGetAziendaByTirocinio);
		

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
	
	public synchronized static boolean addRichiestaStudente(String matr,String na,String nt,String n,String c) throws SQLException{
		Connection connection = null;
		PreparedStatement psAddUtente = null;

		try{
			connection = Database.getConnection();
			psAddUtente = connection.prepareStatement(queryAddRichiestaStudente);
			psAddUtente.setString(1, matr);
			psAddUtente.setString(2, na);
			psAddUtente.setString(3, nt);
			psAddUtente.setString(4, n);
			psAddUtente.setString(5, c);
			
			
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
	
	public synchronized static void updateStudente(String nomeA, String nomeT, String matricola) throws SQLException {
		Connection connection = null;
		PreparedStatement psAddUtente = null;

		try{
			connection = Database.getConnection();
			
			psAddUtente = connection.prepareStatement(queryUpdateStudenteRichiesta);
			
			psAddUtente.setString(1, nomeA);
			psAddUtente.setString(2, nomeT);
			psAddUtente.setString(3, matricola);
			
			
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
	}

	public synchronized static ArrayList queryGetRichiestaStudenteT(String nomea) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
        ArrayList<Studente> rss=new ArrayList<>();
		Studente studente = new Studente();

		
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement(queryGetRichiestaStudenteT);
			preparedStatement.setString(1, nomea);

			ResultSet rs = preparedStatement.executeQuery();

			connection.commit();

			while (rs.next()) {
				studente.setMatricola(rs.getString("matricola"));
				studente.setEmail(rs.getString("email"));
				studente.setNome(rs.getString("nome"));
				studente.setCognome(rs.getString("cognome"));
				studente.setPassword(rs.getString("password"));
			
				studente.setDipartimento(rs.getString("dipartimento"));
				
				rss.add(studente);
			}
		
	
			return rss;
		}
	
	public synchronized static ArrayList RicercaStudente(String nomes,String cognomes) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
        ArrayList<Studente> rss=new ArrayList<>();
		Studente studente = new Studente();

		
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement(queryRicercaStudente);
			preparedStatement.setString(1, nomes);
			preparedStatement.setString(2, cognomes);

			ResultSet rs = preparedStatement.executeQuery();

			connection.commit();

			while (rs.next()) {
				studente.setMatricola(rs.getString("matricola"));
				studente.setEmail(rs.getString("email"));
				studente.setNome(rs.getString("nome"));
				studente.setCognome(rs.getString("cognome"));
				studente.setPassword(rs.getString("password"));
			
				studente.setDipartimento(rs.getString("dipartimento"));
				
				rss.add(studente);
			}
		
	
			return rss;
		}
	
	public synchronized static ArrayList GetTirocinioFromStudente(String nome) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
        ArrayList<Tirocinio> tir=new ArrayList<>();
		Tirocinio t = new Tirocinio();

		try {
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement(queryGetTirocinioFromStudente);
			preparedStatement.setString(1, nome);

			ResultSet rs = preparedStatement.executeQuery();

			connection.commit();

			while (rs.next()) {
				
				t.setNomeTirocinio(rs.getString("nome"));
				t.setDescrizioneTirocinio(rs.getString("descrizione"));
				t.setDatainizioTirocinio(rs.getString("data_inizio"));
			
				t.setDatafineTirocinio(rs.getString("data_fine"));
				t.setNomeaziendaTirocinio(rs.getString("nome_azienda"));
				
				tir.add(t);
			
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
	public synchronized static boolean addFile(String path,String nome) throws SQLException{
		Connection connection = null;
		PreparedStatement psAddUtente = null;

		try{
			connection = Database.getConnection();
			psAddUtente = connection.prepareStatement(queyAddFile);
			psAddUtente.setString(1, path);
			psAddUtente.setString(2, nome);
			
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
	
	public synchronized static ArrayList<FileP> getFile() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
        ArrayList<FileP> f=new ArrayList<>();
		

		try {
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement(queryGetFile);
		

			ResultSet rs = preparedStatement.executeQuery();

			connection.commit();

			while (rs.next()) {
				FileP fi=new FileP();
			    fi.setNomeF(rs.getString("nome_file"));
			    fi.setDescrizioneF(rs.getString("descrizione_file"));
				fi.setPathF(rs.getString("pathfile"));
				
				f.add(fi);
				
			}} finally {
				try{
					if(preparedStatement != null)
						preparedStatement.close();
				} finally {
					Database.releaseConnection(connection);
				}} return f;
			}
	
	public synchronized static ArrayList GetStudenteTutor(String nomet) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
        ArrayList<Studente> rss=new ArrayList<>();
		

		
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement(queryGetRichiestaStudenteT);
			
			preparedStatement.setString(1, nomet);

			ResultSet rs = preparedStatement.executeQuery();

			connection.commit();

			while (rs.next()) {
				Studente studente = new Studente();
				studente.setMatricola(rs.getString("matricola"));
				studente.setEmail(rs.getString("email"));
				studente.setNome(rs.getString("nome"));
				studente.setCognome(rs.getString("cognome"));
				studente.setPassword(rs.getString("password"));
			
				studente.setDipartimento(rs.getString("dipartimento"));
				
				rss.add(studente);
			}
		
	
			return rss;
		}
	
	public synchronized static ArrayList GetTutorStudente(String nomet) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
        ArrayList<Tutor> ta=new ArrayList<>();
		

		
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement(queryGetTutorStudente);
			
			preparedStatement.setString(1, nomet);

			ResultSet rs = preparedStatement.executeQuery();

			connection.commit();

			while (rs.next()) {
				Tutor t = new Tutor();
				t.setNomeT(rs.getString("nome"));
				t.setCognomeT(rs.getString("cognome"));
				t.setEmailT(rs.getString("email"));
				t.setNomeAT(rs.getString("nome_azienda"));
				ta.add(t);
			}
		
	
			return ta;
		}
	
	public synchronized static String GetNomeTirocinioByM(String mat) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
         String nomet = null;
		

		
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement(queryGetNomeTirociniobyma);
			preparedStatement.setString(1, mat);
			ResultSet rs = preparedStatement.executeQuery();

			connection.commit();

			while (rs.next()) {
				nomet=rs.getString("nome_tirocineo");
				
				
			
		}
		
			return nomet;
	}
	
	
	public static boolean addTutorStudente(String ms,String mt) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement psAddAzienda = null;
        
		try{
			connection = Database.getConnection();
			psAddAzienda = connection.prepareStatement(queryAddTutorStudente);
			psAddAzienda.setString(1, ms);
			psAddAzienda.setString(2, mt);
			
		
		
			

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
	
	public synchronized static ArrayList GetStudenteTutorStud(String m) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
        ArrayList<Studente> rss=new ArrayList<>();
		

		
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement(queryGetStudenteTutorStud);
			
			preparedStatement.setString(1, m);

			ResultSet rs = preparedStatement.executeQuery();

			connection.commit();

			while (rs.next()) {
				Studente studente = new Studente();
				studente.setMatricola(rs.getString("matricola"));
				studente.setEmail(rs.getString("email"));
				studente.setNome(rs.getString("nome"));
				studente.setCognome(rs.getString("cognome"));
				studente.setPassword(rs.getString("password"));
			
				studente.setDipartimento(rs.getString("dipartimento"));
				
				rss.add(studente);
			}
		
	
			return rss;
		}
	
	public synchronized static ArrayList getTutorAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

	ArrayList<Tutor> ta=new ArrayList<>();

	
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement(queryGetTutorAll);
			

			ResultSet rs = preparedStatement.executeQuery();

			connection.commit();

			while (rs.next()) {
				Tutor tutor = new Tutor();
				tutor.setEmailT(rs.getString("email"));
				tutor.setNomeT(rs.getString("nome"));
				tutor.setCognomeT(rs.getString("cognome"));
				tutor.setPasswordT(rs.getString("password"));
			
				tutor.setMatricolaT(rs.getString("matricola_tutor"));
				tutor.setNomeAT(rs.getString("nome_azienda"));
				tutor.setNomeTT(rs.getString("nome_tirocineo"));
				ta.add(tutor);
			}
		
			return ta;
	}
	
	public synchronized static ArrayList getPresenzaAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

	ArrayList<Presenza> p=new ArrayList<>();

	
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement(queryGetPresenzaAll);
			

			ResultSet rs = preparedStatement.executeQuery();

			connection.commit();

			while (rs.next()) {
				Presenza pr = new Presenza();
				pr.setMatricolaP(rs.getString("matricola_studente"));
				pr.setData(rs.getString("data"));
				pr.setOraInizio(rs.getString("ora_inizio"));
				pr.setOraFine(rs.getString("ora_fine"));
				p.add(pr);
			}
		
			return p;
	}
	
	static {
		queryAdd_Studente = "INSERT INTO studente1 (matricola, nome, cognome,  email,password,dipartimento) VALUES (?,?,?,?,?,?);";
		queryGetStudente = "SELECT * FROM studente1 WHERE email=?";
		queryAddAzienda="INSERT INTO azienda(nome,sede,email,password) values (?,?,?,?);";
		queryGetAzienda="SELECT * FROM azienda where email=?";
		queryAdd_Tutor = "INSERT INTO tutor (matricola_tutor, nome, cognome,  email,password,nome_azienda,nome_tirocineo) VALUES (?,?,?,?,?,?,?);";
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
		queryAdd_Presenza = "INSERT INTO presenza (matricola_studente, data,ora_inizio,  ora_fine,firmato) VALUES (?,?,?,?,'si');";
		queryGetNomeAzienda="select nome_azienda from studente1 where nome=? and accettato='si';";
		queryGetNomeTirocinio="select nome_tirocineo from studente1 where nome=? and accettato='si';";
		queryGetTirocinioFromNome="SELECT * FROM tirocineo WHERE nome=?;";
		queryGetAziendaFromTirocinio="SELECT * FROM azienda where nome_tirocineo=?";
		queryGetAziendaByTirocinio="select azienda.* from azienda,tirocineo where azienda.nome=tirocineo.nome_azienda and accettata='si';";
		queryAddRichiestaStudente="insert into richiesta_studente(matricola_studente,nome_azienda,nome_tirocinio,nome_studente,cognome_studente) values(?,?,?,?,?);";
		queryUpdateStudenteRichiesta = "update studente1 set nome_azienda = ?, nome_tirocineo = ? WHERE matricola = ?";
		queryGetRichiestaStudenteT=" select studente1.*  from studente1,richiesta_studente where studente1.nome=richiesta_studente.nome_studente and accettato='no' and studente1.nome_azienda=?;";
	    queryRicercaStudente="select * from studente1 where nome=? and cognome=?; ";
	    queryGetTirocinioFromStudente="select tirocineo.* from tirocineo,studente1 where tirocineo.nome=studente1.nome_tirocineo and studente1.accettato='si' and studente1.nome=?;";
	    queyAddFile="insert into file(pathfile,nome_file) values(?,?);";
	    queryGetFile="select * from file;";
	    queryGetStudenteTutor="select studente1.* from studente1, tutor where studente1.nome_tirocineo=?;";
	    queryGetTutorStudente="select * from tutor where nome_tirocineo=?;";
	     queryGetNomeTirociniobyma="select nome_tirocineo from studente1 where matricola=? and accettato='si';";
	     queryAddTutorStudente="insert into tutor_studente(matr_stud,matr_tutor) values(?,?);";
	     queryGetStudenteTutorStud="select studente1.* from studente1,tutor_studente where tutor_studente.matr_stud=studente1.matricola and tutor_studente.matr_tutor=?;";
         queryGetTutorAll="select * from tutor;";
         queryGetPresenzaAll="select * from prenseza where firmato='si';";
	}


	


	






}