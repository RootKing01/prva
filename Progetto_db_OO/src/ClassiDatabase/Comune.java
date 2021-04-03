package ClassiDatabase;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Comune {

	public static void main(String[] args) throws IOException {
		
		Comune comune = new Comune(); 
		
		comune.letturaComuni();
		
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
	    
	    FileReader  f = new FileReader("File\\listacomuni.txt");

	    BufferedReader b = new BufferedReader(f);

	    String s; 

	    while(true) {
	      
	      s = b.readLine();
	     
	      
	     
	     if(s == null)
	        	break;
	      
			modificaFile(s);

//	      System.out.println(s);
	      
	    } 
	
	      b.close();
	      
	      f.close();
  }
	
//	StringBuilder resultStringBuilder = new StringBuilder();
//    try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
//        String line;
//        while ((line = br.readLine()) != null) {
//            resultStringBuilder.append(line).append("\n");
//        }
//	
//	
//	
//	
//    }	
	
  


public void modificaFile(String s) throws IOException {
	
	   String input = s;
	   Scanner scanner = new Scanner(input).useDelimiter(";");

	   FileWriter writer = new FileWriter("File\\listacomunidb.txt", true);
	   PrintWriter boh = new PrintWriter(writer);	    
	   
	   for(int i= 0; i<9; i++){
			String tmp;
			System.out.println(tmp=scanner.next());
			if(i == 1 || i == 2 || i == 5 || i == 6 )
			{
				boh.println(tmp+" "); 
				
			}
				
		}
		
	     scanner.close(); 
	    // f.close();
	     boh.close();
	
}




















}


