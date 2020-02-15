package it.unisalento.myairbnb.restcontrollers;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.unisalento.myairbnb.dto.AcquirenteDTO;
import it.unisalento.myairbnb.dto.UtenteDTO;
import it.unisalento.myairbnb.entities.Acquirente;
import it.unisalento.myairbnb.entities.Utente;
import it.unisalento.myairbnb.service.AcquirenteService;

@RestController
@RequestMapping("/acquirente")
public class AcquirenteRestController {
	
	@Autowired
	AcquirenteService acquirenteService;
	
	@PostMapping(
			
			value = "/save",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	
	public Acquirente post(@RequestBody @Valid AcquirenteDTO acquirenteDTO) {
		
		Acquirente acquirente = new Acquirente();
		Utente utente = new Utente();
		
		utente.setNome(acquirenteDTO.getUtente().getNome());
		utente.setCognome(acquirenteDTO.getUtente().getCognome());
		utente.setUsername(acquirenteDTO.getUtente().getUsername());
		utente.setPassword(acquirenteDTO.getUtente().getPassword());
		//Timestamp ts = new Timestamp(acquirenteDTO.getUtente().getUltimologin().getTime());
		//utente.setUltimologin(ts);
		utente.setStatus(acquirenteDTO.getUtente().getStatus());
		utente.setEmail(acquirenteDTO.getUtente().getEmail());
		utente.setIdutente(acquirenteDTO.getUtente().getIdutente());
		
		acquirente.setTelefono(acquirenteDTO.getTelefono());
		acquirente.setIndirizzo(acquirenteDTO.getIndirizzo());
		acquirente.setCitta(acquirenteDTO.getCitta());
		acquirente.setCap(acquirenteDTO.getCap());
		acquirente.setUtente(utente);
		
		return acquirenteService.saveorUpdate(acquirente);
		
	}
	
	@GetMapping( value="/getByIdAcquirente/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public AcquirenteDTO get(@PathVariable int id) {
		
		AcquirenteDTO acquirenteDTO = new AcquirenteDTO();	
		UtenteDTO utenteDTO = new UtenteDTO();
		Acquirente acquirente =  acquirenteService.getById(id);
		
		utenteDTO.setNome(acquirente.getUtente().getNome());
		utenteDTO.setCognome(acquirente.getUtente().getCognome());
		utenteDTO.setEmail(acquirente.getUtente().getEmail());
		utenteDTO.setIdutente(acquirente.getUtente().getIdutente());
		utenteDTO.setPassword(acquirente.getUtente().getPassword());
		utenteDTO.setUsername(acquirente.getUtente().getUsername());
		utenteDTO.setStatus(acquirente.getUtente().getStatus());
		utenteDTO.setUltimologin(acquirente.getUtente().getUltimologin());
		
		acquirenteDTO.setIdacquirente(acquirente.getIdacquirente());
		acquirenteDTO.setTelefono(acquirente.getTelefono());
		acquirenteDTO.setIndirizzo(acquirente.getIndirizzo());
		acquirenteDTO.setCitta(acquirente.getCitta());
		acquirenteDTO.setCap(acquirente.getCap());
		
		acquirenteDTO.setUtente(utenteDTO);
		
		return acquirenteDTO;
	}
	
	
	
	@GetMapping(
			value = "/getAll",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List<AcquirenteDTO> getAll() {
		
		List<AcquirenteDTO> AcquirenteDTOList = new ArrayList<AcquirenteDTO>();
		UtenteDTO utenteDTO = new UtenteDTO();
		List<Acquirente> acquirentelist = acquirenteService.getAll();

		
		for (Acquirente acquirente : acquirentelist) {
			
			AcquirenteDTO acquirenteDTO = new AcquirenteDTO();
	
			utenteDTO.setNome(acquirente.getUtente().getNome());
			utenteDTO.setCognome(acquirente.getUtente().getCognome());
			utenteDTO.setEmail(acquirente.getUtente().getEmail());
			utenteDTO.setIdutente(acquirente.getUtente().getIdutente());
			utenteDTO.setPassword(acquirente.getUtente().getPassword());
			utenteDTO.setUsername(acquirente.getUtente().getUsername());
			utenteDTO.setStatus(acquirente.getUtente().getStatus());
			utenteDTO.setUltimologin(acquirente.getUtente().getUltimologin());
			
			
			acquirenteDTO.setIdacquirente(acquirente.getIdacquirente());
			acquirenteDTO.setTelefono(acquirente.getTelefono());
			acquirenteDTO.setIndirizzo(acquirente.getIndirizzo());
			acquirenteDTO.setCitta(acquirente.getCitta());
			acquirenteDTO.setCap(acquirente.getCap());
			
			acquirenteDTO.setUtente(utenteDTO);

			AcquirenteDTOList.add(acquirenteDTO);
			
		} 

		return AcquirenteDTOList;
		
	}
	
	
	@GetMapping( value="/getByUsernameandPassword/{username}/{password}",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public AcquirenteDTO getByUsernameandPassword(@PathVariable String username, @PathVariable String password) {
		
		AcquirenteDTO acquirenteDTO = new AcquirenteDTO();	
		UtenteDTO utenteDTO = new UtenteDTO();
		Acquirente acquirente =  acquirenteService.getByUsernameandPassword(username, password);
		
		utenteDTO.setNome(acquirente.getUtente().getNome());
		utenteDTO.setCognome(acquirente.getUtente().getCognome());
		utenteDTO.setEmail(acquirente.getUtente().getEmail());
		utenteDTO.setIdutente(acquirente.getUtente().getIdutente());
		utenteDTO.setPassword(acquirente.getUtente().getPassword());
		utenteDTO.setUsername(acquirente.getUtente().getUsername());
		utenteDTO.setStatus(acquirente.getUtente().getStatus());
		utenteDTO.setUltimologin(acquirente.getUtente().getUltimologin());
		
		acquirenteDTO.setIdacquirente(acquirente.getIdacquirente());
		acquirenteDTO.setTelefono(acquirente.getTelefono());
		acquirenteDTO.setIndirizzo(acquirente.getIndirizzo());
		acquirenteDTO.setCitta(acquirente.getCitta());
		acquirenteDTO.setCap(acquirente.getCap());
		
		acquirenteDTO.setUtente(utenteDTO);
					
		return acquirenteDTO;
		
	}
		

}
