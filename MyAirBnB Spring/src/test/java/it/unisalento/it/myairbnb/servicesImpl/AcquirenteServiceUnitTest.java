package it.unisalento.it.myairbnb.servicesImpl;

import org.junit.jupiter.api.BeforeEach;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import it.unisalento.myairbnb.entities.Acquirente;
import it.unisalento.myairbnb.entities.Beneservizio;
import it.unisalento.myairbnb.entities.Commento;
import it.unisalento.myairbnb.entities.Prenotazione;
import it.unisalento.myairbnb.entities.Utente;
import it.unisalento.myairbnb.exceptions.AcquirenteNotFoundException;
import it.unisalento.myairbnb.exceptions.PrenotazioneNotFoundException;
import it.unisalento.myairbnb.service.AcquirenteService;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = AcquirenteService.class)
public class AcquirenteServiceUnitTest {
	
	
	@Mock
	private AcquirenteService acquirenteServiceMock;
	
	private Acquirente acquirente;
	
	@BeforeEach
	private void setUp() {
		
        acquirente = new Acquirente();
        
        
        acquirente.setTelefono("0833643");
    	acquirente.setIndirizzo("Via via");
    	acquirente.setCitta("prova città");;
    	acquirente.setCap("493843");
    
    
    	
    	Utente utente_prova = new Utente();
    	
	}
	
	
	@Test
	public void saveAcquirenteTest() {
			
		when(acquirenteServiceMock.saveorUpdate(acquirente)).thenReturn(acquirente);
		
		int id = acquirenteServiceMock.saveorUpdate(acquirente).getIdacquirente();
		
		assertThat(id).isNotNull();
		
	}
	
	
	@Test
	public void getByIdTest() throws AcquirenteNotFoundException {
		int id=1;
		
		when(acquirenteServiceMock.getById(id)).thenReturn(acquirente);
		Acquirente a = acquirenteServiceMock.getById(id);
		
		assertThat(a.getCitta()).isNotNull();
		
		
	}
	
	@Test
	public void getByUsernameandPasswordTest() throws AcquirenteNotFoundException{
		
		String username = "valeria";
		String password = "password4";
		
		when(acquirenteServiceMock.getByUsernameandPassword(username, password)).thenReturn(acquirente);
		
		Acquirente a = acquirenteServiceMock.getByUsernameandPassword(username, password);
		
		assertThat(a.getCap()).isNotNull();
		
		
	}
	
	
	
	@Test
	public void getAllTest(){
		
		java.util.List<Acquirente> acquirenti = new ArrayList<Acquirente>();
		
		when(acquirenteServiceMock.getAll()).thenReturn(acquirenti);
		
		acquirenti = acquirenteServiceMock.getAll();
		
		assertThat(acquirenti.size()).isNotNegative();
		
		
	}
	
	
	

}