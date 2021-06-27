package ClassiDatabase;

import java.time.LocalDate;

public class contratto_del_tesserato {
	
	
	private String codiceFiscale;
	private String codiceFiscaleManager;
	private int gettoneNazionale;
	private String codiceFederazioneSportiva;
	private int codiceContratto;
	private LocalDate dataInizio;
	private LocalDate dataFine;
	private int remunerazioneContratto;
	private int parcellaManager;
	private String partitaIvaSponsor;
	private boolean clubOsponsor;
	private String partitaIvaClub;
	
	public  contratto_del_tesserato(String codiceFiscale, String codiceFiscaleManager, int gettoneNazionale, String codiceFederazioneSportiva,
			                        int codiceContratto, Object dataInizio, Object dataFine, int remunerazioneContratto, 
			                        int parcellaManager, String partitaIvaSponsor, boolean clubOsponsor, String partitaIvaClub
									) 
	{
		
		this.codiceFiscale = codiceFiscale;
		this.codiceFiscaleManager = codiceFiscaleManager;
		this.gettoneNazionale = gettoneNazionale;
		this.codiceFederazioneSportiva = codiceFederazioneSportiva;
		this.codiceContratto = codiceContratto;
		this.dataInizio = (LocalDate) dataInizio;
		this.dataFine = (LocalDate) dataFine;
		this.remunerazioneContratto = remunerazioneContratto;
		this.parcellaManager = parcellaManager;
		this.partitaIvaSponsor = partitaIvaSponsor;
		this.clubOsponsor = clubOsponsor;
		this.partitaIvaClub = partitaIvaClub;			                        	
		
		
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public String getCodiceFiscaleManager() {
		return codiceFiscaleManager;
	}

	public int getGettoneNazionale() {
		return gettoneNazionale;
	}

	public String getCodiceFederazioneSportiva() {
		return codiceFederazioneSportiva;
	}

	public int getCodiceContratto() {
		return codiceContratto;
	}

	public LocalDate getDataInizio() {
		return dataInizio;
	}

	public LocalDate getDataFine() {
		return dataFine;
	}

	public int getRemunerazioneContratto() {
		return remunerazioneContratto;
	}

	public int getParcellaManager() {
		return parcellaManager;
	}

	public String getPartitaIvaSponsor() {
		return partitaIvaSponsor;
	}

	public boolean isClubOsponsor() {
		return clubOsponsor;
	}

	public String getPartitaIvaClub() {
		return partitaIvaClub;
	}

}
