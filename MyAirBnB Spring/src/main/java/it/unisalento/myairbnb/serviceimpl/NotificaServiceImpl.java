package it.unisalento.myairbnb.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.unisalento.myairbnb.entities.Notifica;
import it.unisalento.myairbnb.repositories.NotificaRepository;
import it.unisalento.myairbnb.service.NotificaService;

@Service
public class NotificaServiceImpl implements NotificaService{
	
	
	@Autowired
	NotificaRepository nrepo;

	@Override
	@Transactional
	public List<Notifica> getAll() {
		// TODO Auto-generated method stub
		return nrepo.findAll();
	}

	@Override
	@Transactional
	public Notifica getByIdNotifica(int notificaID) {
		// TODO Auto-generated method stub
		return nrepo.findById(notificaID).orElse(null);
	}

	@Override
	@Transactional
	public Notifica saveorUpdate(Notifica notifica) {
		// TODO Auto-generated method stub
		return nrepo.save(notifica);
	}

	@Override
	@Transactional
	public void delete(int id) {
		Notifica notifica = nrepo.findById(id).orElse(null);
		nrepo.delete(notifica);
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public List<Notifica> getByIdProposta(int propostaID) {
		// TODO Auto-generated method stub
		return nrepo.findByIdProposta(propostaID);
	}

	@Override
	@Transactional
	public List<Notifica> getByIdAcquirente(int acquirenteID) {
		// TODO Auto-generated method stub
		return nrepo.findByIdAcquirente(acquirenteID);
	}

	@Override
	@Transactional
	public List<Notifica> getByIdProponente(int proponenteID) {
		// TODO Auto-generated method stub
		return nrepo.findByIdProponente(proponenteID);
	}


	@Override
	@Transactional
	public List<Notifica> getForTipo(int tipoID) {
		// TODO Auto-generated method stub
		return nrepo.findTipo(tipoID);
	}

}
