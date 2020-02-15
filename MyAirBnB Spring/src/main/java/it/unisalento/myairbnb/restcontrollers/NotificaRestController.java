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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.unisalento.myairbnb.dto.AcquirenteDTO;
import it.unisalento.myairbnb.dto.BeneservizioDTO;
import it.unisalento.myairbnb.dto.NotificaDTO;
import it.unisalento.myairbnb.dto.ProponenteDTO;
import it.unisalento.myairbnb.dto.PropostaDTO;
import it.unisalento.myairbnb.dto.UtenteDTO;
import it.unisalento.myairbnb.entities.Acquirente;
import it.unisalento.myairbnb.entities.Beneservizio;
import it.unisalento.myairbnb.entities.Notifica;
import it.unisalento.myairbnb.entities.Proponente;
import it.unisalento.myairbnb.entities.Proposta;
import it.unisalento.myairbnb.entities.Utente;
import it.unisalento.myairbnb.service.NotificaService;

@RestController
@RequestMapping("/notifica")
public class NotificaRestController {
	
	@Autowired
	NotificaService notificaService;
	
	
	
	@GetMapping(
			value = "/getAll",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List<NotificaDTO> getAll() {
		
		List<Notifica> notificalist = notificaService.getAll();
		List<NotificaDTO> dtonotificaList = new ArrayList<NotificaDTO>();
		
		for (Notifica notifica : notificalist) {
			
			NotificaDTO notificaDTO = new  NotificaDTO();
			PropostaDTO propostaDTO = new PropostaDTO();
			ProponenteDTO proponenteDTO = new ProponenteDTO();
			AcquirenteDTO acquirenteDTO = new AcquirenteDTO();
			UtenteDTO utenteDTO = new UtenteDTO();
			UtenteDTO utenteDTO2 = new UtenteDTO();
			UtenteDTO utenteDTO3 = new UtenteDTO();
			BeneservizioDTO beneservizioDTO = new BeneservizioDTO();
			
			utenteDTO.setIdutente(notifica.getProponente().getUtente().getIdutente());
			utenteDTO.setNome(notifica.getProponente().getUtente().getNome());
			utenteDTO.setCognome(notifica.getProponente().getUtente().getCognome());
			utenteDTO.setUsername(notifica.getProponente().getUtente().getUsername());
			utenteDTO.setPassword(notifica.getProponente().getUtente().getPassword());
			utenteDTO.setEmail(notifica.getProponente().getUtente().getEmail());
			utenteDTO.setUltimologin(notifica.getProponente().getUtente().getUltimologin());
			utenteDTO.setStatus(notifica.getProponente().getUtente().getStatus());
			
			proponenteDTO.setIdproponente(notifica.getProponente().getIdproponente());
			proponenteDTO.setTelefono(notifica.getProponente().getTelefono());
			proponenteDTO.setIndirizzo(notifica.getProponente().getIndirizzo());
			proponenteDTO.setCitta(notifica.getProponente().getCitta());
			proponenteDTO.setCap(notifica.getProponente().getCap());
			proponenteDTO.setUtente(utenteDTO);			

			
			
			utenteDTO2.setIdutente(notifica.getProposta().getProponente().getUtente().getIdutente());
			utenteDTO2.setNome(notifica.getProposta().getProponente().getUtente().getNome());
			utenteDTO2.setCognome(notifica.getProposta().getProponente().getUtente().getCognome());
			utenteDTO2.setUsername(notifica.getProposta().getProponente().getUtente().getUsername());
			utenteDTO2.setPassword(notifica.getProposta().getProponente().getUtente().getPassword());
			utenteDTO2.setEmail(notifica.getProposta().getProponente().getUtente().getEmail());
			utenteDTO2.setUltimologin(notifica.getProposta().getProponente().getUtente().getUltimologin());
			utenteDTO2.setStatus(notifica.getProposta().getProponente().getUtente().getStatus());
			
			beneservizioDTO.setIdbeneservizio(notifica.getProposta().getBeneservizio().getIdbeneservizio());
			beneservizioDTO.setCategoria(notifica.getProposta().getBeneservizio().getCategoria());
			beneservizioDTO.setDescrizione(notifica.getProposta().getBeneservizio().getDescrizione());
			
			proponenteDTO.setIdproponente(notifica.getProposta().getProponente().getIdproponente());
			proponenteDTO.setTelefono(notifica.getProposta().getProponente().getTelefono());
			proponenteDTO.setIndirizzo(notifica.getProposta().getProponente().getIndirizzo());
			proponenteDTO.setCitta(notifica.getProposta().getProponente().getCitta());
			proponenteDTO.setCap(notifica.getProposta().getProponente().getCap());
			proponenteDTO.setUtente(utenteDTO2);
			

			propostaDTO.setIdproposta(notifica.getProposta().getIdproposta());
			propostaDTO.setNome(notifica.getProposta().getNome());
			propostaDTO.setDescrizione(notifica.getProposta().getDescrizione());
			propostaDTO.setDatainiziodisp(notifica.getProposta().getDatainiziodisp());
			propostaDTO.setDatafinedisp(notifica.getProposta().getDatafinedisp());
			propostaDTO.setDisponibilita(notifica.getProposta().getDisponibilita());
			propostaDTO.setCostounitario(notifica.getProposta().getCostounitario());
			propostaDTO.setPosizione(notifica.getProposta().getPosizione());
			propostaDTO.setStato(notifica.getProposta().getStato());
			propostaDTO.setDatacreamodpr(notifica.getProposta().getDatacreamodpr());
			propostaDTO.setBeneservizio(beneservizioDTO);
			propostaDTO.setProponente(proponenteDTO);

			
			if(notifica.getAcquirente() != null) {
			
			utenteDTO3.setIdutente(notifica.getAcquirente().getUtente().getIdutente());
			utenteDTO3.setNome(notifica.getAcquirente().getUtente().getNome());
			utenteDTO3.setCognome(notifica.getAcquirente().getUtente().getCognome());
			utenteDTO3.setUsername(notifica.getAcquirente().getUtente().getUsername());
			utenteDTO3.setPassword(notifica.getAcquirente().getUtente().getPassword());
			utenteDTO3.setEmail(notifica.getAcquirente().getUtente().getEmail());
			utenteDTO3.setUltimologin(notifica.getAcquirente().getUtente().getUltimologin());
			utenteDTO3.setStatus(notifica.getAcquirente().getUtente().getStatus());
				
			acquirenteDTO.setIdacquirente(notifica.getAcquirente().getIdacquirente());
			acquirenteDTO.setTelefono(notifica.getAcquirente().getTelefono());
			acquirenteDTO.setIndirizzo(notifica.getAcquirente().getIndirizzo());
			acquirenteDTO.setCitta(notifica.getAcquirente().getCitta());
			acquirenteDTO.setCap(notifica.getAcquirente().getCap());
			acquirenteDTO.setUtente(utenteDTO3);
			
			notificaDTO.setAcquirente(acquirenteDTO);

			
			}
			
			notificaDTO.setIdnotifica(notifica.getIdnotifica());
			notificaDTO.setDescrizione(notifica.getDescrizione());
			notificaDTO.setTipo(notifica.getTipo());
			notificaDTO.setData(notifica.getData());
			notificaDTO.setProposta(propostaDTO);
			notificaDTO.setProponente(proponenteDTO);
			
		
			dtonotificaList.add(notificaDTO);
			
		}
		
		return dtonotificaList;

	}
	
	
	
	
	@GetMapping( value="/getByIdNotifica/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	
	public NotificaDTO get(@PathVariable int id) {
		
		NotificaDTO notificaDTO = new  NotificaDTO();
		PropostaDTO propostaDTO = new PropostaDTO();
		ProponenteDTO proponenteDTO = new ProponenteDTO();
		AcquirenteDTO acquirenteDTO = new AcquirenteDTO();
		UtenteDTO utenteDTO = new UtenteDTO();
		UtenteDTO utenteDTO2 = new UtenteDTO();
		UtenteDTO utenteDTO3 = new UtenteDTO();
		BeneservizioDTO beneservizioDTO = new BeneservizioDTO();
		
		Notifica notifica =  notificaService.getByIdNotifica(id);
		
		
		utenteDTO.setIdutente(notifica.getProponente().getUtente().getIdutente());
		utenteDTO.setNome(notifica.getProponente().getUtente().getNome());
		utenteDTO.setCognome(notifica.getProponente().getUtente().getCognome());
		utenteDTO.setUsername(notifica.getProponente().getUtente().getUsername());
		utenteDTO.setPassword(notifica.getProponente().getUtente().getPassword());
		utenteDTO.setEmail(notifica.getProponente().getUtente().getEmail());
		utenteDTO.setUltimologin(notifica.getProponente().getUtente().getUltimologin());
		utenteDTO.setStatus(notifica.getProponente().getUtente().getStatus());
		
		proponenteDTO.setIdproponente(notifica.getProponente().getIdproponente());
		proponenteDTO.setTelefono(notifica.getProponente().getTelefono());
		proponenteDTO.setIndirizzo(notifica.getProponente().getIndirizzo());
		proponenteDTO.setCitta(notifica.getProponente().getCitta());
		proponenteDTO.setCap(notifica.getProponente().getCap());
		proponenteDTO.setUtente(utenteDTO);			

		
		
		utenteDTO2.setIdutente(notifica.getProposta().getProponente().getUtente().getIdutente());
		utenteDTO2.setNome(notifica.getProposta().getProponente().getUtente().getNome());
		utenteDTO2.setCognome(notifica.getProposta().getProponente().getUtente().getCognome());
		utenteDTO2.setUsername(notifica.getProposta().getProponente().getUtente().getUsername());
		utenteDTO2.setPassword(notifica.getProposta().getProponente().getUtente().getPassword());
		utenteDTO2.setEmail(notifica.getProposta().getProponente().getUtente().getEmail());
		utenteDTO2.setUltimologin(notifica.getProposta().getProponente().getUtente().getUltimologin());
		utenteDTO2.setStatus(notifica.getProposta().getProponente().getUtente().getStatus());
		
		beneservizioDTO.setIdbeneservizio(notifica.getProposta().getBeneservizio().getIdbeneservizio());
		beneservizioDTO.setCategoria(notifica.getProposta().getBeneservizio().getCategoria());
		beneservizioDTO.setDescrizione(notifica.getProposta().getBeneservizio().getDescrizione());
		
		proponenteDTO.setIdproponente(notifica.getProposta().getProponente().getIdproponente());
		proponenteDTO.setTelefono(notifica.getProposta().getProponente().getTelefono());
		proponenteDTO.setIndirizzo(notifica.getProposta().getProponente().getIndirizzo());
		proponenteDTO.setCitta(notifica.getProposta().getProponente().getCitta());
		proponenteDTO.setCap(notifica.getProposta().getProponente().getCap());
		proponenteDTO.setUtente(utenteDTO2);
		

		propostaDTO.setIdproposta(notifica.getProposta().getIdproposta());
		propostaDTO.setNome(notifica.getProposta().getNome());
		propostaDTO.setDescrizione(notifica.getProposta().getDescrizione());
		propostaDTO.setDatainiziodisp(notifica.getProposta().getDatainiziodisp());
		propostaDTO.setDatafinedisp(notifica.getProposta().getDatafinedisp());
		propostaDTO.setDisponibilita(notifica.getProposta().getDisponibilita());
		propostaDTO.setCostounitario(notifica.getProposta().getCostounitario());
		propostaDTO.setPosizione(notifica.getProposta().getPosizione());
		propostaDTO.setStato(notifica.getProposta().getStato());
		propostaDTO.setDatacreamodpr(notifica.getProposta().getDatacreamodpr());
		propostaDTO.setBeneservizio(beneservizioDTO);
		propostaDTO.setProponente(proponenteDTO);

		
		if(notifica.getAcquirente() != null) {
		
			utenteDTO3.setIdutente(notifica.getAcquirente().getUtente().getIdutente());
			utenteDTO3.setNome(notifica.getAcquirente().getUtente().getNome());
			utenteDTO3.setCognome(notifica.getAcquirente().getUtente().getCognome());
			utenteDTO3.setUsername(notifica.getAcquirente().getUtente().getUsername());
			utenteDTO3.setPassword(notifica.getAcquirente().getUtente().getPassword());
			utenteDTO3.setEmail(notifica.getAcquirente().getUtente().getEmail());
			utenteDTO3.setUltimologin(notifica.getAcquirente().getUtente().getUltimologin());
			utenteDTO3.setStatus(notifica.getAcquirente().getUtente().getStatus());
			
		acquirenteDTO.setIdacquirente(notifica.getAcquirente().getIdacquirente());
		acquirenteDTO.setTelefono(notifica.getAcquirente().getTelefono());
		acquirenteDTO.setIndirizzo(notifica.getAcquirente().getIndirizzo());
		acquirenteDTO.setCitta(notifica.getAcquirente().getCitta());
		acquirenteDTO.setCap(notifica.getAcquirente().getCap());
		acquirenteDTO.setUtente(utenteDTO3);
		
		notificaDTO.setAcquirente(acquirenteDTO);

		
		}
		
		notificaDTO.setIdnotifica(notifica.getIdnotifica());
		notificaDTO.setDescrizione(notifica.getDescrizione());
		notificaDTO.setTipo(notifica.getTipo());
		notificaDTO.setData(notifica.getData());
		notificaDTO.setProposta(propostaDTO);
		notificaDTO.setProponente(proponenteDTO);
		
		return notificaDTO;
	
	}
	
	
	
	@PostMapping(
			
			value = "/save",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	
	public Notifica post(@RequestBody @Valid NotificaDTO notificaDTO) {
		
		
		Notifica notifica = new  Notifica();
		Proposta proposta = new Proposta();
		Proponente proponente = new Proponente();
		Proponente proponente2 = new Proponente();

		Acquirente acquirente = new Acquirente();
		Utente utente = new Utente();
		Utente utente2 = new Utente();
		Utente utente3 = new Utente();
		Beneservizio beneservizio = new Beneservizio();
		
		notifica.setIdnotifica(notificaDTO.getIdnotifica());
		notifica.setDescrizione(notificaDTO.getDescrizione());
		notifica.setTipo(notificaDTO.getTipo());
		
		
		Timestamp ts = new Timestamp(notificaDTO.getData().getTime());
		notifica.setData(ts);
		
		
		proposta.setIdproposta(notificaDTO.getProposta().getIdproposta());
		proposta.setNome(notificaDTO.getProposta().getNome());
		proposta.setDescrizione(notificaDTO.getProposta().getDescrizione());
		
		Timestamp ts1 = new Timestamp(notificaDTO.getProposta().getDatainiziodisp().getTime());
		proposta.setDatainiziodisp(ts1);
		
		Timestamp ts2 = new Timestamp(notificaDTO.getProposta().getDatafinedisp().getTime());
		proposta.setDatafinedisp(ts2);
		
		
		proposta.setDisponibilita(notificaDTO.getProposta().getDisponibilita());
		proposta.setCostounitario(notificaDTO.getProposta().getCostounitario());
		proposta.setPosizione(notificaDTO.getProposta().getPosizione());
		proposta.setStato(notificaDTO.getProposta().getStato());
		Date d = new Date();		
		proposta.setDatacreamodpr(new Timestamp(d.getTime()));
		proposta.setBeneservizio(beneservizio);

		
		beneservizio.setIdbeneservizio(notificaDTO.getProposta().getBeneservizio().getIdbeneservizio());
		beneservizio.setCategoria(notificaDTO.getProposta().getBeneservizio().getCategoria());
		beneservizio.setDescrizione(notificaDTO.getProposta().getBeneservizio().getDescrizione());
		

		utente2.setIdutente(notificaDTO.getProposta().getProponente().getUtente().getIdutente());
		utente2.setNome(notificaDTO.getProposta().getProponente().getUtente().getNome());
		utente2.setCognome(notificaDTO.getProposta().getProponente().getUtente().getCognome());
		utente2.setUsername(notificaDTO.getProposta().getProponente().getUtente().getUsername());
		utente2.setPassword(notificaDTO.getProposta().getProponente().getUtente().getPassword());
		utente2.setEmail(notificaDTO.getProposta().getProponente().getUtente().getEmail());
		
		
		Timestamp ts4 = new Timestamp(notificaDTO.getProposta().getProponente().getUtente().getUltimologin().getTime());
		utente2.setUltimologin(ts4);
		
		utente2.setStatus(notificaDTO.getProposta().getProponente().getUtente().getStatus());
		
		proponente.setIdproponente(notificaDTO.getProposta().getProponente().getIdproponente());
		proponente.setTelefono(notificaDTO.getProposta().getProponente().getTelefono());
		proponente.setIndirizzo(notificaDTO.getProposta().getProponente().getIndirizzo());
		proponente.setCitta(notificaDTO.getProposta().getProponente().getCitta());
		proponente.setCap(notificaDTO.getProposta().getProponente().getCap());
		proponente.setUtente(utente2);	
		
		proposta.setProponente(proponente);

		
		

		utente.setIdutente(notificaDTO.getProponente().getUtente().getIdutente());
		utente.setNome(notificaDTO.getProponente().getUtente().getNome());
		utente.setCognome(notificaDTO.getProponente().getUtente().getCognome());
		utente.setUsername(notificaDTO.getProponente().getUtente().getUsername());
		utente.setPassword(notificaDTO.getProponente().getUtente().getPassword());
		utente.setEmail(notificaDTO.getProponente().getUtente().getEmail());
		
		proponente2.setIdproponente(notificaDTO.getProponente().getIdproponente());
		proponente2.setTelefono(notificaDTO.getProponente().getTelefono());
		proponente2.setIndirizzo(notificaDTO.getProponente().getIndirizzo());
		proponente2.setCitta(notificaDTO.getProponente().getCitta());
		proponente2.setCap(notificaDTO.getProponente().getCap());
		proponente2.setUtente(utente);			

		
		
		if(notificaDTO.getProponente().getUtente().getUltimologin() != null) {
		Timestamp ts5 = new Timestamp(notificaDTO.getProponente().getUtente().getUltimologin().getTime());
		utente.setUltimologin(ts5);}
		
		
		utente.setStatus(notificaDTO.getProponente().getUtente().getStatus());
		
		if(notificaDTO.getAcquirente()!= null) {
			utente3.setIdutente(notificaDTO.getAcquirente().getUtente().getIdutente());
			utente3.setNome(notificaDTO.getAcquirente().getUtente().getNome());
			utente3.setCognome(notificaDTO.getAcquirente().getUtente().getCognome());
			utente3.setUsername(notificaDTO.getAcquirente().getUtente().getUsername());
			utente3.setPassword(notificaDTO.getAcquirente().getUtente().getPassword());
			utente3.setEmail(notificaDTO.getAcquirente().getUtente().getEmail());

			Timestamp ts6 = new Timestamp(notificaDTO.getAcquirente().getUtente().getUltimologin().getTime());
			utente3.setUltimologin(ts6);
			
			utente3.setStatus(notificaDTO.getAcquirente().getUtente().getStatus());
		
		if(notificaDTO.getAcquirente()!= null) {
		acquirente.setIdacquirente(notificaDTO.getAcquirente().getIdacquirente());
		acquirente.setTelefono(notificaDTO.getAcquirente().getTelefono());
		acquirente.setIndirizzo(notificaDTO.getAcquirente().getIndirizzo());
		acquirente.setCitta(notificaDTO.getAcquirente().getCitta());
		acquirente.setCap(notificaDTO.getAcquirente().getCap());
		acquirente.setUtente(utente3);
		notifica.setAcquirente(acquirente);}
		else {
			acquirente.setIdacquirente(0);
			notifica.setAcquirente(acquirente);
		}

		
		
		}
		
		
		
		
		
		notifica.setProposta(proposta);
		notifica.setProponente(proponente2);
	
		
		return notificaService.saveorUpdate(notifica);
		
		
		
	}
	
	
	@DeleteMapping(
			
			value="/delete/{id}"
			)
	
	public void delete(@PathVariable int id) {
		notificaService.delete(id);
	}
	
	
	
	@GetMapping( value="/getNotificabyIdProposta/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	
	public List<NotificaDTO> getNotificabyIdProposta(@PathVariable int id) {
		
		List<Notifica> notificalist = notificaService.getByIdProposta(id);
		List<NotificaDTO> dtonotificaList = new ArrayList<NotificaDTO>();
		
		for (Notifica notifica : notificalist) {
			NotificaDTO notificaDTO = new  NotificaDTO();
			PropostaDTO propostaDTO = new PropostaDTO();
			ProponenteDTO proponenteDTO = new ProponenteDTO();
			AcquirenteDTO acquirenteDTO = new AcquirenteDTO();
			UtenteDTO utenteDTO = new UtenteDTO();
			UtenteDTO utenteDTO2 = new UtenteDTO();
			UtenteDTO utenteDTO3 = new UtenteDTO();
			BeneservizioDTO beneservizioDTO = new BeneservizioDTO();
			
			utenteDTO.setIdutente(notifica.getProponente().getUtente().getIdutente());
			utenteDTO.setNome(notifica.getProponente().getUtente().getNome());
			utenteDTO.setCognome(notifica.getProponente().getUtente().getCognome());
			utenteDTO.setUsername(notifica.getProponente().getUtente().getUsername());
			utenteDTO.setPassword(notifica.getProponente().getUtente().getPassword());
			utenteDTO.setEmail(notifica.getProponente().getUtente().getEmail());
			utenteDTO.setUltimologin(notifica.getProponente().getUtente().getUltimologin());
			utenteDTO.setStatus(notifica.getProponente().getUtente().getStatus());
			
			proponenteDTO.setIdproponente(notifica.getProponente().getIdproponente());
			proponenteDTO.setTelefono(notifica.getProponente().getTelefono());
			proponenteDTO.setIndirizzo(notifica.getProponente().getIndirizzo());
			proponenteDTO.setCitta(notifica.getProponente().getCitta());
			proponenteDTO.setCap(notifica.getProponente().getCap());
			proponenteDTO.setUtente(utenteDTO);			

			
			
			utenteDTO2.setIdutente(notifica.getProposta().getProponente().getUtente().getIdutente());
			utenteDTO2.setNome(notifica.getProposta().getProponente().getUtente().getNome());
			utenteDTO2.setCognome(notifica.getProposta().getProponente().getUtente().getCognome());
			utenteDTO2.setUsername(notifica.getProposta().getProponente().getUtente().getUsername());
			utenteDTO2.setPassword(notifica.getProposta().getProponente().getUtente().getPassword());
			utenteDTO2.setEmail(notifica.getProposta().getProponente().getUtente().getEmail());
			utenteDTO2.setUltimologin(notifica.getProposta().getProponente().getUtente().getUltimologin());
			utenteDTO2.setStatus(notifica.getProposta().getProponente().getUtente().getStatus());
			
			beneservizioDTO.setIdbeneservizio(notifica.getProposta().getBeneservizio().getIdbeneservizio());
			beneservizioDTO.setCategoria(notifica.getProposta().getBeneservizio().getCategoria());
			beneservizioDTO.setDescrizione(notifica.getProposta().getBeneservizio().getDescrizione());
			
			proponenteDTO.setIdproponente(notifica.getProposta().getProponente().getIdproponente());
			proponenteDTO.setTelefono(notifica.getProposta().getProponente().getTelefono());
			proponenteDTO.setIndirizzo(notifica.getProposta().getProponente().getIndirizzo());
			proponenteDTO.setCitta(notifica.getProposta().getProponente().getCitta());
			proponenteDTO.setCap(notifica.getProposta().getProponente().getCap());
			proponenteDTO.setUtente(utenteDTO2);
			

			propostaDTO.setIdproposta(notifica.getProposta().getIdproposta());
			propostaDTO.setNome(notifica.getProposta().getNome());
			propostaDTO.setDescrizione(notifica.getProposta().getDescrizione());
			propostaDTO.setDatainiziodisp(notifica.getProposta().getDatainiziodisp());
			propostaDTO.setDatafinedisp(notifica.getProposta().getDatafinedisp());
			propostaDTO.setDisponibilita(notifica.getProposta().getDisponibilita());
			propostaDTO.setCostounitario(notifica.getProposta().getCostounitario());
			propostaDTO.setPosizione(notifica.getProposta().getPosizione());
			propostaDTO.setStato(notifica.getProposta().getStato());
			propostaDTO.setDatacreamodpr(notifica.getProposta().getDatacreamodpr());
			propostaDTO.setBeneservizio(beneservizioDTO);
			propostaDTO.setProponente(proponenteDTO);

			
			if(notifica.getAcquirente() != null) {
			
				utenteDTO3.setIdutente(notifica.getAcquirente().getUtente().getIdutente());
				utenteDTO3.setNome(notifica.getAcquirente().getUtente().getNome());
				utenteDTO3.setCognome(notifica.getAcquirente().getUtente().getCognome());
				utenteDTO3.setUsername(notifica.getAcquirente().getUtente().getUsername());
				utenteDTO3.setPassword(notifica.getAcquirente().getUtente().getPassword());
				utenteDTO3.setEmail(notifica.getAcquirente().getUtente().getEmail());
				utenteDTO3.setUltimologin(notifica.getAcquirente().getUtente().getUltimologin());
				utenteDTO3.setStatus(notifica.getAcquirente().getUtente().getStatus());
				
			acquirenteDTO.setIdacquirente(notifica.getAcquirente().getIdacquirente());
			acquirenteDTO.setTelefono(notifica.getAcquirente().getTelefono());
			acquirenteDTO.setIndirizzo(notifica.getAcquirente().getIndirizzo());
			acquirenteDTO.setCitta(notifica.getAcquirente().getCitta());
			acquirenteDTO.setCap(notifica.getAcquirente().getCap());
			acquirenteDTO.setUtente(utenteDTO3);
			
			notificaDTO.setAcquirente(acquirenteDTO);

			
			}
			
			notificaDTO.setIdnotifica(notifica.getIdnotifica());
			notificaDTO.setDescrizione(notifica.getDescrizione());
			notificaDTO.setTipo(notifica.getTipo());
			notificaDTO.setData(notifica.getData());
			notificaDTO.setProposta(propostaDTO);
			notificaDTO.setProponente(proponenteDTO);
			
		
			dtonotificaList.add(notificaDTO);
			
		}
		
		return dtonotificaList;
	
	
	}
	
	
	@GetMapping( value="/getByIdAcquirente/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	
	public List<NotificaDTO> getByIdAcquirente(@PathVariable int id) {
		
		List<Notifica> notificalist = notificaService.getByIdAcquirente(id);
		List<NotificaDTO> dtonotificaList = new ArrayList<NotificaDTO>();
		
		for (Notifica notifica : notificalist) {
			NotificaDTO notificaDTO = new  NotificaDTO();
			PropostaDTO propostaDTO = new PropostaDTO();
			ProponenteDTO proponenteDTO = new ProponenteDTO();
			AcquirenteDTO acquirenteDTO = new AcquirenteDTO();
			UtenteDTO utenteDTO = new UtenteDTO();
			UtenteDTO utenteDTO2 = new UtenteDTO();
			UtenteDTO utenteDTO3 = new UtenteDTO();
			BeneservizioDTO beneservizioDTO = new BeneservizioDTO();
			utenteDTO.setIdutente(notifica.getProponente().getUtente().getIdutente());
			utenteDTO.setNome(notifica.getProponente().getUtente().getNome());
			utenteDTO.setCognome(notifica.getProponente().getUtente().getCognome());
			utenteDTO.setUsername(notifica.getProponente().getUtente().getUsername());
			utenteDTO.setPassword(notifica.getProponente().getUtente().getPassword());
			utenteDTO.setEmail(notifica.getProponente().getUtente().getEmail());
			utenteDTO.setUltimologin(notifica.getProponente().getUtente().getUltimologin());
			utenteDTO.setStatus(notifica.getProponente().getUtente().getStatus());
			
			proponenteDTO.setIdproponente(notifica.getProponente().getIdproponente());
			proponenteDTO.setTelefono(notifica.getProponente().getTelefono());
			proponenteDTO.setIndirizzo(notifica.getProponente().getIndirizzo());
			proponenteDTO.setCitta(notifica.getProponente().getCitta());
			proponenteDTO.setCap(notifica.getProponente().getCap());
			proponenteDTO.setUtente(utenteDTO);			

			
			
			utenteDTO2.setIdutente(notifica.getProposta().getProponente().getUtente().getIdutente());
			utenteDTO2.setNome(notifica.getProposta().getProponente().getUtente().getNome());
			utenteDTO2.setCognome(notifica.getProposta().getProponente().getUtente().getCognome());
			utenteDTO2.setUsername(notifica.getProposta().getProponente().getUtente().getUsername());
			utenteDTO2.setPassword(notifica.getProposta().getProponente().getUtente().getPassword());
			utenteDTO2.setEmail(notifica.getProposta().getProponente().getUtente().getEmail());
			utenteDTO2.setUltimologin(notifica.getProposta().getProponente().getUtente().getUltimologin());
			utenteDTO2.setStatus(notifica.getProposta().getProponente().getUtente().getStatus());
			
			beneservizioDTO.setIdbeneservizio(notifica.getProposta().getBeneservizio().getIdbeneservizio());
			beneservizioDTO.setCategoria(notifica.getProposta().getBeneservizio().getCategoria());
			beneservizioDTO.setDescrizione(notifica.getProposta().getBeneservizio().getDescrizione());
			
			proponenteDTO.setIdproponente(notifica.getProposta().getProponente().getIdproponente());
			proponenteDTO.setTelefono(notifica.getProposta().getProponente().getTelefono());
			proponenteDTO.setIndirizzo(notifica.getProposta().getProponente().getIndirizzo());
			proponenteDTO.setCitta(notifica.getProposta().getProponente().getCitta());
			proponenteDTO.setCap(notifica.getProposta().getProponente().getCap());
			proponenteDTO.setUtente(utenteDTO2);
			

			propostaDTO.setIdproposta(notifica.getProposta().getIdproposta());
			propostaDTO.setNome(notifica.getProposta().getNome());
			propostaDTO.setDescrizione(notifica.getProposta().getDescrizione());
			propostaDTO.setDatainiziodisp(notifica.getProposta().getDatainiziodisp());
			propostaDTO.setDatafinedisp(notifica.getProposta().getDatafinedisp());
			propostaDTO.setDisponibilita(notifica.getProposta().getDisponibilita());
			propostaDTO.setCostounitario(notifica.getProposta().getCostounitario());
			propostaDTO.setPosizione(notifica.getProposta().getPosizione());
			propostaDTO.setStato(notifica.getProposta().getStato());
			propostaDTO.setDatacreamodpr(notifica.getProposta().getDatacreamodpr());
			propostaDTO.setBeneservizio(beneservizioDTO);
			propostaDTO.setProponente(proponenteDTO);

			
			if(notifica.getAcquirente() != null) {
			
				utenteDTO3.setIdutente(notifica.getAcquirente().getUtente().getIdutente());
				utenteDTO3.setNome(notifica.getAcquirente().getUtente().getNome());
				utenteDTO3.setCognome(notifica.getAcquirente().getUtente().getCognome());
				utenteDTO3.setUsername(notifica.getAcquirente().getUtente().getUsername());
				utenteDTO3.setPassword(notifica.getAcquirente().getUtente().getPassword());
				utenteDTO3.setEmail(notifica.getAcquirente().getUtente().getEmail());
				utenteDTO3.setUltimologin(notifica.getAcquirente().getUtente().getUltimologin());
				utenteDTO3.setStatus(notifica.getAcquirente().getUtente().getStatus());
				
			acquirenteDTO.setIdacquirente(notifica.getAcquirente().getIdacquirente());
			acquirenteDTO.setTelefono(notifica.getAcquirente().getTelefono());
			acquirenteDTO.setIndirizzo(notifica.getAcquirente().getIndirizzo());
			acquirenteDTO.setCitta(notifica.getAcquirente().getCitta());
			acquirenteDTO.setCap(notifica.getAcquirente().getCap());
			acquirenteDTO.setUtente(utenteDTO3);
			
			notificaDTO.setAcquirente(acquirenteDTO);

			
			}
			
			notificaDTO.setIdnotifica(notifica.getIdnotifica());
			notificaDTO.setDescrizione(notifica.getDescrizione());
			notificaDTO.setTipo(notifica.getTipo());
			notificaDTO.setData(notifica.getData());
			notificaDTO.setProposta(propostaDTO);
			notificaDTO.setProponente(proponenteDTO);
			
		
			dtonotificaList.add(notificaDTO);
			
		}
		
		return dtonotificaList;
	
	
	}
	
	
	
	@GetMapping( value="/getByIdProponente/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	
	public List<NotificaDTO> getByIdProponente(@PathVariable int id) {
		
		List<Notifica> notificalist = notificaService.getByIdProponente(id);
		List<NotificaDTO> dtonotificaList = new ArrayList<NotificaDTO>();
		
		for (Notifica notifica : notificalist) {
			NotificaDTO notificaDTO = new  NotificaDTO();
			PropostaDTO propostaDTO = new PropostaDTO();
			ProponenteDTO proponenteDTO = new ProponenteDTO();
			AcquirenteDTO acquirenteDTO = new AcquirenteDTO();
			UtenteDTO utenteDTO = new UtenteDTO();
			UtenteDTO utenteDTO2 = new UtenteDTO();
			UtenteDTO utenteDTO3 = new UtenteDTO();
			BeneservizioDTO beneservizioDTO = new BeneservizioDTO();


			
			utenteDTO.setIdutente(notifica.getProponente().getUtente().getIdutente());
			utenteDTO.setNome(notifica.getProponente().getUtente().getNome());
			utenteDTO.setCognome(notifica.getProponente().getUtente().getCognome());
			utenteDTO.setUsername(notifica.getProponente().getUtente().getUsername());
			utenteDTO.setPassword(notifica.getProponente().getUtente().getPassword());
			utenteDTO.setEmail(notifica.getProponente().getUtente().getEmail());
			utenteDTO.setUltimologin(notifica.getProponente().getUtente().getUltimologin());
			utenteDTO.setStatus(notifica.getProponente().getUtente().getStatus());
			
			proponenteDTO.setIdproponente(notifica.getProponente().getIdproponente());
			proponenteDTO.setTelefono(notifica.getProponente().getTelefono());
			proponenteDTO.setIndirizzo(notifica.getProponente().getIndirizzo());
			proponenteDTO.setCitta(notifica.getProponente().getCitta());
			proponenteDTO.setCap(notifica.getProponente().getCap());
			proponenteDTO.setUtente(utenteDTO);			

			
			
			utenteDTO2.setIdutente(notifica.getProposta().getProponente().getUtente().getIdutente());
			utenteDTO2.setNome(notifica.getProposta().getProponente().getUtente().getNome());
			utenteDTO2.setCognome(notifica.getProposta().getProponente().getUtente().getCognome());
			utenteDTO2.setUsername(notifica.getProposta().getProponente().getUtente().getUsername());
			utenteDTO2.setPassword(notifica.getProposta().getProponente().getUtente().getPassword());
			utenteDTO2.setEmail(notifica.getProposta().getProponente().getUtente().getEmail());
			utenteDTO2.setUltimologin(notifica.getProposta().getProponente().getUtente().getUltimologin());
			utenteDTO2.setStatus(notifica.getProposta().getProponente().getUtente().getStatus());
			
			beneservizioDTO.setIdbeneservizio(notifica.getProposta().getBeneservizio().getIdbeneservizio());
			beneservizioDTO.setCategoria(notifica.getProposta().getBeneservizio().getCategoria());
			beneservizioDTO.setDescrizione(notifica.getProposta().getBeneservizio().getDescrizione());
			
			proponenteDTO.setIdproponente(notifica.getProposta().getProponente().getIdproponente());
			proponenteDTO.setTelefono(notifica.getProposta().getProponente().getTelefono());
			proponenteDTO.setIndirizzo(notifica.getProposta().getProponente().getIndirizzo());
			proponenteDTO.setCitta(notifica.getProposta().getProponente().getCitta());
			proponenteDTO.setCap(notifica.getProposta().getProponente().getCap());
			proponenteDTO.setUtente(utenteDTO2);
			

			propostaDTO.setIdproposta(notifica.getProposta().getIdproposta());
			propostaDTO.setNome(notifica.getProposta().getNome());
			propostaDTO.setDescrizione(notifica.getProposta().getDescrizione());
			propostaDTO.setDatainiziodisp(notifica.getProposta().getDatainiziodisp());
			propostaDTO.setDatafinedisp(notifica.getProposta().getDatafinedisp());
			propostaDTO.setDisponibilita(notifica.getProposta().getDisponibilita());
			propostaDTO.setCostounitario(notifica.getProposta().getCostounitario());
			propostaDTO.setPosizione(notifica.getProposta().getPosizione());
			propostaDTO.setStato(notifica.getProposta().getStato());
			propostaDTO.setDatacreamodpr(notifica.getProposta().getDatacreamodpr());
			propostaDTO.setBeneservizio(beneservizioDTO);
			propostaDTO.setProponente(proponenteDTO);

			
			if(notifica.getAcquirente() != null) {
			
				utenteDTO3.setIdutente(notifica.getAcquirente().getUtente().getIdutente());
				utenteDTO3.setNome(notifica.getAcquirente().getUtente().getNome());
				utenteDTO3.setCognome(notifica.getAcquirente().getUtente().getCognome());
				utenteDTO3.setUsername(notifica.getAcquirente().getUtente().getUsername());
				utenteDTO3.setPassword(notifica.getAcquirente().getUtente().getPassword());
				utenteDTO3.setEmail(notifica.getAcquirente().getUtente().getEmail());
				utenteDTO3.setUltimologin(notifica.getAcquirente().getUtente().getUltimologin());
				utenteDTO3.setStatus(notifica.getAcquirente().getUtente().getStatus());
				
			acquirenteDTO.setIdacquirente(notifica.getAcquirente().getIdacquirente());
			acquirenteDTO.setTelefono(notifica.getAcquirente().getTelefono());
			acquirenteDTO.setIndirizzo(notifica.getAcquirente().getIndirizzo());
			acquirenteDTO.setCitta(notifica.getAcquirente().getCitta());
			acquirenteDTO.setCap(notifica.getAcquirente().getCap());
			acquirenteDTO.setUtente(utenteDTO3);
			
			notificaDTO.setAcquirente(acquirenteDTO);

			
			}
			
			notificaDTO.setIdnotifica(notifica.getIdnotifica());
			notificaDTO.setDescrizione(notifica.getDescrizione());
			notificaDTO.setTipo(notifica.getTipo());
			notificaDTO.setData(notifica.getData());
			notificaDTO.setProposta(propostaDTO);
			notificaDTO.setProponente(proponenteDTO);
			
			
			
		
			dtonotificaList.add(notificaDTO);
			
		}
		
		return dtonotificaList;
	
	
	}
	
	@GetMapping( value="/getForTipo/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	
	public List<NotificaDTO> getForTipo(@PathVariable int id) {
		
		List<Notifica> notificalist = notificaService.getForTipo(id);
		List<NotificaDTO> dtonotificaList = new ArrayList<NotificaDTO>();
		
		for (Notifica notifica : notificalist) {
			NotificaDTO notificaDTO = new  NotificaDTO();
			PropostaDTO propostaDTO = new PropostaDTO();
			ProponenteDTO proponenteDTO = new ProponenteDTO();
			AcquirenteDTO acquirenteDTO = new AcquirenteDTO();
			UtenteDTO utenteDTO = new UtenteDTO();
			UtenteDTO utenteDTO2 = new UtenteDTO();
			UtenteDTO utenteDTO3 = new UtenteDTO();
			BeneservizioDTO beneservizioDTO = new BeneservizioDTO();
			
			utenteDTO.setIdutente(notifica.getProponente().getUtente().getIdutente());
			utenteDTO.setNome(notifica.getProponente().getUtente().getNome());
			utenteDTO.setCognome(notifica.getProponente().getUtente().getCognome());
			utenteDTO.setUsername(notifica.getProponente().getUtente().getUsername());
			utenteDTO.setPassword(notifica.getProponente().getUtente().getPassword());
			utenteDTO.setEmail(notifica.getProponente().getUtente().getEmail());
			utenteDTO.setUltimologin(notifica.getProponente().getUtente().getUltimologin());
			utenteDTO.setStatus(notifica.getProponente().getUtente().getStatus());
			
			proponenteDTO.setIdproponente(notifica.getProponente().getIdproponente());
			proponenteDTO.setTelefono(notifica.getProponente().getTelefono());
			proponenteDTO.setIndirizzo(notifica.getProponente().getIndirizzo());
			proponenteDTO.setCitta(notifica.getProponente().getCitta());
			proponenteDTO.setCap(notifica.getProponente().getCap());
			proponenteDTO.setUtente(utenteDTO);			

			
			
			utenteDTO2.setIdutente(notifica.getProposta().getProponente().getUtente().getIdutente());
			utenteDTO2.setNome(notifica.getProposta().getProponente().getUtente().getNome());
			utenteDTO2.setCognome(notifica.getProposta().getProponente().getUtente().getCognome());
			utenteDTO2.setUsername(notifica.getProposta().getProponente().getUtente().getUsername());
			utenteDTO2.setPassword(notifica.getProposta().getProponente().getUtente().getPassword());
			utenteDTO2.setEmail(notifica.getProposta().getProponente().getUtente().getEmail());
			utenteDTO2.setUltimologin(notifica.getProposta().getProponente().getUtente().getUltimologin());
			utenteDTO2.setStatus(notifica.getProposta().getProponente().getUtente().getStatus());
			
			beneservizioDTO.setIdbeneservizio(notifica.getProposta().getBeneservizio().getIdbeneservizio());
			beneservizioDTO.setCategoria(notifica.getProposta().getBeneservizio().getCategoria());
			beneservizioDTO.setDescrizione(notifica.getProposta().getBeneservizio().getDescrizione());
			
			proponenteDTO.setIdproponente(notifica.getProposta().getProponente().getIdproponente());
			proponenteDTO.setTelefono(notifica.getProposta().getProponente().getTelefono());
			proponenteDTO.setIndirizzo(notifica.getProposta().getProponente().getIndirizzo());
			proponenteDTO.setCitta(notifica.getProposta().getProponente().getCitta());
			proponenteDTO.setCap(notifica.getProposta().getProponente().getCap());
			proponenteDTO.setUtente(utenteDTO2);
			

			propostaDTO.setIdproposta(notifica.getProposta().getIdproposta());
			propostaDTO.setNome(notifica.getProposta().getNome());
			propostaDTO.setDescrizione(notifica.getProposta().getDescrizione());
			propostaDTO.setDatainiziodisp(notifica.getProposta().getDatainiziodisp());
			propostaDTO.setDatafinedisp(notifica.getProposta().getDatafinedisp());
			propostaDTO.setDisponibilita(notifica.getProposta().getDisponibilita());
			propostaDTO.setCostounitario(notifica.getProposta().getCostounitario());
			propostaDTO.setPosizione(notifica.getProposta().getPosizione());
			propostaDTO.setStato(notifica.getProposta().getStato());
			propostaDTO.setDatacreamodpr(notifica.getProposta().getDatacreamodpr());
			propostaDTO.setBeneservizio(beneservizioDTO);
			propostaDTO.setProponente(proponenteDTO);
			
			if(notifica.getAcquirente() != null) {
			
				utenteDTO3.setIdutente(notifica.getAcquirente().getUtente().getIdutente());
				utenteDTO3.setNome(notifica.getAcquirente().getUtente().getNome());
				utenteDTO3.setCognome(notifica.getAcquirente().getUtente().getCognome());
				utenteDTO3.setUsername(notifica.getAcquirente().getUtente().getUsername());
				utenteDTO3.setPassword(notifica.getAcquirente().getUtente().getPassword());
				utenteDTO3.setEmail(notifica.getAcquirente().getUtente().getEmail());
				utenteDTO3.setUltimologin(notifica.getAcquirente().getUtente().getUltimologin());
				utenteDTO3.setStatus(notifica.getAcquirente().getUtente().getStatus());
				
			acquirenteDTO.setIdacquirente(notifica.getAcquirente().getIdacquirente());
			acquirenteDTO.setTelefono(notifica.getAcquirente().getTelefono());
			acquirenteDTO.setIndirizzo(notifica.getAcquirente().getIndirizzo());
			acquirenteDTO.setCitta(notifica.getAcquirente().getCitta());
			acquirenteDTO.setCap(notifica.getAcquirente().getCap());
			acquirenteDTO.setUtente(utenteDTO3);
			
			notificaDTO.setAcquirente(acquirenteDTO);

			
			}
			
			notificaDTO.setIdnotifica(notifica.getIdnotifica());
			notificaDTO.setDescrizione(notifica.getDescrizione());
			notificaDTO.setTipo(notifica.getTipo());
			notificaDTO.setData(notifica.getData());
			notificaDTO.setProposta(propostaDTO);
			notificaDTO.setAcquirente(acquirenteDTO);
			notificaDTO.setProponente(proponenteDTO);
			
		
			dtonotificaList.add(notificaDTO);
			
		}
		
		return dtonotificaList;
	
	
	}
	
	

}
