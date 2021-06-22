package ClassiDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ClassiDatabase.Sponsor;
import Controller.Driver;

public class SponsorDAO {

	
	private Connection connection;
	private PreparedStatement insertSocieta;
	private ResultSet rs;
	
	
	public SponsorDAO( ) throws SQLException
	{
		
		connection = Driver.accessoConnessione();
		
	   
	    insertSocieta = connection.prepareStatement("INSERT INTO \"sponsor\" values (?, ?, ?)"); 
				
	}


	public void insertSponsor( Sponsor sponsor ) throws SQLException
	{
		
		insertSocieta.setString(1, sponsor.getPartitaIVA());
		insertSocieta.setString(2, sponsor.getNomeSocieta());
		insertSocieta.setString(3, sponsor.getSedeLegale() );
		
		insertSocieta.executeUpdate();
	}


}
