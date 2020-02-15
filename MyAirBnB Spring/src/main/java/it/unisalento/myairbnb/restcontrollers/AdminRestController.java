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

import it.unisalento.myairbnb.dto.AdminDTO;
import it.unisalento.myairbnb.dto.UtenteDTO;
import it.unisalento.myairbnb.entities.Admin;
import it.unisalento.myairbnb.entities.Utente;
import it.unisalento.myairbnb.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminRestController {
	
	@Autowired
	AdminService adminService;
	
	
@PostMapping(
			
			value = "/save",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	
	public Admin post(@RequestBody @Valid AdminDTO adminDTO) {
		
		Admin admin = new Admin();
		Utente utente = new Utente();
		
		utente.setNome(adminDTO.getUtente().getNome());
		utente.setCognome(adminDTO.getUtente().getCognome());
		utente.setUsername(adminDTO.getUtente().getUsername());
		utente.setPassword(adminDTO.getUtente().getPassword());
		Timestamp ts = new Timestamp(adminDTO.getUtente().getUltimologin().getTime());
		utente.setUltimologin(ts);
		utente.setStatus(adminDTO.getUtente().getStatus());
		
		admin.setUtente(utente);

		
		return adminService.saveorUpdate(admin);
		
	}
	

	
	@GetMapping( value="/getByIdAdmin/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public AdminDTO get(@PathVariable int id) {
		
		AdminDTO adminDTO = new AdminDTO();	
		UtenteDTO utenteDTO = new UtenteDTO();
		Admin admin =  adminService.getById(id);
		
		utenteDTO.setNome(admin.getUtente().getNome());
		utenteDTO.setCognome(admin.getUtente().getCognome());
		utenteDTO.setEmail(admin.getUtente().getEmail());
		utenteDTO.setIdutente(admin.getUtente().getIdutente());
		utenteDTO.setPassword(admin.getUtente().getPassword());
		utenteDTO.setUsername(admin.getUtente().getUsername());
		utenteDTO.setStatus(admin.getUtente().getStatus());
		utenteDTO.setUltimologin(admin.getUtente().getUltimologin());
		
		adminDTO.setIdadmin(admin.getIdadmin());
		adminDTO.setUtente(utenteDTO);
					
		return adminDTO;
	}
	
	
	
	@GetMapping(
			value = "/getAll",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List<AdminDTO> getAll() {
		
		List<AdminDTO> AdminDTOList = new ArrayList<AdminDTO>();
		UtenteDTO utenteDTO = new UtenteDTO();
		List<Admin> adminlist = adminService.getAll();

		
		for (Admin admin : adminlist) {
			
			AdminDTO adminDTO = new AdminDTO();
	
			utenteDTO.setNome(admin.getUtente().getNome());
			utenteDTO.setCognome(admin.getUtente().getCognome());
			utenteDTO.setEmail(admin.getUtente().getEmail());
			utenteDTO.setIdutente(admin.getUtente().getIdutente());
			utenteDTO.setPassword(admin.getUtente().getPassword());
			utenteDTO.setUsername(admin.getUtente().getUsername());
			utenteDTO.setStatus(admin.getUtente().getStatus());
			utenteDTO.setUltimologin(admin.getUtente().getUltimologin());
			
			adminDTO.setIdadmin(admin.getIdadmin());
			adminDTO.setUtente(utenteDTO);

			AdminDTOList.add(adminDTO);
			
		} 

		return AdminDTOList;
		
	}
	
	
	@GetMapping( value="/getByUsernameandPassword/{username}/{password}",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public AdminDTO getByUsernameandPassword(@PathVariable String username, @PathVariable String password) {
		
		AdminDTO adminDTO = new AdminDTO();	
		UtenteDTO utenteDTO = new UtenteDTO();
		Admin admin =  adminService.getByUsernameandPassword(username, password);
		
		utenteDTO.setNome(admin.getUtente().getNome());
		utenteDTO.setCognome(admin.getUtente().getCognome());
		utenteDTO.setEmail(admin.getUtente().getEmail());
		utenteDTO.setIdutente(admin.getUtente().getIdutente());
		utenteDTO.setPassword(admin.getUtente().getPassword());
		utenteDTO.setUsername(admin.getUtente().getUsername());
		utenteDTO.setStatus(admin.getUtente().getStatus());
		utenteDTO.setUltimologin(admin.getUtente().getUltimologin());
		
		adminDTO.setIdadmin(admin.getIdadmin());
		adminDTO.setUtente(utenteDTO);
					
		return adminDTO;
		
	}

}
