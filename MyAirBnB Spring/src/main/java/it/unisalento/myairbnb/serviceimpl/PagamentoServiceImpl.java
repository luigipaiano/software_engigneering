package it.unisalento.myairbnb.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.unisalento.myairbnb.entities.Pagamento;
import it.unisalento.myairbnb.repositories.PagamentoRepository;
import it.unisalento.myairbnb.service.PagamentoService;

@Service
public class PagamentoServiceImpl implements PagamentoService{
	
	@Autowired
	PagamentoRepository prepository;

	@Override
	@Transactional
	public List<Pagamento> getAll() {
		// TODO Auto-generated method stub
		return prepository.findAll();

	}

	@Override
	@Transactional
	public Pagamento getById(int id) {
		// TODO Auto-generated method stub
		return prepository.findById(id).orElse(null);

	}

	@Override
	@Transactional
	
	public Pagamento saveorUpdate(Pagamento pagamento) {
		// TODO Auto-generated method stub
		return prepository.save(pagamento);
	}

	@Override
	@Transactional

	public List<Pagamento> getByIdPrenotazione(int prenotazioneID) {
		// TODO Auto-generated method stub
		return prepository.findByIdPrenotazione(prenotazioneID);
	}
	
	
	

}
