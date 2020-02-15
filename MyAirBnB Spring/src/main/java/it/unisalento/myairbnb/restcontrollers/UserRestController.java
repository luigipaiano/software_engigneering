package it.unisalento.myairbnb.restcontrollers;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.unisalento.myairbnb.dto.UserDTO;
import it.unisalento.myairbnb.entities.User;
import it.unisalento.myairbnb.exceptions.UserNotFoundException;
import it.unisalento.myairbnb.service.UserService;

@RestController
@RequestMapping("/user")
public class UserRestController {
	
	
	@Autowired
	UserService userService;
	
	
	@PostMapping(
			value = "/save",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE

			)
	public User post(@RequestBody @Valid UserDTO userDTO) {
		
		User user = new User();
		//TODO la data di nascita deve essere assegnata dall'oggetto DTO
		user.setBirthdate(new Timestamp(0));
		user.setName(userDTO.getName());
		user.setSurname(userDTO.getSurname());
		user.setEmail(userDTO.getEmail());
				
		return userService.saveorUpdate(user);
	}
	
	@PutMapping(
			
			value="/update",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
			
			)
	
	public User update(@RequestBody @Valid UserDTO userDTO) throws UserNotFoundException {
		if (userDTO.getId() != 0) {
			
		User user = new User();
		//TODO la data di nascita deve essere assegnata dall'oggetto DTO
		user.setBirthdate(new Timestamp(0));
		user.setName(userDTO.getName());
		user.setSurname(userDTO.getSurname());
		user.setEmail(userDTO.getEmail());
		user.setIduser(userDTO.getId());
		return userService.saveorUpdate(user);
		
		} else {
			throw new UserNotFoundException();
		}

		
		
		
	}
	
	@GetMapping( value="/getById/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public UserDTO get(@PathVariable int id) throws UserNotFoundException {
		
		User user =  userService.getById(id);
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getIduser());
		userDTO.setDataNascita(new Date(user.getBirthdate().getTime()));
		userDTO.setEmail(user.getName());
		userDTO.setSurname(user.getSurname());
		
		return userDTO;
	}
	
	@GetMapping(
			value = "/getAll",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List<UserDTO> getAll() {
		
		List<User> list = userService.getAll();
		List<UserDTO> dtoList = new ArrayList<UserDTO>();
		
		for (User user : list) {
			
			UserDTO userDTO = new UserDTO();
			userDTO.setId(user.getIduser());
			userDTO.setDataNascita(new Date(user.getBirthdate().getTime()));
			userDTO.setEmail(user.getName());
			userDTO.setSurname(user.getSurname());
			dtoList.add(userDTO);
			
		} // :-)

		return dtoList;
		
	}
	
	@GetMapping(value="/getByName/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List <UserDTO> getByName (@PathVariable String name) {
		
		
		List<User> list = userService.getByName(name);
		List<UserDTO> dtoList = new ArrayList<UserDTO>();
		
		for (User user : list) {
			
			UserDTO userDTO = new UserDTO();
			userDTO.setId(user.getIduser());
			userDTO.setDataNascita(new Date(user.getBirthdate().getTime()));
			userDTO.setEmail(user.getName());
			userDTO.setSurname(user.getSurname());
			dtoList.add(userDTO);
			
		} // :-)

		return dtoList;
		
		
	}
	
	
	@GetMapping(value="/getByNameandSurname/{name}/{surname}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List <UserDTO> getByNameandSurname (@PathVariable String name, @PathVariable String surname) {
		
		
		List<User> list = userService.getByNameandSurname(name, surname);
		List<UserDTO> dtoList = new ArrayList<UserDTO>();
		
		for (User user : list) {
			
			UserDTO userDTO = new UserDTO();
			userDTO.setId(user.getIduser());
			userDTO.setDataNascita(new Date(user.getBirthdate().getTime()));
			userDTO.setEmail(user.getName());
			userDTO.setSurname(user.getSurname());
			dtoList.add(userDTO);
			
		} // :-)

		return dtoList;
		
		
	}
	
}
