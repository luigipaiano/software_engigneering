package it.unisalento.myairbnb.dto;

public class AdminDTO {
	int idadmin;
	UtenteDTO utente;

	public int getIdadmin() {
		return idadmin;
	}
	
	public void setIdadmin(int idadmin) {
		this.idadmin = idadmin;
	}

	public UtenteDTO getUtente() {
		return utente;
	}

	public void setUtente(UtenteDTO utente) {
		this.utente = utente;
	}


}
