package DAOinterface;

import ClassiDatabase.Comune;

public interface InterfacciaComuni 
{
	public int inserisciComune( Comune comune );
	public String getCodiceFisco( String comune_nascita );
	public String  getCapComune(String cap_);
	public String  getProvinciaByNome(String nome);
	public String getComuneByNome(String nome);

}
