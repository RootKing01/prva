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

public class Contratto_del_tesseratoDAOPostgre 
{
	
	private PreparedStatement  recupero_dati_contratti_attivi, recapUtente_totale, recap_manager_totale;  
    private ResultSet rs;
	private Connection connection;
	
	
	public Contratto_del_tesseratoDAOPostgre() throws SQLException
	{
		
		connection = Driver.accessoConnessione();
		
		// in contratto del tesserato
	    recupero_dati_contratti_attivi = connection.prepareStatement("SELECT * FROM contratto_del_tesserato WHERE \"codiceFiscale\" like ? AND \"dataFine\" > CURRENT_DATE   ");	

		recapUtente_totale = connection.prepareStatement("SELECT * FROM contratto_del_tesserato WHERE \"codiceFiscale\" like ?");
		
		recap_manager_totale =	connection.prepareStatement("SELECT * FROM contratto_del_tesserato WHERE \"codiceFiscaleManager\" = ? ORDER BY  \"parcellaMenager\" DESC  ");
			
	}	
	
	public ArrayList<String> recap_contratti_tesserati( String codiceFiscaleManager_ ) throws SQLException
	{
		ArrayList<String> totale = new ArrayList<>();
		
		recap_manager_totale.setString( 1, codiceFiscaleManager_ );				
		rs = recap_manager_totale.executeQuery();
		
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
					                      +"\t\t\t\t"+ codiceContratto +"\t"+ dataInizio.toLocalDate() +"\t"+ dataFine.toLocalDate() +"\t\t"+ remunerazioneContratto +"\t\t\t\t"+ parcellaManager +"\t\t\t"+ partitaIvaSponsor
					                      +"\t\t\t"+ partitaIvaClub; 
			
			totale.add( recap_generale_attivi ); 
			
		}
		
		rs.close();
		return totale;
	}
	
	public ArrayList<String> recuperoContrattiAttiviUtenteTesserato( String codiceFiscale ) throws SQLException
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
		
		rs.close();	
		return dati_tesserato;	
	}
	
	public ArrayList<String> recuperoTuttiContrattiUtenteTesserato(String codiceFiscale) throws SQLException
	{
		ArrayList<String> tutti_contrati_utente = new ArrayList<>(); 
		
	    recapUtente_totale.setString(1, codiceFiscale);
	    rs = recapUtente_totale.executeQuery(); 
	    
	    while (rs.next() )
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
			
			String recap_generale_attivi = codiceFiscale_utente +"\t\t"+ codiceFiscaleManager +"\t\t\t\t"+ gettoniNazionale +"\t\t\t"+ codiceFederazioneSportiva
					                      +"\t\t\t\t\t"+ codiceContratto +"\t\t\t\t"+ dataInizio.toLocalDate() +"\t\t"+ dataFine.toLocalDate() +"\t\t\t"+ remunerazioneContratto +"\t\t\t\t"+ parcellaManager +"\t\t"+ partitaIvaSponsor
					                      +"\t\t\t"+ partitaIvaClub; 
			
			tutti_contrati_utente.add( recap_generale_attivi ); 
	    	
	    }
		
		rs.close();
		return tutti_contrati_utente;
	}
	
	
	
}
