package ClassiDAO;

import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextField;



import ClassiDatabase.Persona_creata;
import ClassiDatabase.Tesserato;
import ConnessioneDB.DBConnection;
import Controller.Driver;

public class PersonaDAOpostgre {

	/*
		private String codiceFiscale; 
		private String nome; 
		private String cognome; 
		private String comuneNascita; 
		private String comuneResidenza; 
		private String via; 
		private String provinciaNascita;
		private String password; 
		private int numeroCivico;
		private int cap; 
		private LocalDate dataNascita; 
		private boolean managerOtesserato;
		// forse possiamo anche togliere questi parametri 
		
		
		String codiceFiscale, String nome, String cognome, String comuneNascita, String comuneResidenza,
									String via, String provinciaNascita, int numeroCivico, int CAP, String sesso, LocalDate dataNascita,
									boolean ManagerOtesserato, String password
	*/
	
	private Connection connection;
	
	
	private PreparedStatement getPersonaByNome, inserisciPersona, getPersonaByLavoro, getPersonaByNomeEcognome, deletePersonaByCodiceFiscale, 
	                          getAllPeople;
	private static PreparedStatement controlloPersonaByCodiceFiscale, controlloPasswordByCodiceFiscale, controlloManagerOtesserato; 
	private ResultSet rs;
//	private static ResultSet rs1; 
	
	 

	
	
	public PersonaDAOpostgre( ) throws SQLException
	{
		super();
		
		this.connection = Driver.accessoConnessione();
		
		
		getPersonaByNome = connection.prepareStatement("SELECT * FROM persona_tesserata WHERE \"nome\" like ?");
		
		getPersonaByNomeEcognome = connection.prepareStatement("SELECT * FROM persona_ WHERE \"nome\" LIKE  ? AND \"cognome\" LIKE ? ");
		
		inserisciPersona = connection.prepareStatement("INSERT INTO persona_tesserata VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )");
		
		controlloPersonaByCodiceFiscale = connection.prepareStatement("SELECT \"codiceFiscale\" FROM persona_ WHERE \"codiceFiscale\" like ?"); 
		
//		getPersonaByLavoro = connection.prepareStatement("SELECT * FROM persona_tesserata WHERE managerOtesserato like ?");
		
		controlloPasswordByCodiceFiscale = connection.prepareStatement("SELECT \"password\" FROM persona_ WHERE \"codiceFiscale\" like ?"); 
		
		deletePersonaByCodiceFiscale = connection.prepareStatement("DELETE FROM \"persona_\" WHERE \"codiceFiscale\" like ?"); 
		
		getAllPeople = connection.prepareStatement("SELECT * FROM persona_tesserata"); 
		
		controlloManagerOtesserato = connection.prepareStatement("SELECT \"managerOtesserato\" FROM persona_ WHERE \"codiceFiscale\" like ?");
	}
	// end costruttore


/////////////////////////////////////////////////////////////****METODI****////////////////////////////////////////////////////////

	
	


   public void inserisciPersona(Persona_creata persona, Tesserato tesserato) throws SQLException {
	   
	   inserisciPersona.setString(1, persona.getCodiceFiscale() );
	   inserisciPersona.setString(2, persona.getNome() );
	   inserisciPersona.setString(3, persona.getCognome() );
	   inserisciPersona.setObject(4, persona.getDataNascita());
	   inserisciPersona.setString(5, persona.getComuneNascita() );
	   inserisciPersona.setString(6, persona.getComuneResidenza() );
	   inserisciPersona.setString(7, persona.getVia() );
	   inserisciPersona.setInt(8, persona.getNumeroCivico() );
	   inserisciPersona.setInt(9, persona.getCAP() );
	   inserisciPersona.setString(10, persona.getSesso() );
	   inserisciPersona.setString(11, persona.getProvinciaNascita() );
	   inserisciPersona.setBoolean(12, persona.isManagerOtesserato());
	   inserisciPersona.setString(13, persona.getPassword() );
	   inserisciPersona.setString(14, tesserato.getCodiceFiscale() ); 
	   inserisciPersona.setString(15, tesserato.getCodiceFiscaleManager() ); 
	   inserisciPersona.setInt(16, tesserato.getGettoneNazionale() );
	   inserisciPersona.setString(17, tesserato.getCodiceFederazioneSportiva() );
	  
	   
	   inserisciPersona.executeUpdate(); 
		 
	   
   }
	
	
	
	

//Bisogna cerare metodo per verificare che la persona non sia già esistente all'interno del database
// bisogna togliere lo static

