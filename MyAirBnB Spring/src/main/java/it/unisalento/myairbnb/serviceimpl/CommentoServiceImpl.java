package it.unisalento.myairbnb.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.unisalento.myairbnb.entities.Commento;
import it.unisalento.myairbnb.repositories.CommentoRepository;
import it.unisalento.myairbnb.service.CommentoService;

@Service
public class CommentoServiceImpl implements CommentoService{
	
	@Autowired
	CommentoRepository crepo;

	@Override
	@Transactional
	public List<Commento> getAll() {
		// TODO Auto-generated method stub
		return crepo.findAll();
	}

	@Override
	@Transactional
	public List<Commento> getByIdAcquirente(int acquirenteID) {
		// TODO Auto-generated method stub
		return crepo.findByIdAcquirente(acquirenteID);
	}

	@Override
	@Transactional
	public List<Commento> getByIdProposta(int propostaID) {
		// TODO Auto-generated method stub
		return crepo.findByIdProposta(propostaID);
	}

	@Override
	@Transactional
	public Commento saveorUpdate(Commento commento) {
		// TODO Auto-generated method stub
		return crepo.save(commento);
	}

	@Override
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		Commento commento = crepo.findById(id).orElse(null);
		crepo.delete(commento);
		
	}

	@Override
	@Transactional
	public Commento getById(int id) {
		// TODO Auto-generated method stub
		return crepo.findById(id).orElse(null);

	}

	@Override
	@Transactional
	public void deleteCommentoByIdProposta(int propostaID) {
		// TODO Auto-generated method stub
		crepo.deleteCommentoByIdProposta(propostaID);

		
	}
	
	

}
