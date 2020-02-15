package it.unisalento.myairbnb.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.unisalento.myairbnb.entities.Admin;
import it.unisalento.myairbnb.entities.Utente;
import it.unisalento.myairbnb.repositories.AdminRepository;
import it.unisalento.myairbnb.repositories.UtenteRepository;
import it.unisalento.myairbnb.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	UtenteRepository urepo;
	
	@Autowired
	AdminRepository arepo;

	@Override
	@Transactional
	public List<Admin> getAll() {
		// TODO Auto-generated method stub
		return arepo.findAll();
	}

	@Override
	@Transactional
	public Admin getByUsernameandPassword(String username, String password) {
		Utente u = urepo.findByUsernameAndPassword(username, password);
		return arepo.findByIdAmin(u.getIdutente());
	}

	@Override
	@Transactional
	public Admin getById(int id) {
		// TODO Auto-generated method stub
		return arepo.findById(id).orElse(null);

	}
	
	@Override
	@Transactional
	public Admin saveorUpdate(Admin admin) {
		// TODO Auto-generated method stub
		return arepo.save(admin);
	}

}
