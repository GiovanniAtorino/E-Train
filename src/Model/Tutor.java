package Model;

public class Tutor {
	
	public Tutor() {
		this.username = "";
		this.nome = "";
		this.cognome = "";
		this.tipo = "";
		this.company = "";
		this.indirizzo = "";
		this.telefono = "";
		this.fax = "";
		this.email = "";
		this.citta = "";
		this.sitoweb = "";
		this.chisono = "";
		this.immagine_profilo = "";
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getSitoweb() {
		return sitoweb;
	}
	public void setSitoweb(String sitoweb) {
		this.sitoweb = sitoweb;
	}

	public String getChisono() {
		return chisono;
	}
	public void setChisono(String chisono) {
		this.chisono = chisono;
	}

	public String getImmagine_profilo() {
		return immagine_profilo;
	}
	public void setImmagine_profilo(String immagine_profilo) {
		this.immagine_profilo = immagine_profilo;
	}

	private String username;
	private String nome;
	private String cognome;
	private String tipo;
	private String company;
	private String indirizzo;
	private String telefono;
	private String fax;
	private String email;
	private String psw;
	private String citta;
	private String sitoweb;
	private String chisono;
	private String immagine_profilo;
}
