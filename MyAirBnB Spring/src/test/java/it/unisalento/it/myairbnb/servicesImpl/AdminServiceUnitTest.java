package it.unisalento.it.myairbnb.servicesImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.databind.Module.SetupContext;

import it.unisalento.myairbnb.entities.Acquirente;
import it.unisalento.myairbnb.entities.Admin;
import it.unisalento.myairbnb.entities.Utente;
import it.unisalento.myairbnb.exceptions.AcquirenteNotFoundException;
import it.unisalento.myairbnb.exceptions.AdminNotFoundException;
import it.unisalento.myairbnb.service.AdminService;
import it.unisalento.myairbnb.service.UtenteService;


@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = AdminService.class)


public class AdminServiceUnitTest {

	@Mock
	private AdminService adminServiceMock;
	private Admin admin;
	
	
	@BeforeEach
	private void setup() {
		
		admin = new Admin()	;
		Utente utente_pr = new Utente();
		
		
	}
	
	
	
	@Test
	void saveAdmintest() {

		
		when(adminServiceMock.saveorUpdate(admin)).thenReturn(admin);
		
		int id = adminServiceMock.saveorUpdate(admin).getIdadmin();
		
		assertThat(id).isNotNull();
		
	}
	
	
	
	
	@Test
	public void getByIdTest() throws AdminNotFoundException {
		int id=1;
		
		Utente utente_prova = new Utente();
	
		when(adminServiceMock.getById(id)).thenReturn(admin);
		Admin a = adminServiceMock.getById(id);
		
		a.setUtente(utente_prova);
		
		utente_prova.setCognome("prova_cognome");
		
	assertEquals("prova_cognome",a.getUtente().getCognome());
		
		
	}
	
	
	
	@Test
	public void getByUsernameandPasswordTest() throws AdminNotFoundException{
		
		String username = "andrea";
		String password = "password";
		
		when(adminServiceMock.getByUsernameandPassword(username, password)).thenReturn(admin);
		
		Admin a = adminServiceMock.getByUsernameandPassword(username, password);
		Utente utente_prova = new Utente();
		
		a.setUtente(utente_prova);
		
		utente_prova.setCognome("prova_cognome");
		
		assertEquals("prova_cognome",a.getUtente().getCognome());
		
		
		
	}
	

}









/////////////////////

	