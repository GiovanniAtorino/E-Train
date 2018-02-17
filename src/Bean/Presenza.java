package Bean;

public class Presenza {
	
	String matricola,data,ora_inizio,ora_fine;
	
	public Presenza(String m,String d,String oi,String of) {
		matricola=m;d=data;ora_inizio=oi;ora_fine=of;
	}
	
	public Presenza() {
		// TODO Auto-generated constructor stub
	}

	public String getMatricolaP() {return matricola;}
	public String getData() {return data;}
	public String getOraInzio() {return ora_inizio;}
	public String getOrafine() {return ora_fine;}	
	
	public void setMatricolaP(String m) { matricola=m;}
	public void setData(String d) { data=d;}
	public void setOraInizio(String oi) { ora_inizio=oi;}
	public void setOraFine(String of) { ora_fine=of;}
}
