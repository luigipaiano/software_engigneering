package it.unisalento.myairbnb.service;

import java.util.List;

import it.unisalento.myairbnb.entities.Proponente;

public interface ProponenteService {
	
	public List<Proponente> getAll();
	public Proponente getByUsernameandPassword(String username, String password);
	public Proponente getById(int id);
	public Proponente saveorUpdate(Proponente proponente);

}
