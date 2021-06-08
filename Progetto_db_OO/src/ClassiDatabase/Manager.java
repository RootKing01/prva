package ClassiDatabase;

import java.sql.Date;
import java.util.ArrayList;

import Controller.Driver;

public class Manager extends Persona_creata {

	private String codiceFiscale;
	
	Driver driver = new Driver(); 
	
	ArrayList<Tesserato> tesserati_di_manager = new ArrayList<Tesserato>(); 
	
    
	
	
	
	
	
	
	
	

	public Manager(String codiceFiscale, String nome, String cognome, String comuneNascita, String comuneResidenza,
			String via, String provinciaNascita, int numeroCivico, int cAP, String sesso,  Date dataNascita) {
		
	super(codiceFiscale, nome, cognome, dataNascita, comuneNascita,  comuneResidenza,
				via, numeroCivico, cAP, sesso, provinciaNascita, false); 
	
	
				this.codiceFiscale = codiceFiscale;
	}


////////////////////////////////////////////////////////////****METODI***/////////////////////////////////////////////////////////////////////////////////
	
	
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	
	public void addTesserato(Tesserato tesserato) {
		
		tesserati_di_manager.add(tesserato);
	
		
	}
	
	public void removeTesserato(Tesserato tesserato) {
		
		tesserati_di_manager.remove(tesserato); 
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
  
  