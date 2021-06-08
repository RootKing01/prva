package Controller;



import java.awt.event.MouseAdapter;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;

import ClassiDAO.PersonaDAOpostgre;
import ClassiDAO.comuniDao;
import ClassiDatabase.Comune;
import ClassiDatabase.Persona_creata;
import ClassiDatabase.Tesserato;
import ConnessioneDB.DBConnection;
import GUI.ErroreInserimento;
import GUI.General;
import GUI.Inserimento_dati_persona;
import GUI.Inserimento_persona_tesserata;


public class Driver 
{

	
	public static void main(String[] args) throws SQLException, IOException 
	{
		
		
		Driver driver = new Driver();	
		driver.Controller();
		
		
		//PersonaDAOpostgre personadao = new PersonaDAOpostgre("RGOFNC00T22F839S", "fra", "rogo", "2000/12/02", "Napoli", "Napoli", "sos", "");
		
		
//		try
//		{   
//			
			 
			
			//Comune comune = new Comune(); 
			
//			comune.insertComuni();
			
			
		 
		    //System.out.println("Tutto a buon fine"); 
		
//			System.out.println("Comuni inseriti");
//			
//		}
//		catch(SQLException e)
//		{	
//			
//		}

	}



/////////////////////////////////////////////////****METODI****////////////////////////////////////////////////////
	
	
//    public void funzione_finestra_visibile(JFrame Finestra, JFrame Finestra1) {
//    	
//    	Finestra.setVisible(false);    	
//    	
//    	Finestra1.setVisible(true);
//    }

	
public void Controller() 
	{
		General prima_finestra = new General(this);
		prima_finestra.setVisible(true);	
	}



public String creazioneCodiceFiscale(JTextField cognome_utente, JTextField nome_utente, JTextField anno_nascita, JTextField mese_nascita, JTextField giorno_nascita ,
			JComboBox Sesso_utente, JTextField comune_nascita_utente ) throws SQLException {
		
	String cognome = cognome_utente.getText().toUpperCase(); 
	String nome = nome_utente.getText().toUpperCase();
	String anno = anno_nascita.getText();
	String mese = mese_nascita.getText();
	String giorno = giorno_nascita.getText(); 
	String sesso = (String) Sesso_utente.getSelectedItem().toString(); 
	String comune_nascita = comune_nascita_utente.getText()/*.toLower*/; 
	String codiceFiscale = new String(); 
	
	// SETTO IL COMUNE CON SOLO LA PRIMA LETTERA MAIUSCOLA 
	for(int i = 0; i < comune_nascita.length(); i++) {
		
		String comune_esatto_per_database = comune_nascita; 
		comune_nascita = "";
		
		if( i == 0 )
		{
			comune_nascita += comune_esatto_per_database.charAt(i);
			comune_nascita.toUpperCase();
		}   
		else
		{
			comune_nascita += comune_esatto_per_database.charAt(i);	
		}
		
		//comune_nascita = comune_nascita + " "; 
	}
	
	
	
	System.out.println( "\necco il comune di nascita: " + comune_nascita );
	
    // PRENDIAMO LE PRIME 3 CONSONANTI DEL COGNOME 
	for( int i = 0, count = 0; i < cognome.length(); i++ )
	{
		
		if( (cognome.charAt(i) == 'A' || cognome.charAt(i) == 'E' || cognome.charAt(i) == 'I' || cognome.charAt(i) == 'O' || cognome.charAt(i) == 'U')  )
		{
			 
		}
		else
		{
			
			if( count == 3 )
			{
				break;
			}
			
			codiceFiscale +=  cognome.charAt(i);
			count++;
			
		}
	}
	
	//PRENDIAMO LA PRIMA, LA TERZA E LA QUARTA CONSONANTE DEL NOME
	 
	for( int i = 0, count = 0; i < nome.length(); i++ ) 
	{
			
			if( ( nome.charAt(i) == 'A' || nome.charAt(i) == 'E' || nome.charAt(i) == 'I' || nome.charAt(i) == 'O' || nome.charAt(i) == 'U' ) )
			{
				 
			}
			else
			{
				
				if( count == 0 || count == 2 || count == 3 )
				{
					
					codiceFiscale +=  nome.charAt(i);
					
				}
				count++;
			}
			
	}
	
	// USIAMO L'ANNO DI NASCITA
	if( anno.length() < 2 || anno.length() > 4 || anno.length() == 3)
	{
		System.err.println("Errore: anno sbagliato... " + anno);
		
	}
	else if (anno.length() == 2 )
	{
		// solo le ultime due cifre dell'anno'
		codiceFiscale += anno;
	} 
	else
	{
		codiceFiscale += anno.charAt(2) + anno.charAt(3); 	
	}
		
	//USIAMO IL  MESE PER IL CALCOLO DELLA LETTERA 	
		
	switch ( Integer.parseInt( mese ) ) 
	{
	
		case 1:
		{
			codiceFiscale += "A";
			break;
		}
		case 2:
		{
			codiceFiscale += "B";
			break;
		}
		case 3:
		{
			codiceFiscale += "C";
			break;
		}
		case 4:
		{
			codiceFiscale += "D";
			break;
		}
		case 5:
		{
			codiceFiscale += "E";
			break;
		}
		case 6:
		{
			codiceFiscale += "H";
			break;
		}
		case 7:
		{
			codiceFiscale += "L";
			break;
		}
		case 8:
		{
			codiceFiscale += "M";
			break;
		}
		case 9:
		{
			codiceFiscale += "P";
			break;
		}
		case 10:
		{
			codiceFiscale += "R";
			break;
		}
		case 11:
		{
			codiceFiscale += "S";
			break;
		}
		case 12:
		{
			codiceFiscale += "T";
			break;
		}
		
		//default:
		//	System.err.print("Unexpected value: " + mese);
	}	
	
	// GIORNO
	if( sesso.equals("M")) 
	{
		
		codiceFiscale += giorno; 
	}
	else
	{
		codiceFiscale += (giorno + 40); 
	}
		
	
	//AGGIUNGIAMO IL CODICE FISCO AL CODICE FISCALE 
	
	comuniDao codice_fisco = new comuniDao(accessoConnessione()); 
	
	
	codiceFiscale += codice_fisco.getCodiceFisco(comune_nascita); 	
	
	//TROVIAMO LE LETTERE PARI
	
	int somma = 0;
	
	for(int i = 0; i < codiceFiscale.length(); i++ ) 
	{
		if( i % 2 == 0 ) 
		{
			switch ( codiceFiscale.charAt(i) ) 
			{
			case 'A' :
			{
				somma += 0; 
			}
			case 'B':
			{
				somma += 1 ; 
			}
			case 'C':
			{
				somma += 2 ; 
			}
			case 'D':
			{
				somma += 3 ; 
			}
			case 'E':
			{
				somma += 4 ; 
			}
			case 'F':
			{
				somma += 5 ; 
			}
			case 'G':
			{
				somma += 6 ; 
			}
			case 'H':
			{
				somma += 7 ; 
			}
			case 'I':
			{
				somma += 8 ; 
			}
			case 'J':
			{
				somma += 9 ; 
			}
			case 'K':
			{
				somma += 10 ; 
			}
			case 'L':
			{
				somma += 11 ; 
			}
			case 'M':
			{
				somma += 12 ; 
			}
			case 'N':
			{
				somma += 13 ; 
			}
			case 'O':
			{
				somma += 14 ; 
			}
			case 'P':
			{
				somma += 15 ; 
			}
			case 'Q':
			{
				somma += 16 ; 
			}
			case 'R':
			{
				somma += 17 ; 
			}
			case 'S':
			{
				somma += 18 ; 
			}
			case 'T':
			{
				somma += 19 ; 
			}
			case 'U':
			{
				somma += 20 ; 
			}
			case 'V':
			{
				somma += 21 ; 
			}
			case 'W':
			{
				somma += 22 ; 
			}
			case 'X':
			{
				somma += 23 ; 
			}
			case 'Y':
			{
				somma += 24 ; 
			}
			case 'Z':
			{
				somma += 25 ; 
			}
			case '1':
			{
				somma += 1 ; 
			}
			case '2':
			{
				somma += 2 ; 
			}
			case '3':
			{
				somma += 3 ; 
			}
			case '4':
			{
				somma += 4 ; 
			}
			case '5':
			{
				somma += 5 ; 
			}
			case '6':
			{
				somma += 6 ; 
			}
			case '7':
			{
				somma += 7 ; 
			}
			case '8':
			{
				somma += 8 ; 
			}
			case '9':
			{
				somma += 9 ; 
			}
			
			
			
			
			default:
				
			}
		}
		else
		{
		
			switch ( codiceFiscale.charAt(i) ) 
			{
			case 'A' :
			{
				somma += 1; 
			}
			case 'B':
			{
				somma += 0 ; 
			}
			case 'C':
			{
				somma += 5 ; 
			}
			case 'D':
			{
				somma += 7 ; 
			}
			case 'E':
			{
				somma += 9 ; 
			}
			case 'F':
			{
				somma += 13 ; 
			}
			case 'G':
			{
				somma += 15 ; 
			}
			case 'H':
			{
				somma += 17 ; 
			}
			case 'I':
			{
				somma += 19; 
			}
			case 'J':
			{
				somma += 21 ; 
			}
			case 'K':
			{
				somma += 2 ; 
			}
			case 'L':
			{
				somma += 4 ; 
			}
			case 'M':
			{
				somma += 18 ; 
			}
			case 'N':
			{
				somma += 20 ; 
			}
			case 'O':
			{
				somma += 11 ; 
			}
			case 'P':
			{
				somma += 3 ; 
			}
			case 'Q':
			{
				somma += 6 ; 
			}
			case 'R':
			{
				somma += 8 ; 
			}
			case 'S':
			{
				somma += 12 ; 
			}
			case 'T':
			{
				somma += 14 ; 
			}
			case 'U':
			{
				somma += 16 ; 
			}
			case 'V':
			{
				somma += 10 ; 
			}
			case 'W':
			{
				somma += 22 ; 
			}
			case 'X':
			{
				somma += 25 ; 
			}
			case 'Y':
			{
				somma += 24 ; 
			}
			case 'Z':
			{
				somma += 23 ; 
			}
			case '0':
			{
				somma += 1 ; 
			}
			case '1':
			{
				somma += 0 ; 
			}
			case '2':
			{
				somma += 5 ; 
			}
			case '3':
			{
				somma += 7 ; 
			}
			case '4':
			{
				somma += 9 ; 
			}
			case '5':
			{
				somma += 13 ; 
			}
			case '6':
			{
				somma += 15 ; 
			}
			case '7':
			{
				somma += 17 ; 
			}
			case '8':
			{
				somma += 19 ; 
			}
			case '9':
			{
				somma += 21 ; 
			}
			
            default:
				
			}
			
		}
	}
	
	somma = somma % 26; 
	
	switch ( somma ) 
	{
	case 0 :
	{
		codiceFiscale += 'A'; 
	}
	case 1 :
	{
		codiceFiscale += 'B'; 
	}
	case 2 :
	{
		codiceFiscale += 'C'; 
	}
	case 3 :
	{
		codiceFiscale += 'D'; 
	}
	case 4 :
	{
		codiceFiscale += 'E'; 
	}
	case 5 :
	{
		codiceFiscale += 'F'; 
	}
	case 6 :
	{
		codiceFiscale += 'G'; 
	}
	case 7 :
	{
		codiceFiscale += 'H'; 
	}
	case 8 :
	{
		codiceFiscale += 'I'; 
	}
	case 9 :
	{
		codiceFiscale += 'J'; 
	}
	case 10 :
	{
		codiceFiscale += 'K'; 
	}
	case 11:
	{
		codiceFiscale += 'L' ; 
	}
	case 12:
	{
		codiceFiscale += 'M' ; 
	}
	case 13:
	{
		codiceFiscale += 'N' ; 
	}
	case 14:
	{
		codiceFiscale += 'O' ; 
	}
	case 15:
	{
		codiceFiscale += 'P' ; 
	}
	case 16:
	{
		codiceFiscale += 'Q' ; 
	}
	case 17:
	{
		codiceFiscale += 'R' ; 
	}
	case 18:
	{
		codiceFiscale += 'S' ; 
	}
	case 19:
	{
		codiceFiscale += 'T' ; 
	}
	case 20:
	{
		codiceFiscale += 'U' ; 
	}
	case 21:
	{
		codiceFiscale += 'V' ; 
	}
	case 22:
	{
		codiceFiscale += 'W' ; 
	}
	case 23:
	{
		codiceFiscale += 'X' ; 
	}
	case 24:
	{
		codiceFiscale += 'Y'; 
	}
	case 25:
	{
		codiceFiscale += 'Z' ; 
	}
	
	default:
			
	}
		
		return codiceFiscale; 
	}
	
	
	
public boolean controlloDati( JTextField Nome			,JTextField Cognome,		
								  JTextField anno_nascita	,JTextField mese_nascita		,JTextField giorno_nascita,
								  JTextField ComuneNascita	,JTextField comune_residenza	,  
								  JTextField cap			,JTextField provincia			/*,Inserimento_dati_persona persona,*/ 
								  /*ErroreInserimento errore*/
								) throws SQLException 
	{
		
		//  WORKING IN PROGRESS
		
		
	    Integer anno = Integer.valueOf(anno_nascita.getText()); 
		Integer mese =  Integer.valueOf( mese_nascita.getText() ); 
		Integer giorno =  Integer.valueOf( giorno_nascita.getText() );
	    
		/*int c = anno.byteValue(); 
		
		System.out.println("Sto convertendo in bytes: "+ anno.byteValue());
		System.out.println("Sto Eseguo nuovamente la conversione: "+ anno.reverseBytes( c ) );
		
		*/
		
		java.util.Date data = new java.util.Date( anno, mese, giorno);
		
		 long timeInMilliSeconds = data.getTime();
	     java.sql.Date date1 = new java.sql.Date(timeInMilliSeconds);
		
		long z = 12L;
	    Date data_nascita = new Date( anno, mese, giorno );
	   // Date data_nascita = new Date(  );

		String [] controllo_errori = new  String[4];
//		
		boolean flagProvincia = false;
		boolean flagComuneNascita = false;
		boolean flagCapComune = false; 
		boolean flagDataNascita = false;
		boolean flagGenerale = false; 
//		
		Errore_Inserimento_Dati finestra_di_errore;
//		
		boolean []vettore_flag = new boolean[3]; 
		
        int count = 0; 
		

        while(flagGenerale == false)
        {
	
        	flagComuneNascita = controlloComuneNascita(ComuneNascita); 
        	
        	flagProvincia = controlloProvincia(provincia); 
        	
        	flagCapComune = controlloCap(cap); 
        	
        	vettore_flag[0] = flagComuneNascita; 
    	    vettore_flag[1] = flagProvincia; 
    	    vettore_flag[2] = flagCapComune;
    	    
        	for(int i = 0; i < vettore_flag.length; i++) {
        		
                if(vettore_flag[i] == true)
                	count = count + 1; 
                
                if(count == 3)
                	flagGenerale = true; //esce
        		
        	}
        	count = 0; 
        }
        
        
        if ( flagGenerale != true )
		{
			finestra_di_errore = new Errore_Inserimento_Dati( controllo_errori );
			finestra_di_errore.setVisible(true);
		}   
        
//        
//		while( (flagProvincia == flagComuneNascita == flagCapComune == flagDataNascita) == true )
//	    {
//						
//			if( flagComuneNascita = controlloComuneNascita(ComuneNascita) == false )
//			{
//				controllo_errori[0] = "Inserimento del Comune Nascita errato";				
//			}
//			
//			if( flagProvincia = controlloProvincia(provincia) == false )
//			{
//				controllo_errori[1] = "Inserimento della Provincia errato";
//			}
//			
//			if( flagCapComune = controlloCap(cap) == false )
//			{
//				controllo_errori[2] = "Inserimento del CAP errato";
//		    }	 
//			
//			if( flagDataNascita = controlloDataNascita(data_nascita) == false )
//			{
//				controllo_errori[3] = "Inserimento della Data di Nascita errato\n( range accetto: 1951-2021 ))";
//			}
//			
//		
//			
//			
//	    }
//		
//		if ( !flagProvincia || !flagComuneNascita || !flagCapComune /* ||  !flagDataNascita */ )
//		{
//			finestra_di_errore = new Errore_Inserimento_Dati( controllo_errori );
//			finestra_di_errore.setVisible(true);
//		}
        
        
        
       
//		while( !flagProvincia || !flagComuneNascita || !flagCapComune /* ||  !flagDataNascita */)
//	    {
//						
//			if( flagComuneNascita = controlloComuneNascita(ComuneNascita) == false )
//			{
//				controllo_errori[0] = "Inserimento del Comune Nascita errato";				
//			}
//			
//			if( flagProvincia = controlloProvincia(provincia) == false )
//			{
//				controllo_errori[1] = "Inserimento della Provincia errato";
//			}
//			
//			if( flagCapComune = controlloCap(cap) == false )
//			{
//				controllo_errori[2] = "Inserimento del CAP errato";
//		}	 
//			
////			if( flagDataNascita = controlloDataNascita(data_nascita) == false )
////			{
////				controllo_errori[3] = "Inserimento della Data di Nascita errato\n( range accetto: 1951-2021 ))";
////			}
//			
//		
//			
//			
//	    }
//		
//		if ( !flagProvincia || !flagComuneNascita || !flagCapComune /* ||  !flagDataNascita */ )
//		{
//			finestra_di_errore = new Errore_Inserimento_Dati( controllo_errori );
//			finestra_di_errore.setVisible(true);
//		}
//		
		// inutile metterer sia il while ( fatto cosi ) e il return flag: 
		// il ciclo while finisce solo se le flag sono false -> il return sara solo falso. 
		
		return true; 
		
	}


					
public boolean controlloDataNascita( Date data)
{
	
	if (data.getYear() < 1950 || data.getYear() > LocalDate.now().getYear() )
	    return false;
	else
		return true; 
	
}



public boolean controlloCap(JTextField cap_comune) 
    {
		
	String cap = cap_comune.getText(); 
	
	
	String result = null ; 
	
	try
	{   
		
		System.out.println("sono prima nel try controlloCap");
		comuniDao comunedao = new comuniDao(accessoConnessione());
		
		System.out.println("ha preso la connessione");
		
		
		result = comunedao.getCapComune(cap);
		
		
		System.out.println("ecco la row del getCap\n" + result);
	}
	catch(SQLException e)
	{
		System.out.println("sono nel catch");
		result = null;
		//e.getStackTrace();
		
	}
	
	
	if (result == null) 
	{
		return false;
	}
	else 
	{
		return true; 
	}

	
	
	}
	

	
public boolean controlloProvincia(JTextField provincia) 
    {
		
		String provincia_nascita = provincia.getText(); 
		
		
		String result = null ; 
		
		try
		{   
			
			System.out.println("sono prima nel try controlloProvincia");
			comuniDao comunedao = new comuniDao(accessoConnessione());
			
			System.out.println("ha preso la connessione");
			
			
			result = comunedao.getProvinciaByNome(provincia_nascita);
			
			
			System.out.println("ecco la row del getProvincia\n" + result);
		}
		catch(SQLException e)
		{
			System.out.println("sono nel catch");
			result = null;
			//e.getStackTrace();
			
		}
		
		
		if (result == null) 
		{
			return false;
		}
		else 
		{
			return true; 
		}
	
	
	
	}
	
	

private boolean controlloComuneNascita(JTextField comuneNascita) {
		
		// aggiusta comuneNascita fatto
		// chiamta al db con comuneNascita 
		
		String comuneNascitaString = comuneNascita.getText();
//		int flagUpperCase = 0;
//		String tmp =""; 
//		
//		for ( int i = 0; i < comuneNascitaString.length(); i++)
//		{   
//				
//			char carattere = comuneNascitaString.charAt(i);
//			
//			if( carattere <= 90 && carattere >= 65)
//			{
//				if( flagUpperCase == 2)
//				{
//					tmp += " ";
//				}	
//				
//				flagUpperCase++;
//			}
//			
//			tmp += carattere;
//		}
//		
//		comuneNascitaString = tmp ;
//		
		String result =  null ; 
			
		try
		{   
			
			System.out.println("sono prima nel try controlloComune");
			comuniDao comunedao = new comuniDao(accessoConnessione());
			
			System.out.println("ha preso la connessione");
			
			
			result = comunedao.getComuneByNome(comuneNascitaString);
			
			
			System.out.println("ecco la row del getComune\n" + result);
		}
		catch(SQLException e)
		{
			System.out.println("sono nel catch");
			result = null;
			//e.getStackTrace();
			
		}
		
		
		if (result == null) 
		{
			return false;
		}
		else 
		{
			return true; 
		}
	}

public void inserimento_persone_tesserate_database(Persona_creata persona, Tesserato tesserato) throws SQLException 
{
	
	  PersonaDAOpostgre registrazione = new PersonaDAOpostgre(persona.getCodiceFiscale(), persona.getNome(),  persona.getCognome() , persona.getComuneNascita(), 
			                                                  persona.getComuneResidenza(),  persona.getVia(), persona.getProvinciaNascita(), 
			                                                  persona.getNumeroCivico(), persona.getCAP(), persona.getSesso(),      persona.getDataNascita(),      
			                                                  persona.isManagerOtesserato()); 
		
	  
	
	  
	  
	  
	  registrazione.inserisciPersona(persona, tesserato);
	  
	  /*	  
	  	String cognome, String comuneNascita, String comuneResidenza,
		String via, String provinciaNascita, int numeroCivico, int CAP, String sesso, Date dataNascita,
		boolean ManagerOtesserato
		*/
}





// basterebbe chiamare DBConnection.getInstance();
public static Connection accessoConnessione() throws SQLException {
	
	   DBConnection connessioneDB = DBConnection.getInstance(); 
	   Connection connection =   connessioneDB.getConnection();
	   
	  // System.out.println("connessione"+ connection);
	   
	 return connection; 
	
	}

}