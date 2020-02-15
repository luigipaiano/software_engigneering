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
import it.unisalento.myairbnb.dto.BeneservizioDTO;
import it.unisalento.myairbnb.dto.PagamentoDTO;
import it.unisalento.myairbnb.dto.PrenotazioneDTO;
import it.unisalento.myairbnb.dto.ProponenteDTO;
import it.unisalento.myairbnb.dto.PropostaDTO;
import it.unisalento.myairbnb.dto.UtenteDTO;
import it.unisalento.myairbnb.entities.Acquirente;
import it.unisalento.myairbnb.entities.Beneservizio;
import it.unisalento.myairbnb.entities.Pagamento;
import it.unisalento.myairbnb.entities.Prenotazione;
import it.unisalento.myairbnb.entities.Proponente;
import it.unisalento.myairbnb.entities.Proposta;
import it.unisalento.myairbnb.entities.Utente;
import it.unisalento.myairbnb.service.PagamentoService;

@RestController
@RequestMapping("/pagamento")
public class PagamentoRestController {
	
	
	@Autowired
	PagamentoService pagamentoService;

	@PostMapping(
			
			value = "/save",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	
	public Pagamento post(@RequestBody @Valid PagamentoDTO pagamentoDTO) {
		
		Pagamento pagamento = new Pagamento();
		Utente utente = new Utente();
		Acquirente acquirente = new Acquirente();

		Prenotazione prenotazione = new Prenotazione();
		Proposta proposta = new Proposta();
		Proponente proponente = new Proponente();
		Utente utente2 = new Utente();
		Beneservizio beneservizio = new Beneservizio();
		Acquirente acquirente2 = new Acquirente();
		Utente utente3 = new Utente();
		
		pagamento.setMetodo(pagamentoDTO.getMetodo());
		pagamento.setImporto(pagamento.getImporto());
		pagamento.setDatatransazione(pagamento.getDatatransazione());

		
		utente.setNome(pagamentoDTO.getAcquirente().getUtente().getNome());
		utente.setCognome(pagamentoDTO.getAcquirente().getUtente().getCognome());
		utente.setUsername(pagamentoDTO.getAcquirente().getUtente().getUsername());
		utente.setPassword(pagamentoDTO.getAcquirente().getUtente().getPassword());
		utente.setEmail(pagamentoDTO.getAcquirente().getUtente().getEmail());
		Timestamp ts = new Timestamp(pagamentoDTO.getAcquirente().getUtente().getUltimologin().getTime());
		utente.setUltimologin(ts);
		utente.setStatus(pagamentoDTO.getAcquirente().getUtente().getStatus());
	
		acquirente.setTelefono(pagamentoDTO.getAcquirente().getTelefono());
		acquirente.setIndirizzo(pagamentoDTO.getAcquirente().getIndirizzo());
		acquirente.setCitta(pagamentoDTO.getAcquirente().getCitta());
		acquirente.setCap(pagamentoDTO.getAcquirente().getCap());
		acquirente.setUtente(utente);
		acquirente.setIdacquirente(pagamentoDTO.getAcquirente().getIdacquirente());
		
		
		utente2.setNome(pagamentoDTO.getPrenotazione().getProposta().getProponente().getUtente().getNome());
		utente2.setCognome(pagamentoDTO.getPrenotazione().getProposta().getProponente().getUtente().getCognome());
		utente2.setUsername(pagamentoDTO.getPrenotazione().getProposta().getProponente().getUtente().getUsername());
		utente2.setPassword(pagamentoDTO.getPrenotazione().getProposta().getProponente().getUtente().getPassword());
		utente2.setEmail(pagamentoDTO.getPrenotazione().getProposta().getProponente().getUtente().getEmail());
		
		Timestamp ts9 = new Timestamp(pagamentoDTO.getPrenotazione().getProposta().getProponente().getUtente().getUltimologin().getTime());
		utente2.setUltimologin(ts9);
		utente2.setStatus(pagamentoDTO.getPrenotazione().getProposta().getProponente().getUtente().getStatus());

		acquirente2.setTelefono(pagamentoDTO.getPrenotazione().getAcquirente().getTelefono());
		acquirente2.setIndirizzo(pagamentoDTO.getPrenotazione().getAcquirente().getIndirizzo());
		acquirente2.setCitta(pagamentoDTO.getPrenotazione().getAcquirente().getCitta());
		acquirente2.setCap(pagamentoDTO.getPrenotazione().getAcquirente().getCap());
		acquirente2.setUtente(utente2);
		acquirente2.setIdacquirente(pagamentoDTO.getPrenotazione().getAcquirente().getIdacquirente());

		
		utente3.setNome(pagamentoDTO.getPrenotazione().getProposta().getProponente().getUtente().getNome());
		utente3.setCognome(pagamentoDTO.getPrenotazione().getProposta().getProponente().getUtente().getCognome());
		utente3.setUsername(pagamentoDTO.getPrenotazione().getProposta().getProponente().getUtente().getUsername());
		utente3.setPassword(pagamentoDTO.getPrenotazione().getProposta().getProponente().getUtente().getPassword());
		utente3.setEmail(pagamentoDTO.getPrenotazione().getProposta().getProponente().getUtente().getEmail());
		Timestamp ts2 = new Timestamp(pagamentoDTO.getPrenotazione().getProposta().getProponente().getUtente().getUltimologin().getTime());
		utente3.setUltimologin(ts2);
		utente3.setStatus(pagamentoDTO.getPrenotazione().getProposta().getProponente().getUtente().getStatus());

		proponente.setTelefono(pagamentoDTO.getPrenotazione().getProposta().getProponente().getTelefono());
		proponente.setIndirizzo(pagamentoDTO.getPrenotazione().getProposta().getProponente().getIndirizzo());
		proponente.setCitta(pagamentoDTO.getPrenotazione().getProposta().getProponente().getCitta());
		proponente.setCap(pagamentoDTO.getPrenotazione().getProposta().getProponente().getCap());
		proponente.setUtente(utente3);
		proponente.setIdproponente(pagamentoDTO.getPrenotazione().getProposta().getProponente().getIdproponente());

		
		beneservizio.setCategoria(pagamentoDTO.getPrenotazione().getProposta().getBeneservizio().getCategoria());
		beneservizio.setDescrizione(pagamentoDTO.getPrenotazione().getProposta().getBeneservizio().getDescrizione());
		
		proposta.setNome(pagamentoDTO.getPrenotazione().getProposta().getNome());
		proposta.setDescrizione(pagamentoDTO.getPrenotazione().getProposta().getDescrizione());
		
		Timestamp ts3 = new Timestamp(pagamentoDTO.getPrenotazione().getProposta().getDatainiziodisp().getTime());
		proposta.setDatainiziodisp(ts3);
		
		Timestamp ts4 = new Timestamp(pagamentoDTO.getPrenotazione().getProposta().getDatafinedisp().getTime());
		proposta.setDatafinedisp(ts4);
		
		proposta.setDisponibilita(pagamentoDTO.getPrenotazione().getProposta().getDisponibilita());
		proposta.setCostounitario(pagamentoDTO.getPrenotazione().getProposta().getCostounitario());
		proposta.setPosizione(pagamentoDTO.getPrenotazione().getProposta().getPosizione());
		proposta.setStato(pagamentoDTO.getPrenotazione().getProposta().getStato());
		
		Timestamp ts5 = new Timestamp(pagamentoDTO.getPrenotazione().getProposta().getDatacreamodpr().getTime());
		proposta.setDatacreamodpr(ts5);
		
		proposta.setBeneservizio(beneservizio);
		proposta.setProponente(proponente);
		
		Timestamp ts6 = new Timestamp(pagamentoDTO.getPrenotazione().getDatatransazione().getTime());
		prenotazione.setDatatransazione(ts6);
		
		Timestamp ts7 = new Timestamp(pagamentoDTO.getPrenotazione().getDatacheckin().getTime());
		prenotazione.setDatacheckin(ts7);
		
		Timestamp ts8 = new Timestamp(pagamentoDTO.getPrenotazione().getDatacheckout().getTime());
		prenotazione.setDatacheckout(ts8);
		
		prenotazione.setCostotot(pagamentoDTO.getPrenotazione().getCostotot());
		
		prenotazione.setAcquirente(acquirente2);
		prenotazione.setProposta(proposta);
		prenotazione.setIdprenotazione(pagamentoDTO.getPrenotazione().getIdprenotazione());
				
		pagamento.setAcquirente(acquirente);
		pagamento.setPrenotazione(prenotazione);

		
		
		return pagamentoService.saveorUpdate(pagamento);
		
	}
	
	
	@GetMapping(
			value = "/getAll",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List<PagamentoDTO> getAll() {
		
		List<Pagamento> pagamentolist = pagamentoService.getAll();
		List<PagamentoDTO> dtopagamentoList = new ArrayList<PagamentoDTO>();
		
		for (Pagamento pagamento : pagamentolist) {
			
			PagamentoDTO pagamentoDTO = new PagamentoDTO();
			AcquirenteDTO acquirenteDTO = new AcquirenteDTO();
			UtenteDTO utenteDTO = new UtenteDTO();
			
			PrenotazioneDTO prenotazioneDTO = new PrenotazioneDTO();
			PropostaDTO propostaDTO = new PropostaDTO();
			BeneservizioDTO beneservizioDTO = new BeneservizioDTO();
			ProponenteDTO proponenteDTO = new ProponenteDTO();
			AcquirenteDTO acquirenteDTO2 = new AcquirenteDTO();
			UtenteDTO utenteDTO2 = new UtenteDTO();
			UtenteDTO utenteDTO3 = new UtenteDTO();
			
			
			utenteDTO.setIdutente(pagamento.getAcquirente().getUtente().getIdutente());
			utenteDTO.setNome(pagamento.getAcquirente().getUtente().getNome());
			utenteDTO.setCognome(pagamento.getAcquirente().getUtente().getCognome());
			utenteDTO.setUsername(pagamento.getAcquirente().getUtente().getUsername());
			utenteDTO.setPassword(pagamento.getAcquirente().getUtente().getPassword());
			utenteDTO.setEmail(pagamento.getAcquirente().getUtente().getEmail());
			utenteDTO.setUltimologin(pagamento.getAcquirente().getUtente().getUltimologin());
			utenteDTO.setStatus(pagamento.getAcquirente().getUtente().getStatus());

			acquirenteDTO.setIdacquirente(pagamento.getAcquirente().getIdacquirente());
			acquirenteDTO.setTelefono(pagamento.getAcquirente().getTelefono());
			acquirenteDTO.setIndirizzo(pagamento.getAcquirente().getIndirizzo());
			acquirenteDTO.setCitta(pagamento.getAcquirente().getCitta());
			acquirenteDTO.setCap(pagamento.getAcquirente().getCap());
			acquirenteDTO.setUtente(utenteDTO);
			
			pagamentoDTO.setIdpagamento(pagamento.getIdpagamento());
			pagamentoDTO.setMetodo(pagamento.getMetodo());
			pagamentoDTO.setImporto(pagamento.getImporto().doubleValue());
			pagamentoDTO.setDatatransazione(pagamento.getDatatransazione());
			
			utenteDTO2.setIdutente(pagamento.getPrenotazione().getProposta().getProponente().getUtente().getIdutente());
			utenteDTO2.setNome(pagamento.getPrenotazione().getProposta().getProponente().getUtente().getNome());
			utenteDTO2.setCognome(pagamento.getPrenotazione().getProposta().getProponente().getUtente().getCognome());
			utenteDTO2.setUsername(pagamento.getPrenotazione().getProposta().getProponente().getUtente().getUsername());
			utenteDTO2.setPassword(pagamento.getPrenotazione().getProposta().getProponente().getUtente().getPassword());
			utenteDTO2.setEmail(pagamento.getPrenotazione().getProposta().getProponente().getUtente().getEmail());
			utenteDTO2.setUltimologin(pagamento.getPrenotazione().getProposta().getProponente().getUtente().getUltimologin());
			utenteDTO2.setStatus(pagamento.getPrenotazione().getProposta().getProponente().getUtente().getStatus());

			acquirenteDTO2.setIdacquirente(pagamento.getPrenotazione().getAcquirente().getIdacquirente());
			acquirenteDTO2.setTelefono(pagamento.getPrenotazione().getAcquirente().getTelefono());
			acquirenteDTO2.setIndirizzo(pagamento.getPrenotazione().getAcquirente().getIndirizzo());
			acquirenteDTO2.setCitta(pagamento.getPrenotazione().getAcquirente().getCitta());
			acquirenteDTO2.setCap(pagamento.getPrenotazione().getAcquirente().getCap());
			acquirenteDTO2.setUtente(utenteDTO2);
			
			utenteDTO3.setIdutente(pagamento.getPrenotazione().getAcquirente().getUtente().getIdutente());
			utenteDTO3.setNome(pagamento.getPrenotazione().getAcquirente().getUtente().getNome());
			utenteDTO3.setCognome(pagamento.getPrenotazione().getAcquirente().getUtente().getCognome());
			utenteDTO3.setUsername(pagamento.getPrenotazione().getAcquirente().getUtente().getUsername());
			utenteDTO3.setPassword(pagamento.getPrenotazione().getAcquirente().getUtente().getPassword());
			utenteDTO3.setEmail(pagamento.getPrenotazione().getAcquirente().getUtente().getEmail());
			utenteDTO3.setUltimologin(pagamento.getPrenotazione().getAcquirente().getUtente().getUltimologin());
			utenteDTO3.setStatus(pagamento.getPrenotazione().getAcquirente().getUtente().getStatus());
			
			proponenteDTO.setIdproponente(pagamento.getPrenotazione().getProposta().getProponente().getIdproponente());
			proponenteDTO.setTelefono(pagamento.getPrenotazione().getProposta().getProponente().getTelefono());
			proponenteDTO.setIndirizzo(pagamento.getPrenotazione().getProposta().getProponente().getIndirizzo());
			proponenteDTO.setCitta(pagamento.getPrenotazione().getProposta().getProponente().getCitta());
			proponenteDTO.setCap(pagamento.getPrenotazione().getProposta().getProponente().getCap());
			proponenteDTO.setUtente(utenteDTO3);
			
			
			beneservizioDTO.setIdbeneservizio(pagamento.getPrenotazione().getProposta().getBeneservizio().getIdbeneservizio());
			beneservizioDTO.setCategoria(pagamento.getPrenotazione().getProposta().getBeneservizio().getCategoria());
			beneservizioDTO.setDescrizione(pagamento.getPrenotazione().getProposta().getBeneservizio().getDescrizione());
			
			propostaDTO.setIdproposta(pagamento.getPrenotazione().getProposta().getIdproposta());
			propostaDTO.setNome(pagamento.getPrenotazione().getProposta().getNome());
			propostaDTO.setDescrizione(pagamento.getPrenotazione().getProposta().getDescrizione());
			propostaDTO.setDatainiziodisp(pagamento.getPrenotazione().getProposta().getDatainiziodisp());
			propostaDTO.setDatafinedisp(pagamento.getPrenotazione().getProposta().getDatafinedisp());
			propostaDTO.setDisponibilita(pagamento.getPrenotazione().getProposta().getDisponibilita());
			propostaDTO.setCostounitario(pagamento.getPrenotazione().getProposta().getCostounitario());
			propostaDTO.setPosizione(pagamento.getPrenotazione().getProposta().getPosizione());
			propostaDTO.setStato(pagamento.getPrenotazione().getProposta().getStato());
			propostaDTO.setDatacreamodpr(pagamento.getPrenotazione().getProposta().getDatacreamodpr());
			propostaDTO.setIdproposta(pagamento.getPrenotazione().getProposta().getIdproposta());

			propostaDTO.setBeneservizio(beneservizioDTO);
			propostaDTO.setProponente(proponenteDTO);
			
			prenotazioneDTO.setIdprenotazione(pagamento.getPrenotazione().getIdprenotazione());
			prenotazioneDTO.setDatatransazione(pagamento.getPrenotazione().getDatatransazione());
			prenotazioneDTO.setDatacheckin(pagamento.getPrenotazione().getDatacheckin());
			prenotazioneDTO.setDatacheckout(pagamento.getPrenotazione().getDatacheckout());
			prenotazioneDTO.setCostotot(pagamento.getPrenotazione().getCostotot());
			
			prenotazioneDTO.setAcquirente(acquirenteDTO2);
			prenotazioneDTO.setProposta(propostaDTO);
			
			pagamentoDTO.setAcquirente(acquirenteDTO);
			pagamentoDTO.setPrenotazione(prenotazioneDTO);
			
			dtopagamentoList.add(pagamentoDTO);
			
		}
		
		return dtopagamentoList;

	}
	
	

	@GetMapping( value="/getByIdPagamento/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	
	public PagamentoDTO get(@PathVariable int id) {
		
		PagamentoDTO pagamentoDTO = new PagamentoDTO();
		AcquirenteDTO acquirenteDTO = new AcquirenteDTO();
		UtenteDTO utenteDTO = new UtenteDTO();
		
		PrenotazioneDTO prenotazioneDTO = new PrenotazioneDTO();
		PropostaDTO propostaDTO = new PropostaDTO();
		BeneservizioDTO beneservizioDTO = new BeneservizioDTO();
		ProponenteDTO proponenteDTO = new ProponenteDTO();
		AcquirenteDTO acquirenteDTO2 = new AcquirenteDTO();
		UtenteDTO utenteDTO2 = new UtenteDTO();
		UtenteDTO utenteDTO3 = new UtenteDTO();
		
		Pagamento pagamento =  pagamentoService.getById(id);
		
		utenteDTO.setIdutente(pagamento.getAcquirente().getUtente().getIdutente());
		utenteDTO.setNome(pagamento.getAcquirente().getUtente().getNome());
		utenteDTO.setCognome(pagamento.getAcquirente().getUtente().getCognome());
		utenteDTO.setUsername(pagamento.getAcquirente().getUtente().getUsername());
		utenteDTO.setPassword(pagamento.getAcquirente().getUtente().getPassword());
		utenteDTO.setEmail(pagamento.getAcquirente().getUtente().getEmail());
		utenteDTO.setUltimologin(pagamento.getAcquirente().getUtente().getUltimologin());
		utenteDTO.setStatus(pagamento.getAcquirente().getUtente().getStatus());

		acquirenteDTO.setIdacquirente(pagamento.getAcquirente().getIdacquirente());
		acquirenteDTO.setTelefono(pagamento.getAcquirente().getTelefono());
		acquirenteDTO.setIndirizzo(pagamento.getAcquirente().getIndirizzo());
		acquirenteDTO.setCitta(pagamento.getAcquirente().getCitta());
		acquirenteDTO.setCap(pagamento.getAcquirente().getCap());
		acquirenteDTO.setUtente(utenteDTO);
		
		pagamentoDTO.setIdpagamento(pagamento.getIdpagamento());
		pagamentoDTO.setMetodo(pagamento.getMetodo());
		pagamentoDTO.setImporto(pagamento.getImporto().doubleValue());
		pagamentoDTO.setDatatransazione(pagamento.getDatatransazione());
		
		utenteDTO2.setIdutente(pagamento.getPrenotazione().getProposta().getProponente().getUtente().getIdutente());
		utenteDTO2.setNome(pagamento.getPrenotazione().getProposta().getProponente().getUtente().getNome());
		utenteDTO2.setCognome(pagamento.getPrenotazione().getProposta().getProponente().getUtente().getCognome());
		utenteDTO2.setUsername(pagamento.getPrenotazione().getProposta().getProponente().getUtente().getUsername());
		utenteDTO2.setPassword(pagamento.getPrenotazione().getProposta().getProponente().getUtente().getPassword());
		utenteDTO2.setEmail(pagamento.getPrenotazione().getProposta().getProponente().getUtente().getEmail());
		utenteDTO2.setUltimologin(pagamento.getPrenotazione().getProposta().getProponente().getUtente().getUltimologin());
		utenteDTO2.setStatus(pagamento.getPrenotazione().getProposta().getProponente().getUtente().getStatus());

		acquirenteDTO2.setIdacquirente(pagamento.getPrenotazione().getAcquirente().getIdacquirente());
		acquirenteDTO2.setTelefono(pagamento.getPrenotazione().getAcquirente().getTelefono());
		acquirenteDTO2.setIndirizzo(pagamento.getPrenotazione().getAcquirente().getIndirizzo());
		acquirenteDTO2.setCitta(pagamento.getPrenotazione().getAcquirente().getCitta());
		acquirenteDTO2.setCap(pagamento.getPrenotazione().getAcquirente().getCap());
		acquirenteDTO2.setUtente(utenteDTO2);
		
		utenteDTO3.setIdutente(pagamento.getPrenotazione().getAcquirente().getUtente().getIdutente());
		utenteDTO3.setNome(pagamento.getPrenotazione().getAcquirente().getUtente().getNome());
		utenteDTO3.setCognome(pagamento.getPrenotazione().getAcquirente().getUtente().getCognome());
		utenteDTO3.setUsername(pagamento.getPrenotazione().getAcquirente().getUtente().getUsername());
		utenteDTO3.setPassword(pagamento.getPrenotazione().getAcquirente().getUtente().getPassword());
		utenteDTO3.setEmail(pagamento.getPrenotazione().getAcquirente().getUtente().getEmail());
		utenteDTO3.setUltimologin(pagamento.getPrenotazione().getAcquirente().getUtente().getUltimologin());
		utenteDTO3.setStatus(pagamento.getPrenotazione().getAcquirente().getUtente().getStatus());
		
		proponenteDTO.setIdproponente(pagamento.getPrenotazione().getProposta().getProponente().getIdproponente());
		proponenteDTO.setTelefono(pagamento.getPrenotazione().getProposta().getProponente().getTelefono());
		proponenteDTO.setIndirizzo(pagamento.getPrenotazione().getProposta().getProponente().getIndirizzo());
		proponenteDTO.setCitta(pagamento.getPrenotazione().getProposta().getProponente().getCitta());
		proponenteDTO.setCap(pagamento.getPrenotazione().getProposta().getProponente().getCap());
		proponenteDTO.setUtente(utenteDTO3);
		
		
		beneservizioDTO.setIdbeneservizio(pagamento.getPrenotazione().getProposta().getBeneservizio().getIdbeneservizio());
		beneservizioDTO.setCategoria(pagamento.getPrenotazione().getProposta().getBeneservizio().getCategoria());
		beneservizioDTO.setDescrizione(pagamento.getPrenotazione().getProposta().getBeneservizio().getDescrizione());
		
		propostaDTO.setIdproposta(pagamento.getPrenotazione().getProposta().getIdproposta());
		propostaDTO.setNome(pagamento.getPrenotazione().getProposta().getNome());
		propostaDTO.setDescrizione(pagamento.getPrenotazione().getProposta().getDescrizione());
		propostaDTO.setDatainiziodisp(pagamento.getPrenotazione().getProposta().getDatainiziodisp());
		propostaDTO.setDatafinedisp(pagamento.getPrenotazione().getProposta().getDatafinedisp());
		propostaDTO.setDisponibilita(pagamento.getPrenotazione().getProposta().getDisponibilita());
		propostaDTO.setCostounitario(pagamento.getPrenotazione().getProposta().getCostounitario());
		propostaDTO.setPosizione(pagamento.getPrenotazione().getProposta().getPosizione());
		propostaDTO.setStato(pagamento.getPrenotazione().getProposta().getStato());
		propostaDTO.setDatacreamodpr(pagamento.getPrenotazione().getProposta().getDatacreamodpr());
		propostaDTO.setIdproposta(pagamento.getPrenotazione().getProposta().getIdproposta());

		propostaDTO.setBeneservizio(beneservizioDTO);
		propostaDTO.setProponente(proponenteDTO);
		
		prenotazioneDTO.setIdprenotazione(pagamento.getPrenotazione().getIdprenotazione());
		prenotazioneDTO.setDatatransazione(pagamento.getPrenotazione().getDatatransazione());
		prenotazioneDTO.setDatacheckin(pagamento.getPrenotazione().getDatacheckin());
		prenotazioneDTO.setDatacheckout(pagamento.getPrenotazione().getDatacheckout());
		prenotazioneDTO.setCostotot(pagamento.getPrenotazione().getCostotot());
		
		prenotazioneDTO.setAcquirente(acquirenteDTO2);
		prenotazioneDTO.setProposta(propostaDTO);
		
		pagamentoDTO.setAcquirente(acquirenteDTO);
		pagamentoDTO.setPrenotazione(prenotazioneDTO);
		
		return pagamentoDTO;
	}
	
	
	
	@GetMapping( value="/getByIdPrenotazione/{prenotazioneID}",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	
	public PagamentoDTO getByIdPrenotazione(@PathVariable int prenotazioneID) {
		
		PagamentoDTO pagamentoDTO = new PagamentoDTO();
		AcquirenteDTO acquirenteDTO = new AcquirenteDTO();
		UtenteDTO utenteDTO = new UtenteDTO();
		
		PrenotazioneDTO prenotazioneDTO = new PrenotazioneDTO();
		PropostaDTO propostaDTO = new PropostaDTO();
		BeneservizioDTO beneservizioDTO = new BeneservizioDTO();
		ProponenteDTO proponenteDTO = new ProponenteDTO();
		AcquirenteDTO acquirenteDTO2 = new AcquirenteDTO();
		UtenteDTO utenteDTO2 = new UtenteDTO();
		UtenteDTO utenteDTO3 = new UtenteDTO();
		
		Pagamento pagamento =  pagamentoService.getById(prenotazioneID);
		
		utenteDTO.setIdutente(pagamento.getAcquirente().getUtente().getIdutente());
		utenteDTO.setNome(pagamento.getAcquirente().getUtente().getNome());
		utenteDTO.setCognome(pagamento.getAcquirente().getUtente().getCognome());
		utenteDTO.setUsername(pagamento.getAcquirente().getUtente().getUsername());
		utenteDTO.setPassword(pagamento.getAcquirente().getUtente().getPassword());
		utenteDTO.setEmail(pagamento.getAcquirente().getUtente().getEmail());
		utenteDTO.setUltimologin(pagamento.getAcquirente().getUtente().getUltimologin());
		utenteDTO.setStatus(pagamento.getAcquirente().getUtente().getStatus());

		acquirenteDTO.setIdacquirente(pagamento.getAcquirente().getIdacquirente());
		acquirenteDTO.setTelefono(pagamento.getAcquirente().getTelefono());
		acquirenteDTO.setIndirizzo(pagamento.getAcquirente().getIndirizzo());
		acquirenteDTO.setCitta(pagamento.getAcquirente().getCitta());
		acquirenteDTO.setCap(pagamento.getAcquirente().getCap());
		acquirenteDTO.setUtente(utenteDTO);
		
		pagamentoDTO.setIdpagamento(pagamento.getIdpagamento());
		pagamentoDTO.setMetodo(pagamento.getMetodo());
		pagamentoDTO.setImporto(pagamento.getImporto().doubleValue());
		pagamentoDTO.setDatatransazione(pagamento.getDatatransazione());
		
		utenteDTO2.setIdutente(pagamento.getPrenotazione().getProposta().getProponente().getUtente().getIdutente());
		utenteDTO2.setNome(pagamento.getPrenotazione().getProposta().getProponente().getUtente().getNome());
		utenteDTO2.setCognome(pagamento.getPrenotazione().getProposta().getProponente().getUtente().getCognome());
		utenteDTO2.setUsername(pagamento.getPrenotazione().getProposta().getProponente().getUtente().getUsername());
		utenteDTO2.setPassword(pagamento.getPrenotazione().getProposta().getProponente().getUtente().getPassword());
		utenteDTO2.setEmail(pagamento.getPrenotazione().getProposta().getProponente().getUtente().getEmail());
		utenteDTO2.setUltimologin(pagamento.getPrenotazione().getProposta().getProponente().getUtente().getUltimologin());
		utenteDTO2.setStatus(pagamento.getPrenotazione().getProposta().getProponente().getUtente().getStatus());

		acquirenteDTO2.setIdacquirente(pagamento.getPrenotazione().getAcquirente().getIdacquirente());
		acquirenteDTO2.setTelefono(pagamento.getPrenotazione().getAcquirente().getTelefono());
		acquirenteDTO2.setIndirizzo(pagamento.getPrenotazione().getAcquirente().getIndirizzo());
		acquirenteDTO2.setCitta(pagamento.getPrenotazione().getAcquirente().getCitta());
		acquirenteDTO2.setCap(pagamento.getPrenotazione().getAcquirente().getCap());
		acquirenteDTO2.setUtente(utenteDTO2);
		
		utenteDTO3.setIdutente(pagamento.getPrenotazione().getAcquirente().getUtente().getIdutente());
		utenteDTO3.setNome(pagamento.getPrenotazione().getAcquirente().getUtente().getNome());
		utenteDTO3.setCognome(pagamento.getPrenotazione().getAcquirente().getUtente().getCognome());
		utenteDTO3.setUsername(pagamento.getPrenotazione().getAcquirente().getUtente().getUsername());
		utenteDTO3.setPassword(pagamento.getPrenotazione().getAcquirente().getUtente().getPassword());
		utenteDTO3.setEmail(pagamento.getPrenotazione().getAcquirente().getUtente().getEmail());
		utenteDTO3.setUltimologin(pagamento.getPrenotazione().getAcquirente().getUtente().getUltimologin());
		utenteDTO3.setStatus(pagamento.getPrenotazione().getAcquirente().getUtente().getStatus());
		
		proponenteDTO.setIdproponente(pagamento.getPrenotazione().getProposta().getProponente().getIdproponente());
		proponenteDTO.setTelefono(pagamento.getPrenotazione().getProposta().getProponente().getTelefono());
		proponenteDTO.setIndirizzo(pagamento.getPrenotazione().getProposta().getProponente().getIndirizzo());
		proponenteDTO.setCitta(pagamento.getPrenotazione().getProposta().getProponente().getCitta());
		proponenteDTO.setCap(pagamento.getPrenotazione().getProposta().getProponente().getCap());
		proponenteDTO.setUtente(utenteDTO3);
		
		
		beneservizioDTO.setIdbeneservizio(pagamento.getPrenotazione().getProposta().getBeneservizio().getIdbeneservizio());
		beneservizioDTO.setCategoria(pagamento.getPrenotazione().getProposta().getBeneservizio().getCategoria());
		beneservizioDTO.setDescrizione(pagamento.getPrenotazione().getProposta().getBeneservizio().getDescrizione());
		
		propostaDTO.setIdproposta(pagamento.getPrenotazione().getProposta().getIdproposta());
		propostaDTO.setNome(pagamento.getPrenotazione().getProposta().getNome());
		propostaDTO.setDescrizione(pagamento.getPrenotazione().getProposta().getDescrizione());
		propostaDTO.setDatainiziodisp(pagamento.getPrenotazione().getProposta().getDatainiziodisp());
		propostaDTO.setDatafinedisp(pagamento.getPrenotazione().getProposta().getDatafinedisp());
		propostaDTO.setDisponibilita(pagamento.getPrenotazione().getProposta().getDisponibilita());
		propostaDTO.setCostounitario(pagamento.getPrenotazione().getProposta().getCostounitario());
		propostaDTO.setPosizione(pagamento.getPrenotazione().getProposta().getPosizione());
		propostaDTO.setStato(pagamento.getPrenotazione().getProposta().getStato());
		propostaDTO.setDatacreamodpr(pagamento.getPrenotazione().getProposta().getDatacreamodpr());
		propostaDTO.setIdproposta(pagamento.getPrenotazione().getProposta().getIdproposta());

		propostaDTO.setBeneservizio(beneservizioDTO);
		propostaDTO.setProponente(proponenteDTO);
		
		prenotazioneDTO.setIdprenotazione(pagamento.getPrenotazione().getIdprenotazione());
		prenotazioneDTO.setDatatransazione(pagamento.getPrenotazione().getDatatransazione());
		prenotazioneDTO.setDatacheckin(pagamento.getPrenotazione().getDatacheckin());
		prenotazioneDTO.setDatacheckout(pagamento.getPrenotazione().getDatacheckout());
		prenotazioneDTO.setCostotot(pagamento.getPrenotazione().getCostotot());
		
		prenotazioneDTO.setAcquirente(acquirenteDTO2);
		prenotazioneDTO.setProposta(propostaDTO);
		
		pagamentoDTO.setAcquirente(acquirenteDTO);
		pagamentoDTO.setPrenotazione(prenotazioneDTO);
		
		return pagamentoDTO;
	}

}
