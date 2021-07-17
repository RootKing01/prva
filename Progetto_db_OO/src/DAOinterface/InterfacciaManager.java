package DAOinterface;

import java.util.ArrayList;

import ClassiDatabase.Manager;

public interface InterfacciaManager 
{
	
	public String  getManagerByNome(String nome);
	public ArrayList<Manager> getAtletiByManager(String codiceFiscale );
	public int inserisciManager(Manager manager);
	public String getCodiceFiscale();
	public void creazioneEinserimentoManager(String codiceFiscale);
	
	

}
