package Bean;

public class Presenza {
	
	String matricola,data,ora_inizio,ora_fine,nometirocinio;
	
	public Presenza(String m,String d,String oi,String of,String nomet) {
		matricola=m;d=data;ora_inizio=oi;ora_fine=of;nometirocinio=nomet;
	}
	
	public Presenza() {
		// TODO Auto-generated constructor stub
	}

	public String getMatricolaP() {return matricola;}
	public String getData() {return data;}
	public String getOraInzio() {return ora_inizio;}
	public String getOrafine() {return ora_fine;}	
	public String getNometP() {return nometirocinio;}	
	
	public void setMatricolaP(String m) { matricola=m;}
	public void setData(String d) { data=d;}
	public void setOraInizio(String oi) { ora_inizio=oi;}
	public void setOraFine(String of) { ora_fine=of;}
	public void setNomeTP(String nt) { nometirocinio=nt;}
}
