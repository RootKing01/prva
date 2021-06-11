package ClassiDAO;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import Controller.Driver;

public class TesseratoDAO extends PersonaDAOpostgre {

	private String codiceFiscale; 
	private String codiceFiscaleManager; 
	private String codiceFederazioneSportiva; 
	private int gettoneNazionale;
	
	
	Driver driver = new Driver(); 
	
	
	
     public TesseratoDAO( String codiceFiscale, String nome, String cognome, String comuneNascita, String comuneResidenza,
			String via, String provinciaNascita, int numeroCivico, int cAP, String sesso, LocalDate dataNascita, String codiceFiscaleManager, String codiceFederazioneSportiva,
			int gettoneNazionale) throws SQLException {
	
		super(codiceFiscale, nome, cognome,  comuneNascita,  comuneResidenza,
				via, provinciaNascita,  numeroCivico, cAP, sesso,  dataNascita, true ); 
		
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
