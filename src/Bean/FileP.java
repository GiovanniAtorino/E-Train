package Bean;

public class FileP {

	String path,nome,descrizione;
	
	public FileP() {}
	
	public FileP(String n,String d,String p) {
		nome=n;descrizione=d;path=p;
	}
	
	public String getNomeF() {return nome;}
	public String getDescrzioneF() {return descrizione;}
	public String getPathF() {return path;}
	public void setNomeF(String n) {nome=n;}
	public void setDescrizioneF(String d) {descrizione=d;}
	public void setPathF(String p) {path=p;}
}
