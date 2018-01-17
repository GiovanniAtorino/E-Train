package Bean;

public class Azienda {
    
	String nome,sede;
	
	public Azienda() {}
	
	public Azienda(String n,String s) {
		this.nome=n;
		this.sede=s;
	}
	
	public String getNomeA() {return nome;}
	public String getSedeA() {return sede;}
    public void setNomeA(String n) { this.nome=n;}
    public void setSedeA(String s) {this.sede=s;}
}
