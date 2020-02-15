package it.unisalento.myairbnb.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.unisalento.myairbnb.entities.Immagine;
import it.unisalento.myairbnb.repositories.ImmagineRepository;
import it.unisalento.myairbnb.service.ImmagineService;

@Service
public class ImmagineServiceImpl implements ImmagineService {
	
	@Autowired
	ImmagineRepository irepo;


	@Override
	@Transactional
	public List<Immagine> getAll() {
		// TODO Auto-generated method stub
		return irepo.findAll();
	}

	@Override
	@Transactional
	public List<Immagine> getByIdProposta(int propostaID) {
		// TODO Auto-generated method stub
		return irepo.findByIdProposta(propostaID);
	}

	@Override
	@Transactional
	public Immagine saveorUpdate(Immagine immagine) {
		// TODO Auto-generated method stub
		return irepo.save(immagine);
	}

	@Override
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		Immagine immagine = irepo.findById(id).orElse(null);
		irepo.delete(immagine);
		
	}

	@Override
	@Transactional
	public Immagine getById(int id) {
		// TODO Auto-generated method stub
		return irepo.findById(id).orElse(null);

	}

	@Override
	@Transactional

	public void deleteImageByIdProposta(int propostaID) {
		// TODO Auto-generated method stub
		irepo.deleteImmagineByIdProposta(propostaID);

		
	}
	

}
