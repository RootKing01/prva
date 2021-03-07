package ClassiDAO;

public class Club {

	private String partitaIVA; 
	private String codiceFederazioneSportiva; 
	private String sedeLegale; 
	private String nome;
	
	
	public Club(String partitaIVA, String codiceFederazioneSportiva, String sedeLegale, String nome) {
		super();
		this.partitaIVA = partitaIVA;
		this.codiceFederazioneSportiva = codiceFederazioneSportiva;
		this.sedeLegale = sedeLegale;
		this.nome = nome;
	}


	public String getPartitaIVA() {
		return partitaIVA;
	}


	public String getCodiceFederazioneSportiva() {
		return codiceFederazioneSportiva;
	}



	public String getSedeLegale() {
		return sedeLegale;
	}




	public String getNome() {
		return nome;
	}




}
