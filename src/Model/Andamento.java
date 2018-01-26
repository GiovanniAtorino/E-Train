package Model;

public class Andamento {
	
	public Andamento() {
		this.id = -1;
		this.dataT = "";
		this.ora_inizio = "";
		this.ora_fine = "";
		this.tirocinioID = -1;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDataT() {
		return dataT;
	}
	public void setDataT(String dataT) {
		this.dataT = dataT;
	}
	
	public String getOra_inizio() {
		return ora_inizio;
	}
	public void setOra_inizio(String ora_inizio) {
		this.ora_inizio = ora_inizio;
	}
	
	public String getOra_fine() {
		return ora_fine;
	}
	public void setOra_fine(String ora_fine) {
		this.ora_fine = ora_fine;
	}
	
	public int getTirocinioID() {
		return tirocinioID;
	}
	public void setTirocinioID(int tirocinioID) {
		this.tirocinioID = tirocinioID;
	}

	
	public String getNomeCognome() {
		return NomeCognome;
	}
	public void setNomeCognome(String nomeCognome) {
		NomeCognome = nomeCognome;
	}

	public String getNomeCognomeStudent() {
		return NomeCognomeStudent;
	}
	public void setNomeCognomeStudent(String nomeCognomeStudent) {
		NomeCognomeStudent = nomeCognomeStudent;
	}

	private int id;
	private String dataT;
	private String ora_inizio;
	private String ora_fine;
	private int  tirocinioID;
	private String NomeCognome;
	private String NomeCognomeStudent;
	
}
