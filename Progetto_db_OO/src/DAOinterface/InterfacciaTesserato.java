package DAOinterface;

import java.util.ArrayList;

public interface InterfacciaTesserato 
{
	
    public ArrayList<String> conteggioTesserati( String codiceFiscaleManager );
    public void inserimentoMangerDelTesserato( String codice_fiscale_tesserato, String codice_fiscale_manager );
    public void eliminaManger( String codiceFiscaleTesserato);
	
}
