package Controller;



import java.awt.event.MouseAdapter;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

import java.sql.Connection;

import ClassiDAO.PersonaDAOpostgre;
import ClassiDAO.comuniDao;
import ClassiDatabase.Comune;
import ClassiDatabase.Tesserato;
import ConnessioneDB.DBConnection;
import GUI.ErroreInserimento;
import GUI.General;
import GUI.Inserimento_dati_persona;
import GUI.Inserimento_persona_tesserata;


public class Driver 
{
  
         
	
	
	
	  
	//Inserimento_dati_persona persona = new Inserimento_dati_persona(); 

	
	public static void main(String[] args) throws SQLException, IOException 
	{
		Driver driver = new Driver();	
		driver.Controller();
	
//		try
//		{   
//			
			 
			
			Comune comune = new Comune(); 
			
//			comune.insertComuni();
			
			
		 
		    System.out.println("Tutto a buon fine"); 
		
//			System.out.println("Comuni inseriti");
//			
//		}
//		catch(SQLException e)
//		{	
//			
//		}

	}



/////////////////////////////////////////////////****METODI****////////////////////////////////////////////////////
	
	public void inertTesseratoDB(Tesserato tesserato)
	{
			
	}

	
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


	public boolean controlloCodiceFiscale(JTextField CF)
	{
	
		boolean flag = true; 
		
		if(CF.getText().length() != 16) 
		{
			System.out.println("errore, il CF deve essere di 16 caretteri");
			//errore_codice_fiscale.setVisible(true);
			flag = false; 
			
		}
		else
		{
			System.out.println("flag=true");
			flag = true;
		}
		
		return flag; 
		
		
	}
		
	public boolean controlloProvincia(JTextField provincia) {
		
		
		boolean flag = false;
		 
		if(provincia.getText().length() < 2 || provincia.getText().length() > 3)
		{
			System.out.println("Inserire la provincia corretta");
//			errore_provincia.setVisible(true);
			
		}
		
//		qui c'è anche da chiamre una query sul db e controllare lappartenenza a provincia (variabile)
		
		
		return flag; 
	}
	
	
	

	
	public boolean controlloDati( JTextField CF				,JTextField Nome		,JTextField Cognome,		
								  JTextField DataNascita	,int selectedIndex		,JTextField ComuneNascita,
								  JTextField provincia		,int selectedIndex2,	Inserimento_dati_persona persona, 
								  ErroreInserimento errore
								) throws SQLException 
	{
		
		//  WORKING IN PROGRESS
		
		
		// flag == vero, concettualmente vuol dire che va utto bene oppure vuol dire che c'è un errore?
		
		boolean flagCodiceFiscale = true;
		boolean flagProvincia = true;
		boolean flagGenerale;
		boolean flagComuneNascita = true;
		
		
		while( flagCodiceFiscale && flagProvincia )
	    {
			//System.out.println("while controllo credenziali");
			flagComuneNascita = controlloComuneNascita(ComuneNascita);
		 	flagCodiceFiscale = controlloCodiceFiscale(CF); 
      	  
			flagProvincia = controlloProvincia(provincia);
				 
	    }
		
		
		// inutile metterer sia il while ( fatto cosi ) e il return flag: 
		// il ciclo while finisce solo se le flag sono false -> il return sara solo falso. 
		
		return 1!=1; 
		
	}
	
	

private boolean controlloComuneNascita(JTextField comuneNascita) {
		
		// aggiusta comuneNascita fatto
		// chiamta al db con comuneNascita 
		
		String comuneNascitaString = comuneNascita.getText().trim();
		int flagUpperCase = 0;
		String tmp =""; 
		
		for ( int i = 0; i < comuneNascitaString.length(); i++)
		{
				
			char carattere = comuneNascitaString.charAt(i);
			
			if( carattere <= 90 && carattere >= 65)
			{
				if( flagUpperCase == 2)
				{
					tmp += " ";
				}	
				
				flagUpperCase++;
			}
			
			tmp += carattere;
		}
		
		comuneNascitaString = tmp + " ";
		
		
		
		try
		{   
			
			System.out.println("sono prima nel try controlloComune");
			comuniDao comunedao = new comuniDao(accessoConnessione());
			
			System.out.println("ha preso la connessione");
			
			
			int row = comunedao.getComuneByNome(comuneNascitaString);
			
			
			System.out.println("ecco la row del getComune" + row);
		}
		catch(SQLException e)
		{
			System.out.println("sono nel catch");
			e.getStackTrace();
		}
		
		
		
		
		return false;
	}



public Connection accessoConnessione() throws SQLException {
	
	   DBConnection connessioneDB = DBConnection.getInstance(); 
	   Connection connection =   connessioneDB.getConnection();
	   
	  // System.out.println("connessione"+ connection);
	   
	 return connection; 
	
	}

}