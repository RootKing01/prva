package ClassiDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	
	private PreparedStatement getPersonaByNome, inserisciPersona, getPersonaByLavoro ;
	private static PreparedStatement getPersonaByCodiceFiscale, getPasswordByCodiceFiscale; 
	private ResultSet rs;
//	private static ResultSet rs1; 
	
	 

	
	
	public PersonaDAOpostgre( ) throws SQLException
	{
		super();
		
		this.connection = Driver.accessoConnessione();
		
		
		getPersonaByNome = connection.prepareStatement("SELECT * FROM persona_tesserata WHERE \"nome\" like '?'");
		 
		inserisciPersona = connection.prepareStatement("INSERT INTO persona_tesserata VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )");
		
		getPersonaByCodiceFiscale = connection.prepareStatement("SELECT \"codiceFiscale\" FROM persona_ WHERE \"codiceFiscale\" like ?"); 
		
//		getPersonaByLavoro = connection.prepareStatement("SELECT * FROM persona_tesserata WHERE managerOtesserato like ?");
		
		getPasswordByCodiceFiscale = connection.prepareStatement("SELECT \"password\" FROM persona_ WHERE \"codiceFiscale\" like ?"); 
		
		
	}
	// end costruttore


/////////////////////////////////////////////////////////////****METODI****////////////////////////////////////////////////////////

	public ArrayList<String> getPersonaByNome(String nome) throws SQLException {
		
		
		return null;
		
	   }


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

   
	public boolean getPersonaByCodiceFiscale( String codiceFiscale ) throws SQLException
	{
		
		boolean verifica = false;
		
		
		getPersonaByCodiceFiscale.setString(1, codiceFiscale);
		rs = getPersonaByCodiceFiscale.executeQuery();
		
		while(rs.next()) 
		{
			
			if( rs.getString("codiceFiscale") != null )
				verifica = true;
				
		}
		rs.close();
		
		return verifica;
	}
	
	public String getPasswordByCodiceFiscale(String codiceFiscale) throws SQLException
	{
		
		String risultato = null;
		
	    getPasswordByCodiceFiscale.setString(1, codiceFiscale);
	    rs = getPasswordByCodiceFiscale.executeQuery(); 
	    
	    while(rs.next())	
		risultato = rs.getString("password");
		System.out.println(risultato);
		
		
	    rs.close();
	    
		return risultato;
	}

}



