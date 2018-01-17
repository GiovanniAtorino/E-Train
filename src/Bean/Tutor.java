package Bean;

public class Tutor {
	
	String nome,matricola,cognome,email,username,password;
	
	public Tutor() {}
	
	public Tutor(String n,String m,String c,String e,String p,String u) {
		this.nome=n;
		this.matricola=m;
		this.cognome=c;
		this.email=e;
		this.username=u;
		this.password=p;
	}
	
	public String getNomeT() {return nome;}
	public String getCognomeT() {return cognome;}
	public String getEmailT() {return email;}
	public String getMatricolaT() {return matricola;}
	public String getUsernameT() {return username;}
	public String getPasswordT() {return password;}
	
	public void setNomeT(String n) { this.nome=n;}
	public void setCognomeT(String c) { this.cognome=c;}
	public void setMatricolaT(String m) { this.matricola=m;}
	public void setEmailT(String e) { this.email=e;}
	public void setUsernameT(String u) {this.username=u;}
	public void setPasswordT(String p) {this.password=p;}
	
	
	


}
