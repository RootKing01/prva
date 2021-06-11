package Controller;



import java.awt.event.MouseAdapter;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

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



public String creazioneCodiceFiscale(JTextField cognome_utente, JTextField nome_utente, JTextField anno_nascita, JTextField mese_nascita,
									 JTextField giorno_nascita ,JComboBox Sesso_utente, JTextField comune_nascita_utente
								    ) throws SQLException 
{
		
	String cognome = cognome_utente.getText().toUpperCase(); 
	String nome = nome_utente.getText().toUpperCase();
	String anno = anno_nascita.getText();
	String mese = mese_nascita.getText();
	String giorno = giorno_nascita.getText(); 
	String sesso = (String) Sesso_utente.getSelectedItem().toString(); 
	String comune_nascita = comune_nascita_utente.getText()/*.toLower*/; 
	String codiceFiscale = new String(); 
	
	//Per l'anno, andiamo a creare un frammento di codice che ci prenda solo decine e unit�
	
	anno = anno.substring( anno.length() -3 , anno.length() -1 );
	
	
	// SETTO IL COMUNE CON SOLO LA PRIMA LETTERA MAIUSCOLA 
	
	
	String comune_esatto_per_database;  
	
	comune_esatto_per_database = comune_nascita;
	comune_nascita = "";
	
	for(int i = 0; i < comune_esatto_per_database.length(); i++) 
	{
		
		if( i == 0 )
		{
			comune_nascita += comune_esatto_per_database.charAt(i);
			comune_nascita.toUpperCase();
		}   
		else
		{
			comune_nascita += comune_esatto_per_database.charAt(i);	
		}
		
		
	}
	//comune_nascita = comune_nascita + " "; 
	
	
	System.out.println( "\necco il comune di nascita: " + comune_nascita );
	
   
	int count = 0; 
	int i = 0; 
	// PRENDIAMO LE PRIME 3 CONSONANTI DEL COGNOME 
	for( i = 0, count = 0; i < cognome.length(); i++ )
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
	
	
	if( count < 3)
	{
			for( i = 0; i < cognome.length(); i++) 
			{
				if(cognome.charAt(i) == 'A' || cognome.charAt(i) == 'E' || cognome.charAt(i) == 'I' || cognome.charAt(i) == 'O' || cognome.charAt(i) == 'U')
				{
					codiceFiscale +=  cognome.charAt(i);
				    count++; 
				    if(count == 3)
				    	break;
				}
		    }
		
	}
	
	//PRENDIAMO LA PRIMA, LA TERZA E LA QUARTA CONSONANTE DEL NOME
	 
	for(  i = 0, count = 0; i < nome.length(); i++ ) 
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
	
	if( count < 3)
	{
			for( i = 0; i < nome.length(); i++) 
			{
				if(nome.charAt(i) == 'A' || nome.charAt(i) == 'E' || nome.charAt(i) == 'I' || nome.charAt(i) == 'O' || nome.charAt(i) == 'U')
				{
					codiceFiscale +=  nome.charAt(i);
				    count++; 
				    if(count == 3)
				    	break;
				}
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
	System.out.println("Accedo alla connesione");
	
	comuniDao codice_fisco = new comuniDao(accessoConnessione()); 
	
	String codice_fisco_real = codice_fisco.getCodiceFisco(comune_nascita); 
	
	codiceFiscale += codice_fisco_real; 	
	
	System.out.println("Si presuppone abbia recuperato il codice fisco");
	
	System.out.println(codice_fisco.getComuneByNome(comune_nascita));
	
	// TROVIAMO LE LETTERE PARI
	
	int somma_pari = 0;
	int somma_dispari = 0; 
	int resto_totale = 0; 
	int somma_totale = 0; 
	
	
	
	
	for( i = 0; i < codiceFiscale.length(); i++ ) 
	{
		
		if( ( i + 1 )  % 2 == 0 ) 
		{
			switch ( codiceFiscale.charAt( i ) ) 
			{
				case 'A' :
				{
					somma_pari += 0; 
					break;
				}
				case 'B':
				{
					somma_pari += 1 ;
					break; 
				}
				case 'C':
				{
					somma_pari += 2 ;
					break; 
				}
				case 'D':
				{
					somma_pari += 3 ;
					break; 
				}
				case 'E':
				{
					somma_pari += 4 ;
					break; 
				}
				case 'F':
				{
					somma_pari += 5 ;
					break; 
				}
				case 'G':
				{
					somma_pari += 6 ;
					break; 
				}
				case 'H':
				{
					somma_pari += 7 ;
					break; 
				}
				case 'I':
				{
					somma_pari += 8 ;
					break; 
				}
				case 'J':
				{
					somma_pari += 9 ;
					break; 
				}
				case 'K':
				{
					somma_pari += 10 ;
					break; 
				}
				case 'L':
				{
					somma_pari += 11 ;
					break; 
				}
				case 'M':
				{
					somma_pari += 12 ;
					break; 
				}
				case 'N':
				{
					somma_pari += 13 ;
					break; 
				}
				case 'O':
				{
					somma_pari += 14 ;
					break; 
				}
				case 'P':
				{
					somma_pari += 15 ;
					break; 
				}
				case 'Q':
				{
					somma_pari += 16 ;
					break; 
				}
				case 'R':
				{
					somma_pari += 17 ;
					break; 
				}
				case 'S':
				{
					somma_pari += 18 ;
					break; 
				}
				case 'T':
				{
					somma_pari += 19 ;
					break; 
				}
				case 'U':
				{
					somma_pari += 20 ;
					break; 
				}
				case 'V':
				{
					somma_pari += 21 ;
					break; 
				}
				case 'W':
				{
					somma_pari += 22 ;
					break; 
				}
				case 'X':
				{
					somma_pari += 23 ;
					break; 
				}
				case 'Y':
				{
					somma_pari += 24 ;
					break; 
				}
				case 'Z':
				{
					somma_pari += 25 ;
					break; 
				}
				case '1':
				{
					somma_pari += 1 ;
					break; 
				}
				case '2':
				{
					somma_pari += 2 ;
					break; 
				}
				case '3':
				{
					somma_pari += 3 ;
					break; 
				}
				case '4':
				{
					somma_pari += 4 ;
					break; 
				}
				case '5':
				{
					somma_pari += 5 ;
					break; 
				}
				case '6':
				{
					somma_pari += 6 ;
					break; 
				}
				case '7':
				{
					somma_pari += 7 ;
					break; 
				}
				case '8':
				{
					somma_pari += 8 ;
					break; 
				}
				case '9':
				{
					somma_pari += 9 ;
					break; 
				}
				
				
				
			}
		}
		else
		{
		
			switch ( codiceFiscale.charAt(i) ) 
			{
			case 'A' :
			{
				somma_dispari += 1; 
				break; 
			}
			case 'B':
			{
				somma_dispari += 0 ;
				break; 
			}
			case 'C':
			{
				somma_dispari += 5 ; 
				break; 
			}
			case 'D':
			{
				somma_dispari += 7 ; 
				break; 
			}
			case 'E':
			{
				somma_dispari += 9 ;
				break; 
			}
			case 'F':
			{
				somma_dispari += 13 ;
				break; 
			}
			case 'G':
			{
				somma_dispari += 15 ;
				break; 
			}
			case 'H':
			{
				somma_dispari += 17 ;
				break; 
			}
			case 'I':
			{
				somma_dispari += 19;
				break; 
			}
			case 'J':
			{
				somma_dispari += 21 ;
				break; 
			}
			case 'K':
			{
				somma_dispari += 2 ;
				break; 
			}
			case 'L':
			{
				somma_dispari += 4 ;
				break; 
			}
			case 'M':
			{
				somma_dispari += 18 ; 
				break; 
			}
			case 'N':
			{
				somma_dispari += 20 ; 
				break; 
			}
			case 'O':
			{
				somma_dispari += 11 ; 
				break; 
			}
			case 'P':
			{
				somma_dispari += 3 ;
				break; 
			}
			case 'Q':
			{
				somma_dispari += 6 ;
				break; 
			}
			case 'R':
			{
				somma_dispari += 8 ;
				break; 
			}
			case 'S':
			{
				somma_dispari += 12 ;
				break; 
			}
			case 'T':
			{
				somma_dispari += 14 ;
				break; 
			}
			case 'U':
			{
				somma_dispari += 16 ;
				break; 
			}
			case 'V':
			{
				somma_dispari += 10 ;
				break; 
			}
			case 'W':
			{
				somma_dispari += 22 ;
				break; 
			}
			case 'X':
			{
				somma_dispari += 25 ;
				break; 
			}
			case 'Y':
			{
				somma_dispari += 24 ;
				break; 
			}
			case 'Z':
			{
				somma_dispari += 23 ;
				break; 
			}
			case '0':
			{
				somma_dispari += 1 ;
				break; 
			}
			case '1':
			{
				somma_dispari += 0 ;
				break; 
			}
			case '2':
			{
				somma_dispari += 5 ;
				break; 
			}
			case '3':
			{
				somma_dispari += 7 ;
				break; 
			}
			case '4':
			{
				somma_dispari += 9 ;
				break; 
			}
			case '5':
			{
				somma_dispari += 13 ;
				break; 
			}
			case '6':
			{
				somma_dispari += 15 ;
				break; 
			}
			case '7':
			{
				somma_dispari += 17 ;
				break; 
			}
			case '8':
			{
				somma_dispari += 19 ;
				break; 
			}
			case '9':
			{
				somma_dispari += 21 ; 
				break;
			}
			
		}
	}// end else
	
	}// end for
	
	
	
      
	
	
	somma_totale = somma_pari + somma_dispari; 
	resto_totale =  (somma_totale) % 26  ; 
	System.out.println(resto_totale);
	
	switch ( resto_totale ) 
	{
		case 0 :
		{
			codiceFiscale += 'A';
			break; 
		}
		case 1 :
		{
			codiceFiscale += 'B';
			break; 
		}
		case 2 :
		{
			codiceFiscale += 'C';
			break; 
		}
		case 3 :
		{
			codiceFiscale += 'D';
			break; 
		}
		case 4 :
		{
			codiceFiscale += 'E';
			break; 
		}
		case 5 :
		{
			codiceFiscale += 'F';
			break; 
		}
		case 6 :
		{
			codiceFiscale += 'G';
			break; 
		}
		case 7 :
		{
			codiceFiscale += 'H';
			break; 
		}
		case 8 :
		{
			codiceFiscale += 'I';
			break; 
		}
		case 9 :
		{
			codiceFiscale += 'J';
			break; 
		}
		case 10 :
		{
			codiceFiscale += 'K';
			break; 
		}
		case 11:
		{
			codiceFiscale += 'L' ;
			break; 
		}
		case 12:
		{
			codiceFiscale += 'M' ;
			break; 
		}
		case 13:
		{
			codiceFiscale += 'N' ;
			break; 
		}
		case 14:
		{
			codiceFiscale += 'O' ;
			break; 
		}
		case 15:
		{
			codiceFiscale += 'P' ;
			break; 
		}
		case 16:
		{
			codiceFiscale += 'Q' ;
			break; 
		}
		case 17:
		{
			codiceFiscale += 'R' ;
			break; 
		}
		case 18:
		{
			codiceFiscale += 'S' ;
			break; 
		}
		case 19:
		{
			codiceFiscale += 'T' ;
			break; 
		}
		case 20:
		{
			codiceFiscale += 'U' ;
			break; 
		}
		case 21:
		{
			codiceFiscale += 'V' ;
			break; 
		}
		case 22:
		{
			codiceFiscale += 'W' ;
			break; 
		}
		case 23:
		{
			codiceFiscale += 'X' ; 
			break;
		}
		case 24:
		{
			codiceFiscale += 'Y' ;
			break; 
		}
		case 25:
		{
			codiceFiscale += 'Z' ;
			break; 
		}
		
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
		
//		 long timeInMilliSeconds = data.getTime();
//	     java.sql.Date date1 = new java.sql.Date(timeInMilliSeconds);
		
		
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


					
public boolean controlloDataNascita( LocalDate data)
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