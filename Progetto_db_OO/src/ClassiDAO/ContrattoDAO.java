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
	private PreparedStatement insertContratto, deleteContratto, modificaContrattoByManager, eliminaContrattoByManager;
	private ResultSet rs;
	
	
	
	
	public ContrattoDAO() throws SQLException 
	{
		
		connection = Driver.accessoConnessione();	
		
		insertContratto = connection.prepareStatement("INSERT INTO \"contratto\" ( \"codiceFiscale\", \"dataInizio\", \"dataFine\", \"remunerazioneContratto\", \"parcellaMenager\", \"PartitaIVAsponsor\",\"partitaIVAclub\", \"clubOsponsor\" ) values ( ?, ?, ?, ?, ?, ?, ?, ?)" );
		
		//deletContratto;
		
		modificaContrattoByManager = connection.prepareStatement(""); 
		
	}
   	public void inserisciContratto( Contratto contratto ) throws SQLException 
   	{
	
	   //insertContratto.setLong(1, contratto.getCodiceContratto());
		insertContratto.setString(1, contratto.getCodiceFiscale());
	    insertContratto.setObject(2, contratto.getDataInizio());
	    insertContratto.setObject(3, contratto.getDataFine());
	    insertContratto.setFloat(4, contratto.getRemunerazioneContratto());
	    insertContratto.setFloat(5, contratto.getParcellaManager());
	    insertContratto.setString(6, contratto.getPartitaIVASponsor());
		insertContratto.setString(7, contratto.getPartitaIVAClub());
	    insertContratto.setBoolean(8, contratto.isSponsorOclub());
	   	
	    insertContratto.executeUpdate(); 
	   
   	}

	
}
