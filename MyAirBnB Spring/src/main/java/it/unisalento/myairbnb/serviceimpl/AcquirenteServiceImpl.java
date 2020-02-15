package it.unisalento.myairbnb.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.unisalento.myairbnb.entities.Acquirente;
import it.unisalento.myairbnb.entities.Utente;
import it.unisalento.myairbnb.repositories.AcquirenteRepository;
import it.unisalento.myairbnb.repositories.UtenteRepository;
import it.unisalento.myairbnb.service.AcquirenteService;

@Service
public class AcquirenteServiceImpl implements AcquirenteService{
	
	@Autowired
	UtenteRepository urepo;
	
	@Autowired
	AcquirenteRepository arepo;

	@Override
	@Transactional
	public List<Acquirente> getAll() {
		// TODO Auto-generated method stub
		return arepo.findAll();
	}

	@Override
	@Transactional
	public Acquirente getByUsernameandPassword(String username, String password) {
		// TODO Auto-generated method stub
		Utente u = urepo.findByUsernameAndPassword(username, password);
		return arepo.findByIdAcquirente(u.getIdutente());
	}

	@Override
	@Transactional
	public Acquirente getById(int id) {
		// TODO Auto-generated method stub
		return arepo.findById(id).orElse(null);

	}
	
	@Override
	@Transactional
	public Acquirente saveorUpdate(Acquirente acquirente) {
		// TODO Auto-generated method stub
		return arepo.save(acquirente);
	}

}
