package it.unisalento.myairbnb.serviceimpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.unisalento.myairbnb.entities.Beneservizio;
import it.unisalento.myairbnb.repositories.BeneservizioRepository;
import it.unisalento.myairbnb.service.BeneservizioService;

@Service
public class BeneservizioServiceImpl implements BeneservizioService {
	
	@Autowired
	BeneservizioRepository bsrepo;


	@Override
	@Transactional
	public List<Beneservizio> getAll() {
		// TODO Auto-generated method stub
		return bsrepo.findAll();
	}


	@Override
	@Transactional
	public Beneservizio saveorUpdate(Beneservizio beneservizio) {
		// TODO Auto-generated method stub
		return bsrepo.save(beneservizio);
	}

	@Override
	@Transactional

	public void delete(int id) {
		// TODO Auto-generated method stub
		Beneservizio beneservizio = bsrepo.findById(id).orElse(null);
		bsrepo.delete(beneservizio);
		
	}

	@Override
	@Transactional

	public Beneservizio getById(int id) {
		// TODO Auto-generated method stub
		return bsrepo.findById(id).orElse(null);
	}


	@Override
	@Transactional
	public List<Beneservizio> getByCategoria(String categoriaPR) {
		// TODO Auto-generated method stub
		return bsrepo.findByCategoria(categoriaPR);
	}


	
}
