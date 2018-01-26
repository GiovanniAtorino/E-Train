package Model;

public class Tirocinio {
	
	public Tirocinio() {
		this.id = -1;
		this.stato = "";
		this.tipo = "";
		this.matricola_studente = "";
		this.segreteria_username = "";
		this.tutor_username = "";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStato() {
		return stato;
	}
	public void setStato(String stato) {
		this.stato = stato;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getMatricola_studente() {
		return matricola_studente;
	}
	public void setMatricola_studente(String matricola_studente) {
		this.matricola_studente = matricola_studente;
	}
	public String getSegreteria_username() {
		return segreteria_username;
	}
	public void setSegreteria_username(String segreteria_username) {
		this.segreteria_username = segreteria_username;
	}
	public String getTutor_username() {
		return tutor_username;
	}
	public void setTutor_username(String tutor_username) {
		this.tutor_username = tutor_username;
	}
	
	public String getNomeCognome() {
		return NomeCognome;
	}
	public void setNomeCognome(String nomeCognome) {
		NomeCognome = nomeCognome;
	}

	public String getTipoTutorProfessore() {
		return TipoTutorProfessore;
	}
	public void setTipoTutorProfessore(String tipoTutorProfessore) {
		TipoTutorProfessore = tipoTutorProfessore;
	}
	
	public String getStudent_usename() {
		return student_usename;
	}
	public void setStudent_usename(String student_usename) {
		this.student_usename = student_usename;
	}

	public String getStudent_email() {
		return student_email;
	}
	public void setStudent_email(String student_email) {
		this.student_email = student_email;
	}

	public String getNomeCognomeStudent() {
		return NomeCognomeStudent;
	}
	public void setNomeCognomeStudent(String nomeCognomeStudent) {
		NomeCognomeStudent = nomeCognomeStudent;
	}


	private int id;
	private String stato;
	private String tipo;
	private String matricola_studente;
	private String segreteria_username;
	private String tutor_username;
	private String NomeCognome;
	private String TipoTutorProfessore;
	private String NomeCognomeStudent;
	private String student_usename;
	private String student_email;
	
}
