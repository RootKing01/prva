package ClassiDatabase;

import java.sql.Date;
import java.time.LocalDate;

public class Persona_creata {

	private String codiceFiscale; 
	private String nome; 
	private String cognome; 
	private String comuneNascita; 
	private String comuneResidenza; 
	private String via; 
	private String provinciaNascita; 
	private int numeroCivico;
	private int CAP; 
	private LocalDate dataNascita; 
	private String sesso;
	private boolean managerOtesserato;
	
	
	
	
	public Persona_creata( String codiceFiscale, String nome, String cognome, LocalDate dataNascita, String comuneNascita, String comuneResidenza,
			String via, int numeroCivico, int cAP, String sesso,  String provinciaNascita,
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
		this.CAP = cAP;
		this.sesso = sesso;
		this.dataNascita = dataNascita;
		this.managerOtesserato = managerOtesserato;
	}




//	public Persona_creata( String codiceFiscale, String Nome, String Cognome, String ComuneNascita
//															,String ComuneResidenza, String Via,String  NumeroCivico
//															,String Sesso, String Provincia, String  ManagerOtesserato) 
//																
//		{
//			super();
//			this.codiceFiscale = codiceFiscale;
//			this.nome = Nome;
//			this.cognome = Cognome;
//			this.comuneNascita = ComuneNascita;
//			this.comuneResidenza = ComuneResidenza;
//			this.via = Via;
//			this.provinciaNascita = ProvinciaNascita;
//			this.numeroCivico = NumeroCivico;
//			this.CAP = cAP;
//			this.sesso = Sesso;
//			this.dataNascita = SataNascita;
//			this.managerOtesserato = ManagerOtesserato;
//	}






	








	public boolean isManagerOtesserato() {
		return managerOtesserato;
	}




	public void setManagerOtesserato(boolean managerOtesserato) {
		this.managerOtesserato = managerOtesserato;
	}


    
	public String getSesso() {
		return sesso;
	}


	
	public void setSesso(String sesso) {
		this.sesso = sesso;
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




	public LocalDate getDataNascita() {
		return dataNascita;
	}




	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}




	



	

}
