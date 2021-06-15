package ClassiDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JFrame;

import ClassiDatabase.Persona_creata;
import ClassiDatabase.Tesserato;
import ConnessioneDB.DBConnection;
import Controller.Driver;

public class PersonaDAOpostgre {

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
	
	private Connection connection;
	
	
	private PreparedStatement getPersonaByNome, inserisciPersona, getPersonaByLavoro ; 
	private ResultSet rs;
	
	 
	
	public PersonaDAOpostgre(	String codiceFiscale, String nome, String cognome, String comuneNascita, String comuneResidenza,
								String via, String provinciaNascita, int numeroCivico, int CAP, String sesso, LocalDate dataNascita,
								boolean ManagerOtesserato, String password
							) throws SQLException
	{
		super();
		this.codiceFiscale = codiceFiscale;
		this.nome = nome;
		this.cognome = cognome;
		this.comuneNascita = comuneNascita;
		this.comuneResidenza = comuneResidenza;
		this.via = via;
		this.provinciaNascita = provinciaNascita;
		this.numeroCivico = numeroCivico;
		this.cap = CAP;
		this.dataNascita = dataNascita;
		this.managerOtesserato = ManagerOtesserato;
		this.password = password;
		
		
		this.connection = Driver.accessoConnessione();
		
		getPersonaByNome = connection.prepareStatement("SELECT * FROM persona_tesserata WHERE \"nome\" like '?'");
		 
		inserisciPersona = connection.prepareStatement("INSERT INTO persona_tesserata VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )");
		
//		getPersonaByLavoro = connection.prepareStatement("SELECT * FROM persona_tesserata WHERE managerOtesserato like ?");
		
		
	}


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
	
	
	
	

//Bisogna cer	are metodo per verificare che la persona non sia già esistente all'interno del database




	
	
       

}



