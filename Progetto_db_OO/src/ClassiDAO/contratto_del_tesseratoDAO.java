package ClassiDAO;

import java.sql.Connection;
import java.sql.Date;
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
	
	private PreparedStatement  recupero_dati_contratti_attivi, recapUtente_totale;  
    private ResultSet rs;
	private Connection connection;
	
	
	public contratto_del_tesseratoDAO() throws SQLException
	{
		
		connection = Driver.accessoConnessione();
		
		
	    recupero_dati_contratti_attivi = connection.prepareStatement("SELECT * FROM contratto_del_tesserato WHERE \"codiceFiscale\" like ? AND \"dataFine\" > CURRENT_DATE");	

		recapUtente_totale = connection.prepareStatement("SELECT * FROM contratto_del_tesserato WHERE \"codiceFiscale\" like ?");
		
	}	
	
	public ArrayList<String> recuperoDatiUtenteTesserato( String codiceFiscale ) throws SQLException
	{
		
	    ArrayList<String> dati_tesserato = new ArrayList<String>();   
	    
	    
	    recupero_dati_contratti_attivi.setString(1, codiceFiscale);
	    rs =  recupero_dati_contratti_attivi.executeQuery();
		
		while( rs.next() )
		{
				
			String codiceFiscale_utente = rs.getString("codiceFiscale"); 
			String codiceFiscaleManager = rs.getString("codiceFiscaleManager");
			int gettoniNazionale = rs.getInt("gettoneNazionale");
			String codiceFederazioneSportiva = rs.getString("CodiceFederazioneSportiva");
			int codiceContratto = rs.getInt("codiceContratto");
		    Date dataInizio =  rs.getDate("dataInizio");
			Date dataFine =  rs.getDate("dataFine");
			int remunerazioneContratto = rs.getInt("remunerazioneContratto");
			int parcellaManager = rs.getInt("parcellaMenager");
			String partitaIvaSponsor = rs.getString("partitaIvaSponsor");
			boolean clubOtesserato = rs.getBoolean("clubOsponsor");
			String partitaIvaClub = rs.getString("partitaIvaClub");
			
			String recap_generale_attivi = codiceFiscale_utente +"\t"+ codiceFiscaleManager +"\t\t\t"+ gettoniNazionale +"\t\t\t"+ codiceFederazioneSportiva
					                      +"\t\t\t\t"+ codiceContratto +"\t\t\t"+ dataInizio.toLocalDate() +"\t"+ dataFine.toLocalDate() +"\t\t"+ remunerazioneContratto +"\t\t\t\t"+ parcellaManager +"\t\t"+ partitaIvaSponsor
					                      +"\t\t\t"+ partitaIvaClub; 
			
			dati_tesserato.add( recap_generale_attivi ); 
		
		}
					
			return dati_tesserato;
			
	}
	
	
}
