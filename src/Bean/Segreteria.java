package Bean;

public class Segreteria {
    
	String nome,dipartimento,facolta,email,password,numerotelefono;
	
	public Segreteria() {}
	
	public Segreteria(String n,String d,String f,String nt,String e,String p) {
		this.nome=n;
		this.dipartimento=d;
		this.facolta=f;
		this.numerotelefono=nt;
		this.email=e;
		this.password=p;
	}
	
	public String getNomeS() {return nome;}
	public String getDipartimentoS() {return dipartimento;}
    public void setNomeS(String n) { this.nome=n;}
    public void setDipartimentoS(String s) {this.dipartimento=s;}
    public String getEmailS() {return email;}
    public void setEmailS(String e) {this.email=e;}
    public String getPassS() {return password;}
    public void setPasswordS(String p) {this.password=p;}
    public String getFacS() {return facolta;}
    public void setFacS(String f) {this.facolta=f;}
    public String getNumTS() {return numerotelefono;}
    public void setNumTS(String p) {this.numerotelefono=p;}
    }

