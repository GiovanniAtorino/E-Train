package Model;

public class Studente {
	
	public Studente() {
		this.matricola = "";
		this.nome = "";
		this.cognome = "";
		this.email = "";
		this.username = "";
		this.linkedin = "";
		this.link_curriculum = "";
	}
	
	public String getMatricola() {
		return matricola;
	}
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public String getLink_curriculum() {
		return link_curriculum;
	}

	public void setLink_curriculum(String link_curriculum) {
		this.link_curriculum = link_curriculum;
	}

	private String matricola;
	private String nome;
	private String cognome;
	private String email;
	private String username;
	private String psw;
	private String linkedin;
	private String link_curriculum;
}
