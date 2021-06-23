package ClassiDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ClassiDatabase.Contratto;
import Controller.Driver;

public class ContrattoDAO {
    
	private Connection connection;
	private PreparedStatement insertContratto, deleteContratto;
	private ResultSet rs;
	
	
	
	
	public ContrattoDAO() throws SQLException 
	{
		
		connection = Driver.accessoConnessione();	
		
		insertContratto = connection.prepareStatement("INSERT INTO \"contratto\" values ( ?, ?, ?, ?, ?, ?, ?, ? )");
		
		//deletContratto;
		
	}

   public void inserisciContratto( Contratto contratto ) throws SQLException 
   {
	
	   //insertContratto.setLong(1, contratto.getCodiceContratto());
	   insertContratto.setString(1, contratto.getCodiceFiscale());
	   insertContratto.setDate(2, contratto.getDataInizio());
	   insertContratto.setDate(3, contratto.getDataFine());
	   insertContratto.setFloat(4, contratto.getRemunerazioneContratto());
	   insertContratto.setFloat(5, contratto.getParcellaManager());
	   insertContratto.setBoolean(6, contratto.isSponsorOclub());
	   insertContratto.setString(7, contratto.getPartitaIVAClub());
	   insertContratto.setString(8, contratto.getPartitaIVASponsor());
	   
	   insertContratto.executeUpdate(); 
	   
   }

	
}
