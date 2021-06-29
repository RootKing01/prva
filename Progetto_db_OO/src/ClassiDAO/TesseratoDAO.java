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
	
	
	private PreparedStatement inserimentoMangerDelTesserato, deleteManagerDelTesserato, recuperoDati_contratti_attivi, recapUtente_totale, conteggioTesserati;  
    private ResultSet rs;
	private Connection connection;
	
	Driver driver = new Driver(); 
	
	
	
    public TesseratoDAO( ) throws SQLException 
	{
	
		connection = Driver.accessoConnessione();	
		 
		inserimentoMangerDelTesserato = connection.prepareStatement("UPDATE tesserato SET \"codiceFiscaleManager\" = ? WHERE \"codiceFiscale\" like ?  " );
		
	    deleteManagerDelTesserato = connection.prepareStatement("UPDATE tesserato SET \"codiceFiscaleManager\" = null WHERE \"codiceFiscale\" like ?"); 
	    
	    conteggioTesserati = connection.prepareStatement("SELECT \"codiceFiscale\" FROM tesserato WHERE \"codiceFiscaleManager\" like ?"); 
	}


	
	
	
	
/////////////////////////////////////////////////////****METODI****//////////////////////////////////////////////////////////////////
	
	
  
    
    
    public ArrayList<String> conteggioTesserati( String codiceFiscaleManager ) throws SQLException
    {
    	
    	ArrayList<String> tutti_i_tesserati_del_manager = new ArrayList<>(); 
    	
    	conteggioTesserati.setString(1, codiceFiscaleManager);
    	rs = conteggioTesserati.executeQuery(); 
    	
    	while( rs.next() )
    	{
    		tutti_i_tesserati_del_manager.add( rs.getString("codiceFiscale") ); 
    	}
    	
    	rs.close();
    	return tutti_i_tesserati_del_manager; 
    }
    
	
	public void inserimentoMangerDelTesserato( String codice_fiscale_tesserato, String codice_fiscale_manager ) throws SQLException
	{
		
		inserimentoMangerDelTesserato.setString( 1,  codice_fiscale_manager );
		inserimentoMangerDelTesserato.setString( 2, codice_fiscale_tesserato );
		
		inserimentoMangerDelTesserato.executeUpdate(); 

	}

	public void eliminaManger( String codiceFiscaleTesserato) throws SQLException
	{
	
		deleteManagerDelTesserato.setString(1, codiceFiscaleTesserato);
		
		deleteManagerDelTesserato.executeUpdate(); 
	}

}
