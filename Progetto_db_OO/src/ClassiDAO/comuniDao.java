package ClassiDAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.Connection;

import ClassiDatabase.Comune;
import ConnessioneDB.DBConnection;

public class comuniDao {

    //Creiamo un oggetto connection di tipo Connection per effettuare la connessione al database 
	
	private Connection connection; 
	
   //Creiamo un oggetto di tipo PreparedStatment che è sempre di tipo sql e permette di fissare un comando sql da usare 
	
	private PreparedStatement getComuneByNome, inserisciComune; 
	
   //Creiamo ora il costruttore comuniDao che prende in input un oggetto di tipo connessione e che servirà  a gestire le operazioni con il DB
	
	public comuniDao(Connection connection) throws SQLException{
		
		this.connection = connection;   
	 
	 
   //Inizializiamo gli oggetti prima creati per le operazioni sql nel seguente modo. Osserviamo che il primo comando corrsiponde alla selezione
   //da una tabella del db
	 
	 getComuneByNome = connection.prepareStatement("SELECT * FROM comuni WHERE comune like ?"); 
	 
   //Questo ulteriore comando serve per inserire valori all'interno della tabella comuni (nel nostro caso, e che deve essere presente all'interno
   //del DB)

	 inserisciComune = connection.prepareStatement("INSERT INTO comuni VALUES (?, ?, ?, ?)"); 	
		
	}
	
	
	
	
	
    //Il metodo inserisciComune prende in inpu un oggetto comune e procede invece all'inserimento nel database (i valori devono essere in ordine
	//corretto)
	
	public int inserisciComune(Comune comune) throws SQLException
	    {
	      
		
		inserisciComune.setString(1, comune.getNomeComune() );
		inserisciComune.setString(2, comune.getCodiceFisco());
		inserisciComune.setString(3, comune.getCap() );
		inserisciComune.setString(4, comune.getProvincia() );
		
     //Il comando seguente committa in modo definitivo le operazioni 
		
		int row = inserisciComune.executeUpdate(); 
		return row; 
		
	    }
}