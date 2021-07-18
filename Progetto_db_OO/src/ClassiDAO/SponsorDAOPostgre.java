package ClassiDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ClassiDatabase.Sponsor;
import Controller.Driver;

public class SponsorDAOPostgre {

	
	private Connection connection;
	private PreparedStatement insertSocieta, deleteSocieta;
	private ResultSet rs;
	
	
	public SponsorDAOPostgre( ) throws SQLException
	{
		
		connection = Driver.accessoConnessione();
		
	   
	    insertSocieta = connection.prepareStatement("INSERT INTO \"sponsor\" values (?, ?, ?)"); 
	    
	    deleteSocieta = connection.prepareStatement("DELETE FROM \"sponsor\" WHERE \"partitaIva\" like ?"); 
				
	}


	public void insertSponsor( Sponsor sponsor ) throws SQLException
	{
		
		insertSocieta.setString(1, sponsor.getPartitaIVA());
		insertSocieta.setString(2, sponsor.getNomeSocieta());
		insertSocieta.setString(3, sponsor.getSedeLegale() );
		
		insertSocieta.executeUpdate();
	}
   
	public void cancellaSponsor(String partitaIva) throws SQLException 
	{
		deleteSocieta.setString(1, partitaIva);
		
		deleteSocieta.executeUpdate(); 
	}

}
