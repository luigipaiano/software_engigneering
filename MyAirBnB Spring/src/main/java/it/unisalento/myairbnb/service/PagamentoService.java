package it.unisalento.myairbnb.service;

import java.util.List;

import it.unisalento.myairbnb.entities.Pagamento;

public interface PagamentoService {
	
	public Pagamento saveorUpdate(Pagamento pagamento);
	public List<Pagamento> getAll();
	public Pagamento getById(int id);
	public List<Pagamento> getByIdPrenotazione(int prenotazioneID);

}
