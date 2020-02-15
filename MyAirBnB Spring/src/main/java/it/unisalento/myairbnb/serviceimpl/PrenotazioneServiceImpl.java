package it.unisalento.myairbnb.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.unisalento.myairbnb.entities.Prenotazione;
import it.unisalento.myairbnb.repositories.PrenotazioneRepository;
import it.unisalento.myairbnb.service.PrenotazioneService;

@Service

public class PrenotazioneServiceImpl implements PrenotazioneService {
	
	@Autowired
	PrenotazioneRepository prepo;

	@Override
	@Transactional
	public List<Prenotazione> getAll() {
		// TODO Auto-generated method stub
		return prepo.findAll();

	}

	@Override
	@Transactional
	public List<Prenotazione> getByIdAcquirente(int acquirenteID) {
		// TODO Auto-generated method stub
		return prepo.findByIdAcquirente(acquirenteID);
	}

	@Override
	@Transactional
	public List<Prenotazione> getByIdProposta(int propostaID) {
		// TODO Auto-generated method stub
		return prepo.findByIdProposta(propostaID);
	}

	@Override
	@Transactional
	public Prenotazione saveorUpdate(Prenotazione prenotazione) {
		// TODO Auto-generated method stub
		return prepo.save(prenotazione);
	}

	@Override
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		Prenotazione prenotazione = prepo.findById(id).orElse(null);
		prepo.delete(prenotazione);
		
	}

	@Override
	@Transactional

	public Prenotazione getById(int id) {
		// TODO Auto-generated method stub
		return prepo.findById(id).orElse(null);

	}

	
	
	//public List<Prenotazione> getByIdProponente(int proponenteID) {
		// TODO Auto-generated method stub
	//	return prepo.findByIdProponente(proponenteID);
	//}
	
	

}
