package it.unisalento.myairbnb.restcontrollers;

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

import it.unisalento.myairbnb.dto.BeneservizioDTO;
import it.unisalento.myairbnb.entities.Beneservizio;
import it.unisalento.myairbnb.service.BeneservizioService;

@RestController
@RequestMapping("/beneservizio")
public class BeneservizioRestController {
	
	@Autowired
	BeneservizioService beneservizioService;
	
	
	@GetMapping(
			value = "/getAll",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List<BeneservizioDTO> getAll() {
		
		List<Beneservizio> beneserviziolist = beneservizioService.getAll();
		List<BeneservizioDTO> dtobeneservizioList = new ArrayList<BeneservizioDTO>();
		
		for (Beneservizio beneservizio : beneserviziolist) {
			
			BeneservizioDTO beneservizioDTO = new BeneservizioDTO();
			
			beneservizioDTO.setIdbeneservizio(beneservizio.getIdbeneservizio());
			beneservizioDTO.setCategoria(beneservizio.getCategoria());
			beneservizioDTO.setDescrizione(beneservizio.getDescrizione());

			dtobeneservizioList.add(beneservizioDTO);
			
		}
		
		return dtobeneservizioList;

	}
	
	@GetMapping( value="/getByCategoria/{categoria}",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List <BeneservizioDTO> getByCategoria(@PathVariable String categoria) {
		
		List<Beneservizio> beneserviziolist = beneservizioService.getByCategoria(categoria);
		List<BeneservizioDTO> dtobeneservizioList = new ArrayList<BeneservizioDTO>();
		
		for (Beneservizio beneservizio : beneserviziolist) {
			
			BeneservizioDTO beneservizioDTO = new BeneservizioDTO();
			
			beneservizioDTO.setIdbeneservizio(beneservizio.getIdbeneservizio());
			beneservizioDTO.setCategoria(beneservizio.getCategoria());
			beneservizioDTO.setDescrizione(beneservizio.getDescrizione());

			dtobeneservizioList.add(beneservizioDTO);
			
		}
		
		return dtobeneservizioList;

	}

	@PostMapping(
			
			value = "/save",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	
	public Beneservizio post(@RequestBody @Valid BeneservizioDTO beneservizioDTO) {
		
		Beneservizio beneservizio = new Beneservizio();
		beneservizio.setCategoria(beneservizioDTO.getCategoria());
		beneservizio.setDescrizione(beneservizioDTO.getDescrizione());

		return beneservizioService.saveorUpdate(beneservizio);
		
	}

	@PutMapping(
			
			value="/update",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
			
			)
	
	public Beneservizio update(@RequestBody @Valid BeneservizioDTO beneservizioDTO) {
		
		Beneservizio beneservizio = new Beneservizio();
		beneservizio.setCategoria(beneservizioDTO.getCategoria());
		beneservizio.setDescrizione(beneservizioDTO.getDescrizione());
		
		return beneservizioService.saveorUpdate(beneservizio);
		
	}
	
	@DeleteMapping(
			
			value="/delete/{id}"
			)
	
	public void delete(@PathVariable int id) {
		beneservizioService.delete(id);
	}
	
	
	@GetMapping( value="/getByIdBeneservizio/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	
	public BeneservizioDTO get(@PathVariable int id) {
		BeneservizioDTO beneservizioDTO = new BeneservizioDTO();
		
		Beneservizio beneservizio =  beneservizioService.getById(id);
		beneservizioDTO.setIdbeneservizio(beneservizio.getIdbeneservizio());
		beneservizioDTO.setCategoria(beneservizio.getCategoria());
		beneservizioDTO.setDescrizione(beneservizio.getDescrizione());
		
		return beneservizioDTO;
	}
	
	
		
}
