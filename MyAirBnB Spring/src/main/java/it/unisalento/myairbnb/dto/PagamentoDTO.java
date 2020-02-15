package it.unisalento.myairbnb.dto;

import java.util.Date;

public class PagamentoDTO {
	
	int idpagamento;
	String metodo;
	Double importo;
	Date datatransazione;
	AcquirenteDTO acquirente;
	PrenotazioneDTO prenotazione;
	
	public int getIdpagamento() {
		return idpagamento;
	}
	public void setIdpagamento(int idpagamento) {
		this.idpagamento = idpagamento;
	}
	public String getMetodo() {
		return metodo;
	}
	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}
	public Double getImporto() {
		return importo;
	}
	public void setImporto(Double bigDecimal) {
		this.importo = bigDecimal;
	}
	public Date getDatatransazione() {
		return datatransazione;
	}
	public void setDatatransazione(Date datatransazione) {
		this.datatransazione = datatransazione;
	}
	public AcquirenteDTO getAcquirente() {
		return acquirente;
	}
	public void setAcquirente(AcquirenteDTO acquirente) {
		this.acquirente = acquirente;
	}
	
	public PrenotazioneDTO getPrenotazione() {
		return prenotazione;
	}
	public void setPrenotazione(PrenotazioneDTO prenotazione) {
		this.prenotazione = prenotazione;
	}
	
	public void setDatatransazione(long time) {
		// TODO Auto-generated method stub
		
	}

	
}
