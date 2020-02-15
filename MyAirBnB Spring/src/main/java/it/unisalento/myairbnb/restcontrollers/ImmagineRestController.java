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

import it.unisalento.myairbnb.dto.BeneservizioDTO;
import it.unisalento.myairbnb.dto.ImmagineDTO;
import it.unisalento.myairbnb.dto.ProponenteDTO;
import it.unisalento.myairbnb.dto.PropostaDTO;
import it.unisalento.myairbnb.dto.UtenteDTO;
import it.unisalento.myairbnb.entities.Beneservizio;
import it.unisalento.myairbnb.entities.Immagine;
import it.unisalento.myairbnb.entities.Proponente;
import it.unisalento.myairbnb.entities.Proposta;
import it.unisalento.myairbnb.entities.Utente;
import it.unisalento.myairbnb.service.ImmagineService;

@RestController
@RequestMapping("/immagine")
public class ImmagineRestController {
	
	
	@Autowired
	ImmagineService immagineService;
	
	@GetMapping(
			value = "/getAll",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List<ImmagineDTO> getAll() {
		
		List<Immagine> immaginelist = immagineService.getAll();
		List<ImmagineDTO> dtoimmagineList = new ArrayList<ImmagineDTO>();
		
		for (Immagine immagine : immaginelist) {
			
			ImmagineDTO immagineDTO = new ImmagineDTO();
			PropostaDTO propostaDTO = new PropostaDTO();
			
			BeneservizioDTO beneservizioDTO = new BeneservizioDTO();
			
			ProponenteDTO proponenteDTO = new ProponenteDTO();
			UtenteDTO utenteDTO = new UtenteDTO();
			
			
			utenteDTO.setIdutente(immagine.getProposta().getProponente().getUtente().getIdutente());
			utenteDTO.setNome(immagine.getProposta().getProponente().getUtente().getNome());
			utenteDTO.setCognome(immagine.getProposta().getProponente().getUtente().getCognome());
			utenteDTO.setUsername(immagine.getProposta().getProponente().getUtente().getUsername());
			utenteDTO.setPassword(immagine.getProposta().getProponente().getUtente().getPassword());
			utenteDTO.setEmail(immagine.getProposta().getProponente().getUtente().getEmail());
			utenteDTO.setUltimologin(immagine.getProposta().getProponente().getUtente().getUltimologin());
			utenteDTO.setStatus(immagine.getProposta().getProponente().getUtente().getStatus());

			proponenteDTO.setIdproponente(immagine.getProposta().getProponente().getIdproponente());
			proponenteDTO.setTelefono(immagine.getProposta().getProponente().getTelefono());
			proponenteDTO.setIndirizzo(immagine.getProposta().getProponente().getIndirizzo());
			proponenteDTO.setCitta(immagine.getProposta().getProponente().getCitta());
			proponenteDTO.setCap(immagine.getProposta().getProponente().getCap());
			proponenteDTO.setUtente(utenteDTO);

			
			beneservizioDTO.setIdbeneservizio(immagine.getProposta().getBeneservizio().getIdbeneservizio());
			beneservizioDTO.setCategoria(immagine.getProposta().getBeneservizio().getCategoria());
			beneservizioDTO.setDescrizione(immagine.getProposta().getBeneservizio().getDescrizione());


			propostaDTO.setIdproposta(immagine.getProposta().getIdproposta());
			propostaDTO.setNome(immagine.getProposta().getNome());
			propostaDTO.setDescrizione(immagine.getProposta().getDescrizione());
			propostaDTO.setDatainiziodisp(immagine.getProposta().getDatainiziodisp());
			propostaDTO.setDatafinedisp(immagine.getProposta().getDatafinedisp());
			propostaDTO.setDisponibilita(immagine.getProposta().getDisponibilita());
			propostaDTO.setCostounitario(immagine.getProposta().getCostounitario());
			propostaDTO.setPosizione(immagine.getProposta().getPosizione());
			propostaDTO.setDatacreamodpr(immagine.getProposta().getDatacreamodpr());
			propostaDTO.setStato(immagine.getProposta().getStato());
			propostaDTO.setProponente(proponenteDTO);
			propostaDTO.setBeneservizio(beneservizioDTO);
			
			
			immagineDTO.setIdimmagine(immagine.getIdimmagine());
			immagineDTO.setPercorso(immagine.getPercorso());
			immagineDTO.setProposta(propostaDTO);


			dtoimmagineList.add(immagineDTO);
			
		}
		
		return dtoimmagineList;

	}
		
		@GetMapping( value="/getImmaginebyIdProposta/{id}",
				produces = MediaType.APPLICATION_JSON_VALUE
				)
		
		public List<ImmagineDTO> getImmaginebyIdProposta(@PathVariable int id) {
			
			List<Immagine> immaginelist = immagineService.getByIdProposta(id);
			List<ImmagineDTO> dtoimmagineList = new ArrayList<ImmagineDTO>();
			
			for (Immagine immagine : immaginelist) {
				
				ImmagineDTO immagineDTO = new ImmagineDTO();
				PropostaDTO propostaDTO = new PropostaDTO();
				
				BeneservizioDTO beneservizioDTO = new BeneservizioDTO();
				
				ProponenteDTO proponenteDTO = new ProponenteDTO();
				UtenteDTO utenteDTO = new UtenteDTO();
				
				
				utenteDTO.setIdutente(immagine.getProposta().getProponente().getUtente().getIdutente());
				utenteDTO.setNome(immagine.getProposta().getProponente().getUtente().getNome());
				utenteDTO.setCognome(immagine.getProposta().getProponente().getUtente().getCognome());
				utenteDTO.setUsername(immagine.getProposta().getProponente().getUtente().getUsername());
				utenteDTO.setPassword(immagine.getProposta().getProponente().getUtente().getPassword());
				utenteDTO.setEmail(immagine.getProposta().getProponente().getUtente().getEmail());
				utenteDTO.setUltimologin(immagine.getProposta().getProponente().getUtente().getUltimologin());
				utenteDTO.setStatus(immagine.getProposta().getProponente().getUtente().getStatus());

				proponenteDTO.setIdproponente(immagine.getProposta().getProponente().getIdproponente());
				proponenteDTO.setTelefono(immagine.getProposta().getProponente().getTelefono());
				proponenteDTO.setIndirizzo(immagine.getProposta().getProponente().getIndirizzo());
				proponenteDTO.setCitta(immagine.getProposta().getProponente().getCitta());
				proponenteDTO.setCap(immagine.getProposta().getProponente().getCap());
				proponenteDTO.setUtente(utenteDTO);

				
				beneservizioDTO.setIdbeneservizio(immagine.getProposta().getBeneservizio().getIdbeneservizio());
				beneservizioDTO.setCategoria(immagine.getProposta().getBeneservizio().getCategoria());
				beneservizioDTO.setDescrizione(immagine.getProposta().getBeneservizio().getDescrizione());


				propostaDTO.setIdproposta(immagine.getProposta().getIdproposta());
				propostaDTO.setNome(immagine.getProposta().getNome());
				propostaDTO.setDescrizione(immagine.getProposta().getDescrizione());
				propostaDTO.setDatainiziodisp(immagine.getProposta().getDatainiziodisp());
				propostaDTO.setDatafinedisp(immagine.getProposta().getDatafinedisp());
				propostaDTO.setDisponibilita(immagine.getProposta().getDisponibilita());
				propostaDTO.setCostounitario(immagine.getProposta().getCostounitario());
				propostaDTO.setPosizione(immagine.getProposta().getPosizione());
				propostaDTO.setDatacreamodpr(immagine.getProposta().getDatacreamodpr());
				propostaDTO.setStato(immagine.getProposta().getStato());
				propostaDTO.setProponente(proponenteDTO);
				propostaDTO.setBeneservizio(beneservizioDTO);
				
				
				immagineDTO.setIdimmagine(immagine.getIdimmagine());
				immagineDTO.setPercorso(immagine.getPercorso());
				immagineDTO.setProposta(propostaDTO);


				dtoimmagineList.add(immagineDTO);
				
			}
			
			return dtoimmagineList;

		}
		
		@PostMapping(
				
				value = "/save",
				consumes = MediaType.APPLICATION_JSON_VALUE,
				produces = MediaType.APPLICATION_JSON_VALUE
				)
		
		public Immagine post(@RequestBody @Valid ImmagineDTO immagineDTO) {
			
			Immagine immagine = new Immagine();
			Proposta proposta = new Proposta();
			
			Beneservizio beneservizio = new Beneservizio();
			Proponente proponente = new Proponente();
			Utente utente = new Utente();
			
			utente.setIdutente(immagineDTO.getProposta().getProponente().getUtente().getIdutente());
			utente.setNome(immagineDTO.getProposta().getProponente().getUtente().getNome());
			utente.setCognome(immagineDTO.getProposta().getProponente().getUtente().getCognome());
			utente.setUsername(immagineDTO.getProposta().getProponente().getUtente().getUsername());
			utente.setPassword(immagineDTO.getProposta().getProponente().getUtente().getPassword());
			utente.setEmail(immagineDTO.getProposta().getProponente().getUtente().getEmail());
			Timestamp ts0 = new Timestamp(immagineDTO.getProposta().getProponente().getUtente().getUltimologin().getTime());
			utente.setUltimologin(ts0);
			utente.setStatus(immagineDTO.getProposta().getProponente().getUtente().getStatus());

			proponente.setIdproponente(immagineDTO.getProposta().getProponente().getIdproponente());
			proponente.setTelefono(immagineDTO.getProposta().getProponente().getTelefono());
			proponente.setIndirizzo(immagineDTO.getProposta().getProponente().getIndirizzo());
			proponente.setCitta(immagineDTO.getProposta().getProponente().getCitta());
			proponente.setCap(immagineDTO.getProposta().getProponente().getCap());
			proponente.setUtente(utente);

			beneservizio.setIdbeneservizio(immagineDTO.getProposta().getBeneservizio().getIdbeneservizio());
			beneservizio.setCategoria(immagineDTO.getProposta().getBeneservizio().getCategoria());
			beneservizio.setDescrizione(immagineDTO.getProposta().getBeneservizio().getDescrizione());


			proposta.setIdproposta(immagineDTO.getProposta().getIdproposta());
			proposta.setNome(immagineDTO.getProposta().getNome());
			proposta.setDescrizione(immagineDTO.getProposta().getDescrizione());
			Timestamp ts1 = new Timestamp(immagineDTO.getProposta().getDatainiziodisp().getTime());
			proposta.setDatainiziodisp(ts1);

			
			Timestamp ts2 = new Timestamp(immagineDTO.getProposta().getDatafinedisp().getTime());
			proposta.setDatafinedisp(ts2);
			proposta.setDisponibilita(immagineDTO.getProposta().getDisponibilita());
			proposta.setCostounitario(immagineDTO.getProposta().getCostounitario());
			proposta.setPosizione(immagineDTO.getProposta().getPosizione());
			Timestamp ts3 = new Timestamp(immagineDTO.getProposta().getDatacreamodpr().getTime());
			proposta.setDatacreamodpr(ts3);
			proposta.setStato(immagineDTO.getProposta().getStato());
			proposta.setProponente(proponente);
			proposta.setBeneservizio(beneservizio);
			
			immagine.setPercorso(immagineDTO.getPercorso());
			immagine.setProposta(proposta);
			
			
			return immagineService.saveorUpdate(immagine);

			
		}
		

		@PutMapping(
				
				value="/update",
				consumes = MediaType.APPLICATION_JSON_VALUE,
				produces = MediaType.APPLICATION_JSON_VALUE
				
				)
		
		public Immagine update(@RequestBody @Valid ImmagineDTO immagineDTO) {
			
			Immagine immagine = new Immagine();
			Proposta proposta = new Proposta();
			
			Beneservizio beneservizio = new Beneservizio();
			Proponente proponente = new Proponente();
			Utente utente = new Utente();
			
			
			utente.setIdutente(immagineDTO.getProposta().getProponente().getUtente().getIdutente());
			utente.setNome(immagineDTO.getProposta().getProponente().getUtente().getNome());
			utente.setCognome(immagineDTO.getProposta().getProponente().getUtente().getCognome());
			utente.setUsername(immagineDTO.getProposta().getProponente().getUtente().getUsername());
			utente.setPassword(immagineDTO.getProposta().getProponente().getUtente().getPassword());
			utente.setEmail(immagineDTO.getProposta().getProponente().getUtente().getEmail());
			Timestamp ts0 = new Timestamp(immagineDTO.getProposta().getProponente().getUtente().getUltimologin().getTime());
			utente.setUltimologin(ts0);
			utente.setStatus(immagineDTO.getProposta().getProponente().getUtente().getStatus());

			proponente.setIdproponente(immagineDTO.getProposta().getProponente().getIdproponente());
			proponente.setTelefono(immagineDTO.getProposta().getProponente().getTelefono());
			proponente.setIndirizzo(immagineDTO.getProposta().getProponente().getIndirizzo());
			proponente.setCitta(immagineDTO.getProposta().getProponente().getCitta());
			proponente.setCap(immagineDTO.getProposta().getProponente().getCap());
			proponente.setUtente(utente);

			
			beneservizio.setIdbeneservizio(immagineDTO.getProposta().getBeneservizio().getIdbeneservizio());
			beneservizio.setCategoria(immagineDTO.getProposta().getBeneservizio().getCategoria());
			beneservizio.setDescrizione(immagineDTO.getProposta().getBeneservizio().getDescrizione());


			proposta.setIdproposta(immagineDTO.getProposta().getIdproposta());
			proposta.setNome(immagineDTO.getProposta().getNome());
			proposta.setDescrizione(immagineDTO.getProposta().getDescrizione());
			Timestamp ts1 = new Timestamp(immagineDTO.getProposta().getDatainiziodisp().getTime());
			proposta.setDatainiziodisp(ts1);

			
			Timestamp ts2 = new Timestamp(immagineDTO.getProposta().getDatafinedisp().getTime());
			proposta.setDatafinedisp(ts2);
			proposta.setDisponibilita(immagineDTO.getProposta().getDisponibilita());
			proposta.setCostounitario(immagineDTO.getProposta().getCostounitario());
			proposta.setPosizione(immagineDTO.getProposta().getPosizione());
			Timestamp ts3 = new Timestamp(immagineDTO.getProposta().getDatacreamodpr().getTime());
			proposta.setDatacreamodpr(ts3);
			proposta.setStato(immagineDTO.getProposta().getStato());
			proposta.setProponente(proponente);
			proposta.setBeneservizio(beneservizio);
			
			
			immagine.setIdimmagine(immagine.getIdimmagine());
			immagine.setPercorso(immagine.getPercorso());
			immagine.setProposta(proposta);
			
			
			return immagineService.saveorUpdate(immagine);
			
			
		}
		
		@DeleteMapping(
				
				value="/delete/{id}"
				)
		
		public void delete(@PathVariable int id) {
			immagineService.delete(id);
		}
		
		
		@GetMapping( value="/getByIdImmagine/{id}",
				produces = MediaType.APPLICATION_JSON_VALUE
				)
		public ImmagineDTO getByIdImmagine(@PathVariable int id) {
			ImmagineDTO immagineDTO = new ImmagineDTO();
			PropostaDTO propostaDTO = new PropostaDTO();
			
			BeneservizioDTO beneservizioDTO = new BeneservizioDTO();
			ProponenteDTO proponenteDTO = new ProponenteDTO();
			UtenteDTO utenteDTO = new UtenteDTO();
			
			Immagine immagine =  immagineService.getById(id);
			
			utenteDTO.setIdutente(immagine.getProposta().getProponente().getUtente().getIdutente());
			utenteDTO.setNome(immagine.getProposta().getProponente().getUtente().getNome());
			utenteDTO.setCognome(immagine.getProposta().getProponente().getUtente().getCognome());
			utenteDTO.setUsername(immagine.getProposta().getProponente().getUtente().getUsername());
			utenteDTO.setPassword(immagine.getProposta().getProponente().getUtente().getPassword());
			utenteDTO.setEmail(immagine.getProposta().getProponente().getUtente().getEmail());
			utenteDTO.setUltimologin(immagine.getProposta().getProponente().getUtente().getUltimologin());
			utenteDTO.setStatus(immagine.getProposta().getProponente().getUtente().getStatus());

			proponenteDTO.setIdproponente(immagine.getProposta().getProponente().getIdproponente());
			proponenteDTO.setTelefono(immagine.getProposta().getProponente().getTelefono());
			proponenteDTO.setIndirizzo(immagine.getProposta().getProponente().getIndirizzo());
			proponenteDTO.setCitta(immagine.getProposta().getProponente().getCitta());
			proponenteDTO.setCap(immagine.getProposta().getProponente().getCap());
			proponenteDTO.setUtente(utenteDTO);

			
			beneservizioDTO.setIdbeneservizio(immagine.getProposta().getBeneservizio().getIdbeneservizio());
			beneservizioDTO.setCategoria(immagine.getProposta().getBeneservizio().getCategoria());
			beneservizioDTO.setDescrizione(immagine.getProposta().getBeneservizio().getDescrizione());


			propostaDTO.setIdproposta(immagine.getProposta().getIdproposta());
			propostaDTO.setNome(immagine.getProposta().getNome());
			propostaDTO.setDescrizione(immagine.getProposta().getDescrizione());
			propostaDTO.setDatainiziodisp(immagine.getProposta().getDatainiziodisp());
			propostaDTO.setDatafinedisp(immagine.getProposta().getDatafinedisp());
			propostaDTO.setDisponibilita(immagine.getProposta().getDisponibilita());
			propostaDTO.setCostounitario(immagine.getProposta().getCostounitario());
			propostaDTO.setPosizione(immagine.getProposta().getPosizione());
			propostaDTO.setDatacreamodpr(immagine.getProposta().getDatacreamodpr());
			propostaDTO.setStato(immagine.getProposta().getStato());
			propostaDTO.setProponente(proponenteDTO);
			propostaDTO.setBeneservizio(beneservizioDTO);
			
			
			immagineDTO.setIdimmagine(immagine.getIdimmagine());
			immagineDTO.setPercorso(immagine.getPercorso());
			immagineDTO.setProposta(propostaDTO);
			
			
			return immagineDTO;
		}
		

		@DeleteMapping(
				
				value="/cancellabyidproposta/{id}"
				)
		
		public void cancellaImmagineByIdProposta(@PathVariable int id) {
			immagineService.deleteImageByIdProposta(id);
		}
		
	
			
		
		
}
