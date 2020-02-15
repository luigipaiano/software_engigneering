package it.unisalento.myairbnb.service;

import java.util.List;

import it.unisalento.myairbnb.entities.Utente;

public interface UtenteService {
	
	public Utente saveorUpdate(Utente utente);
	public List<Utente> getAll();
	public Utente getById(int id);
	public Utente getByUsernameandPassword(String username, String password);
	public void delete(int id);
	
}
