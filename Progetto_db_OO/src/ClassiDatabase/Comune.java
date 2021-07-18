package ClassiDatabase;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.text.PlainDocument;

import java.sql.PreparedStatement;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import ClassiDAO.ComuniDAOPostgre;
import ConnessioneDB.DBConnection;
import Controller.Driver;






public class Comune {
	
	

	
	public Comune(){}
	
	public Comune(String comune, String provincia, String cap, String codiceFisco) {
	super(); 
	//this.nomeComune = comune;
	//this.provincia = provincia;
	//this.cap = cap;
	//this.codiceFisco = codiceFisco;


	setNomeComune(comune);
	setProvincia(provincia);
	setCap(cap);
	setCodiceFisco(codiceFisco);
	
	}
	
	
	private String nomeComune; 
	private String provincia; 
	private String cap; 
	private String codiceFisco; 
	
	public String getNomeComune() {
		return nomeComune;
	}
	
	public void setNomeComune(String nomeComune) {
		this.nomeComune = nomeComune;
	}
	
	public String getProvincia() {
		return provincia;
	}
	
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	public String getCap() {
		return cap;
	}
	
	public void setCap(String cap) {
		this.cap = cap;
	}
	
	public String getCodiceFisco() {
		return codiceFisco;
	}
	
	public void setCodiceFisco(String codiceFisco) {
		this.codiceFisco = codiceFisco;
	}
	
 
	
	
	public void letturaComuni() throws IOException {
	    
	//Creaiamo un oggetto f di tipo FileReader che indirizza il file da leggere 
		
	    FileReader  f = new FileReader("File\\listacomuni.txt");

    //Adesso creiamo invece un oggetto b di tipo BufferedReader che prende in input il file da leggere 
	    
	    BufferedReader b = new BufferedReader(f);

	    String s; 
		int count = 4;
	 //Tramite il metodo readline prendiamo le stringhe dal file e con s ne recuperiamo il contenuto	   
	    

		s = b.readLine();
		System.out.println(s);
		s = b.readLine();
		System.out.println(s);
		s = b.readLine();
		System.out.println(s);
		s = b.readLine();
		System.out.println(s);
	    while((s = b.readLine()) != null) {
	    		
			
				
    	
	//Eseguiamo un controllo sulla stringa presa per vedere se effettivamente � stato recuperato il contenuto  
		//modificaFile(s);

//	      System.out.println(s);
	      
	    } 
	//Chiudiamo il buffer 
	      b.close();
	//Chiudiamo il file reader      
	      f.close();
  }
	


public void modificaFile(String s) throws IOException {
	
	//Il metodo prende in input una stringa da analizzare, ovvero quella letta dal file nel metodo letturaFile
	  
	String input = s;
	
	//Creiamo un nuovo oggetto scanner che prende in input la stringa passata al metodo e ne appplica delle limitazioni tramite il metodo
	//useDelimiter, che permette di applicare espressioni regolari o con caratteri che hanno uno specifico significato che determinano operazioni
	//sul testo
	   
	   Scanner scanner = new Scanner(input).useDelimiter(";");
	   
	//Creiamo un oggetto writer di tipo FileWriter per indicare o creare il file da scrivere
	   
	   FileWriter writer = new FileWriter("File\\listacomunidb.txt", true);
	   
	//Creiamo un oggetto printer di tipo PrintWriter che prende l'oggetto su cui andare a scrivere 
	   
	   PrintWriter printer = new PrintWriter(writer);	    
	   
	   for(int i= 0; i<9; i++){
		   
			String tmp;
			
    //La stringa tmp prende il contenuto della stringa risultante da scanner.next(), stringa che risulta essere quella passata al metodo
			
			System.out.println(tmp=scanner.next());
   
	//Il seguente if ci dice che deve considerare le stringhe in posizione 2,3,6,7 rispetto al file (limitazioni tramite ; visto sopra)
			
			if(i == 1 || i == 2 || i == 5 || i == 6 )
			{
	
	//La seguente stringa di codice stampa all'interno del file la stringa nel caso in cui la condizione sia vera 
		
				printer.println(tmp+" "); 
				
			}
				
		                         }
		
	//Viene chiuso lo scanner che prende in input le stringhe passate al metodo
	    
	   scanner.close(); 
	    // f.close();
	   
	//Chiudiamo il printer 
	   
	   printer.close();
	
   }

 public void insertComuni() throws IOException, SQLException {
	 
	 FileReader  f = new FileReader("File\\listacomunidb.txt");
	 
	 BufferedReader b = new BufferedReader(f);
	 
	 String string_comune , string_codiceFisco, string_cap, string_provincia ; 
	 
	 string_comune = b.readLine(); 
	 string_codiceFisco = b.readLine();
	 string_cap = b.readLine();
	 string_provincia = b.readLine();
	
	 while(string_comune != null && string_codiceFisco != null && string_cap != null && string_provincia != null) {
		 
		 string_comune = b.readLine(); 
		 string_codiceFisco = b.readLine();
	 	 string_cap = b.readLine();
	 	 string_provincia = b.readLine();
		 
		
		  Comune comune = new Comune(string_comune, string_codiceFisco, string_cap, string_provincia);
		
		  Driver driver = new Driver(); 
		  Connection connection = driver.accessoConnessione(); 
				
		  ComuniDAOPostgre comuneDao = new ComuniDAOPostgre(connection); 	 
		  comuneDao.inserisciComune(comune); 
				 
				 
				
		 
		 
	 }
	    
       b.close();
	 f.close();
 }

}