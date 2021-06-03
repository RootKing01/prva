package ClassiDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Connection;

import ClassiDatabase.Comune;
import ConnessioneDB.DBConnection;



public class comuniDao {

    //Creiamo un oggetto connection di tipo Connection per effettuare la connessione al database 
	
	private Connection connection; 
	
   //Creiamo un oggetto di tipo PreparedStatment che è sempre di tipo sql e permette di fissare un comando sql da usare 
	
	private PreparedStatement getComuneByNome, getCodiceFiscoByNome, getProvinciaByNome,  getCapComune,  inserisciComune; 
	private ResultSet rs;
	
   //Creiamo ora il costruttore comuniDao che prende in input un oggetto di tipo connessione e che servirà  a gestire le operazioni con il DB
	
	
	
	public comuniDao(Connection connection) throws SQLException{
		
		this.connection = connection;   
	 
	 
   //Inizializiamo gli oggetti prima creati per le operazioni sql nel seguente modo. Osserviamo che il primo comando corrsiponde alla selezione
   //da una tabella del db
	 
	 getComuneByNome = connection.prepareStatement("SELECT * FROM comuni WHERE \"nomeComune\" like '?'"); 
	 
	 getCodiceFiscoByNome = connection.prepareStatement("SELECT \"codiceFisco\" FROM comuni WHERE \"codiceFisco\" like '?'"); 
	 
	 getProvinciaByNome = connection.prepareStatement("SELECT * FROM comuni WHERE \"provincia\" like '?'"); 
	 
	 getCapComune = connection.prepareStatement("SELECT * FROM comuni WHERE \"cap\" like '?'"); 

   //Questo ulteriore comando serve per inserire valori all'interno della tabella comuni (nel nostro caso, e che deve essere presente all'interno
   //del DB)

	 inserisciComune = connection.prepareStatement("INSERT INTO comuni VALUES (?, ?, ?, ?)"); 	
		
	}
	
		
	
    //Il metodo inserisciComune prende in inpu un oggetto comune e procede invece all'inserimento nel database (i valori devono essere in ordine
	//corretto)
	public String  getComuneByNome(String nome) throws SQLException
	{
		String comune = nome; 
		
		try 
		{   
			getComuneByNome.setString(0, nome+" ");
			rs = getComuneByNome.executeQuery();
			comune = rs.getString("nomeComune");	
			  
		}
		catch (Exception e) 
		{
			
		}
		
		return comune;
		
	}
	
	public String  getProvinciaByNome(String nome) throws SQLException
	{
		String provincia = nome; 
		
		try 
		{   
			getProvinciaByNome.setString(0, nome+" ");
			rs = getProvinciaByNome.executeQuery();
			provincia = rs.getString("provincia");	
			  
		}
		catch (Exception e) 
		{
			
		}
		
		return provincia;
	}
	
	public String  getCapComune(String cap_) throws SQLException
	{
		String cap = cap_; 
		
		try 
		{   
			getCapComune.setString(0, cap_ );
			rs = getCapComune.executeQuery();
			cap = rs.getString("cap");	
			  
		}
		catch (Exception e) 
		{
//			System.out.println("Erroe: sezione executeQuery cap");
//			cap = null;
		}
		
		return cap;
		
	}
	
	
	
	public String getCodiceFisco(String comune_nascita ) throws SQLException
	{
		
		getCodiceFiscoByNome.setString(0, comune_nascita); 
		rs = getCodiceFiscoByNome.executeQuery();
		String result = rs.getString("codiceFisco"); 
		
		
		return result;
		
	}
	



	public int inserisciComune(Comune comune) throws SQLException
	    {
	      
		
		inserisciComune.setString(0, comune.getNomeComune() );
		inserisciComune.setString(1, comune.getCodiceFisco());
		inserisciComune.setString(2, comune.getCap() );
		inserisciComune.setString(3, comune.getProvincia() );
		
     	//Il comando seguente committa in modo definitivo le operazioni 
		
		int row = inserisciComune.executeUpdate(); 
		return row; 
		
	    }
    
   
	
}