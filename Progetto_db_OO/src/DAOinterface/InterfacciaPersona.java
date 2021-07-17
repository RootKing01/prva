package DAOinterface;

import java.util.ArrayList;

import ClassiDatabase.Persona_creata;
import ClassiDatabase.Tesserato;

public interface InterfacciaPersona 
{
	
	public void inserisciPersona(Persona_creata persona, Tesserato tesserato);
	public boolean controlloManagerOtesserato(String codiceFiscale);
	public ArrayList<String> tutteLePersone();
	public ArrayList<String> getPersonaByNome( String nome, String cognome );
	public boolean controlloPersonaByCodiceFiscale( String codiceFiscale );
	public String controlloPasswordByCodiceFiscale( String codiceFiscale );
	public boolean deletePersonaByCodiceFiscale( String codiceFiscale );
	
}
