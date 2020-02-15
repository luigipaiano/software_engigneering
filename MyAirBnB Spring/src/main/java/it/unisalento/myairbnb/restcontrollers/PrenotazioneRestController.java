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

import it.unisalento.myairbnb.dto.AcquirenteDTO;
import it.unisalento.myairbnb.dto.BeneservizioDTO;
import it.unisalento.myairbnb.dto.PrenotazioneDTO;
import it.unisalento.myairbnb.dto.ProponenteDTO;
import it.unisalento.myairbnb.dto.PropostaDTO;
import it.unisalento.myairbnb.dto.UtenteDTO;
import it.unisalento.myairbnb.entities.Acquirente;
import it.unisalento.myairbnb.entities.Beneservizio;
import it.unisalento.myairbnb.entities.Prenotazione;
import it.unisalento.myairbnb.entities.Proponente;
import it.unisalento.myairbnb.entities.Proposta;
import it.unisalento.myairbnb.entities.Utente;
import it.unisalento.myairbnb.service.PrenotazioneService;

@RestController
@RequestMapping("/prenotazione")
public class PrenotazioneRestController {
	
	@Autowired
	PrenotazioneService prenotazioneService;
	
	@GetMapping(
			value = "/getAll",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List<PrenotazioneDTO> getAll() {
		
		List<Prenotazione> prenotazionelist = prenotazioneService.getAll();
		List<PrenotazioneDTO> dtoprenotazioneList = new ArrayList<PrenotazioneDTO>();
		
		for (Prenotazione prenotazione : prenotazionelist) {
			
			PrenotazioneDTO prenotazioneDTO = new PrenotazioneDTO();
			PropostaDTO propostaDTO = new PropostaDTO();
			BeneservizioDTO beneservizioDTO = new BeneservizioDTO();
			ProponenteDTO proponenteDTO = new ProponenteDTO();
			AcquirenteDTO acquirenteDTO = new AcquirenteDTO();
			UtenteDTO utenteDTO = new UtenteDTO();
			UtenteDTO utenteDTO2 = new UtenteDTO();

			
			
			utenteDTO2.setIdutente(prenotazione.getAcquirente().getUtente().getIdutente());
			utenteDTO2.setNome(prenotazione.getAcquirente().getUtente().getNome());
			utenteDTO2.setCognome(prenotazione.getAcquirente().getUtente().getCognome());
			utenteDTO2.setUsername(prenotazione.getAcquirente().getUtente().getUsername());
			utenteDTO2.setPassword(prenotazione.getAcquirente().getUtente().getPassword());
			utenteDTO2.setEmail(prenotazione.getAcquirente().getUtente().getEmail());
			utenteDTO2.setUltimologin(prenotazione.getAcquirente().getUtente().getUltimologin());
			utenteDTO2.setStatus(prenotazione.getAcquirente().getUtente().getStatus());
			
			
			acquirenteDTO.setIdacquirente(prenotazione.getAcquirente().getIdacquirente());
			acquirenteDTO.setTelefono(prenotazione.getAcquirente().getTelefono());
			acquirenteDTO.setIndirizzo(prenotazione.getAcquirente().getIndirizzo());
			acquirenteDTO.setCitta(prenotazione.getAcquirente().getCitta());
			acquirenteDTO.setCap(prenotazione.getAcquirente().getCap());
			acquirenteDTO.setUtente(utenteDTO2);
			
			
			utenteDTO.setIdutente(prenotazione.getProposta().getProponente().getUtente().getIdutente());
			utenteDTO.setNome(prenotazione.getProposta().getProponente().getUtente().getNome());
			utenteDTO.setCognome(prenotazione.getProposta().getProponente().getUtente().getCognome());
			utenteDTO.setUsername(prenotazione.getProposta().getProponente().getUtente().getUsername());
			utenteDTO.setPassword(prenotazione.getProposta().getProponente().getUtente().getPassword());
			utenteDTO.setEmail(prenotazione.getProposta().getProponente().getUtente().getEmail());
			utenteDTO.setUltimologin(prenotazione.getProposta().getProponente().getUtente().getUltimologin());
			utenteDTO.setStatus(prenotazione.getProposta().getProponente().getUtente().getStatus());

			
			proponenteDTO.setIdproponente(prenotazione.getProposta().getProponente().getIdproponente());
			proponenteDTO.setTelefono(prenotazione.getProposta().getProponente().getTelefono());
			proponenteDTO.setIndirizzo(prenotazione.getProposta().getProponente().getIndirizzo());
			proponenteDTO.setCitta(prenotazione.getProposta().getProponente().getCitta());
			proponenteDTO.setCap(prenotazione.getProposta().getProponente().getCap());
			proponenteDTO.setUtente(utenteDTO);
			
			
			beneservizioDTO.setIdbeneservizio(prenotazione.getProposta().getBeneservizio().getIdbeneservizio());
			beneservizioDTO.setCategoria(prenotazione.getProposta().getBeneservizio().getCategoria());
			beneservizioDTO.setDescrizione(prenotazione.getProposta().getBeneservizio().getDescrizione());
			
			propostaDTO.setIdproposta(prenotazione.getProposta().getIdproposta());
			propostaDTO.setNome(prenotazione.getProposta().getNome());
			propostaDTO.setDescrizione(prenotazione.getProposta().getDescrizione());
			propostaDTO.setDatainiziodisp(prenotazione.getProposta().getDatainiziodisp());
			propostaDTO.setDatafinedisp(prenotazione.getProposta().getDatafinedisp());
			propostaDTO.setDisponibilita(prenotazione.getProposta().getDisponibilita());
			propostaDTO.setCostounitario(prenotazione.getProposta().getCostounitario());
			propostaDTO.setPosizione(prenotazione.getProposta().getPosizione());
			propostaDTO.setStato(prenotazione.getProposta().getStato());
			propostaDTO.setDatacreamodpr(prenotazione.getProposta().getDatacreamodpr());
			propostaDTO.setIdproposta(prenotazione.getProposta().getIdproposta());

			propostaDTO.setBeneservizio(beneservizioDTO);
			propostaDTO.setProponente(proponenteDTO);
			
			prenotazioneDTO.setIdprenotazione(prenotazione.getIdprenotazione());
			prenotazioneDTO.setDatatransazione(prenotazione.getDatatransazione());
			prenotazioneDTO.setDatacheckin(prenotazione.getDatacheckin());
			prenotazioneDTO.setDatacheckout(prenotazione.getDatacheckout());
			prenotazioneDTO.setCostotot(prenotazione.getCostotot());
			
			prenotazioneDTO.setAcquirente(acquirenteDTO);
			prenotazioneDTO.setProposta(propostaDTO);
			
			
			dtoprenotazioneList.add(prenotazioneDTO);
			
		}
		
		return dtoprenotazioneList;

	}
	
	
	
	@GetMapping(
			value = "/getByIdAcquirente/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List<PrenotazioneDTO> getPrenotazionebyIdAcquirente(@PathVariable int id) {
		
		List<Prenotazione> prenotazionelist = prenotazioneService.getByIdAcquirente(id);
		List<PrenotazioneDTO> dtoprenotazioneList = new ArrayList<PrenotazioneDTO>();
		
		for (Prenotazione prenotazione : prenotazionelist) {
			
			PrenotazioneDTO prenotazioneDTO = new PrenotazioneDTO();
			PropostaDTO propostaDTO = new PropostaDTO();
			BeneservizioDTO beneservizioDTO = new BeneservizioDTO();
			ProponenteDTO proponenteDTO = new ProponenteDTO();
			AcquirenteDTO acquirenteDTO = new AcquirenteDTO();
			UtenteDTO utenteDTO = new UtenteDTO();
			UtenteDTO utenteDTO2 = new UtenteDTO();


			utenteDTO2.setIdutente(prenotazione.getAcquirente().getUtente().getIdutente());
			utenteDTO2.setNome(prenotazione.getAcquirente().getUtente().getNome());
			utenteDTO2.setCognome(prenotazione.getAcquirente().getUtente().getCognome());
			utenteDTO2.setUsername(prenotazione.getAcquirente().getUtente().getUsername());
			utenteDTO2.setPassword(prenotazione.getAcquirente().getUtente().getPassword());
			utenteDTO2.setEmail(prenotazione.getAcquirente().getUtente().getEmail());
			utenteDTO2.setUltimologin(prenotazione.getAcquirente().getUtente().getUltimologin());
			utenteDTO2.setStatus(prenotazione.getAcquirente().getUtente().getStatus());
			

			acquirenteDTO.setIdacquirente(prenotazione.getAcquirente().getIdacquirente());
			acquirenteDTO.setTelefono(prenotazione.getAcquirente().getTelefono());
			acquirenteDTO.setIndirizzo(prenotazione.getAcquirente().getIndirizzo());
			acquirenteDTO.setCitta(prenotazione.getAcquirente().getCitta());
			acquirenteDTO.setCap(prenotazione.getAcquirente().getCap());
			acquirenteDTO.setUtente(utenteDTO2);
			
			utenteDTO.setIdutente(prenotazione.getProposta().getProponente().getUtente().getIdutente());
			utenteDTO.setNome(prenotazione.getProposta().getProponente().getUtente().getNome());
			utenteDTO.setCognome(prenotazione.getProposta().getProponente().getUtente().getCognome());
			utenteDTO.setUsername(prenotazione.getProposta().getProponente().getUtente().getUsername());
			utenteDTO.setPassword(prenotazione.getProposta().getProponente().getUtente().getPassword());
			utenteDTO.setEmail(prenotazione.getProposta().getProponente().getUtente().getEmail());
			utenteDTO.setUltimologin(prenotazione.getProposta().getProponente().getUtente().getUltimologin());
			utenteDTO.setStatus(prenotazione.getProposta().getProponente().getUtente().getStatus());
			
			proponenteDTO.setIdproponente(prenotazione.getProposta().getProponente().getIdproponente());
			proponenteDTO.setTelefono(prenotazione.getProposta().getProponente().getTelefono());
			proponenteDTO.setIndirizzo(prenotazione.getProposta().getProponente().getIndirizzo());
			proponenteDTO.setCitta(prenotazione.getProposta().getProponente().getCitta());
			proponenteDTO.setCap(prenotazione.getProposta().getProponente().getCap());
			proponenteDTO.setUtente(utenteDTO);
			
			
			beneservizioDTO.setIdbeneservizio(prenotazione.getProposta().getBeneservizio().getIdbeneservizio());
			beneservizioDTO.setCategoria(prenotazione.getProposta().getBeneservizio().getCategoria());
			beneservizioDTO.setDescrizione(prenotazione.getProposta().getBeneservizio().getDescrizione());
			
			propostaDTO.setIdproposta(prenotazione.getProposta().getIdproposta());
			propostaDTO.setNome(prenotazione.getProposta().getNome());
			propostaDTO.setDescrizione(prenotazione.getProposta().getDescrizione());
			propostaDTO.setDatainiziodisp(prenotazione.getProposta().getDatainiziodisp());
			propostaDTO.setDatafinedisp(prenotazione.getProposta().getDatafinedisp());
			propostaDTO.setDisponibilita(prenotazione.getProposta().getDisponibilita());
			propostaDTO.setCostounitario(prenotazione.getProposta().getCostounitario());
			propostaDTO.setPosizione(prenotazione.getProposta().getPosizione());
			propostaDTO.setStato(prenotazione.getProposta().getStato());
			propostaDTO.setDatacreamodpr(prenotazione.getProposta().getDatacreamodpr());
			propostaDTO.setIdproposta(prenotazione.getProposta().getIdproposta());

			propostaDTO.setBeneservizio(beneservizioDTO);
			propostaDTO.setProponente(proponenteDTO);
			
			prenotazioneDTO.setIdprenotazione(prenotazione.getIdprenotazione());
			prenotazioneDTO.setDatatransazione(prenotazione.getDatatransazione());
			prenotazioneDTO.setDatacheckin(prenotazione.getDatacheckin());
			prenotazioneDTO.setDatacheckout(prenotazione.getDatacheckout());
			prenotazioneDTO.setCostotot(prenotazione.getCostotot());
			
			prenotazioneDTO.setAcquirente(acquirenteDTO);
			prenotazioneDTO.setProposta(propostaDTO);
			
			
			dtoprenotazioneList.add(prenotazioneDTO);
			
		}
		
		return dtoprenotazioneList;

	}
	
	@GetMapping(
			value = "/getByIdProposta/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List<PrenotazioneDTO> getPrenotazionebyIdProposta(@PathVariable int id) {
		
		List<Prenotazione> prenotazionelist = prenotazioneService.getByIdProposta(id);
		List<PrenotazioneDTO> dtoprenotazioneList = new ArrayList<PrenotazioneDTO>();
		
		for (Prenotazione prenotazione : prenotazionelist) {
			
			PrenotazioneDTO prenotazioneDTO = new PrenotazioneDTO();
			PropostaDTO propostaDTO = new PropostaDTO();
			BeneservizioDTO beneservizioDTO = new BeneservizioDTO();
			ProponenteDTO proponenteDTO = new ProponenteDTO();
			AcquirenteDTO acquirenteDTO = new AcquirenteDTO();
			UtenteDTO utenteDTO = new UtenteDTO();
			UtenteDTO utenteDTO2 = new UtenteDTO();

			utenteDTO2.setIdutente(prenotazione.getAcquirente().getUtente().getIdutente());
			utenteDTO2.setNome(prenotazione.getAcquirente().getUtente().getNome());
			utenteDTO2.setCognome(prenotazione.getAcquirente().getUtente().getCognome());
			utenteDTO2.setUsername(prenotazione.getAcquirente().getUtente().getUsername());
			utenteDTO2.setPassword(prenotazione.getAcquirente().getUtente().getPassword());
			utenteDTO2.setEmail(prenotazione.getAcquirente().getUtente().getEmail());
			utenteDTO2.setUltimologin(prenotazione.getAcquirente().getUtente().getUltimologin());
			utenteDTO2.setStatus(prenotazione.getAcquirente().getUtente().getStatus());
			
			
			acquirenteDTO.setIdacquirente(prenotazione.getAcquirente().getIdacquirente());
			acquirenteDTO.setTelefono(prenotazione.getAcquirente().getTelefono());
			acquirenteDTO.setIndirizzo(prenotazione.getAcquirente().getIndirizzo());
			acquirenteDTO.setCitta(prenotazione.getAcquirente().getCitta());
			acquirenteDTO.setCap(prenotazione.getAcquirente().getCap());
			acquirenteDTO.setUtente(utenteDTO2);
			
	
			
			utenteDTO.setIdutente(prenotazione.getProposta().getProponente().getUtente().getIdutente());
			utenteDTO.setNome(prenotazione.getProposta().getProponente().getUtente().getNome());
			utenteDTO.setCognome(prenotazione.getProposta().getProponente().getUtente().getCognome());
			utenteDTO.setUsername(prenotazione.getProposta().getProponente().getUtente().getUsername());
			utenteDTO.setPassword(prenotazione.getProposta().getProponente().getUtente().getPassword());
			utenteDTO.setEmail(prenotazione.getProposta().getProponente().getUtente().getEmail());
			utenteDTO.setUltimologin(prenotazione.getProposta().getProponente().getUtente().getUltimologin());
			utenteDTO.setStatus(prenotazione.getProposta().getProponente().getUtente().getStatus());

			
			proponenteDTO.setIdproponente(prenotazione.getProposta().getProponente().getIdproponente());
			proponenteDTO.setTelefono(prenotazione.getProposta().getProponente().getTelefono());
			proponenteDTO.setIndirizzo(prenotazione.getProposta().getProponente().getIndirizzo());
			proponenteDTO.setCitta(prenotazione.getProposta().getProponente().getCitta());
			proponenteDTO.setCap(prenotazione.getProposta().getProponente().getCap());
			proponenteDTO.setUtente(utenteDTO);
			
			
			beneservizioDTO.setIdbeneservizio(prenotazione.getProposta().getBeneservizio().getIdbeneservizio());
			beneservizioDTO.setCategoria(prenotazione.getProposta().getBeneservizio().getCategoria());
			beneservizioDTO.setDescrizione(prenotazione.getProposta().getBeneservizio().getDescrizione());
			
			propostaDTO.setIdproposta(prenotazione.getProposta().getIdproposta());
			propostaDTO.setNome(prenotazione.getProposta().getNome());
			propostaDTO.setDescrizione(prenotazione.getProposta().getDescrizione());
			propostaDTO.setDatainiziodisp(prenotazione.getProposta().getDatainiziodisp());
			propostaDTO.setDatafinedisp(prenotazione.getProposta().getDatafinedisp());
			propostaDTO.setDisponibilita(prenotazione.getProposta().getDisponibilita());
			propostaDTO.setCostounitario(prenotazione.getProposta().getCostounitario());
			propostaDTO.setPosizione(prenotazione.getProposta().getPosizione());
			propostaDTO.setStato(prenotazione.getProposta().getStato());
			propostaDTO.setDatacreamodpr(prenotazione.getProposta().getDatacreamodpr());
			propostaDTO.setIdproposta(prenotazione.getProposta().getIdproposta());

			propostaDTO.setBeneservizio(beneservizioDTO);
			propostaDTO.setProponente(proponenteDTO);
			
			prenotazioneDTO.setIdprenotazione(prenotazione.getIdprenotazione());
			prenotazioneDTO.setDatatransazione(prenotazione.getDatatransazione());
			prenotazioneDTO.setDatacheckin(prenotazione.getDatacheckin());
			prenotazioneDTO.setDatacheckout(prenotazione.getDatacheckout());
			prenotazioneDTO.setCostotot(prenotazione.getCostotot());
			
			prenotazioneDTO.setAcquirente(acquirenteDTO);
			prenotazioneDTO.setProposta(propostaDTO);
			
			
			dtoprenotazioneList.add(prenotazioneDTO);
			
		}
		
		return dtoprenotazioneList;

	}
	
	
	@PostMapping(
			
			value = "/save",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	
	public Prenotazione post(@RequestBody @Valid PrenotazioneDTO prenotazioneDTO) {
		
		
		Prenotazione prenotazione = new Prenotazione();
		Proposta proposta = new Proposta();
		Beneservizio beneservizio = new Beneservizio();
		Proponente proponente = new Proponente();
		Acquirente acquirente = new Acquirente();
		Utente utente = new Utente();
		Utente utente2 = new Utente();

		utente.setNome(prenotazioneDTO.getProposta().getProponente().getUtente().getNome());
		utente.setCognome(prenotazioneDTO.getProposta().getProponente().getUtente().getCognome());
		utente.setUsername(prenotazioneDTO.getProposta().getProponente().getUtente().getUsername());
		utente.setPassword(prenotazioneDTO.getProposta().getProponente().getUtente().getPassword());
		utente.setEmail(prenotazioneDTO.getProposta().getProponente().getUtente().getEmail());
		
		Timestamp ts = new Timestamp(prenotazioneDTO.getProposta().getProponente().getUtente().getUltimologin().getTime());
		utente.setUltimologin(ts);
		utente.setStatus(prenotazioneDTO.getProposta().getProponente().getUtente().getStatus());
		
		proponente.setTelefono(prenotazioneDTO.getProposta().getProponente().getTelefono());
		proponente.setIndirizzo(prenotazioneDTO.getProposta().getProponente().getIndirizzo());
		proponente.setCitta(prenotazioneDTO.getProposta().getProponente().getCitta());
		proponente.setCap(prenotazioneDTO.getProposta().getProponente().getCap());
		proponente.setUtente(utente);
		

		utente2.setNome(prenotazioneDTO.getProposta().getProponente().getUtente().getNome());
		utente2.setCognome(prenotazioneDTO.getProposta().getProponente().getUtente().getCognome());
		utente2.setUsername(prenotazioneDTO.getProposta().getProponente().getUtente().getUsername());
		utente2.setPassword(prenotazioneDTO.getProposta().getProponente().getUtente().getPassword());
		utente2.setEmail(prenotazioneDTO.getProposta().getProponente().getUtente().getEmail());
		Timestamp ts2 = new Timestamp(prenotazioneDTO.getProposta().getProponente().getUtente().getUltimologin().getTime());
		utente2.setUltimologin(ts2);
		utente2.setStatus(prenotazioneDTO.getProposta().getProponente().getUtente().getStatus());

		
		acquirente.setTelefono(prenotazioneDTO.getAcquirente().getTelefono());
		acquirente.setIdacquirente(prenotazioneDTO.getAcquirente().getIdacquirente());
		acquirente.setIndirizzo(prenotazioneDTO.getAcquirente().getIndirizzo());
		acquirente.setCitta(prenotazioneDTO.getAcquirente().getCitta());
		acquirente.setCap(prenotazioneDTO.getAcquirente().getCap());
		acquirente.setUtente(utente2);
		
		
		beneservizio.setCategoria(prenotazioneDTO.getProposta().getBeneservizio().getCategoria());
		beneservizio.setDescrizione(prenotazioneDTO.getProposta().getBeneservizio().getDescrizione());
		
		proposta.setNome(prenotazioneDTO.getProposta().getNome());
		proposta.setDescrizione(prenotazioneDTO.getProposta().getDescrizione());
		
		Timestamp ts3 = new Timestamp(prenotazioneDTO.getProposta().getDatainiziodisp().getTime());
		proposta.setDatainiziodisp(ts3);
		
		Timestamp ts4 = new Timestamp(prenotazioneDTO.getProposta().getDatafinedisp().getTime());
		proposta.setDatafinedisp(ts4);
		
		proposta.setDisponibilita(prenotazioneDTO.getProposta().getDisponibilita());
		proposta.setCostounitario(prenotazioneDTO.getProposta().getCostounitario());
		proposta.setPosizione(prenotazioneDTO.getProposta().getPosizione());
		proposta.setStato(prenotazioneDTO.getProposta().getStato());
		proposta.setIdproposta(prenotazioneDTO.getProposta().getIdproposta());
		
		Timestamp ts5 = new Timestamp(prenotazioneDTO.getProposta().getDatacreamodpr().getTime());
		proposta.setDatacreamodpr(ts5);
		
		proposta.setBeneservizio(beneservizio);
		proposta.setProponente(proponente);
		
		Timestamp ts6 = new Timestamp(prenotazioneDTO.getDatatransazione().getTime());
		prenotazione.setDatatransazione(ts6);
		
		Timestamp ts7 = new Timestamp(prenotazioneDTO.getDatacheckin().getTime());
		prenotazione.setDatacheckin(ts7);
		
		Timestamp ts8 = new Timestamp(prenotazioneDTO.getDatacheckout().getTime());
		prenotazione.setDatacheckout(ts8);
		
		prenotazione.setCostotot(prenotazioneDTO.getCostotot());
		
		prenotazione.setAcquirente(acquirente);
		prenotazione.setProposta(proposta);

				
		return prenotazioneService.saveorUpdate(prenotazione);
		
	}
	
	
	@PutMapping(
			
			value="/update",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
			
			)
	
	public Prenotazione update(@RequestBody @Valid PrenotazioneDTO prenotazioneDTO) {
		
		Prenotazione prenotazione = new Prenotazione();
		Proposta proposta = new Proposta();
		Beneservizio beneservizio = new Beneservizio();
		Proponente proponente = new Proponente();
		Acquirente acquirente = new Acquirente();
		Utente utente = new Utente();
		Utente utente2 = new Utente();

		utente.setNome(prenotazioneDTO.getProposta().getProponente().getUtente().getNome());
		utente.setCognome(prenotazioneDTO.getProposta().getProponente().getUtente().getCognome());
		utente.setUsername(prenotazioneDTO.getProposta().getProponente().getUtente().getUsername());
		utente.setPassword(prenotazioneDTO.getProposta().getProponente().getUtente().getPassword());
		utente.setEmail(prenotazioneDTO.getProposta().getProponente().getUtente().getEmail());
		
		Timestamp ts = new Timestamp(prenotazioneDTO.getProposta().getProponente().getUtente().getUltimologin().getTime());
		utente.setUltimologin(ts);
		utente.setStatus(prenotazioneDTO.getProposta().getProponente().getUtente().getStatus());
		
		
		proponente.setTelefono(prenotazioneDTO.getProposta().getProponente().getTelefono());
		proponente.setIndirizzo(prenotazioneDTO.getProposta().getProponente().getIndirizzo());
		proponente.setCitta(prenotazioneDTO.getProposta().getProponente().getCitta());
		proponente.setCap(prenotazioneDTO.getProposta().getProponente().getCap());
		proponente.setUtente(utente);
		

		utente2.setNome(prenotazioneDTO.getProposta().getProponente().getUtente().getNome());
		utente2.setCognome(prenotazioneDTO.getProposta().getProponente().getUtente().getCognome());
		utente2.setUsername(prenotazioneDTO.getProposta().getProponente().getUtente().getUsername());
		utente2.setPassword(prenotazioneDTO.getProposta().getProponente().getUtente().getPassword());
		utente2.setEmail(prenotazioneDTO.getProposta().getProponente().getUtente().getEmail());
		Timestamp ts2 = new Timestamp(prenotazioneDTO.getProposta().getProponente().getUtente().getUltimologin().getTime());
		utente2.setUltimologin(ts2);
		utente2.setStatus(prenotazioneDTO.getProposta().getProponente().getUtente().getStatus());

		
		
		acquirente.setTelefono(prenotazioneDTO.getAcquirente().getTelefono());
		acquirente.setIndirizzo(prenotazioneDTO.getAcquirente().getIndirizzo());
		acquirente.setCitta(prenotazioneDTO.getAcquirente().getCitta());
		acquirente.setCap(prenotazioneDTO.getAcquirente().getCap());
		acquirente.setUtente(utente2);
		
		
		beneservizio.setCategoria(prenotazioneDTO.getProposta().getBeneservizio().getCategoria());
		beneservizio.setDescrizione(prenotazioneDTO.getProposta().getBeneservizio().getDescrizione());
		
		proposta.setNome(prenotazioneDTO.getProposta().getNome());
		proposta.setDescrizione(prenotazioneDTO.getProposta().getDescrizione());
		
		Timestamp ts3 = new Timestamp(prenotazioneDTO.getProposta().getDatainiziodisp().getTime());
		proposta.setDatainiziodisp(ts3);
		
		Timestamp ts4 = new Timestamp(prenotazioneDTO.getProposta().getDatafinedisp().getTime());
		proposta.setDatafinedisp(ts4);
		
		proposta.setDisponibilita(prenotazioneDTO.getProposta().getDisponibilita());
		proposta.setCostounitario(prenotazioneDTO.getProposta().getCostounitario());
		proposta.setPosizione(prenotazioneDTO.getProposta().getPosizione());
		proposta.setStato(prenotazioneDTO.getProposta().getStato());
		
		Timestamp ts5 = new Timestamp(prenotazioneDTO.getProposta().getDatacreamodpr().getTime());
		proposta.setDatacreamodpr(ts5);
		
		proposta.setBeneservizio(beneservizio);
		proposta.setProponente(proponente);
		
		Timestamp ts6 = new Timestamp(prenotazioneDTO.getDatatransazione().getTime());
		prenotazione.setDatatransazione(ts6);
		
		Timestamp ts7 = new Timestamp(prenotazioneDTO.getDatacheckin().getTime());
		prenotazione.setDatacheckin(ts7);
		
		Timestamp ts8 = new Timestamp(prenotazioneDTO.getDatacheckout().getTime());
		prenotazione.setDatacheckout(ts8);
		
		prenotazione.setCostotot(prenotazioneDTO.getCostotot());
		
		prenotazione.setAcquirente(acquirente);
		prenotazione.setProposta(proposta);

		
		return prenotazioneService.saveorUpdate(prenotazione);
	
	}
	
	@DeleteMapping(
			
			value="/delete/{id}"
			)
	
	public void delete(@PathVariable int id) {
		prenotazioneService.delete(id);
	}
	
	
	

	@GetMapping( value="/getByIdPrenotazione/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	
	public PrenotazioneDTO get(@PathVariable int id) {
		
		PrenotazioneDTO prenotazioneDTO = new PrenotazioneDTO();
		PropostaDTO propostaDTO = new PropostaDTO();
		BeneservizioDTO beneservizioDTO = new BeneservizioDTO();
		ProponenteDTO proponenteDTO = new ProponenteDTO();
		AcquirenteDTO acquirenteDTO = new AcquirenteDTO();
		UtenteDTO utenteDTO = new UtenteDTO();
		UtenteDTO utenteDTO2 = new UtenteDTO();

		
		Prenotazione prenotazione =  prenotazioneService.getById(id);
		
		
		utenteDTO2.setIdutente(prenotazione.getAcquirente().getUtente().getIdutente());
		utenteDTO2.setNome(prenotazione.getAcquirente().getUtente().getNome());
		utenteDTO2.setCognome(prenotazione.getAcquirente().getUtente().getCognome());
		utenteDTO2.setUsername(prenotazione.getAcquirente().getUtente().getUsername());
		utenteDTO2.setPassword(prenotazione.getAcquirente().getUtente().getPassword());
		utenteDTO2.setEmail(prenotazione.getAcquirente().getUtente().getEmail());
		utenteDTO2.setUltimologin(prenotazione.getAcquirente().getUtente().getUltimologin());
		utenteDTO2.setStatus(prenotazione.getAcquirente().getUtente().getStatus());
		
		acquirenteDTO.setIdacquirente(prenotazione.getAcquirente().getIdacquirente());
		acquirenteDTO.setTelefono(prenotazione.getAcquirente().getTelefono());
		acquirenteDTO.setIndirizzo(prenotazione.getAcquirente().getIndirizzo());
		acquirenteDTO.setCitta(prenotazione.getAcquirente().getCitta());
		acquirenteDTO.setCap(prenotazione.getAcquirente().getCap());
		acquirenteDTO.setUtente(utenteDTO2);
		
		
		utenteDTO.setIdutente(prenotazione.getProposta().getProponente().getUtente().getIdutente());
		utenteDTO.setNome(prenotazione.getProposta().getProponente().getUtente().getNome());
		utenteDTO.setCognome(prenotazione.getProposta().getProponente().getUtente().getCognome());
		utenteDTO.setUsername(prenotazione.getProposta().getProponente().getUtente().getUsername());
		utenteDTO.setPassword(prenotazione.getProposta().getProponente().getUtente().getPassword());
		utenteDTO.setEmail(prenotazione.getProposta().getProponente().getUtente().getEmail());
		utenteDTO.setUltimologin(prenotazione.getProposta().getProponente().getUtente().getUltimologin());
		utenteDTO.setStatus(prenotazione.getProposta().getProponente().getUtente().getStatus());
		
		
		proponenteDTO.setIdproponente(prenotazione.getProposta().getProponente().getIdproponente());
		proponenteDTO.setTelefono(prenotazione.getProposta().getProponente().getTelefono());
		proponenteDTO.setIndirizzo(prenotazione.getProposta().getProponente().getIndirizzo());
		proponenteDTO.setCitta(prenotazione.getProposta().getProponente().getCitta());
		proponenteDTO.setCap(prenotazione.getProposta().getProponente().getCap());
		proponenteDTO.setUtente(utenteDTO);
		
		
		beneservizioDTO.setIdbeneservizio(prenotazione.getProposta().getBeneservizio().getIdbeneservizio());
		beneservizioDTO.setCategoria(prenotazione.getProposta().getBeneservizio().getCategoria());
		beneservizioDTO.setDescrizione(prenotazione.getProposta().getBeneservizio().getDescrizione());
		
		propostaDTO.setIdproposta(prenotazione.getProposta().getIdproposta());
		propostaDTO.setNome(prenotazione.getProposta().getNome());
		propostaDTO.setDescrizione(prenotazione.getProposta().getDescrizione());
		propostaDTO.setDatainiziodisp(prenotazione.getProposta().getDatainiziodisp());
		propostaDTO.setDatafinedisp(prenotazione.getProposta().getDatafinedisp());
		propostaDTO.setDisponibilita(prenotazione.getProposta().getDisponibilita());
		propostaDTO.setCostounitario(prenotazione.getProposta().getCostounitario());
		propostaDTO.setPosizione(prenotazione.getProposta().getPosizione());
		propostaDTO.setStato(prenotazione.getProposta().getStato());
		propostaDTO.setDatacreamodpr(prenotazione.getProposta().getDatacreamodpr());
		propostaDTO.setIdproposta(prenotazione.getProposta().getIdproposta());

		propostaDTO.setBeneservizio(beneservizioDTO);
		propostaDTO.setProponente(proponenteDTO);
		
		prenotazioneDTO.setIdprenotazione(prenotazione.getIdprenotazione());
		prenotazioneDTO.setDatatransazione(prenotazione.getDatatransazione());
		prenotazioneDTO.setDatacheckin(prenotazione.getDatacheckin());
		prenotazioneDTO.setDatacheckout(prenotazione.getDatacheckout());
		prenotazioneDTO.setCostotot(prenotazione.getCostotot());
		
		prenotazioneDTO.setAcquirente(acquirenteDTO);
		prenotazioneDTO.setProposta(propostaDTO);
		
		
		return prenotazioneDTO;

	
	}
	
}