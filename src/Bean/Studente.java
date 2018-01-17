package Bean;


public class Studente {
	
	private String email;
	private String Nome;
	private String Cognome;
    private String matricola;
	private String username;
	private String dipartimento;
	
	private String universita;
	private String password;

	public Studente () {}
	
	public Studente(String m,String nome, String cognome, String mail,  
			String p,String d) {
		super();
		this.email = mail;
		this.Nome = nome;
		this.Cognome = cognome;
		
	    this.matricola=m;
	    this.dipartimento=d;
		this.password=p;
	}


	

	

	public String getEmail() {
		return email;
	}
	public String getMatricola() {
		return matricola;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCognome() {
		return Cognome;
	}

	public void setCognome(String cognome) {
		Cognome = cognome;
	}

	public String getusername() {
		return username;
	}

	
	
	public String getDipartimento(){
		return dipartimento;
	}
	
	public void setUsername(String u){
		this.username = u;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String p){
		this.password = p;
	}
	public void setDipartimento(String d) {
		this.dipartimento=d;
	}
	public void setMatricola(String m) {
		this.matricola=m;
	}
	
}