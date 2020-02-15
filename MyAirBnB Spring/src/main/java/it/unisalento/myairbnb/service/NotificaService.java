package it.unisalento.myairbnb.service;

import java.util.List;

import it.unisalento.myairbnb.entities.Notifica;

public interface NotificaService {
	
	
	public List<Notifica> getAll();
	public Notifica getByIdNotifica(int notificaID);
	public Notifica saveorUpdate(Notifica notifica);
	public void delete(int id);
	
	public List<Notifica> getByIdProposta(int propostaID);
	public List<Notifica> getByIdAcquirente(int acquirenteID);
	public List<Notifica> getByIdProponente(int proponenteID);
	
	public List<Notifica> getForTipo(int tipoID);



}
