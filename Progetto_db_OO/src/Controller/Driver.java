package Controller;



import java.awt.event.MouseAdapter;
import java.sql.SQLException;

import javax.swing.JFrame;

import com.sun.jdi.connect.spi.Connection;

import ClassiDAO.PersonaDAOpostgre;
import ClassiDatabase.Tesserato;
import ConnessioneDB.DBConnection;
import GUI.General;


public class Driver {
  

	public static void main(String[] args) {
		
		DBConnection istanza = null; 
		Connection connessione = null; 
		General prima_finestra = new General(this); 
		
		try{
			
			istanza = DBConnection.getInstance(); 
			connessione = (Connection) istanza.getConnection(); 
			prima_finestra.setVisible(true);
			
			PersonaDAOpostgre personadao = null; 
			
			
			
			
		}catch(SQLException e){
			
			
			
			
			
			
		}

	}



/////////////////////////////////////////////////****METODI****////////////////////////////////////////////////////
	
	public void inertTesseratoDB(Tesserato tesserato) {
		
		
		
	}

    public void funzione_finestra_visibile(JFrame Finestra, JFrame Finestra1) {
    	
    	Finestra.setVisible(false);    	
    	
    	Finestra1.setVisible(true);
    }














}
