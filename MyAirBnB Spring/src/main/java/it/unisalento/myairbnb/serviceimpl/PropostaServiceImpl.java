package it.unisalento.myairbnb.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.unisalento.myairbnb.entities.Proposta;
import it.unisalento.myairbnb.repositories.PropostaRepository;
import it.unisalento.myairbnb.service.PropostaService;

@Service
public class PropostaServiceImpl implements PropostaService {
	
	@Autowired
	PropostaRepository prepo;

	@Override
	@Transactional
	public List<Proposta> getAll() {
		// TODO Auto-generated method stub
		return prepo.findAll();
	}

	@Override
	@Transactional
	public List<Proposta> getByIdBeneServizio(int beneservizioID) {
		// TODO Auto-generated method stub
		return prepo.findByIdBeneServizio(beneservizioID);
		}

	@Override
	@Transactional
	public List<Proposta>  getByIdProponente(int proponenteID) {
		// TODO Auto-generated method stub
		return prepo.findByIdProponente(proponenteID);
	}

	@Override
	@Transactional
	public Proposta saveorUpdate(Proposta proposta) {
		// TODO Auto-generated method stub
		return prepo.save(proposta);
	}

	@Override
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		Proposta proposta = prepo.findById(id).orElse(null);
		prepo.delete(proposta);
	}

	@Override
	@Transactional

	public Proposta getById(int id) {
		// TODO Auto-generated method stub
		return prepo.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public List<Proposta> getByApproved() {
		// TODO Auto-generated method stub
		return prepo.findByApproved();
	}

	@Override
	@Transactional
	public List<Proposta> getByNonApproved() {
		// TODO Auto-generated method stub
		return prepo.findByNonApproved();
	}

	@Override
	@Transactional
	public void setByApprovaProposta(int beneservizioID) {
		// TODO Auto-generated method stub
		 prepo.approvaProposta(beneservizioID);
	}



}
