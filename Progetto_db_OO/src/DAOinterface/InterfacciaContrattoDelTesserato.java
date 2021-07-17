package DAOinterface;

import java.util.ArrayList;

public interface InterfacciaContrattoDelTesserato 
{

	public ArrayList<String> recap_contratti_tesserati( String codiceFiscaleManager_ );
	public ArrayList<String> recuperoContrattiAttiviUtenteTesserato( String codiceFiscale );
	public ArrayList<String> recuperoTuttiContrattiUtenteTesserato(String codiceFiscale);
	
	
}
