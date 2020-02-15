package it.unisalento.myairbnb.dto;

import java.math.BigDecimal;
import java.util.Date;

public class PropostaDTO {
	
	int idproposta;
	String nome;
	String descrizione;
	Date datainiziodisp;
	Date datafinedisp;
	int disponibilita;
	BigDecimal costounitario;
	String posizione;
	int stato;
	Date datacreamodpr;
	BeneservizioDTO beneservizio;
	ProponenteDTO proponente;
	
	public int getIdproposta() {
		return idproposta;
	}
	public void setIdproposta(int idproposta) {
		this.idproposta = idproposta;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Date getDatainiziodisp() {
		return datainiziodisp;
	}
	public void setDatainiziodisp(Date datainiziodisp) {
		this.datainiziodisp = datainiziodisp;
	}
	public Date getDatafinedisp() {
		return datafinedisp;
	}
	public void setDatafinedisp(Date datafinedisp) {
		this.datafinedisp = datafinedisp;
	}
	public int getDisponibilita() {
		return disponibilita;
	}
	public void setDisponibilita(int disponibilita) {
		this.disponibilita = disponibilita;
	}
	public BigDecimal getCostounitario() {
		return costounitario;
	}
	public void setCostounitario(BigDecimal costounitario) {
		this.costounitario = costounitario;
	}
	public String getPosizione() {
		return posizione;
	}
	public void setPosizione(String posizione) {
		this.posizione = posizione;
	}
	public Date getDatacreamodpr() {
		return datacreamodpr;
	}
	public void setDatacreamodpr(Date datacreamodpr) {
		this.datacreamodpr = datacreamodpr;
	}
	
	public int getStato() {
		return stato;
	}
	public void setStato(int stato) {
		this.stato = stato;
	}
	

	public BeneservizioDTO getBeneservizio() {
		return beneservizio;
	}
	public void setBeneservizio(BeneservizioDTO beneservizio) {
		this.beneservizio = beneservizio;
	}
	public ProponenteDTO getProponente() {
		return proponente;
	}
	public void setProponente(ProponenteDTO proponente) {
		this.proponente = proponente;
	}

	

}
