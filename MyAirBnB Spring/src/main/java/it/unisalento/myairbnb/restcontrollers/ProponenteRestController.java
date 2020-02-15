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

import it.unisalento.myairbnb.dto.ProponenteDTO;
import it.unisalento.myairbnb.dto.UtenteDTO;
import it.unisalento.myairbnb.entities.Proponente;
import it.unisalento.myairbnb.entities.Utente;
import it.unisalento.myairbnb.service.ProponenteService;

@RestController
@RequestMapping("/proponente")
public class ProponenteRestController {

	@Autowired
	ProponenteService proponenteService;
	
	@PostMapping(
			
			value = "/save",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	
	public Proponente post(@RequestBody @Valid ProponenteDTO proponenteDTO) {
		
		Proponente proponente = new Proponente();
		Utente utente = new Utente();
		
		utente.setNome(proponenteDTO.getUtente().getNome());
		utente.setCognome(proponenteDTO.getUtente().getCognome());
		utente.setUsername(proponenteDTO.getUtente().getUsername());
		utente.setPassword(proponenteDTO.getUtente().getPassword());
		utente.setIdutente(proponenteDTO.getUtente().getIdutente());
		
		utente.setUltimologin(null);

		//Timestamp ts = new Timestamp(proponenteDTO.getUtente().getUltimologin().getTime());
		//utente.setUltimologin(ts);
		utente.setStatus(proponenteDTO.getUtente().getStatus());
		
		proponente.setTelefono(proponenteDTO.getTelefono());
		proponente.setIndirizzo(proponenteDTO.getIndirizzo());
		proponente.setCitta(proponenteDTO.getCitta());
		proponente.setCap(proponenteDTO.getCap());
		
		proponente.setUtente(utente);


		return proponenteService.saveorUpdate(proponente);
		
	}
	
	@GetMapping( value="/getByIdProponente/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public ProponenteDTO get(@PathVariable int id) {
		
		ProponenteDTO proponenteDTO = new ProponenteDTO();	
		UtenteDTO utenteDTO = new UtenteDTO();
		Proponente proponente =  proponenteService.getById(id);
		
		utenteDTO.setNome(proponente.getUtente().getNome());
		utenteDTO.setCognome(proponente.getUtente().getCognome());
		utenteDTO.setEmail(proponente.getUtente().getEmail());
		utenteDTO.setIdutente(proponente.getUtente().getIdutente());
		utenteDTO.setPassword(proponente.getUtente().getPassword());
		utenteDTO.setUsername(proponente.getUtente().getUsername());
		utenteDTO.setStatus(proponente.getUtente().getStatus());
		utenteDTO.setUltimologin(proponente.getUtente().getUltimologin());

		proponenteDTO.setIdproponente(proponente.getIdproponente());
		proponenteDTO.setTelefono(proponente.getTelefono());
		proponenteDTO.setIndirizzo(proponente.getIndirizzo());
		proponenteDTO.setCitta(proponente.getCitta());
		proponenteDTO.setCap(proponente.getCap());
		
		proponenteDTO.setUtente(utenteDTO);
		
		return proponenteDTO;
	}
	
	
	
	@GetMapping(
			value = "/getAll",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List<ProponenteDTO> getAll() {
		
		List<ProponenteDTO> ProponenteDTOList = new ArrayList<ProponenteDTO>();
		UtenteDTO utenteDTO = new UtenteDTO();
		List<Proponente> proponentelist = proponenteService.getAll();

		
		for (Proponente proponente : proponentelist) {
			
			ProponenteDTO proponenteDTO = new ProponenteDTO();
	
			utenteDTO.setNome(proponente.getUtente().getNome());
			utenteDTO.setCognome(proponente.getUtente().getCognome());
			utenteDTO.setEmail(proponente.getUtente().getEmail());
			utenteDTO.setIdutente(proponente.getUtente().getIdutente());
			utenteDTO.setPassword(proponente.getUtente().getPassword());
			utenteDTO.setUsername(proponente.getUtente().getUsername());
			utenteDTO.setStatus(proponente.getUtente().getStatus());
			utenteDTO.setUltimologin(proponente.getUtente().getUltimologin());
			
			proponenteDTO.setIdproponente(proponente.getIdproponente());
			proponenteDTO.setTelefono(proponente.getTelefono());
			proponenteDTO.setIndirizzo(proponente.getIndirizzo());
			proponenteDTO.setCitta(proponente.getCitta());
			proponenteDTO.setCap(proponente.getCap());
			
			proponenteDTO.setUtente(utenteDTO);

			ProponenteDTOList.add(proponenteDTO);
			
		} 

		return ProponenteDTOList;
		
	}
	
	
	@GetMapping( value="/getByUsernameandPassword/{username}/{password}",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public ProponenteDTO getByUsernameandPassword(@PathVariable String username, @PathVariable String password) {
		
		ProponenteDTO proponenteDTO = new ProponenteDTO();	
		UtenteDTO utenteDTO = new UtenteDTO();
		Proponente proponente =  proponenteService.getByUsernameandPassword(username, password);
		
		utenteDTO.setNome(proponente.getUtente().getNome());
		utenteDTO.setCognome(proponente.getUtente().getCognome());
		utenteDTO.setEmail(proponente.getUtente().getEmail());
		utenteDTO.setIdutente(proponente.getUtente().getIdutente());
		utenteDTO.setPassword(proponente.getUtente().getPassword());
		utenteDTO.setUsername(proponente.getUtente().getUsername());
		utenteDTO.setStatus(proponente.getUtente().getStatus());
		utenteDTO.setUltimologin(proponente.getUtente().getUltimologin());
		
		
		proponenteDTO.setIdproponente(proponente.getIdproponente());
		proponenteDTO.setTelefono(proponente.getTelefono());
		proponenteDTO.setIndirizzo(proponente.getIndirizzo());
		proponenteDTO.setCitta(proponente.getCitta());
		proponenteDTO.setCap(proponente.getCap());
		
		proponenteDTO.setUtente(utenteDTO);
					
		return proponenteDTO;
		
	}
		

}
