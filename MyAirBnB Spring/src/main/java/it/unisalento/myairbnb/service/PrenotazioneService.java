package it.unisalento.myairbnb.service;

import java.util.List;

import it.unisalento.myairbnb.entities.Prenotazione;

public interface PrenotazioneService {
	
	public List<Prenotazione> getAll();
	public List<Prenotazione> getByIdAcquirente(int acquirenteID);
	public List<Prenotazione> getByIdProposta(int propostaID);
	//public List<Prenotazione> getByIdProponente(int proponenteID);
	public Prenotazione saveorUpdate(Prenotazione prenotazione);
	public void delete(int id);
	public Prenotazione getById(int id);


}
