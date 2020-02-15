package it.unisalento.myairbnb.service;

import java.util.List;

import it.unisalento.myairbnb.entities.Beneservizio;


public interface BeneservizioService {
	
	public List<Beneservizio> getAll();
	public List<Beneservizio> getByCategoria(String categoriaPR);
	public Beneservizio saveorUpdate(Beneservizio beneservizio);
	public void delete(int id);
	public Beneservizio getById(int id);


}
