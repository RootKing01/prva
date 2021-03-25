package Controller;



import java.awt.event.MouseAdapter;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.sun.jdi.connect.spi.Connection;

import ClassiDAO.PersonaDAOpostgre;
import ClassiDatabase.Tesserato;
import ConnessioneDB.DBConnection;
import GUI.ErroreCodiceFiscale;
import GUI.General;
import GUI.Inserimento_dati_persona;


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




public boolean ControlloDatiPersona( JTextField CF			,JTextField Nome 	,JTextField Cognome,
									 JTextField DataNascita	,int selectedIndex	,JTextField ComuneNascita,
									 JTextField provincia	,int selectedIndex2
								   ) 
{
			
		boolean flag = false;	
	     //controlli sulla validita dei dati; vediamo se è fatto bene il cf
	    // se tutto bene si passa al chiamare il db per la comboBox
		
		
		// per ogni errore si aggiunge una labale o una stringa di testo 
		// per ogni errore e alla fine si manda a schermo con una dialog
		
		
		if(CF.toString().length()  != 16)
		{	
			
      
			System.out.println("errore, il CF deve essere di 16 caretteri");
			ErroreCodiceFiscale erroreCF = new ErroreCodiceFiscale();  
			 erroreCF.setVisible(true); 
    	    //persona.setVisible(false); 
			flag = true;	
		
		
}

		return flag;




    }

}
