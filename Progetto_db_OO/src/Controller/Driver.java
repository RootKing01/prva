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
	
public boolean controlloProvincia(JTextField provincia, Inserimento_dati_persona inserimento_dati_persona) {
	
	
	boolean flag = false;
	
	if(provincia.getText().length() < 2 || provincia.getText().length() > 3) {
		System.out.println("Inserire la provincia corretta");
		ErroreInserimento errore_provincia =  new ErroreInserimento(inserimento_dati_persona); 
	}
	
	
	return flag; 
}
	
	
	

	
public boolean controlloDati( JTextField CF			,JTextField Nome 	,JTextField Cognome,
									 JTextField DataNascita	,int selectedIndex	,JTextField ComuneNascita,
									 JTextField provincia	,int selectedIndex2, Inserimento_dati_persona inserimento_dati_persona
								   ) 
{
			
	
	 boolean flag = true; 
	   
	  
	   while( flag != false)
     {

		  		flag = controlloCodiceFiscale(CF, inserimento_dati_persona); 
		        flag = controlloProvincia(provincia, inserimento_dati_persona); 
		 }
		


		return flag;




    }


  }

