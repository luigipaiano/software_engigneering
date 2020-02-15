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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.unisalento.myairbnb.dto.AcquirenteDTO;
import it.unisalento.myairbnb.dto.BeneservizioDTO;
import it.unisalento.myairbnb.dto.CommentoDTO;
import it.unisalento.myairbnb.dto.ProponenteDTO;
import it.unisalento.myairbnb.dto.PropostaDTO;
import it.unisalento.myairbnb.dto.UtenteDTO;
import it.unisalento.myairbnb.entities.Acquirente;
import it.unisalento.myairbnb.entities.Beneservizio;
import it.unisalento.myairbnb.entities.Commento;
import it.unisalento.myairbnb.entities.Proponente;
import it.unisalento.myairbnb.entities.Proposta;
import it.unisalento.myairbnb.entities.Utente;
import it.unisalento.myairbnb.service.CommentoService;

@RestController
@RequestMapping("/commento")
public class CommentoRestController {
	
	@Autowired
	CommentoService commentoService;
	
	
	@GetMapping(
			value = "/getAll",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List<CommentoDTO> getAll() {
		
		List<Commento> commentolist = commentoService.getAll();
		List<CommentoDTO> dtocommentoList = new ArrayList<CommentoDTO>();
		
		for (Commento commento : commentolist) {
			
			CommentoDTO commentoDTO = new CommentoDTO();
			AcquirenteDTO acquirenteDTO = new AcquirenteDTO();
			UtenteDTO utenteDTO = new UtenteDTO();
			UtenteDTO utenteDTO2 = new UtenteDTO();
			PropostaDTO propostaDTO = new PropostaDTO();
			ProponenteDTO proponenteDTO = new ProponenteDTO();
			BeneservizioDTO beneservizioDTO = new BeneservizioDTO();
			
			
			beneservizioDTO.setIdbeneservizio(commento.getProposta().getBeneservizio().getIdbeneservizio());
			beneservizioDTO.setCategoria(commento.getProposta().getBeneservizio().getCategoria());
			beneservizioDTO.setDescrizione(commento.getProposta().getBeneservizio().getDescrizione());
			
			
			utenteDTO2.setIdutente(commento.getProposta().getProponente().getUtente().getIdutente());
			utenteDTO2.setNome(commento.getProposta().getProponente().getUtente().getNome());
			utenteDTO2.setCognome(commento.getProposta().getProponente().getUtente().getCognome());
			utenteDTO2.setUsername(commento.getProposta().getProponente().getUtente().getUsername());
			utenteDTO2.setPassword(commento.getProposta().getProponente().getUtente().getPassword());
			utenteDTO2.setEmail(commento.getProposta().getProponente().getUtente().getEmail());
			utenteDTO2.setUltimologin(commento.getProposta().getProponente().getUtente().getUltimologin());
			utenteDTO2.setStatus(commento.getProposta().getProponente().getUtente().getStatus());
			
			
			proponenteDTO.setIdproponente(commento.getProposta().getProponente().getIdproponente());
			proponenteDTO.setTelefono(commento.getProposta().getProponente().getTelefono());
			proponenteDTO.setIndirizzo(commento.getProposta().getProponente().getIndirizzo());
			proponenteDTO.setCitta(commento.getProposta().getProponente().getCitta());
			proponenteDTO.setCap(commento.getProposta().getProponente().getCap());
			proponenteDTO.setUtente(utenteDTO2);

			propostaDTO.setIdproposta(commento.getProposta().getIdproposta());
			propostaDTO.setNome(commento.getProposta().getNome());
			propostaDTO.setDescrizione(commento.getProposta().getDescrizione());
			propostaDTO.setDatainiziodisp(commento.getProposta().getDatainiziodisp());
			propostaDTO.setDatafinedisp(commento.getProposta().getDatafinedisp());
			propostaDTO.setDisponibilita(commento.getProposta().getDisponibilita());
			propostaDTO.setCostounitario(commento.getProposta().getCostounitario());
			propostaDTO.setPosizione(commento.getProposta().getPosizione());
			propostaDTO.setStato(commento.getProposta().getStato());
			propostaDTO.setDatacreamodpr(commento.getProposta().getDatacreamodpr());
			propostaDTO.setBeneservizio(beneservizioDTO);
			propostaDTO.setProponente(proponenteDTO);
			
			if(commento.getAcquirente() != null) {

			
			utenteDTO.setIdutente(commento.getAcquirente().getUtente().getIdutente());
			utenteDTO.setNome(commento.getAcquirente().getUtente().getNome());
			utenteDTO.setCognome(commento.getAcquirente().getUtente().getCognome());
			utenteDTO.setUsername(commento.getAcquirente().getUtente().getUsername());
			utenteDTO.setPassword(commento.getAcquirente().getUtente().getPassword());
			utenteDTO.setEmail(commento.getAcquirente().getUtente().getEmail());
			utenteDTO.setUltimologin(commento.getAcquirente().getUtente().getUltimologin());
			utenteDTO.setStatus(commento.getAcquirente().getUtente().getStatus());

			
			acquirenteDTO.setIdacquirente(commento.getAcquirente().getIdacquirente());
			acquirenteDTO.setTelefono(commento.getAcquirente().getTelefono());
			acquirenteDTO.setIndirizzo(commento.getAcquirente().getIndirizzo());
			acquirenteDTO.setCitta(commento.getAcquirente().getCitta());
			acquirenteDTO.setCap(commento.getAcquirente().getCap());
			acquirenteDTO.setUtente(utenteDTO);
			
			commentoDTO.setAcquirente(acquirenteDTO);
			
			
		}
			commentoDTO.setIdcommento(commento.getIdcommento());
			commentoDTO.setTipo(commento.getTipo());
			commentoDTO.setVal(commento.getVal());
			commentoDTO.setDescrizione(commento.getDescrizione());
			commentoDTO.setData(commento.getData());

			commentoDTO.setAcquirente(acquirenteDTO);
			commentoDTO.setProposta(propostaDTO);
			
			dtocommentoList.add(commentoDTO);

		}
			
		
		return dtocommentoList;

	}
	
	
	@GetMapping(
			value = "/getByIdAcquirente/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List<CommentoDTO> getCommentoByIdAcquirente(@PathVariable int id) {
		
		List<Commento> commentolist = commentoService.getByIdAcquirente(id);
		List<CommentoDTO> dtocommentoList = new ArrayList<CommentoDTO>();
		
		for (Commento commento : commentolist) {
			
			CommentoDTO commentoDTO = new CommentoDTO();
			AcquirenteDTO acquirenteDTO = new AcquirenteDTO();
			UtenteDTO utenteDTO = new UtenteDTO();
			UtenteDTO utenteDTO2 = new UtenteDTO();
			PropostaDTO propostaDTO = new PropostaDTO();
			ProponenteDTO proponenteDTO = new ProponenteDTO();
			BeneservizioDTO beneservizioDTO = new BeneservizioDTO();
			
			beneservizioDTO.setIdbeneservizio(commento.getProposta().getBeneservizio().getIdbeneservizio());
			beneservizioDTO.setCategoria(commento.getProposta().getBeneservizio().getCategoria());
			beneservizioDTO.setDescrizione(commento.getProposta().getBeneservizio().getDescrizione());
			
			
			utenteDTO2.setIdutente(commento.getProposta().getProponente().getUtente().getIdutente());
			utenteDTO2.setNome(commento.getProposta().getProponente().getUtente().getNome());
			utenteDTO2.setCognome(commento.getProposta().getProponente().getUtente().getCognome());
			utenteDTO2.setUsername(commento.getProposta().getProponente().getUtente().getUsername());
			utenteDTO2.setPassword(commento.getProposta().getProponente().getUtente().getPassword());
			utenteDTO2.setEmail(commento.getProposta().getProponente().getUtente().getEmail());
			utenteDTO2.setUltimologin(commento.getProposta().getProponente().getUtente().getUltimologin());
			utenteDTO2.setStatus(commento.getProposta().getProponente().getUtente().getStatus());
			
			
			proponenteDTO.setIdproponente(commento.getProposta().getProponente().getIdproponente());
			proponenteDTO.setTelefono(commento.getProposta().getProponente().getTelefono());
			proponenteDTO.setIndirizzo(commento.getProposta().getProponente().getIndirizzo());
			proponenteDTO.setCitta(commento.getProposta().getProponente().getCitta());
			proponenteDTO.setCap(commento.getProposta().getProponente().getCap());
			proponenteDTO.setUtente(utenteDTO2);

			propostaDTO.setIdproposta(commento.getProposta().getIdproposta());
			propostaDTO.setNome(commento.getProposta().getNome());
			propostaDTO.setDescrizione(commento.getProposta().getDescrizione());
			propostaDTO.setDatainiziodisp(commento.getProposta().getDatainiziodisp());
			propostaDTO.setDatafinedisp(commento.getProposta().getDatafinedisp());
			propostaDTO.setDisponibilita(commento.getProposta().getDisponibilita());
			propostaDTO.setCostounitario(commento.getProposta().getCostounitario());
			propostaDTO.setPosizione(commento.getProposta().getPosizione());
			propostaDTO.setStato(commento.getProposta().getStato());
			propostaDTO.setDatacreamodpr(commento.getProposta().getDatacreamodpr());
			propostaDTO.setBeneservizio(beneservizioDTO);
			propostaDTO.setProponente(proponenteDTO);
			
			if(commento.getAcquirente() != null) {

			
			utenteDTO.setIdutente(commento.getAcquirente().getUtente().getIdutente());
			utenteDTO.setNome(commento.getAcquirente().getUtente().getNome());
			utenteDTO.setCognome(commento.getAcquirente().getUtente().getCognome());
			utenteDTO.setUsername(commento.getAcquirente().getUtente().getUsername());
			utenteDTO.setPassword(commento.getAcquirente().getUtente().getPassword());
			utenteDTO.setEmail(commento.getAcquirente().getUtente().getEmail());
			utenteDTO.setUltimologin(commento.getAcquirente().getUtente().getUltimologin());
			utenteDTO.setStatus(commento.getAcquirente().getUtente().getStatus());

			
			acquirenteDTO.setIdacquirente(commento.getAcquirente().getIdacquirente());
			acquirenteDTO.setTelefono(commento.getAcquirente().getTelefono());
			acquirenteDTO.setIndirizzo(commento.getAcquirente().getIndirizzo());
			acquirenteDTO.setCitta(commento.getAcquirente().getCitta());
			acquirenteDTO.setCap(commento.getAcquirente().getCap());
			acquirenteDTO.setUtente(utenteDTO);
			
			commentoDTO.setAcquirente(acquirenteDTO);
			
			
		}
			commentoDTO.setIdcommento(commento.getIdcommento());
			commentoDTO.setTipo(commento.getTipo());
			commentoDTO.setVal(commento.getVal());
			commentoDTO.setDescrizione(commento.getDescrizione());
			commentoDTO.setData(commento.getData());

			commentoDTO.setAcquirente(acquirenteDTO);
			commentoDTO.setProposta(propostaDTO);
			
			dtocommentoList.add(commentoDTO);

		}
			
		
		return dtocommentoList;

	}
	
	
	@GetMapping(
			value = "/getByIdProposta/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List<CommentoDTO> getCommentoByIdProposta(@PathVariable int id) {
		
		List<Commento> commentolist = commentoService.getByIdProposta(id);
		List<CommentoDTO> dtocommentoList = new ArrayList<CommentoDTO>();
		
		for (Commento commento : commentolist) {
			
			CommentoDTO commentoDTO = new CommentoDTO();
			AcquirenteDTO acquirenteDTO = new AcquirenteDTO();
			UtenteDTO utenteDTO = new UtenteDTO();
			UtenteDTO utenteDTO2 = new UtenteDTO();
			PropostaDTO propostaDTO = new PropostaDTO();
			ProponenteDTO proponenteDTO = new ProponenteDTO();
			BeneservizioDTO beneservizioDTO = new BeneservizioDTO();
			
			beneservizioDTO.setIdbeneservizio(commento.getProposta().getBeneservizio().getIdbeneservizio());
			beneservizioDTO.setCategoria(commento.getProposta().getBeneservizio().getCategoria());
			beneservizioDTO.setDescrizione(commento.getProposta().getBeneservizio().getDescrizione());
			
			
			utenteDTO2.setIdutente(commento.getProposta().getProponente().getUtente().getIdutente());
			utenteDTO2.setNome(commento.getProposta().getProponente().getUtente().getNome());
			utenteDTO2.setCognome(commento.getProposta().getProponente().getUtente().getCognome());
			utenteDTO2.setUsername(commento.getProposta().getProponente().getUtente().getUsername());
			utenteDTO2.setPassword(commento.getProposta().getProponente().getUtente().getPassword());
			utenteDTO2.setEmail(commento.getProposta().getProponente().getUtente().getEmail());
			utenteDTO2.setUltimologin(commento.getProposta().getProponente().getUtente().getUltimologin());
			utenteDTO2.setStatus(commento.getProposta().getProponente().getUtente().getStatus());
			
			
			proponenteDTO.setIdproponente(commento.getProposta().getProponente().getIdproponente());
			proponenteDTO.setTelefono(commento.getProposta().getProponente().getTelefono());
			proponenteDTO.setIndirizzo(commento.getProposta().getProponente().getIndirizzo());
			proponenteDTO.setCitta(commento.getProposta().getProponente().getCitta());
			proponenteDTO.setCap(commento.getProposta().getProponente().getCap());
			proponenteDTO.setUtente(utenteDTO2);

			propostaDTO.setIdproposta(commento.getProposta().getIdproposta());
			propostaDTO.setNome(commento.getProposta().getNome());
			propostaDTO.setDescrizione(commento.getProposta().getDescrizione());
			propostaDTO.setDatainiziodisp(commento.getProposta().getDatainiziodisp());
			propostaDTO.setDatafinedisp(commento.getProposta().getDatafinedisp());
			propostaDTO.setDisponibilita(commento.getProposta().getDisponibilita());
			propostaDTO.setCostounitario(commento.getProposta().getCostounitario());
			propostaDTO.setPosizione(commento.getProposta().getPosizione());
			propostaDTO.setStato(commento.getProposta().getStato());
			propostaDTO.setDatacreamodpr(commento.getProposta().getDatacreamodpr());
			propostaDTO.setBeneservizio(beneservizioDTO);
			propostaDTO.setProponente(proponenteDTO);
			
			if(commento.getAcquirente() != null) {

			
			utenteDTO.setIdutente(commento.getAcquirente().getUtente().getIdutente());
			utenteDTO.setNome(commento.getAcquirente().getUtente().getNome());
			utenteDTO.setCognome(commento.getAcquirente().getUtente().getCognome());
			utenteDTO.setUsername(commento.getAcquirente().getUtente().getUsername());
			utenteDTO.setPassword(commento.getAcquirente().getUtente().getPassword());
			utenteDTO.setEmail(commento.getAcquirente().getUtente().getEmail());
			utenteDTO.setUltimologin(commento.getAcquirente().getUtente().getUltimologin());
			utenteDTO.setStatus(commento.getAcquirente().getUtente().getStatus());

			
			acquirenteDTO.setIdacquirente(commento.getAcquirente().getIdacquirente());
			acquirenteDTO.setTelefono(commento.getAcquirente().getTelefono());
			acquirenteDTO.setIndirizzo(commento.getAcquirente().getIndirizzo());
			acquirenteDTO.setCitta(commento.getAcquirente().getCitta());
			acquirenteDTO.setCap(commento.getAcquirente().getCap());
			acquirenteDTO.setUtente(utenteDTO);
			
			commentoDTO.setAcquirente(acquirenteDTO);
			
			
		}
			commentoDTO.setIdcommento(commento.getIdcommento());
			commentoDTO.setTipo(commento.getTipo());
			commentoDTO.setVal(commento.getVal());
			commentoDTO.setDescrizione(commento.getDescrizione());
			commentoDTO.setData(commento.getData());

			commentoDTO.setAcquirente(acquirenteDTO);
			commentoDTO.setProposta(propostaDTO);
			
			dtocommentoList.add(commentoDTO);

		}
			
		
		return dtocommentoList;
	}
	
	
	@PostMapping(
			
			value = "/save",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	
	public Commento post(@RequestBody @Valid CommentoDTO commentoDTO) {
		
		Commento commento = new Commento();
		Acquirente acquirente = new Acquirente();
		Utente utente = new Utente();
		Utente utente2 = new Utente();
		Proposta proposta = new Proposta();
		Proponente proponente = new Proponente();
		Beneservizio beneservizio = new Beneservizio();
		
		//commento.setIdcommento(commentoDTO.getIdcommento());
		commento.setTipo(commentoDTO.getTipo());
		commento.setVal(commentoDTO.getVal());
		commento.setDescrizione(commentoDTO.getDescrizione());
		
		Timestamp ts = new Timestamp(commentoDTO.getData().getTime());
		commento.setData(ts);
		
		
		proposta.setIdproposta(commentoDTO.getProposta().getIdproposta());
		proposta.setNome(commentoDTO.getProposta().getNome());
		proposta.setDescrizione(commentoDTO.getProposta().getDescrizione());
		
		Timestamp ts2 = new Timestamp(commentoDTO.getProposta().getDatainiziodisp().getTime());
		proposta.setDatainiziodisp(ts2);
		
		Timestamp ts3 = new Timestamp(commentoDTO.getProposta().getDatafinedisp().getTime());
		proposta.setDatafinedisp(ts3);
		
		proposta.setDisponibilita(commentoDTO.getProposta().getDisponibilita());
		proposta.setCostounitario(commentoDTO.getProposta().getCostounitario());
		proposta.setPosizione(commentoDTO.getProposta().getPosizione());
		proposta.setStato(commentoDTO.getProposta().getStato());
		
		Timestamp ts4 = new Timestamp(commentoDTO.getProposta().getDatacreamodpr().getTime());
		proposta.setDatacreamodpr(ts4);
		
		proposta.setBeneservizio(beneservizio);
		proposta.setProponente(proponente);
		
		beneservizio.setIdbeneservizio(commentoDTO.getProposta().getBeneservizio().getIdbeneservizio());
		beneservizio.setCategoria(commentoDTO.getProposta().getBeneservizio().getCategoria());
		beneservizio.setDescrizione(commentoDTO.getProposta().getBeneservizio().getDescrizione());
		
		utente2.setNome(commentoDTO.getProposta().getProponente().getUtente().getNome());
		utente2.setCognome(commentoDTO.getProposta().getProponente().getUtente().getCognome());
		utente2.setUsername(commentoDTO.getProposta().getProponente().getUtente().getUsername());
		utente2.setPassword(commentoDTO.getProposta().getProponente().getUtente().getPassword());
		utente2.setEmail(commentoDTO.getProposta().getProponente().getUtente().getEmail());
		
		Timestamp ts5 = new Timestamp(commentoDTO.getProposta().getProponente().getUtente().getUltimologin().getTime());
		utente2.setUltimologin(ts5);
		utente2.setStatus(commentoDTO.getProposta().getProponente().getUtente().getStatus());
		
		
		proponente.setIdproponente(commentoDTO.getProposta().getProponente().getIdproponente());
		proponente.setTelefono(commentoDTO.getProposta().getProponente().getTelefono());
		proponente.setIndirizzo(commentoDTO.getProposta().getProponente().getIndirizzo());
		proponente.setCitta(commentoDTO.getProposta().getProponente().getCitta());
		proponente.setCap(commentoDTO.getProposta().getProponente().getCap());
		proponente.setUtente(utente2);
		
	
		
	if(commentoDTO.getAcquirente()!= null) {
		
		utente.setNome(commentoDTO.getAcquirente().getUtente().getNome());
		utente.setCognome(commentoDTO.getAcquirente().getUtente().getCognome());
		utente.setUsername(commentoDTO.getAcquirente().getUtente().getUsername());
		utente.setPassword(commentoDTO.getAcquirente().getUtente().getPassword());
		utente.setEmail(commentoDTO.getAcquirente().getUtente().getEmail());
		
		Timestamp ts1 = new Timestamp(commentoDTO.getAcquirente().getUtente().getUltimologin().getTime());
		utente.setUltimologin(ts1);
		utente.setStatus(commentoDTO.getAcquirente().getUtente().getStatus());
		
	if(commentoDTO.getAcquirente()!= null) {
		
		acquirente.setTelefono(commentoDTO.getAcquirente().getTelefono());
		acquirente.setIndirizzo(commentoDTO.getAcquirente().getIndirizzo());
		acquirente.setCitta(commentoDTO.getAcquirente().getCitta());
		acquirente.setCap(commentoDTO.getAcquirente().getCap());
		acquirente.setUtente(utente);
		acquirente.setIdacquirente(commentoDTO.getAcquirente().getIdacquirente());
		commento.setAcquirente(acquirente);}
		else {

		acquirente.setIdacquirente(0);
		commento.setAcquirente(acquirente);
		
		}
	
		}

	
	
		commento.setProposta(proposta);
		
		
		return commentoService.saveorUpdate(commento);
		
		
	}

	@PutMapping(
			
			value="/update",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
			
			)
	
	public Commento update(@RequestBody @Valid CommentoDTO commentoDTO) {
		
		Commento commento = new Commento();
		Acquirente acquirente = new Acquirente();
		Utente utente = new Utente();
		Utente utente2 = new Utente();
		Proposta proposta = new Proposta();
		Proponente proponente = new Proponente();
		Beneservizio beneservizio = new Beneservizio();
		
		//commento.setIdcommento(commentoDTO.getIdcommento());
		commento.setTipo(commentoDTO.getTipo());
		commento.setVal(commentoDTO.getVal());
		commento.setDescrizione(commentoDTO.getDescrizione());
		
		Timestamp ts = new Timestamp(commentoDTO.getData().getTime());
		commento.setData(ts);
		
		
		proposta.setIdproposta(commentoDTO.getProposta().getIdproposta());
		proposta.setNome(commentoDTO.getProposta().getNome());
		proposta.setDescrizione(commentoDTO.getProposta().getDescrizione());
		
		Timestamp ts2 = new Timestamp(commentoDTO.getProposta().getDatainiziodisp().getTime());
		proposta.setDatainiziodisp(ts2);
		
		Timestamp ts3 = new Timestamp(commentoDTO.getProposta().getDatafinedisp().getTime());
		proposta.setDatafinedisp(ts3);
		
		proposta.setDisponibilita(commentoDTO.getProposta().getDisponibilita());
		proposta.setCostounitario(commentoDTO.getProposta().getCostounitario());
		proposta.setPosizione(commentoDTO.getProposta().getPosizione());
		proposta.setStato(commentoDTO.getProposta().getStato());
		
		Timestamp ts4 = new Timestamp(commentoDTO.getProposta().getDatacreamodpr().getTime());
		proposta.setDatacreamodpr(ts4);
		
		proposta.setBeneservizio(beneservizio);
		proposta.setProponente(proponente);
		
		beneservizio.setIdbeneservizio(commentoDTO.getProposta().getBeneservizio().getIdbeneservizio());
		beneservizio.setCategoria(commentoDTO.getProposta().getBeneservizio().getCategoria());
		beneservizio.setDescrizione(commentoDTO.getProposta().getBeneservizio().getDescrizione());
		
		utente2.setNome(commentoDTO.getProposta().getProponente().getUtente().getNome());
		utente2.setCognome(commentoDTO.getProposta().getProponente().getUtente().getCognome());
		utente2.setUsername(commentoDTO.getProposta().getProponente().getUtente().getUsername());
		utente2.setPassword(commentoDTO.getProposta().getProponente().getUtente().getPassword());
		utente2.setEmail(commentoDTO.getProposta().getProponente().getUtente().getEmail());
		
		Timestamp ts5 = new Timestamp(commentoDTO.getProposta().getProponente().getUtente().getUltimologin().getTime());
		utente2.setUltimologin(ts5);
		utente2.setStatus(commentoDTO.getProposta().getProponente().getUtente().getStatus());
		
		
		proponente.setIdproponente(commentoDTO.getProposta().getProponente().getIdproponente());
		proponente.setTelefono(commentoDTO.getProposta().getProponente().getTelefono());
		proponente.setIndirizzo(commentoDTO.getProposta().getProponente().getIndirizzo());
		proponente.setCitta(commentoDTO.getProposta().getProponente().getCitta());
		proponente.setCap(commentoDTO.getProposta().getProponente().getCap());
		proponente.setUtente(utente2);
		
	
		
	if(commentoDTO.getAcquirente()!= null) {
		
		utente.setNome(commentoDTO.getAcquirente().getUtente().getNome());
		utente.setCognome(commentoDTO.getAcquirente().getUtente().getCognome());
		utente.setUsername(commentoDTO.getAcquirente().getUtente().getUsername());
		utente.setPassword(commentoDTO.getAcquirente().getUtente().getPassword());
		utente.setEmail(commentoDTO.getAcquirente().getUtente().getEmail());
		
		Timestamp ts1 = new Timestamp(commentoDTO.getAcquirente().getUtente().getUltimologin().getTime());
		utente.setUltimologin(ts1);
		utente.setStatus(commentoDTO.getAcquirente().getUtente().getStatus());
		
	if(commentoDTO.getAcquirente()!= null) {
		
		acquirente.setTelefono(commentoDTO.getAcquirente().getTelefono());
		acquirente.setIndirizzo(commentoDTO.getAcquirente().getIndirizzo());
		acquirente.setCitta(commentoDTO.getAcquirente().getCitta());
		acquirente.setCap(commentoDTO.getAcquirente().getCap());
		acquirente.setUtente(utente);
		commento.setAcquirente(acquirente);}
		else {

		acquirente.setIdacquirente(0);
		commento.setAcquirente(acquirente);
		
		}
	
		}

		commento.setProposta(proposta);
		
		
		return commentoService.saveorUpdate(commento);
		
	}
	
	
	@DeleteMapping(
			
			value="/delete/{id}"
			)
	
	public void delete(@PathVariable int id) {
		commentoService.delete(id);
	}
	
	
	@GetMapping( value="/getByIdCommento/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public CommentoDTO get(@PathVariable int id) {
		
		CommentoDTO commentoDTO = new CommentoDTO();
		AcquirenteDTO acquirenteDTO = new AcquirenteDTO();
		UtenteDTO utenteDTO = new UtenteDTO();
		UtenteDTO utenteDTO2 = new UtenteDTO();
		PropostaDTO propostaDTO = new PropostaDTO();
		ProponenteDTO proponenteDTO = new ProponenteDTO();
		BeneservizioDTO beneservizioDTO = new BeneservizioDTO();
		
		Commento commento =  commentoService.getById(id);
		
		beneservizioDTO.setIdbeneservizio(commento.getProposta().getBeneservizio().getIdbeneservizio());
		beneservizioDTO.setCategoria(commento.getProposta().getBeneservizio().getCategoria());
		beneservizioDTO.setDescrizione(commento.getProposta().getBeneservizio().getDescrizione());
		
		
		utenteDTO2.setIdutente(commento.getProposta().getProponente().getUtente().getIdutente());
		utenteDTO2.setNome(commento.getProposta().getProponente().getUtente().getNome());
		utenteDTO2.setCognome(commento.getProposta().getProponente().getUtente().getCognome());
		utenteDTO2.setUsername(commento.getProposta().getProponente().getUtente().getUsername());
		utenteDTO2.setPassword(commento.getProposta().getProponente().getUtente().getPassword());
		utenteDTO2.setEmail(commento.getProposta().getProponente().getUtente().getEmail());
		utenteDTO2.setUltimologin(commento.getProposta().getProponente().getUtente().getUltimologin());
		utenteDTO2.setStatus(commento.getProposta().getProponente().getUtente().getStatus());
		
		
		proponenteDTO.setIdproponente(commento.getProposta().getProponente().getIdproponente());
		proponenteDTO.setTelefono(commento.getProposta().getProponente().getTelefono());
		proponenteDTO.setIndirizzo(commento.getProposta().getProponente().getIndirizzo());
		proponenteDTO.setCitta(commento.getProposta().getProponente().getCitta());
		proponenteDTO.setCap(commento.getProposta().getProponente().getCap());
		proponenteDTO.setUtente(utenteDTO2);

		propostaDTO.setIdproposta(commento.getProposta().getIdproposta());
		propostaDTO.setNome(commento.getProposta().getNome());
		propostaDTO.setDescrizione(commento.getProposta().getDescrizione());
		propostaDTO.setDatainiziodisp(commento.getProposta().getDatainiziodisp());
		propostaDTO.setDatafinedisp(commento.getProposta().getDatafinedisp());
		propostaDTO.setDisponibilita(commento.getProposta().getDisponibilita());
		propostaDTO.setCostounitario(commento.getProposta().getCostounitario());
		propostaDTO.setPosizione(commento.getProposta().getPosizione());
		propostaDTO.setStato(commento.getProposta().getStato());
		propostaDTO.setDatacreamodpr(commento.getProposta().getDatacreamodpr());
		propostaDTO.setBeneservizio(beneservizioDTO);
		propostaDTO.setProponente(proponenteDTO);
		
		if(commento.getAcquirente() != null) {

		
		utenteDTO.setIdutente(commento.getAcquirente().getUtente().getIdutente());
		utenteDTO.setNome(commento.getAcquirente().getUtente().getNome());
		utenteDTO.setCognome(commento.getAcquirente().getUtente().getCognome());
		utenteDTO.setUsername(commento.getAcquirente().getUtente().getUsername());
		utenteDTO.setPassword(commento.getAcquirente().getUtente().getPassword());
		utenteDTO.setEmail(commento.getAcquirente().getUtente().getEmail());
		utenteDTO.setUltimologin(commento.getAcquirente().getUtente().getUltimologin());
		utenteDTO.setStatus(commento.getAcquirente().getUtente().getStatus());

		
		acquirenteDTO.setIdacquirente(commento.getAcquirente().getIdacquirente());
		acquirenteDTO.setTelefono(commento.getAcquirente().getTelefono());
		acquirenteDTO.setIndirizzo(commento.getAcquirente().getIndirizzo());
		acquirenteDTO.setCitta(commento.getAcquirente().getCitta());
		acquirenteDTO.setCap(commento.getAcquirente().getCap());
		acquirenteDTO.setUtente(utenteDTO);
		
		commentoDTO.setAcquirente(acquirenteDTO);
		
		
	}
		commentoDTO.setIdcommento(commento.getIdcommento());
		commentoDTO.setTipo(commento.getTipo());
		commentoDTO.setVal(commento.getVal());
		commentoDTO.setDescrizione(commento.getDescrizione());
		commentoDTO.setData(commento.getData());

		commentoDTO.setAcquirente(acquirenteDTO);
		commentoDTO.setProposta(propostaDTO);

				
		return commentoDTO;
	}

	
	@DeleteMapping(
			
			value="/cancellabyidproposta/{id}"
			)
	
	public void cancellaCommentoByIdProposta(@PathVariable int id) {
		commentoService.deleteCommentoByIdProposta(id);
	}
	

}
