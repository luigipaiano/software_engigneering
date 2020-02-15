package it.unisalento.myairbnb.restcontrollers;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.unisalento.myairbnb.dto.UtenteDTO;
import it.unisalento.myairbnb.entities.Utente;
import it.unisalento.myairbnb.service.UtenteService;

@RestController
@RequestMapping("/utente")
public class UtenteRestController {
	
	@Autowired
	UtenteService utenteService;

	@PostMapping(
			
			value = "/save",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	
	public Utente post(@RequestBody @Valid UtenteDTO utenteDTO) {
		
		Utente utente = new Utente();
		utente.setNome(utenteDTO.getNome());
		utente.setCognome(utenteDTO.getCognome());
		utente.setUsername(utenteDTO.getUsername());
		utente.setPassword(utenteDTO.getPassword());
		utente.setEmail(utenteDTO.getEmail());
		utente.setStatus(utenteDTO.getStatus());
		Timestamp ts = new Timestamp(utenteDTO.getUltimologin().getTime());
		utente.setUltimologin(ts);

		return utenteService.saveorUpdate(utente);
		
	}

	@PutMapping(
			
			value="/update",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
			
			)
	
	public Utente update(@RequestBody @Valid UtenteDTO utenteDTO) {
		
		Utente utente = new Utente();
		utente.setNome(utenteDTO.getNome());
		utente.setCognome(utenteDTO.getCognome());
		utente.setUsername(utenteDTO.getUsername());
		utente.setPassword(utenteDTO.getPassword());
		utente.setEmail(utenteDTO.getEmail());
		utente.setStatus(utenteDTO.getStatus());
		utente.setIdutente(utenteDTO.getIdutente());
		Timestamp ts = new Timestamp(utenteDTO.getUltimologin().getTime());
		utente.setUltimologin(ts);
		return utenteService.saveorUpdate(utente);
		
	}
	
	@GetMapping( value="/getByIdUtente/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public UtenteDTO get(@PathVariable int id) {
		UtenteDTO utenteDTO = new UtenteDTO();
		
		Utente utente =  utenteService.getById(id);
		utenteDTO.setIdutente(utente.getIdutente());
		utenteDTO.setNome(utente.getNome());
		utenteDTO.setCognome(utente.getCognome());
		utenteDTO.setUsername(utente.getUsername());
		utenteDTO.setPassword(utente.getPassword());
		utenteDTO.setEmail(utente.getEmail());
		utenteDTO.setStatus(utente.getStatus());
		Timestamp ts = new Timestamp(utente.getUltimologin().getTime());
		utenteDTO.setUltimologin(ts);
		
		return utenteDTO;
	}
	
	
	@GetMapping(
			value = "/getAll",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List<UtenteDTO> getAll() {
		
		List<Utente> utentelist = utenteService.getAll();
		List<UtenteDTO> dtoUtenteList = new ArrayList<UtenteDTO>();
		
		for (Utente utente : utentelist) {
			
			UtenteDTO utenteDTO = new UtenteDTO();
			utenteDTO.setIdutente(utente.getIdutente());
			utenteDTO.setNome(utente.getNome());
			utenteDTO.setCognome(utente.getCognome());
			utenteDTO.setUsername(utente.getUsername());
			utenteDTO.setPassword(utente.getPassword());
			utenteDTO.setEmail(utente.getEmail());
			utenteDTO.setStatus(utente.getStatus());
			Timestamp ts = new Timestamp(utente.getUltimologin().getTime());
			utenteDTO.setUltimologin(ts);

			dtoUtenteList.add(utenteDTO);
			
		} 

		return dtoUtenteList;
		
	}
	
	@GetMapping( value="/getByUsernameandPassword/{username}/{password}",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public UtenteDTO getByUsernameandPassword(@PathVariable String username, @PathVariable String password) {
		UtenteDTO utenteDTO = new UtenteDTO();
		
		Utente utente =  utenteService.getByUsernameandPassword(username, password);
		utenteDTO.setIdutente(utente.getIdutente());
		utenteDTO.setNome(utente.getNome());
		utenteDTO.setCognome(utente.getCognome());
		utenteDTO.setUsername(utente.getUsername());
		utenteDTO.setPassword(utente.getPassword());
		utenteDTO.setEmail(utente.getEmail());
		utenteDTO.setStatus(utente.getStatus());
		Timestamp ts = new Timestamp(utente.getUltimologin().getTime());
		utenteDTO.setUltimologin(ts);
		
		return utenteDTO;
	}
	
	
	@DeleteMapping(
			
			value="/delete/{id}"
			)
	
	public void delete(@PathVariable int id) {
		utenteService.delete(id);
	}
	
	
	

}
