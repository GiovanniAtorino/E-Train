package Bean;

public class Tutor {
	
	String nome,matricola,cognome,email,nomeazienda,nometirocinio,password;
	
	public Tutor() {}
	
	public Tutor(String n,String m,String c,String e,String na,String ntt,String p) {
		this.nome=n;
		this.matricola=m;
		this.cognome=c;
		this.email=e;
		this.nomeazienda=na;
		this.nometirocinio=ntt;
		this.password=p;
	}
	
	public String getNomeT() {return nome;}
	public String getCognomeT() {return cognome;}
	public String getEmailT() {return email;}
	public String getMatricolaT() {return matricola;}
	public String getNomeAT() {return nomeazienda;}
	public String getPasswordT() {return password;}
	public String getNomeTirocinioT() {return nometirocinio;}
	
	public void setNomeT(String n) { this.nome=n;}
	public void setCognomeT(String c) { this.cognome=c;}
	public void setMatricolaT(String m) { this.matricola=m;}
	public void setEmailT(String e) { this.email=e;}
	public void setNomeAT(String u) {this.nomeazienda=u;}
	public void setNomeTT(String ntt) {this.nometirocinio=ntt;}
	public void setPasswordT(String p) {this.password=p;}
	
	
	


}
