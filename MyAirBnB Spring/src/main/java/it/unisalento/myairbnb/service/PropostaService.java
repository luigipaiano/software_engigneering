package it.unisalento.myairbnb.service;

import java.util.List;
import it.unisalento.myairbnb.entities.Proposta;

public interface PropostaService {
	
	public List<Proposta> getAll();
	public List<Proposta> getByIdBeneServizio(int beneservizioID);
	public List<Proposta> getByIdProponente(int proponenteID);
	public Proposta saveorUpdate(Proposta proposta);
	public void delete(int id);
	public Proposta getById(int id);
	public List<Proposta> getByApproved();
	public List<Proposta> getByNonApproved();
	public void setByApprovaProposta(int beneservizioID);


}
