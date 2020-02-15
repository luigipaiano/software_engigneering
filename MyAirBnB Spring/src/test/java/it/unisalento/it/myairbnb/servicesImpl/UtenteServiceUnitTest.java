package it.unisalento.it.myairbnb.servicesImpl;

import org.junit.jupiter.api.BeforeEach;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import antlr.collections.List;
import it.unisalento.myairbnb.entities.Acquirente;
import it.unisalento.myairbnb.entities.Proponente;
import it.unisalento.myairbnb.entities.Utente;
import it.unisalento.myairbnb.exceptions.AcquirenteNotFoundException;
import it.unisalento.myairbnb.exceptions.ProponenteNotFoundException;
import it.unisalento.myairbnb.exceptions.UtenteNotFoundException;
import it.unisalento.myairbnb.repositories.UtenteRepository;
import it.unisalento.myairbnb.service.AcquirenteService;
import it.unisalento.myairbnb.service.UtenteService;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = Utente.class)

public class UtenteServiceUnitTest {
	
	@Mock
	private UtenteService utenteServiceMock;
	
	private Utente utente;
	private Utente utente2;
	
	
	
	@BeforeEach
	private void setUp() {
		
        utente = new Utente();
        //u.setIdutente(1); non va fatto il set dell'id perché è autoincroment
        utente.setNome("Mario");
        utente.setCognome("Rossi");
        utente.setUsername("mariorossi");
        utente.setPassword("ciaociao");
        utente.setEmail("mariorossi@gmail.com");
        utente.setStatus(1);
        
        utente2 = new Utente();
        //u.setIdutente(1); non va fatto il set dell'id perché è autoincroment
        utente2.setNome("Giulio");
        utente2.setCognome("Bianchi");
        utente2.setUsername("giuliobianchi");
        utente2.setPassword("pw");
        utente2.setEmail("giuliobianchi@gmail.com");
        utente2.setStatus(1);
        
        
	}
	
	
	@Test
	public void saveUtenteTest() {
			
		when(utenteServiceMock.saveorUpdate(utente)).thenReturn(utente);
		
		int id = utenteServiceMock.saveorUpdate(utente).getIdutente();
		
		assertThat(id).isNotNull();
		
	}
	
	
	
	@Test
	public void getByIdTest() throws UtenteNotFoundException {
		int id=1;
		when(utenteServiceMock.getById(id)).thenReturn(utente);
		Utente u = utenteServiceMock.getById(id);
		
		assertThat(u.getCognome()).isNotNull();
	
	
	
	

	}
	
	
	@Test
	public void getByUsernameandPasswordTest() throws UtenteNotFoundException{
		
		String username = "valeria";
		String password = "password4";
		
		when(utenteServiceMock.getByUsernameandPassword(username, password)).thenReturn(utente);
		
		Utente u = utenteServiceMock.getByUsernameandPassword(username, password);
		
		assertThat(u.getNome()).isNotNull();
		
		
	}
	
	
	@Test
	public void getAllTest(){
		
		java.util.List<Utente> utenti = new ArrayList<Utente>();
		
		when(utenteServiceMock.getAll()).thenReturn(utenti);
		
		utenti = utenteServiceMock.getAll();
		
		assertThat(utenti.size()).isNotNegative();
		
		
	}


}