package it.unisalento.myairbnb.dto;

import java.util.Date;

public class NotificaDTO {
	
	int idnotifica;
	String descrizione;
	int tipo;
	Date data;
	PropostaDTO proposta;
	AcquirenteDTO acquirente;
	ProponenteDTO proponente;
	
	public int getIdnotifica() {
		return idnotifica;
	}
	public void setIdnotifica(int idnotifica) {
		this.idnotifica = idnotifica;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public PropostaDTO getProposta() {
		return proposta;
	}
	public void setProposta(PropostaDTO proposta) {
		this.proposta = proposta;
	}
	public AcquirenteDTO getAcquirente() {
		return acquirente;
	}
	public void setAcquirente(AcquirenteDTO acquirente) {
		this.acquirente = acquirente;
	}
	public ProponenteDTO getProponente() {
		return proponente;
	}
	public void setProponente(ProponenteDTO proponente) {
		this.proponente = proponente;
	}
	

}
