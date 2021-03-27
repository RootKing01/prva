package ClassiDAO;

import java.sql.Date;

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
	
	
	
	
	public PersonaDAOpostgre(String codiceFiscale, String nome, String cognome, String comuneNascita, String comuneResidenza,
			String via, String provinciaNascita, int numeroCivico, int CAP, Date dataNascita,
			boolean managerOtesserato) {
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
	}


/////////////////////////////////////////////////////////////****METODI****////////////////////////////////////////////////////////

	public void creazionePersonaPostgre() {
		
		
		
		
		
		
		
		
		
	}

}



//Bisogna cerare metodo per verificare che la persona non sia già esistente all'interno del database









