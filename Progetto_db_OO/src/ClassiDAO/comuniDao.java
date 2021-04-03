package ClassiDAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.Connection;

import ClassiDatabase.Comune;

public class comuniDao {

	private Connection connection; 
	private PreparedStatement getComuneByNome, inserisciComune; 
	

	public comuniDao(Connection connection) throws SQLException{
		
	 this.connection = connection; 
	 
	 getComuneByNome = connection.prepareStatement("SELECT * FROM comuni WHERE comune like ?"); 
	 inserisciComune = connection.prepareStatement("INSERT INTO comuni VALUES (?, ?, ?, ?)"); 	
		
	}
	
	
	
	
	
	
	
	public int inserisciComune(Comune comune) throws SQLException
	    {
	      
		
		inserisciComune.setString(1, comune.getNomeComune() );
		inserisciComune.setString(2, comune.getCodiceFisco());
		inserisciComune.setString(3, comune.getCap() );
		inserisciComune.setString(4, comune.getProvincia() );
		
		int row = inserisciComune.executeUpdate(); 
		return row; 
		
//		
//		  inserisciStudentePS.setString(1, comune.getNomeComune());
//	        inserisciStudentePS.setString(2, studente.getNome());
//	        inserisciStudentePS.setString(3, studente.getCognome());
//	        inserisciStudentePS.setString(4, studente.getEmail());
//	        int row = inserisciStudentePS.executeUpdate();
//	        return row;
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
