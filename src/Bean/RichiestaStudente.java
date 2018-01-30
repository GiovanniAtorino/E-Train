package Bean;

public class RichiestaStudente {
	
	String matr,nome,cognome,nome_azienda,nome_tirocinio;
	
	public RichiestaStudente() {}
	public RichiestaStudente(String m,String n,String c,String na,String nt) {
		matr=m;nome=n;cognome=c;nome_azienda=na;nome_tirocinio=nt;
	}

	public String getMatricolaR() {
		return matr;
	}
  public void setMatricolaR(String m) {matr=m;}

	

	public String getNomeR() {
		return nome;
	}

	public void setNomeR(String n) {
		nome = n;
	}

	public String getCognomeR() {
		return cognome;
	}

	public void setCognomeR(String c) {
		cognome = c;
	}
	
	public String getNomeAR() {return nome_azienda;}
	public void setNomeAR(String na) { nome_azienda=na;}
	public String getNomeTR() {return nome_tirocinio;}
	public void setNomeTR(String nt) { nome_tirocinio=nt;}
	
}
