package ClassiDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ClassiDatabase.Comune;
import ClassiDatabase.Manager;
import Controller.Driver;

public class ManagerDAOpostgre {

	

	private String codiceFiscale;
	private Connection connection; 
	private PreparedStatement getManagerByNome,  inserisciManager, getAtletiByManager; 
	private ResultSet rs, rb;

///COSTRUTTORE
	
	public ManagerDAOpostgre( Connection connection) throws SQLException {
		 
		this.connection = connection;
		
		 inserisciManager = connection.prepareStatement("INSERT INTO manager VALUES (?)");
		
		 getManagerByNome = connection.prepareStatement("SELECT * FROM persona_ WHERE managerOtesserato like ?"); 
		 
		 getAtletiByManager =  connection.prepareStatement("SELECT * FROM tesserato WHERE codiceFiscaleManager like ?"); 
		 
		
	}
////////////	


////////////////////////////////////////////////////////////****METODI***/////////////////////////////////////////////////////////////////////////////////
	
	
	public String  getManagerByNome(String nome) throws SQLException
	{
		getManagerByNome.setString(1, nome);
		rs = getManagerByNome.executeQuery();
		String result = "Nome: " + rs.getString("nome") + "Cognome:  " + rs.getString("cognome") + " \t"+"Codice Fiscale: " + rs.getString("codiceFiscale");
		
		return result; 
	}
	// getPersoabyCF
	
	public ArrayList<Manager> getAtletiByManager(String codiceFiscale ) throws SQLException
	{
		
		ArrayList<Manager> atleti = new ArrayList<Manager>();  
		
		getAtletiByManager.setString(1, codiceFiscale);
		
		rs = inserisciManager.executeQuery(); 
		
		while(rs.next()) 
		{
			
			
			String result = (String) ("Codice Fiscale : " + rs.getString("codiceFiscale") + "Gettoni nazionali :  " + rs.getString("gettoneNazionale") + " \t"+"Codice federazione sportiva : " + rs.getString("CodiceFederazioneSportiva"));
			//Manager tipo = new Manager(rs.getString("codiceFiscale"), rs.getString, result, result, result, result, result, 0, 0, null);
			 
			
			//atleti.add(tipo);  
			
		}
		
		return atleti;
		
	}
	
	
	
	public int inserisciManager(Manager manager) throws SQLException
    {
      
	
	inserisciManager.setString(1, manager.getCodiceFiscale());
	
 	//Il comando seguente committa in modo definitivo le operazioni 
	
	int row = inserisciManager.executeUpdate(); 
	return row; 
	
    }
	
	
	
	
	
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	
	public void addTesserato(Tesserato tesserato) {
		
	
	}
	
	public void removeTesserato(Tesserato tesserato) {
		
		
		
	}
	
	
	public void creazioneEinserimentoManager(String codiceFiscale) {
		
		if(this.codiceFiscale.equals(codiceFiscale))
			System.out.println();
			
		
	}


}
  
  