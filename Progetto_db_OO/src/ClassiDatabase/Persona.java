package ClassiDatabase;

import java.sql.Date;

public class Persona {

	private String codiceFiscale; 
	private String nome; 
	private String cognome; 
	private String comuneNascita; 
	private String comuneResidenza; 
	private String via; 
	private String provinciaNascita; 
	private int numeroCivico;
	private int CAP; 
	private Date dataNascita; 
	private boolean managerOtesserato;
	
	
	
	
	public Persona(String codiceFiscale, String nome, String cognome, String comuneNascita, String comuneResidenza,
			String via, String provinciaNascita, int numeroCivico, int cAP, Date dataNascita,
			boolean managerOtesserato) {
		super();
		this.codiceFiscale = codiceFiscale;
		this.nome = nome;
		this.cognome = cognome;
		this.comuneNascita = comuneNascita;
		this.comuneResidenza = comuneResidenza;
		this.via = via;
		this.provinciaNascita = provinciaNascita;
		this.numeroCivico = numeroCivico;
		CAP = cAP;
		this.dataNascita = dataNascita;
		this.managerOtesserato = managerOtesserato;
	}




	public String getCodiceFiscale() {
		return codiceFiscale;
	}




	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}




	public String getNome() {
		return nome;
	}




	public void setNome(String nome) {
		this.nome = nome;
	}




	public String getCognome() {
		return cognome;
	}




	public void setCognome(String cognome) {
		this.cognome = cognome;
	}




	public String getComuneNascita() {
		return comuneNascita;
	}




	public void setComuneNascita(String comuneNascita) {
		this.comuneNascita = comuneNascita;
	}




	public String getComuneResidenza() {
		return comuneResidenza;
	}




	public void setComuneResidenza(String comuneResidenza) {
		this.comuneResidenza = comuneResidenza;
	}




	public String getVia() {
		return via;
	}




	public void setVia(String via) {
		this.via = via;
	}




	public String getProvinciaNascita() {
		return provinciaNascita;
	}




	public void setProvinciaNascita(String provinciaNascita) {
		this.provinciaNascita = provinciaNascita;
	}




	public int getNumeroCivico() {
		return numeroCivico;
	}




	public void setNumeroCivico(int numeroCivico) {
		this.numeroCivico = numeroCivico;
	}




	public int getCAP() {
		return CAP;
	}




	public void setCAP(int cAP) {
		CAP = cAP;
	}




	public Date getDataNascita() {
		return dataNascita;
	}




	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}




	public boolean isManagerOtesserato() {
		return managerOtesserato;
	}




	public void setManagerOtesserato(boolean managerOtesserato) {
		this.managerOtesserato = managerOtesserato;
	} 

}
