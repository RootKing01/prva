package ClassiDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import ClassiDatabase.Tesserato;
import Controller.Driver;

public class TesseratoDAO extends PersonaDAOpostgre {

	private String codiceFiscale; 
	private String codiceFiscaleManager; 
	private String codiceFederazioneSportiva; 
	private int gettoneNazionale;
	
	
	private PreparedStatement inserimentoMangerDelTesserato, deleteManager, recuperoDati;  
    private ResultSet rs;
	private Connection connection;
	
	Driver driver = new Driver(); 
	
	
	
    public TesseratoDAO( ) throws SQLException 
	{
	
		connection = Driver.accessoConnessione();	
		 
		inserimentoMangerDelTesserato = connection.prepareStatement("UPDATE tesserato SET \"codiceFiscaleManager\" = ? WHERE \"codiceFiscale\" like ?  " );
		
	    deleteManager = connection.prepareStatement("UPDATE tesserato SET \"codiceFiscaleManager\" = null WHERE \"codiceFiscale\" like ?"); 
	    
		recuperoDati = connection.prepareStatement("SELECT * FROM tesserato WHERE \"codiceFiscale\" like ?");	    
		
	}


	
	
	
	
/////////////////////////////////////////////////////****METODI****//////////////////////////////////////////////////////////////////
	
	
  /*  public Tesserato recuperoDatiUtenteTesserato( String codiceFiscale ) throws SQLException
	{
    	Tesserato dati_tesserato;   
    	
    	
    	recuperoDati.setString(1, codiceFiscale);
    	rs = recuperoDati.executeQuery();
		
		while( rs.next() )
		{
			
		//	dati_tesserato = new Tesserato( rs.getString("codiceFiscale"), rs.getString("codiceFiscaleManager"), rs.getInt("gettoneNazionale"), rs.getString("codiceFiderazioneSportiva") );
			
		}
	
		//return dati_tesserato; 
    }
    */
	public void inserimentoMangerDelTesserato( String codice_fiscale_tesserato, String codice_fiscale_manager ) throws SQLException
	{
		
		inserimentoMangerDelTesserato.setString( 1,  codice_fiscale_tesserato);
		
		inserimentoMangerDelTesserato.executeUpdate(); 

	}

	public void eliminaManger( String codiceFiscaleTesserato) throws SQLException
	{
	
		deleteManager.setString(1, codiceFiscaleTesserato);
		
		deleteManager.executeUpdate(); 
	}

}
