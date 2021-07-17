package DAOinterface;

import ClassiDatabase.Sponsor;

public interface InterfacciaSponsor 
{
	
	public void insertSponsor( Sponsor sponsor );
	public void cancellaSponsor(String partitaIva);
	
}
