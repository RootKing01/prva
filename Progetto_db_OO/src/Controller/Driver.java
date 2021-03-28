package Controller;



import java.awt.event.MouseAdapter;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.sun.jdi.connect.spi.Connection;

import ClassiDAO.PersonaDAOpostgre;
import ClassiDatabase.Tesserato;
import ConnessioneDB.DBConnection;
import GUI.ErroreInserimento;
import GUI.General;
import GUI.Inserimento_dati_persona;
import GUI.Inserimento_persona_tesserata;


public class Driver {
  

	//Inserimento_dati_persona persona = new Inserimento_dati_persona(); 
	
	
	
	
	
	public static void main(String[] args) {
		
		DBConnection istanza = null; 
		Connection connessione = null; 
		Driver driver = new Driver(); 
		
		driver.Controller();
		
		try{
			
			
			istanza = DBConnection.getInstance(); 
			connessione = (Connection) istanza.getConnection(); 
          
		 
			
			PersonaDAOpostgre personadao = null; 
			
			
			
			
		}catch(SQLException e){
			
			
			
			
			
			
		}

	}



/////////////////////////////////////////////////****METODI****////////////////////////////////////////////////////
	
	public void inertTesseratoDB(Tesserato tesserato) {
		
		
		
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


public boolean controlloCodiceFiscale(JTextField CF, Inserimento_dati_persona inserimento_dati_persona){
	
	boolean flag = true; 
	
	if(CF.getText().length() != 16) 
	{
		System.out.println("errore, il CF deve essere di 16 caretteri");
		ErroreInserimento errore_codice_fiscale = new ErroreInserimento(inserimento_dati_persona); 
		errore_codice_fiscale.setVisible(true);
		flag = false; 
		
	}
	else
	{
		System.out.println("flag true");
		flag = true;
	}
	
	return flag; 
	
	
}
	
	
	
	
	

	
public boolean controlloDati( JTextField CF			,JTextField Nome 	,JTextField Cognome,
									 JTextField DataNascita	,int selectedIndex	,JTextField ComuneNascita,
									 JTextField provincia	,int selectedIndex2, Inserimento_dati_persona inserimento_dati_persona
								   ) 
{
			
		boolean flag = false;	
	     //controlli sulla validita dei dati; vediamo se � fatto bene il cf
	    // se tutto bene si passa al chiamare il db per la comboBox
		
		
		// per ogni errore si aggiunge una labale o una stringa di testo 
		// per ogni errore e alla fine si manda a schermo con una dialog
		
		if(!controlloCodiceFiscale(CF, inserimento_dati_persona))
		{
			ErroreInserimento errore_codice_fiscale = new ErroreInserimento(inserimento_dati_persona); 
			errore_codice_fiscale.setVisible(true);
		}
			
		
		
		


		return flag;




    }





public void controllerInserimentoPersona( JTextField CF , Inserimento_dati_persona inserimento_dati_persona) {
	
	     
	  boolean flag = true; 
	   
			  
	   while( flag != false)
       {

		  		flag = controlloCodiceFiscale(CF, inserimento_dati_persona); 
		  
		 }

     }
	
}


