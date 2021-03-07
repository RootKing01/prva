package ClassiDAO;

import java.sql.Date;

public class Contratto {

	private int  codiceContratto; 
	private String codiceFiscale; 
	private String partitaIVAClub; 
	private String partitaIVASponsor; 
	private float remunerazioneContratto; 
	private float parcellaManager; 
	private Date dataInizio; 
	private Date dataFine; 
	private boolean sponsorOcontratto;
	
	
	public Contratto(int codiceContratto, String codiceFiscale, String partitaIVAClub, String partitaIVASponsor,
			float remunerazioneContratto, float parcellaManager, Date dataInizio, Date dataFine,
			boolean sponsorOcontratto) {
		super();
		this.codiceContratto = codiceContratto;
		this.codiceFiscale = codiceFiscale;
		this.partitaIVAClub = partitaIVAClub;
		this.partitaIVASponsor = partitaIVASponsor;
		this.remunerazioneContratto = remunerazioneContratto;
		this.parcellaManager = parcellaManager;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.sponsorOcontratto = sponsorOcontratto;
	}


	public int getCodiceContratto() {
		return codiceContratto;
	}


	public String getCodiceFiscale() {
		return codiceFiscale;
	}


	public String getPartitaIVAClub() {
		return partitaIVAClub;
	}


	public String getPartitaIVASponsor() {
		return partitaIVASponsor;
	}


	public float getRemunerazioneContratto() {
		return remunerazioneContratto;
	}


	public float getParcellaManager() {
		return parcellaManager;
	}


	public Date getDataInizio() {
		return dataInizio;
	}


	public Date getDataFine() {
		return dataFine;
	}


	public boolean isSponsorOcontratto() {
		return sponsorOcontratto;
	} 
	
}
