package it.unisalento.myairbnb.service;

import java.util.List;

import it.unisalento.myairbnb.entities.Immagine;

public interface ImmagineService {
	
	public List<Immagine> getAll();
	public List<Immagine> getByIdProposta(int propostaID);
	public Immagine saveorUpdate(Immagine immagine);
	public void delete(int id);
	public Immagine getById(int id);
	public void deleteImageByIdProposta(int propostaID);

}
