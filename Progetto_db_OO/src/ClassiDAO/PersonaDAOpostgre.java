package ClassiDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;

import ClassiDatabase.Persona_creata;

public class PersonaDAOpostgre {

	private String codiceFiscale; 
	private String nome; 
	private String cognome; 
	private String comuneNascita; 
	private String comuneResidenza; 
	private String via; 
	private String provinciaNascita; 
	private int numeroCivico;
	private int cap; 
	private Date dataNascita; 
	private boolean managerOtesserato;
	private Connection connection;
	
	
	private PreparedStatement getPersonaByNome, inserisciPersona, getPersonaByLavoro ; 
	private ResultSet rs;
	
	 
	
	public PersonaDAOpostgre(String codiceFiscale, String nome, String cognome, String comuneNascita, String comuneResidenza,
			String via, String provinciaNascita, int numeroCivico, int CAP, Date dataNascita,
			boolean managerOtesserato) throws SQLException {
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
		this.managerOtesserato = managerOtesserato;
		
		
		this.connection = connection;
		
		getPersonaByNome = connection.prepareStatement("SELECT * FROM persona_tesserata WHERE \"nome\" like '?");
		 
		inserisciPersona = connection.prepareStatement("INSERT INTO persona_tesserata VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )");
		
//		getPersonaByLavoro = connection.prepareStatement("SELECT * FROM persona_tesserata WHERE managerOtesserato like ?");
		
		
	}


/////////////////////////////////////////////////////////////****METODI****////////////////////////////////////////////////////////

	public ArrayList<String> getPersonaByNome(String nome) throws SQLException {
		
		
		
		
		
		
		
		
		
		
		return null;
		
	   }


   public void inserisciPersona(Persona_creata persona, Tesserato tesserato) throws SQLException {
	   
	   inserisciPersona.setString(0, persona.getCodiceFiscale() );
	   inserisciPersona.setString(1, persona.getNome() );
	   inserisciPersona.setString(2, persona.getCognome() );
	   inserisciPersona.setString(3, persona.getDataNascita().toString());
	   inserisciPersona.setString(4, persona.getComuneNascita() );
	   inserisciPersona.setString(5, persona.getComuneResidenza() );
	   inserisciPersona.setString(6, persona.getVia() );
	   inserisciPersona.setLong(7, persona.getNumeroCivico() );
	   inserisciPersona.setLong(8, persona.getCAP() );
	   inserisciPersona.setString(9, persona.getSesso() );
	   inserisciPersona.setString(10, persona.getProvinciaNascita() );
	   inserisciPersona.setString(11, persona.getManagerOtesserato());
	   inserisciPersona.setString(12, tesserato.getCodiceFiscale() ); 
	   inserisciPersona.setString(13, tesserato.getCodiceFiscaleManager() ); 
	   inserisciPersona.setLong(14, tesserato.getGettoneNazionale() );
	   inserisciPersona.setString(15, tesserato.getCodiceFederazioneSportiva() );
	   
   }
	
	
	
	

//Bisogna cer	are metodo per verificare che la persona non sia già esistente all'interno del database




	
	
       

}



