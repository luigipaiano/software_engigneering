package it.unisalento.myairbnb.dto;

public class ProponenteDTO {
	
	int idproponente;
	String telefono;
	String indirizzo;
	String citta;
	String cap;
	UtenteDTO utente;
	
	public int getIdproponente() {
		return idproponente;
	}
	public void setIdproponente(int idproponente) {
		this.idproponente = idproponente;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public String getCap() {
		return cap;
	}
	public void setCap(String cap) {
		this.cap = cap;
	}
	public UtenteDTO getUtente() {
		return utente;
	}
	public void setUtente(UtenteDTO utente) {
		this.utente = utente;
	}

}
