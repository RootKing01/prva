package ClassiDatabase;

import java.sql.Date;
import java.time.LocalDate;

public class Contratto {
 
	private String codiceFiscale; 
	private String partitaIVAClub;
	private String partitaIVASponsor;
	private float remunerazioneContratto; 
	private float parcellaManager; 
	private LocalDate dataInizio; 
	private LocalDate dataFine; 
	private boolean sponsorOclub;
	
	
	public Contratto( String codiceFiscale, String partitaIVA,
					  float remunerazioneContratto, float parcellaManager, LocalDate dataInizio, LocalDate dataFine,
					  boolean sponsorOclub
					) 
	{
		
		super();
		this.codiceFiscale = codiceFiscale;
		
		if( sponsorOclub )
		{
			partitaIVASponsor = partitaIVA;
			partitaIVAClub = null;
		}
		else
		{
			partitaIVAClub = partitaIVA;
			partitaIVASponsor = null;
		}
		
		this.remunerazioneContratto = remunerazioneContratto;
		this.parcellaManager = parcellaManager;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.sponsorOclub = sponsorOclub;
	}



	public String getCodiceFiscale() {
		return codiceFiscale;
	}


	public String getPartitaIVASponsor() {
		return partitaIVASponsor;
	}

	public String getPartitaIVAClub() {
		return partitaIVAClub;
	}

	public float getRemunerazioneContratto() {
		return remunerazioneContratto;
	}


	public float getParcellaManager() {
		return parcellaManager;
	}


	public LocalDate getDataInizio() {
		return dataInizio;
	}


	public LocalDate getDataFine() {
		return dataFine;
	}


	public boolean isSponsorOclub() {
		return sponsorOclub;
	} 
	
}
