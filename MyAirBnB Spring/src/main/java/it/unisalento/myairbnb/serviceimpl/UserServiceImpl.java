package it.unisalento.myairbnb.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.unisalento.myairbnb.entities.User;
import it.unisalento.myairbnb.exceptions.UserNotFoundException;
import it.unisalento.myairbnb.repositories.UserRepository;
import it.unisalento.myairbnb.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	UserRepository repository;
	
	@Override
	@Transactional
	public User saveorUpdate(User user) {
		// TODO Auto-generated method stub
		return repository.save(user);
	}

	@Override
	@Transactional
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	@Transactional
	public List<User> getByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(rollbackFor = UserNotFoundException.class)
	public User getById(int id) throws UserNotFoundException {
		// TODO Auto-generated method stub
		// PRIMO MODO DI IMPLEMENATRE GET BY ID
		/**
		User user = repository.getOne(id);
		if (user == null) {
		
			throw new UserNotFoundException();
			} else {
				return user;
			}
			
		}
		**/
		
		//SECONDO MODO - utilizzando oggetto optional
		/**Optional<User> optional = repository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
			} else {
				throw new UserNotFoundException();
			}**/
		
		 
	
		//TERZO MODO - possiamo implementare il 2 in maniera molto più compatta
		return repository.findById(id).orElseThrow(() -> new UserNotFoundException());
	
		}

	@Override
	@Transactional
	public List<User> getByName(String name) {
		// TODO Auto-generated method stub
		Sort sort = new Sort(Sort.Direction.DESC, "id");
		
		return repository.findByName(name,sort);
	}

	@Override 
	@Transactional
	public List<User> getByNameandSurname(String name, String surname) {
		// TODO Auto-generated method stub
		return repository.findByNameAndSurname(name, surname); //lo abbiamo impl. in UserRepository.
	}

	@Override
	@Transactional(rollbackFor = UserNotFoundException.class)
	public void delete(int id) throws UserNotFoundException {
		// TODO Auto-generated method stub
		User user = repository.findById(id).orElseThrow(() -> new UserNotFoundException());
		repository.delete(user);
	}

	@Override
	@Transactional
	public Page<User> getAll(int page, int size) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(page, size); //ex lato frontend vogliamo visualizzare 20 elementi x pagina, size.
				
		return repository.findAll(pageable);

	}
	
	
	@Override
	@Transactional
	public User save(User user) {
		// TODO Auto-generated method stub
		return repository.save(user);
	}


	


}
