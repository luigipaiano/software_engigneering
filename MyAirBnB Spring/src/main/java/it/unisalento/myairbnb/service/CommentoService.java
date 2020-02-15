package it.unisalento.myairbnb.service;

import java.util.List;

import it.unisalento.myairbnb.entities.Commento;

public interface CommentoService {
	
	public List<Commento> getAll();
	public List<Commento> getByIdAcquirente(int acquirenteID);
	public List<Commento> getByIdProposta(int propostaID);
	public Commento saveorUpdate(Commento commento);
	public void delete(int id);
	public Commento getById(int id);
	public void deleteCommentoByIdProposta(int propostaID);

}
