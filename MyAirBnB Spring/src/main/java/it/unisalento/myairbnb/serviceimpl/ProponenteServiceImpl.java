package it.unisalento.myairbnb.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import it.unisalento.myairbnb.entities.Proponente;
import it.unisalento.myairbnb.entities.Utente;
import it.unisalento.myairbnb.repositories.ProponenteRepository;
import it.unisalento.myairbnb.repositories.UtenteRepository;
import it.unisalento.myairbnb.service.ProponenteService;

@Service
public class ProponenteServiceImpl implements ProponenteService{
	
	@Autowired
	UtenteRepository urepo;
	
	@Autowired
	ProponenteRepository prepo;

	@Override
	@Transactional
	public List<Proponente> getAll() {
		// TODO Auto-generated method stub
		return prepo.findAll();

	}

	@Override
	@Transactional
	public Proponente getByUsernameandPassword(String username, String password) {
		Utente u = urepo.findByUsernameAndPassword(username, password);
		return prepo.findByIdProponente(u.getIdutente());
	}

	@Override
	@Transactional

	public Proponente getById(int id) {
		// TODO Auto-generated method stub
		return prepo.findById(id).orElse(null);

	}
	
	@Override
	@Transactional
	public Proponente saveorUpdate(Proponente proponente) {
		// TODO Auto-generated method stub
		return prepo.save(proponente);
	}

}
