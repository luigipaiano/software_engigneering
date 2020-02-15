package it.unisalento.myairbnb.restcontrollers;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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

import it.unisalento.myairbnb.dto.BeneservizioDTO;
import it.unisalento.myairbnb.dto.ProponenteDTO;
import it.unisalento.myairbnb.dto.PropostaDTO;
import it.unisalento.myairbnb.dto.UtenteDTO;
import it.unisalento.myairbnb.entities.Beneservizio;
import it.unisalento.myairbnb.entities.Proponente;
import it.unisalento.myairbnb.entities.Proposta;
import it.unisalento.myairbnb.entities.Utente;
import it.unisalento.myairbnb.service.PropostaService;

@RestController
@RequestMapping("/proposta")
public class PropostaRestController {
	
	@Autowired
	PropostaService propostaService;
	
	@GetMapping(
			value = "/getAll",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List<PropostaDTO> getAll() {
		
		List<Proposta> propostalist = propostaService.getAll();
		List<PropostaDTO> dtopropostaList = new ArrayList<PropostaDTO>();
		
		for (Proposta proposta : propostalist) {
			
			PropostaDTO propostaDTO = new PropostaDTO();
			BeneservizioDTO beneservizioDTO = new BeneservizioDTO();
			ProponenteDTO proponenteDTO = new ProponenteDTO();
			UtenteDTO utenteDTO = new UtenteDTO();
			
			utenteDTO.setIdutente(proposta.getProponente().getUtente().getIdutente());
			utenteDTO.setNome(proposta.getProponente().getUtente().getNome());
			utenteDTO.setCognome(proposta.getProponente().getUtente().getCognome());
			utenteDTO.setUsername(proposta.getProponente().getUtente().getUsername());
			utenteDTO.setPassword(proposta.getProponente().getUtente().getPassword());
			utenteDTO.setEmail(proposta.getProponente().getUtente().getEmail());
			utenteDTO.setUltimologin(proposta.getProponente().getUtente().getUltimologin());
			utenteDTO.setStatus(proposta.getProponente().getUtente().getStatus());

			proponenteDTO.setIdproponente(proposta.getProponente().getIdproponente());
			proponenteDTO.setTelefono(proposta.getProponente().getTelefono());
			proponenteDTO.setIndirizzo(proposta.getProponente().getIndirizzo());
			proponenteDTO.setCitta(proposta.getProponente().getCitta());
			proponenteDTO.setCap(proposta.getProponente().getCap());
			proponenteDTO.setUtente(utenteDTO);
			
			beneservizioDTO.setIdbeneservizio(proposta.getBeneservizio().getIdbeneservizio());
			beneservizioDTO.setCategoria(proposta.getBeneservizio().getCategoria());
			beneservizioDTO.setDescrizione(proposta.getBeneservizio().getDescrizione());
			
			
			propostaDTO.setIdproposta(proposta.getIdproposta());
			propostaDTO.setNome(proposta.getNome());
			propostaDTO.setDescrizione(proposta.getDescrizione());
			propostaDTO.setDatainiziodisp(proposta.getDatainiziodisp());
			propostaDTO.setDatafinedisp(proposta.getDatafinedisp());
			propostaDTO.setDisponibilita(proposta.getDisponibilita());
			propostaDTO.setCostounitario(proposta.getCostounitario());
			propostaDTO.setPosizione(proposta.getPosizione());
			propostaDTO.setStato(proposta.getStato());
			propostaDTO.setDatacreamodpr(proposta.getDatacreamodpr());
			propostaDTO.setIdproposta(proposta.getIdproposta());

			propostaDTO.setBeneservizio(beneservizioDTO);
			propostaDTO.setProponente(proponenteDTO);

			dtopropostaList.add(propostaDTO);
			
		}
		
		return dtopropostaList;

	}
	
	
	@GetMapping(
			value = "/getByIdBeneservizio/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List<PropostaDTO> getPropostaByIdBeneservizio(@PathVariable int id) {
		
		List<Proposta> propostalist = propostaService.getByIdBeneServizio(id);
		List<PropostaDTO> dtopropostaList = new ArrayList<PropostaDTO>();
		
		for (Proposta proposta : propostalist) {
			
			PropostaDTO propostaDTO = new PropostaDTO();
			BeneservizioDTO beneservizioDTO = new BeneservizioDTO();
			ProponenteDTO proponenteDTO = new ProponenteDTO();
			UtenteDTO utenteDTO = new UtenteDTO();
			
			utenteDTO.setIdutente(proposta.getProponente().getUtente().getIdutente());
			utenteDTO.setNome(proposta.getProponente().getUtente().getNome());
			utenteDTO.setCognome(proposta.getProponente().getUtente().getCognome());
			utenteDTO.setUsername(proposta.getProponente().getUtente().getUsername());
			utenteDTO.setPassword(proposta.getProponente().getUtente().getPassword());
			utenteDTO.setEmail(proposta.getProponente().getUtente().getEmail());
			utenteDTO.setUltimologin(proposta.getProponente().getUtente().getUltimologin());
			utenteDTO.setStatus(proposta.getProponente().getUtente().getStatus());

			proponenteDTO.setIdproponente(proposta.getProponente().getIdproponente());
			proponenteDTO.setTelefono(proposta.getProponente().getTelefono());
			proponenteDTO.setIndirizzo(proposta.getProponente().getIndirizzo());
			proponenteDTO.setCitta(proposta.getProponente().getCitta());
			proponenteDTO.setCap(proposta.getProponente().getCap());
			proponenteDTO.setUtente(utenteDTO);
			
			beneservizioDTO.setIdbeneservizio(proposta.getBeneservizio().getIdbeneservizio());
			beneservizioDTO.setCategoria(proposta.getBeneservizio().getCategoria());
			beneservizioDTO.setDescrizione(proposta.getBeneservizio().getDescrizione());
			
			propostaDTO.setIdproposta(proposta.getIdproposta());
			propostaDTO.setNome(proposta.getNome());
			propostaDTO.setDescrizione(proposta.getDescrizione());
			propostaDTO.setDatainiziodisp(proposta.getDatainiziodisp());
			propostaDTO.setDatafinedisp(proposta.getDatafinedisp());
			propostaDTO.setDisponibilita(proposta.getDisponibilita());
			propostaDTO.setCostounitario(proposta.getCostounitario());
			
			propostaDTO.setPosizione(proposta.getPosizione());
			propostaDTO.setStato(proposta.getStato());
			propostaDTO.setDatacreamodpr(proposta.getDatacreamodpr());
			propostaDTO.setIdproposta(proposta.getIdproposta());

			propostaDTO.setBeneservizio(beneservizioDTO);
			propostaDTO.setProponente(proponenteDTO);

			dtopropostaList.add(propostaDTO);
			
		}
		
		return dtopropostaList;

	}
	
	
	@GetMapping(
			value = "/getByIdProponente/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List<PropostaDTO> getPropostaByIdProponente(@PathVariable int id) {
		
		List<Proposta> propostalist = propostaService.getByIdProponente(id);
		List<PropostaDTO> dtopropostaList = new ArrayList<PropostaDTO>();
		
		for (Proposta proposta : propostalist) {
			
			PropostaDTO propostaDTO = new PropostaDTO();
			BeneservizioDTO beneservizioDTO = new BeneservizioDTO();
			ProponenteDTO proponenteDTO = new ProponenteDTO();
			UtenteDTO utenteDTO = new UtenteDTO();
			
			utenteDTO.setIdutente(proposta.getProponente().getUtente().getIdutente());
			utenteDTO.setNome(proposta.getProponente().getUtente().getNome());
			utenteDTO.setCognome(proposta.getProponente().getUtente().getCognome());
			utenteDTO.setUsername(proposta.getProponente().getUtente().getUsername());
			utenteDTO.setPassword(proposta.getProponente().getUtente().getPassword());
			utenteDTO.setEmail(proposta.getProponente().getUtente().getEmail());
			utenteDTO.setUltimologin(proposta.getProponente().getUtente().getUltimologin());
			utenteDTO.setStatus(proposta.getProponente().getUtente().getStatus());

			proponenteDTO.setIdproponente(proposta.getProponente().getIdproponente());
			proponenteDTO.setTelefono(proposta.getProponente().getTelefono());
			proponenteDTO.setIndirizzo(proposta.getProponente().getIndirizzo());
			proponenteDTO.setCitta(proposta.getProponente().getCitta());
			proponenteDTO.setCap(proposta.getProponente().getCap());
			proponenteDTO.setUtente(utenteDTO);
			
			beneservizioDTO.setIdbeneservizio(proposta.getBeneservizio().getIdbeneservizio());
			beneservizioDTO.setCategoria(proposta.getBeneservizio().getCategoria());
			beneservizioDTO.setDescrizione(proposta.getBeneservizio().getDescrizione());
			
			
			propostaDTO.setIdproposta(proposta.getIdproposta());
			propostaDTO.setNome(proposta.getNome());
			propostaDTO.setDescrizione(proposta.getDescrizione());
			propostaDTO.setDatainiziodisp(proposta.getDatainiziodisp());
			propostaDTO.setDatafinedisp(proposta.getDatafinedisp());
			propostaDTO.setDisponibilita(proposta.getDisponibilita());
			propostaDTO.setCostounitario(proposta.getCostounitario());
			
			propostaDTO.setPosizione(proposta.getPosizione());
			propostaDTO.setStato(proposta.getStato());
			propostaDTO.setDatacreamodpr(proposta.getDatacreamodpr());
			propostaDTO.setIdproposta(proposta.getIdproposta());

			propostaDTO.setBeneservizio(beneservizioDTO);
			propostaDTO.setProponente(proponenteDTO);

			dtopropostaList.add(propostaDTO);
			
		}
		
		return dtopropostaList;

	}

	
	
	@PostMapping(
			
			value = "/save",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	
	public Proposta post(@RequestBody @Valid PropostaDTO propostaDTO) {
		
		
		Proposta proposta = new Proposta();
		Beneservizio beneservizio = new Beneservizio();
		Proponente proponente = new Proponente();
		Utente utente = new Utente();
		
		utente.setNome(propostaDTO.getProponente().getUtente().getNome());
		utente.setCognome(propostaDTO.getProponente().getUtente().getCognome());
		utente.setUsername(propostaDTO.getProponente().getUtente().getUsername());
		utente.setPassword(propostaDTO.getProponente().getUtente().getPassword());
		utente.setEmail(propostaDTO.getProponente().getUtente().getEmail());
		Timestamp ts = new Timestamp(propostaDTO.getProponente().getUtente().getUltimologin().getTime());
		utente.setUltimologin(ts);
		utente.setStatus(propostaDTO.getProponente().getUtente().getStatus());
		utente.setLockFlag(1);
		utente.setIdutente(propostaDTO.getProponente().getUtente().getIdutente());

		proponente.setTelefono(propostaDTO.getProponente().getTelefono());
		proponente.setIndirizzo(propostaDTO.getProponente().getIndirizzo());
		proponente.setCitta(propostaDTO.getProponente().getCitta());
		proponente.setCap(propostaDTO.getProponente().getCap());
		proponente.setUtente(utente);
		proponente.setLockFlag(1);
		proponente.setIdproponente(propostaDTO.getProponente().getIdproponente());
		
		beneservizio.setCategoria(propostaDTO.getBeneservizio().getCategoria());
		beneservizio.setDescrizione(propostaDTO.getBeneservizio().getDescrizione());
		beneservizio.setLockFlag(1);
		beneservizio.setIdbeneservizio(propostaDTO.getBeneservizio().getIdbeneservizio());
		
		proposta.setNome(propostaDTO.getNome());
		proposta.setDescrizione(propostaDTO.getDescrizione());
		
		Timestamp ts1 = new Timestamp(propostaDTO.getDatainiziodisp().getTime());
		proposta.setDatainiziodisp(ts1);
		
		Timestamp ts2 = new Timestamp(propostaDTO.getDatafinedisp().getTime());
		proposta.setDatafinedisp(ts2);
				
		proposta.setDisponibilita(propostaDTO.getDisponibilita());
		proposta.setCostounitario(propostaDTO.getCostounitario());
		proposta.setPosizione(propostaDTO.getPosizione());
		proposta.setStato(propostaDTO.getStato());
		
		Date d = new Date();
		proposta.setDatacreamodpr(new Timestamp(d.getTime()));
		proposta.setBeneservizio(beneservizio);
		proposta.setProponente(proponente);
		
		return propostaService.saveorUpdate(proposta);
		
	}

	@PutMapping(
			
			value="/update",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
			
			)
	
	public Proposta update(@RequestBody @Valid PropostaDTO propostaDTO) {
		
		Proposta proposta = new Proposta();
		Beneservizio beneservizio = new Beneservizio();
		Proponente proponente = new Proponente();
		Utente utente = new Utente();
		
		utente.setNome(propostaDTO.getProponente().getUtente().getNome());
		utente.setCognome(propostaDTO.getProponente().getUtente().getCognome());
		utente.setUsername(propostaDTO.getProponente().getUtente().getUsername());
		utente.setPassword(propostaDTO.getProponente().getUtente().getPassword());
		utente.setEmail(propostaDTO.getProponente().getUtente().getEmail());
		Timestamp ts = new Timestamp(propostaDTO.getProponente().getUtente().getUltimologin().getTime());
		utente.setUltimologin(ts);
		utente.setStatus(propostaDTO.getProponente().getUtente().getStatus());
		utente.setLockFlag(1);
		utente.setIdutente(propostaDTO.getProponente().getUtente().getIdutente());

		proponente.setTelefono(propostaDTO.getProponente().getTelefono());
		proponente.setIndirizzo(propostaDTO.getProponente().getIndirizzo());
		proponente.setCitta(propostaDTO.getProponente().getCitta());
		proponente.setCap(propostaDTO.getProponente().getCap());
		proponente.setUtente(utente);
		proponente.setLockFlag(1);
		proponente.setIdproponente(propostaDTO.getProponente().getIdproponente());
		
		beneservizio.setCategoria(propostaDTO.getBeneservizio().getCategoria());
		beneservizio.setDescrizione(propostaDTO.getBeneservizio().getDescrizione());
		beneservizio.setLockFlag(1);
		beneservizio.setIdbeneservizio(propostaDTO.getBeneservizio().getIdbeneservizio());
		
		proposta.setNome(propostaDTO.getNome());
		proposta.setDescrizione(propostaDTO.getDescrizione());
		
		Timestamp ts1 = new Timestamp(propostaDTO.getDatainiziodisp().getTime());
		proposta.setDatainiziodisp(ts1);
		
		Timestamp ts2 = new Timestamp(propostaDTO.getDatafinedisp().getTime());
		proposta.setDatafinedisp(ts2);
				
		proposta.setDisponibilita(propostaDTO.getDisponibilita());
		proposta.setCostounitario(propostaDTO.getCostounitario());
		proposta.setPosizione(propostaDTO.getPosizione());
		proposta.setStato(propostaDTO.getStato());
		proposta.setIdproposta(propostaDTO.getIdproposta());
		
		Date d = new Date();
		proposta.setDatacreamodpr(new Timestamp(d.getTime()));
		proposta.setBeneservizio(beneservizio);
		proposta.setProponente(proponente);
		
		return propostaService.saveorUpdate(proposta);
		
	}
	
	
	@DeleteMapping(
			
			value="/delete/{id}"
			)
	
	public void delete(@PathVariable int id) {
		propostaService.delete(id);
	}
	
	
	
	@GetMapping( value="/getByIdProposta/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	
	public PropostaDTO get(@PathVariable int id) {
		
		
		PropostaDTO propostaDTO = new PropostaDTO();
		BeneservizioDTO beneservizioDTO = new BeneservizioDTO();
		ProponenteDTO proponenteDTO = new ProponenteDTO();
		UtenteDTO utenteDTO = new UtenteDTO();

		
		Proposta proposta =  propostaService.getById(id);
		
		utenteDTO.setIdutente(proposta.getProponente().getUtente().getIdutente());
		utenteDTO.setNome(proposta.getProponente().getUtente().getNome());
		utenteDTO.setCognome(proposta.getProponente().getUtente().getCognome());
		utenteDTO.setUsername(proposta.getProponente().getUtente().getUsername());
		utenteDTO.setPassword(proposta.getProponente().getUtente().getPassword());
		utenteDTO.setEmail(proposta.getProponente().getUtente().getEmail());
		utenteDTO.setUltimologin(proposta.getProponente().getUtente().getUltimologin());
		utenteDTO.setStatus(proposta.getProponente().getUtente().getStatus());

		proponenteDTO.setIdproponente(proposta.getProponente().getIdproponente());
		proponenteDTO.setTelefono(proposta.getProponente().getTelefono());
		proponenteDTO.setIndirizzo(proposta.getProponente().getIndirizzo());
		proponenteDTO.setCitta(proposta.getProponente().getCitta());
		proponenteDTO.setCap(proposta.getProponente().getCap());
		proponenteDTO.setUtente(utenteDTO);
		
		beneservizioDTO.setIdbeneservizio(proposta.getBeneservizio().getIdbeneservizio());
		beneservizioDTO.setCategoria(proposta.getBeneservizio().getCategoria());
		beneservizioDTO.setDescrizione(proposta.getBeneservizio().getDescrizione());
		
		propostaDTO.setIdproposta(proposta.getIdproposta());
		propostaDTO.setNome(proposta.getNome());
		propostaDTO.setDescrizione(proposta.getDescrizione());
		propostaDTO.setDatainiziodisp(proposta.getDatainiziodisp());
		propostaDTO.setDatafinedisp(proposta.getDatafinedisp());
		propostaDTO.setDisponibilita(proposta.getDisponibilita());
		propostaDTO.setCostounitario(proposta.getCostounitario());
		
		propostaDTO.setPosizione(proposta.getPosizione());
		propostaDTO.setStato(proposta.getStato());
		propostaDTO.setDatacreamodpr(proposta.getDatacreamodpr());
		propostaDTO.setIdproposta(proposta.getIdproposta());

		propostaDTO.setBeneservizio(beneservizioDTO);
		propostaDTO.setProponente(proponenteDTO);
		
		
		return propostaDTO;
	}

	
	@GetMapping(
			value = "/getByNonApproved",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List<PropostaDTO> getByNoApproved() {
		
		List<Proposta> propostalist = propostaService.getByNonApproved();
		List<PropostaDTO> dtopropostaList = new ArrayList<PropostaDTO>();
		
		for (Proposta proposta : propostalist) {
			
			PropostaDTO propostaDTO = new PropostaDTO();
			BeneservizioDTO beneservizioDTO = new BeneservizioDTO();
			ProponenteDTO proponenteDTO = new ProponenteDTO();
			UtenteDTO utenteDTO = new UtenteDTO();
			
			utenteDTO.setIdutente(proposta.getProponente().getUtente().getIdutente());
			utenteDTO.setNome(proposta.getProponente().getUtente().getNome());
			utenteDTO.setCognome(proposta.getProponente().getUtente().getCognome());
			utenteDTO.setUsername(proposta.getProponente().getUtente().getUsername());
			utenteDTO.setPassword(proposta.getProponente().getUtente().getPassword());
			utenteDTO.setEmail(proposta.getProponente().getUtente().getEmail());
			utenteDTO.setUltimologin(proposta.getProponente().getUtente().getUltimologin());
			utenteDTO.setStatus(proposta.getProponente().getUtente().getStatus());

			proponenteDTO.setIdproponente(proposta.getProponente().getIdproponente());
			proponenteDTO.setTelefono(proposta.getProponente().getTelefono());
			proponenteDTO.setIndirizzo(proposta.getProponente().getIndirizzo());
			proponenteDTO.setCitta(proposta.getProponente().getCitta());
			proponenteDTO.setCap(proposta.getProponente().getCap());
			proponenteDTO.setUtente(utenteDTO);
			
			beneservizioDTO.setIdbeneservizio(proposta.getBeneservizio().getIdbeneservizio());
			beneservizioDTO.setCategoria(proposta.getBeneservizio().getCategoria());
			beneservizioDTO.setDescrizione(proposta.getBeneservizio().getDescrizione());
			
			
			propostaDTO.setIdproposta(proposta.getIdproposta());
			propostaDTO.setNome(proposta.getNome());
			propostaDTO.setDescrizione(proposta.getDescrizione());
			propostaDTO.setDatainiziodisp(proposta.getDatainiziodisp());
			propostaDTO.setDatafinedisp(proposta.getDatafinedisp());
			propostaDTO.setDisponibilita(proposta.getDisponibilita());
			propostaDTO.setCostounitario(proposta.getCostounitario());
			
			propostaDTO.setPosizione(proposta.getPosizione());
			propostaDTO.setStato(proposta.getStato());
			propostaDTO.setDatacreamodpr(proposta.getDatacreamodpr());
			propostaDTO.setIdproposta(proposta.getIdproposta());

			propostaDTO.setBeneservizio(beneservizioDTO);
			propostaDTO.setProponente(proponenteDTO);

			dtopropostaList.add(propostaDTO);
			
		}
		
		return dtopropostaList;
	
	}
	
	
	@GetMapping(
			value = "/getByApproved",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List<PropostaDTO> getByApproved() {
		
		List<Proposta> propostalist = propostaService.getByApproved();
		List<PropostaDTO> dtopropostaList = new ArrayList<PropostaDTO>();
		
		for (Proposta proposta : propostalist) {
			
			PropostaDTO propostaDTO = new PropostaDTO();
			BeneservizioDTO beneservizioDTO = new BeneservizioDTO();
			ProponenteDTO proponenteDTO = new ProponenteDTO();
			UtenteDTO utenteDTO = new UtenteDTO();
			
			utenteDTO.setIdutente(proposta.getProponente().getUtente().getIdutente());
			utenteDTO.setNome(proposta.getProponente().getUtente().getNome());
			utenteDTO.setCognome(proposta.getProponente().getUtente().getCognome());
			utenteDTO.setUsername(proposta.getProponente().getUtente().getUsername());
			utenteDTO.setPassword(proposta.getProponente().getUtente().getPassword());
			utenteDTO.setEmail(proposta.getProponente().getUtente().getEmail());
			utenteDTO.setUltimologin(proposta.getProponente().getUtente().getUltimologin());
			utenteDTO.setStatus(proposta.getProponente().getUtente().getStatus());

			proponenteDTO.setIdproponente(proposta.getProponente().getIdproponente());
			proponenteDTO.setTelefono(proposta.getProponente().getTelefono());
			proponenteDTO.setIndirizzo(proposta.getProponente().getIndirizzo());
			proponenteDTO.setCitta(proposta.getProponente().getCitta());
			proponenteDTO.setCap(proposta.getProponente().getCap());
			proponenteDTO.setUtente(utenteDTO);
			
			beneservizioDTO.setIdbeneservizio(proposta.getBeneservizio().getIdbeneservizio());
			beneservizioDTO.setCategoria(proposta.getBeneservizio().getCategoria());
			beneservizioDTO.setDescrizione(proposta.getBeneservizio().getDescrizione());
			
			
			propostaDTO.setIdproposta(proposta.getIdproposta());
			propostaDTO.setNome(proposta.getNome());
			propostaDTO.setDescrizione(proposta.getDescrizione());
			propostaDTO.setDatainiziodisp(proposta.getDatainiziodisp());
			propostaDTO.setDatafinedisp(proposta.getDatafinedisp());
			propostaDTO.setDisponibilita(proposta.getDisponibilita());
			propostaDTO.setCostounitario(proposta.getCostounitario());
			
			propostaDTO.setPosizione(proposta.getPosizione());
			propostaDTO.setStato(proposta.getStato());
			propostaDTO.setDatacreamodpr(proposta.getDatacreamodpr());
			propostaDTO.setIdproposta(proposta.getIdproposta());

			propostaDTO.setBeneservizio(beneservizioDTO);
			propostaDTO.setProponente(proponenteDTO);

			dtopropostaList.add(propostaDTO);
			
		}
		
		return dtopropostaList;
	
	}

	@PutMapping(
			
			value="/approvaproposta/{id}",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
			
			)
	
	public void approvaProposta(@PathVariable int id) {
		
		
		 propostaService.setByApprovaProposta(id);
		
	}
	
}
