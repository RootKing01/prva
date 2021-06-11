package ClassiDatabase;

import java.sql.Date;
import java.time.LocalDate;

import Controller.Driver;

public class Tesserato extends Persona_creata {

	private String codiceFiscale; 
	private String codiceFiscaleManager; 
	private String codiceFederazioneSportiva; 
	private int gettoneNazionale;
	
	
	Driver driver = new Driver(); 
	
	
	
	
	//boolean tesserato = true; 
	
	
	
	
	
	
	
     public Tesserato(	String codiceFiscale, String nome, String cognome, String comuneNascita, String comuneResidenza,
						String via, String provinciaNascita, int numeroCivico, int cAP, String sesso, LocalDate dataNascita, String codiceFiscaleManager, String codiceFederazioneSportiva,
						int gettoneNazionale) 
	{
	
		super(codiceFiscale, nome, cognome, dataNascita, comuneNascita,  comuneResidenza,
				via, numeroCivico,   cAP, sesso, provinciaNascita, true ); 
				
				
		this.codiceFiscale = codiceFiscale;
		this.codiceFiscaleManager = codiceFiscaleManager;
		this.codiceFederazioneSportiva = codiceFederazioneSportiva;
		this.gettoneNazionale = gettoneNazionale;
	}


	
	
	
	
/////////////////////////////////////////////////////****METODI****//////////////////////////////////////////////////////////////////
	
	
	

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}






	public void setCodiceFiscaleManager(String codiceFiscaleManager) {
		this.codiceFiscaleManager = codiceFiscaleManager;
	}






	public void setCodiceFederazioneSportiva(String codiceFederazioneSportiva) {
		this.codiceFederazioneSportiva = codiceFederazioneSportiva;
	}






	public void setGettoneNazionale(int gettoneNazionale) {
		this.gettoneNazionale = gettoneNazionale;
	}






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
