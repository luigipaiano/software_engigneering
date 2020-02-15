package it.unisalento.myairbnb.dto;

import java.math.BigDecimal;
import java.util.Date;

public class PrenotazioneDTO {
	
	int idprenotazione;
	Date datatransazione;
	Date datacheckin;
	Date datacheckout;
	BigDecimal costotot;
	
	AcquirenteDTO acquirente;
	PropostaDTO proposta;
	
	public int getIdprenotazione() {
		return idprenotazione;
	}
	public void setIdprenotazione(int idprenotazione) {
		this.idprenotazione = idprenotazione;
	}
	public Date getDatatransazione() {
		return datatransazione;
	}
	public void setDatatransazione(Date datatransazione) {
		this.datatransazione = datatransazione;
	}
	public Date getDatacheckin() {
		return datacheckin;
	}
	public void setDatacheckin(Date datacheckin) {
		this.datacheckin = datacheckin;
	}
	public Date getDatacheckout() {
		return datacheckout;
	}
	public void setDatacheckout(Date datacheckout) {
		this.datacheckout = datacheckout;
	}
	public BigDecimal getCostotot() {
		return costotot;
	}
	public void setCostotot(BigDecimal costotot) {
		this.costotot = costotot;
	}
	
	public AcquirenteDTO getAcquirente() {
		return acquirente;
	}
	public void setAcquirente(AcquirenteDTO acquirente) {
		this.acquirente = acquirente;
	}
	public PropostaDTO getProposta() {
		return proposta;
	}
	public void setProposta(PropostaDTO proposta) {
		this.proposta = proposta;
	}

	

}
