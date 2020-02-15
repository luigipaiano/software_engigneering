package it.unisalento.myairbnb.dto;

import java.util.Date;

public class CommentoDTO {
	
	int idcommento;
	Date data;
	int tipo;
	int val;
	String descrizione;
	AcquirenteDTO acquirente;
	PropostaDTO proposta;
	
	public int getIdcommento() {
		return idcommento;
	}
	public void setIdcommento(int idcommento) {
		this.idcommento = idcommento;
	}
	public int getTipo() {
		return tipo;
	}
	
	public void setTipo(int tipo) {
		this.val = tipo;
	}
	
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
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
