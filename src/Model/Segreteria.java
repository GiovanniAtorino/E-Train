package Model;

public class Segreteria {
	
	public Segreteria() {
		this.username = "";
		this.email = "";
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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

	private String username;
	private String email;
	private String psw;
}
