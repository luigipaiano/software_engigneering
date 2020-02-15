package it.unisalento.myairbnb.dto;

public class ImmagineDTO {
	
	int idimmagine;
	String percorso;
	PropostaDTO proposta;
	
	public int getIdimmagine() {
		return idimmagine;
	}
	public void setIdimmagine(int idimmagine) {
		this.idimmagine = idimmagine;
	}
	public String getPercorso() {
		return percorso;
	}
	public void setPercorso(String percorso) {
		this.percorso = percorso;
	}
	public PropostaDTO getProposta() {
		return proposta;
	}
	public void setProposta(PropostaDTO proposta) {
		this.proposta = proposta;
	}

	
}
