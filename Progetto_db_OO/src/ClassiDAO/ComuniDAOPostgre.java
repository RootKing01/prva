package ClassiDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

import ClassiDatabase.Comune;
import ConnessioneDB.DBConnection;



public class ComuniDAOPostgre {

    //Creiamo un oggetto connection di tipo Connection per effettuare la connessione al database 
	
	private Connection connection; 
	
   //Creiamo un oggetto di tipo PreparedStatment che � sempre di tipo sql e permette di fissare un comando sql da usare 
	
	private PreparedStatement getComuneByNome, getCodiceFiscoByNome, getProvinciaByNome,  getCapComune,  inserisciComune; 
	         
	
   //Creiamo ora il costruttore comuniDao che prende in input un oggetto di tipo connessione e che servir�  a gestire le operazioni con il DB
	
	
	
	public ComuniDAOPostgre(Connection connection) throws SQLException{
		
		this.connection = connection;   
	 
	 
   //Inizializiamo gli oggetti prima creati per le operazioni sql nel seguente modo. Osserviamo che il primo comando corrsiponde alla selezione
   //da una tabella del db
	 
	 getComuneByNome = connection.prepareStatement("SELECT \"nomeComune\" FROM comuni WHERE \"nomeComune\" like ? ");

	 getCodiceFiscoByNome = connection.prepareStatement("SELECT \"codiceFisco\" FROM comuni WHERE \"nomeComune\" like  ?"); 
	 
	 getProvinciaByNome = connection.prepareStatement("SELECT * FROM comuni WHERE \"provincia\" like ?"); 
	 
	 getCapComune = connection.prepareStatement("SELECT * FROM comuni WHERE cap like ?"); 

   //Questo ulteriore comando serve per inserire valori all'interno della tabella comuni (nel nostro caso, e che deve essere presente all'interno
   //del DB)

	 inserisciComune = connection.prepareStatement("INSERT INTO comuni VALUES (?, ?, ?, ?)"); 	
		
	}
		

    //Il metodo inserisciComune prende in inpu un oggetto comune e procede invece all'inserimento nel database (i valori devono essere in ordine
	//corretto)
	public String getComuneByNome(String nome) throws SQLException
	{
	
		
		ResultSet rs = null;
		String nome_comune = nome +" "; 
		String comune = nome;
		
		
		try 
		{
			
			
	       	getComuneByNome.setString( 1 , nome_comune );
			
			rs = getComuneByNome.executeQuery();
			
			 
			rs.next();
			
			comune = rs.getString("nomeComune");
			
			rs.close();
			
		   	
		}
		catch (Exception e)
		{
			System.out.println("Errore da nomeComune: ");
			System.out.println( comune );		
		}
		
		
		
		return comune;
		
	}
	
	public String  getProvinciaByNome(String nome)
	{
		String provincia = ""; 
		
		try 
		{   
			getProvinciaByNome.setString(1, nome+" ");
			ResultSet rs = getProvinciaByNome.executeQuery();
			
			rs.next();
			
			provincia = rs.getString("provincia");	
			rs.close();
		}
		catch (Exception e) 
		{
			System.out.println("Errore da provincia: " + provincia);
		}
		
		return provincia;
	}
	
	public String  getCapComune(String cap_) throws SQLException
	{
		String cap = ""; 
		
		try 
		{   
			
			getCapComune.setString(1, cap_ );
			ResultSet rs =  getCapComune.executeQuery();
			
			rs.next();
			
			cap = rs.getString("cap");	
			
			rs.close();
		}
		catch (Exception e) 
		{
			System.out.println("Erroe: sezione executeQuery cap");
//			cap = null;
		}
		
		return cap;
		
	}
	
	
	
	public String getCodiceFisco(String comune_nascita )
	{
        String codice_fisco = ""; 
		
		try 
		{   
			
			getCodiceFiscoByNome.setString( 1 , comune_nascita+" ");
			
			ResultSet rs =  getCodiceFiscoByNome.executeQuery();
			
			rs.next(); 
			
			codice_fisco = rs.getString("codiceFisco");	
			
			rs.close();
		}
		catch (Exception e) 
		{
			System.out.println("Erroe: sezione executeQuery codiceFisco");
//			cap = null;
		}
		
		//System.out.println( codice_fisco );
		//System.out.println("ecco l'errore per vedere meglio" + rs.toString() );
		
		return codice_fisco;
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