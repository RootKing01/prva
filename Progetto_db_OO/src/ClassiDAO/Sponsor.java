package ClassiDAO;

public class Sponsor {

	private String partitaIVA; 
	private String nomeSocieta; 
	private String  sedeLegale;
	
	
	public Sponsor(String partitaIVA, String nomeSocieta, String sedeLegale) {
		super();
		this.partitaIVA = partitaIVA;
		this.nomeSocieta = nomeSocieta;
		this.sedeLegale = sedeLegale;
	}


	public String getPartitaIVA() {
		return partitaIVA;
	}


	public String getNomeSocieta() {
		return nomeSocieta;
	}


	public String getSedeLegale() {
		return sedeLegale;
	} 
	

}
