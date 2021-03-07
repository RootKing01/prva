package ClassiDAO;

import java.sql.Date;
import java.util.ArrayList;

import Controller.Driver;

public class ManagerDAOpostgre {

	

	private String codiceFiscale;
	
	
///COSTRUTTORE
	
	public ManagerDAOpostgre(String codiceFiscale, String nome, String cognome, String comuneNascita,
			String comuneResidenza, String via, String provinciaNascita, int numeroCivico, int cAP, Date dataNascita,
			boolean managerOtesserato) {
		super();
		
	}
////////////	


////////////////////////////////////////////////////////////****METODI***/////////////////////////////////////////////////////////////////////////////////
	
	
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	
	public void addTesserato(Tesserato tesserato) {
		
	
	}
	
	public void removeTesserato(Tesserato tesserato) {
		
		
		
	}
	
	
	public void creazioneEinserimentoManager(String codiceFiscale) {
		
		if(this.codiceFiscale.equals(codiceFiscale))
			System.out.println();
			
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
  
  