package it.unisalento.myairbnb.service;

import java.util.List;

import org.springframework.data.domain.Page;

import it.unisalento.myairbnb.entities.User;
import it.unisalento.myairbnb.exceptions.UserNotFoundException;

public interface UserService {

	public User saveorUpdate(User user);
	public List<User> getAll();
	public List<User> getByEmail(String email); //es per visualizzare tutte le email, lato app, che iniziano con maria.rossi...
	public User getById(int id) throws UserNotFoundException;
	public List<User> getByName(String name);
	public List<User> getByNameandSurname(String name, String surname);
	public void delete(int id) throws UserNotFoundException;

	public Page<User> getAll(int page, int size);
	public User save(User user);
	
}
