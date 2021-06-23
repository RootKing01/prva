package ClassiDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;

import ClassiDatabase.Club;
import Controller.Driver;

public class ClubDAO 
{

	private Connection connection;
	private PreparedStatement insertClub, deleteClub;
	private ResultSet rs;
	
	
	public ClubDAO() throws SQLException 
	{
		super();
		
		connection = Driver.accessoConnessione();	
		
		insertClub = connection.prepareStatement("INSERT INTO \"club\" values (?, ?, ?, ?)"); 
		
		deleteClub = connection.prepareStatement("DELETE FROM \"club\" WHERE \"partitaIva\" like ?");
	
		
		
		
		
		
	}
	
	
	public void deletClub( String partitaIva) throws SQLException
	{
		
		deleteClub.setString(1, partitaIva);
		deleteClub.executeUpdate();
		
	}
	
   	public void insertClub( Club club ) throws SQLException 
   	{
	   	insertClub.setString(1, club.getPartitaIVA() );
	   	insertClub.setString(2, club.getSedeLegale() );
	   	insertClub.setString(3, club.getNome() );
	  	insertClub.setString(4, club.getCodiceFederazioneSportiva() );
	   
		
	   	insertClub.executeUpdate();
 
   }
	



}
