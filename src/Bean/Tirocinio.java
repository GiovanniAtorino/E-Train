package Bean;

public class Tirocinio {

	String nome,descrizione,datainizio,datafine,nomeazienda;
	
	public Tirocinio() {}
	
	public Tirocinio(String n,String d,String di,String df,String na) {
		this.nome=n;
		this.descrizione=d;
		this.datainizio=di;
		this.datafine=df;
		this.nomeazienda=na;
	}
	
	public String getNomeTirocinio() { return nome;}
	public String getDescrizioneTirocinio() { return descrizione;}
	public String getDatainizioTirocinio() { return datainizio;}
	public String getDatafineTirocinio() { return datafine;}
	public String getNomeaziendaTirocinio() { return nomeazienda;}
	
	public void setNomeTirocinio(String n) {this.nome=n;}
	public void setDescrizioneTirocinio(String d) {this.descrizione=d;}
	public void setDatainizioTirocinio(String di) {this.datainizio=di;}
	public void setDatafineTirocinio(String df) {this.datafine=df;}
	public void setNomeaziendaTirocinio(String na) {this.nomeazienda=na;}
}
