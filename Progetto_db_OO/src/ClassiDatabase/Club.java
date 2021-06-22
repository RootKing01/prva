package ClassiDatabase;

public class Club {

	private String partitaIVA; 
	private String codiceFederazioneSportiva; 
	private String sedeLegale; 
	private String nome;
	
	
	public Club(String partitaIVA,  String sedeLegale, String nome, String codiceFederazioneSportiva)
	{
		super();
		this.partitaIVA = partitaIVA;
		this.sedeLegale = sedeLegale;
		this.nome = nome;
		this.codiceFederazioneSportiva = codiceFederazioneSportiva;
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
