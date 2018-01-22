package Bean;

public class Azienda {
    
	String nome,sede,email,password;
	
	public Azienda() {}
	
	public Azienda(String n,String s,String e,String p) {
		this.nome=n;
		this.sede=s;
		this.email=e;
		this.password=p;
	}
	
	public String getNomeA() {return nome;}
	public String getSedeA() {return sede;}
    public void setNomeA(String n) { this.nome=n;}
    public void setSedeA(String s) {this.sede=s;}
    public String getEmailA() {return email;}
    public void setEmailA(String e) {this.email=e;}
    public String getPassA() {return password;}
    public void setPasswordA(String p) {this.password=p;}
    }

