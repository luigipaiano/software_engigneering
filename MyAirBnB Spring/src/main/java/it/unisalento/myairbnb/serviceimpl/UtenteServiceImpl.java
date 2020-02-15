package it.unisalento.myairbnb.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.unisalento.myairbnb.entities.Utente;
import it.unisalento.myairbnb.repositories.UtenteRepository;
import it.unisalento.myairbnb.service.UtenteService;

@Service
public class UtenteServiceImpl implements UtenteService {
	
	
	@Autowired
	UtenteRepository repository;

	@Override
	@Transactional
	public Utente saveorUpdate(Utente utente) {
		// TODO Auto-generated method stub
		return repository.save(utente);
	}

	@Override
	@Transactional
	public List<Utente> getAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	

	@Override
	@Transactional

	public Utente getById(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}


	@Override
	@Transactional

	public Utente getByUsernameandPassword(String username, String password) {
		
		return repository.findByUsernameAndPassword(username, password); 

		// TODO Auto-generated method stub
	}
	
	
	@Override
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		Utente utente = repository.findById(id).orElse(null);
		repository.delete(utente);
	}
	
	


}
