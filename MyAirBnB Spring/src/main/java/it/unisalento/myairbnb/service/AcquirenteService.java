package it.unisalento.myairbnb.service;

import java.util.List;

import it.unisalento.myairbnb.entities.Acquirente;

public interface AcquirenteService {
	
	public List<Acquirente> getAll();
	public Acquirente getByUsernameandPassword(String username, String password); 
	public Acquirente getById(int id);
	public Acquirente saveorUpdate(Acquirente acquirente);


	

}
