package ClassiDatabase;

import java.sql.Date;

import Controller.Driver;

public class Tesserato extends Persona {

	private String codiceFiscale; 
	private String codiceFiscaleManager; 
	private String codiceFederazioneSportiva; 
	private int gettoneNazionale;
	
	
	Driver driver = new Driver(); 
	
	
	
	
	
	
	
	
	
	
	
	
     public Tesserato(String codiceFiscale, String nome, String cognome, String comuneNascita, String comuneResidenza,
			String via, String provinciaNascita, int numeroCivico, int cAP, Date dataNascita, String codiceFiscaleManager, String codiceFederazioneSportiva,
			int gettoneNazionale) {
	
		super(codiceFiscale, nome, cognome,  comuneNascita,  comuneResidenza,
				via, provinciaNascita,  numeroCivico, cAP, dataNascita, true); 
		
		this.codiceFiscale = codiceFiscale;
		this.codiceFiscaleManager = codiceFiscaleManager;
		this.codiceFederazioneSportiva = codiceFederazioneSportiva;
		this.gettoneNazionale = gettoneNazionale;
	}


	
	
	
	
/////////////////////////////////////////////////////****METODI****//////////////////////////////////////////////////////////////////
	
	
	

	public String getCodiceFiscale() {
		return codiceFiscale;
	}



	public String getCodiceFiscaleManager() {
		return codiceFiscaleManager;
	}




	public String getCodiceFederazioneSportiva() {
		return codiceFederazioneSportiva;
	}





	public int getGettoneNazionale() {
		return gettoneNazionale;
	}




}
