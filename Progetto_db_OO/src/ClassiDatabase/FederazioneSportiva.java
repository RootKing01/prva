package ClassiDatabase;

public class FederazioneSportiva {

	private String codiceFederazioneSportiva; 
	private String disciplinaSportiva;
	
	
	
	public FederazioneSportiva(String codiceFederazioneSportiva, String disciplinaSportiva) {
		super();
		this.codiceFederazioneSportiva = codiceFederazioneSportiva;
		this.disciplinaSportiva = disciplinaSportiva;
	}



	public String getCodiceFederazioneSportiva() {
		return codiceFederazioneSportiva;
	}



	public String getDisciplinaSportiva() {
		return disciplinaSportiva;
	} 
}
