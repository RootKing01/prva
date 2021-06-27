package ClassiDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import ClassiDatabase.Tesserato;
import Controller.Driver;
import ClassiDatabase.contratto_del_tesserato;

public class contratto_del_tesseratoDAO 
{
	
	private PreparedStatement  recuperoDati_contratti_attivi, recapUtente_totale;  
    private ResultSet rs;
	private Connection connection;
	
	
	public contratto_del_tesseratoDAO() throws SQLException
	{
		connection = Driver.accessoConnessione();
		
	    recuperoDati_contratti_attivi = connection.prepareStatement("SELECT * FROM contratto_del_tesserato WHERE \"codiceFiscale\" like ? AND \"dataFine\" > CURRENT_DATE");	

		recapUtente_totale = connection.prepareStatement("SELECT * FROM contratto_del_tesserato WHERE \"codiceFiscale\" like ?");
		
	}	
	
	public ArrayList<String> recuperoDatiUtenteTesserato( String codiceFiscale ) throws SQLException
	{
		
	    ArrayList<String> dati_tesserato = new ArrayList<String>();   
	    
	    
	    recuperoDati_contratti_attivi.setString(1, codiceFiscale);
	    rs =  recuperoDati_contratti_attivi.executeQuery();
		
		while( rs.next() )
		{
				
			String codiceFiscale_utente = rs.getString("codiceFiscale"); 
			String codiceFiscaleManager = rs.getString("codiceFiscaleManager");
			int gettoniNazionale = rs.getInt("gettoneNazionale");
			String codiceFederazioneSportiva = rs.getString("codiceFedrazioneSportiva");
			int codiceContratto = rs.getInt("codiceContratto");
			LocalDate dataInizio = (LocalDate) rs.getObject("dataInizio");
			LocalDate dataFine = (LocalDate) rs.getObject("dataFine");
			int remunerazioneContratto = rs.getInt("remunerazioneContratto");
			int parcellaManager = rs.getInt("parcellaManager");
			String partitaIvaSponsor = rs.getString("partitaIvaSponsor");
			boolean clubOtesserato = rs.getBoolean("clubOsponsor");
			String partitaIvaClub = rs.getString("partitaIvaClub");
			
			String recap_generale_attivi = codiceFiscale_utente + codiceFiscaleManager + gettoniNazionale + codiceFederazioneSportiva
					                      + codiceContratto + dataInizio + dataFine + remunerazioneContratto + parcellaManager + partitaIvaSponsor
					                      + clubOtesserato + partitaIvaClub; 
			
			dati_tesserato.add( recap_generale_attivi ); 
				
		}
			
			return dati_tesserato;
			
	}
	
	
}