   public boolean controlloManagerOtesserato(String codiceFiscale) throws SQLException   
{
   		boolean managerOtesserato = false; 
	   
	   	controlloManagerOtesserato.setString(1, codiceFiscale);
	   	rs = controlloManagerOtesserato.executeQuery(); 
	   
	   	while( rs.next() )
		{
			managerOtesserato = rs.getBoolean( "managerOtesserato");
		}
	   	
	   	
	   	rs.close();
	   	return managerOtesserato; 
   }
   
   public ArrayList<String> tutteLePersone() throws SQLException
   {    
	   	
		ArrayList<String> tutti_gli_utenti = new ArrayList<>();
		

        rs = getAllPeople.executeQuery(); 
	  

//		rs.last();
//		int columnsNumber = rs.getRow();
//		
//		
//	    tutti_gli_utenti.add("Sono presenti nel database " + columnsNumber + " utenti.\n\n");
//		
//	    
//	    
//	    rs.beforeFirst();
	   
        
        while(rs.next()) 
	    {
	    	
// aggiungere ulteriori stringhe per il metodo
  
		  
	    	
	    	String codice_fiscale_utente = rs.getString("codiceFiscale");
			String nome_utente = rs.getString("nome");	
			String cognome_utente = rs.getString("cognome");
			String data_di_nascita_utente = rs.getString("dataNascita");
			boolean managerOtesserato = rs.getBoolean("managerOtesserato"); 
			
			
			String menager_o_tesserato; 
			
			if( managerOtesserato )
			{
				menager_o_tesserato = "Tesserato"; 
   			}
			else
			{
				menager_o_tesserato = "Manager";
			}
	                  
			
		    String dati_utente = "Nome: "+ nome_utente+
							     "\t\tCognome: " + cognome_utente+
								 "\tCodice fiscale: "+codice_fiscale_utente+
		    		             "\tData di nascita: " +data_di_nascita_utente+
								 "\t\t"+ menager_o_tesserato;
											    
			tutti_gli_utenti.add(dati_utente);
			
			
	    }
	   
		rs.close();
		
   		return tutti_gli_utenti; 
   }
   
    public ArrayList<String> getPersonaByNome( String nome, String cognome ) throws SQLException 
	{
		ArrayList<String> utenti_ricercati = new ArrayList<>(); 
	   
		//Il per cento indica una serie di caratteri che vengono ulteriormente presi in considerazione 
		
		getPersonaByNomeEcognome.setString(1, nome+"%");
		getPersonaByNomeEcognome.setString(2, cognome+"%");
		rs = getPersonaByNomeEcognome.executeQuery();
		
		while( rs.next() )
		{
			
			String codice_fiscale_utente = rs.getString("codiceFiscale");
			String nome_utente = rs.getString("nome");	
			String cognome_utente = rs.getString("cognome");
			String data_di_nascita_utente = rs.getString("dataNascita");
			
		    String dati_utente = "Nome: "+ nome_utente+
							     "\tCognome: " + cognome_utente+
								 "\tCodice fiscale: "+codice_fiscale_utente+
		    		             "\tData di nascita: " +data_di_nascita_utente;
		    
			utenti_ricercati.add(dati_utente);
		}
		 
		
		rs.close();
		return utenti_ricercati;
		
	}
	
   	public boolean controlloPersonaByCodiceFiscale( String codiceFiscale ) throws SQLException
	{
		
		boolean verifica = false;
		
		
		controlloPersonaByCodiceFiscale.setString(1, codiceFiscale);
		rs = controlloPersonaByCodiceFiscale.executeQuery();
		
		while( rs.next() ) 
		{
			
			if( rs.getString("codiceFiscale") != null )
				verifica = true;
				
		}
		rs.close();
		
		return verifica;
	}
	
	public String controlloPasswordByCodiceFiscale( String codiceFiscale ) throws SQLException
	{
		
		String risultato = null; 
		
	    controlloPasswordByCodiceFiscale.setString( 1, codiceFiscale );
	    rs = controlloPasswordByCodiceFiscale.executeQuery(); 
	    
	    while( rs.next() )	
		{
			
	    	
			if( rs.getString("password") != null )
	    		risultato = rs.getString("password");
					
			System.out.println(risultato);
		}
		
		//System.out.println("risulato\t\t"+risultato);
		
		rs.close();
		return risultato;
	}

	public boolean deletePersonaByCodiceFiscale( String codiceFiscale ) throws SQLException
	{
		
		deletePersonaByCodiceFiscale.setString(1, codiceFiscale);
		int row = deletePersonaByCodiceFiscale.executeUpdate(); 		
		
		return row != 0; 
	}
	
}



