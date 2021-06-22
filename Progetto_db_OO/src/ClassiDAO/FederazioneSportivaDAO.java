package ClassiDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Controller.Driver;

public class FederazioneSportivaDAO {

	private Connection connection;
	private PreparedStatement insertFederazioneSportiva;
	private ResultSet rs;
	
	
	public FederazioneSportivaDAO( ) throws SQLException 
	{
		
		super();
		
		connection = Driver.accessoConnessione();
		
		insertFederazioneSportiva = connection.prepareStatement("INSERT INTO \"federazioneSportiva\" values (?)");
		
		
		
	}

	
	public void insertFederazioniSportive() throws SQLException 
	{
		
		String [] codici_federazioni_sportive = { "AECI" ,"ACI", "FIDAL", "FIBA", "FIBS", "FIB", "FIDS", "FIDASC", "FIGC", "FICK", "FIC", "FCI", "FICR", "FGI", "FIG", "FIGH", "FIGS", "FIH", "FISR", "FIJLKAM", "FMSI", "FMI", "FIM", "FIN", "FIP", "FIPAV", "FIPM", "FIPSAS", "FIPE", "FPI", "FIR", "FIS", "FISW", "FISG", "FISE", "FISI", "FITA", "FIT", "FITET", "UITS", "FITAV", "FITARCO", "FITRI", "FIV" };
		
		for(int i = 0; i < codici_federazioni_sportive.length; i++) 
		{
			
			insertFederazioneSportiva.setString(1, codici_federazioni_sportive[i]);
			
			insertFederazioneSportiva.executeUpdate();
			 
		}
		
	}

	
}
