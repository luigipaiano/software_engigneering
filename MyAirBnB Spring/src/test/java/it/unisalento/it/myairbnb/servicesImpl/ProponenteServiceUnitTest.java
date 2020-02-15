package it.unisalento.it.myairbnb.servicesImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import it.unisalento.myairbnb.entities.Acquirente;
import it.unisalento.myairbnb.entities.Pagamento;
import it.unisalento.myairbnb.entities.Proponente;
import it.unisalento.myairbnb.entities.Proposta;
import it.unisalento.myairbnb.entities.Utente;
import it.unisalento.myairbnb.exceptions.AcquirenteNotFoundException;
import it.unisalento.myairbnb.exceptions.PagamentoNotFoundException;
import it.unisalento.myairbnb.exceptions.ProponenteNotFoundException;
import it.unisalento.myairbnb.service.ProponenteService;
import it.unisalento.myairbnb.service.UtenteService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = ProponenteService.class)

class ProponenteServiceUnitTest {
	
	@Mock
	private ProponenteService proponenteServiceMock;
	
	private Proponente proponente;
	
	

	@BeforeEach
	private void setUp() {
		
        proponente = new Proponente();
        
        proponente.setTelefono("0853643");
    	proponente.setIndirizzo("Via_prova");
    	proponente.setCitta("prova_città");
    	proponente.setCap("4934343");
    
    
    	
    	Utente utente_prova = new Utente();
	}
	
	
	
	@Test
	public void saveProponenteTest() {
			
		when(proponenteServiceMock.saveorUpdate(proponente)).thenReturn(proponente);
		
		int id = proponenteServiceMock.saveorUpdate(proponente).getIdproponente();
		
		assertThat(id).isNotNull();
		
	}
	
	
	@Test
	public void getByIdTest() throws ProponenteNotFoundException {
		int id=1;
		when(proponenteServiceMock.getById(id)).thenReturn(proponente);
		Proponente p = proponenteServiceMock.getById(id);
		
		assertThat(p.getCap()).isNotNull();

}
	
	
	@Test
	public void getByUsernameandPasswordTest() throws ProponenteNotFoundException{
		
		String username = "valeria";
		String password = "password4";
		
		when(proponenteServiceMock.getByUsernameandPassword(username, password)).thenReturn(proponente);
		
		Proponente p = proponenteServiceMock.getByUsernameandPassword(username, password);
		
		assertThat(p.getCap()).isNotNull();
		
		
	}
	
	
	
	@Test
	public void getAllTest(){
		
		java.util.List<Proponente> proponenti = new ArrayList<Proponente>();
		
		when(proponenteServiceMock.getAll()).thenReturn(proponenti);
		
		proponenti = proponenteServiceMock.getAll();
		
		assertThat(proponenti.size()).isNotNegative();
		
		
	}
	
	
}

