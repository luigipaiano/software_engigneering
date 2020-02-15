package it.unisalento.it.myairbnb.servicesImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.security.Timestamp;
import java.sql.Date;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import it.unisalento.myairbnb.entities.Acquirente;
import it.unisalento.myairbnb.entities.Prenotazione;
import it.unisalento.myairbnb.entities.Proposta;
import it.unisalento.myairbnb.entities.Utente;
import it.unisalento.myairbnb.exceptions.PrenotazioneNotFoundException;
import it.unisalento.myairbnb.service.PrenotazioneService;
import it.unisalento.myairbnb.service.UtenteService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = PrenotazioneService.class)

	
	

class PrenotazioneServiceUnitTest {
	
	
	@Mock
	private PrenotazioneService prenotazioneServiceMock;
	private Prenotazione prenotazione;


	@BeforeEach
	private void setUp() {
		
        prenotazione = new Prenotazione();
        
        BigDecimal n1 = new BigDecimal("1000.123482248908085303458975309348");
       
         prenotazione.setCostotot(n1);
      //   prenotazione.setDatacheckin(Timestamp.valueOf("2012-03-12 8:23:30.0"));
        // prenotazione.setDatacheckout(Timestamp.valueOf("2019-08-14 10:10:10.0"));
         
         Acquirente acquirente = new Acquirente();
         Proposta proposta = new Proposta();  
        
	}

	
	@Test
	public void savePrenotazioneTest() {
			
		when(prenotazioneServiceMock.saveorUpdate(prenotazione)).thenReturn(prenotazione);
		
		int id = prenotazioneServiceMock.saveorUpdate(prenotazione).getIdprenotazione();
		
		assertThat(id).isNotNull();
		
	}
	
	
	@Test
	public void getByIdTest() throws PrenotazioneNotFoundException {
		int id=1;
		when(prenotazioneServiceMock.getById(id)).thenReturn(prenotazione);
		Prenotazione p = prenotazioneServiceMock.getById(id);
		
		assertThat(p.getCostotot()).isNotNull();
		
		
	}
	
	
	@Test
	public void getAllTest(){
		
		java.util.List<Prenotazione> prenotazioni = new ArrayList<Prenotazione>();
		
		when(prenotazioneServiceMock.getAll()).thenReturn(prenotazioni);
		
		prenotazioni = prenotazioneServiceMock.getAll();
		
		assertThat(prenotazioni.size()).isNotNegative();
		
		
	}
	
	
	
	@Test
	public void getByIdAcquirenteTest(){
		
		int acquirenteID = 1;
	
java.util.List<Prenotazione> prenotazioni = new ArrayList<Prenotazione>();
		
		when(prenotazioneServiceMock.getByIdAcquirente(acquirenteID)).thenReturn(prenotazioni);
		
		prenotazioni = prenotazioneServiceMock.getByIdAcquirente(acquirenteID);
		
		assertThat(prenotazioni.size()).isNotNegative();
		
		
	
	}
	
	
	
	@Test
	public void getByIdPropostaTest(){
		
		int propostaID = 1;
	
java.util.List<Prenotazione> prenotazioni = new ArrayList<Prenotazione>();
		
		when(prenotazioneServiceMock.getByIdProposta(propostaID)).thenReturn(prenotazioni);
		
		prenotazioni = prenotazioneServiceMock.getByIdProposta(propostaID);
		
		assertThat(prenotazioni.size()).isNotNegative();
		
		
	
	}











////////////////

/*@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class PrenotazioneServiceUnitTest {

	@Mock 
	private PrenotazioneService prenotazioneServiceMock;
	
	private Prenotazione prenotazione;
	
	@BeforeEach
	private void setUp() { 

		prenotazione = new Prenotazione();
		Servizio servizio_prova = new Servizio();
		servizio_prova.setAmministratore(new Amministratore());
		
		
		Pagamento pagamento_prova = new Pagamento();
		prenotazione.setPagamento(pagamento_prova);
		Proposta proposta_prova = new Proposta();
		proposta_prova.setServizio(servizio_prova);
		proposta_prova.setUtenteProponente(new UtenteProponente());
		proposta_prova.setDatainserimento(Timestamp.valueOf("2019-08-12 10:10:10.0"));
		prenotazione.setProposta(proposta_prova);
		UtenteAcquirente acquirente_prova = new UtenteAcquirente();
		prenotazione.setUtenteAcquirente(acquirente_prova);
		
		
	}
	

	
	
		
	}
	
	
	@Test
	public void findByUtenteAcquirenteQueryTest(){
		int id=1;
		List<Prenotazione> prenotazioni = new ArrayList<Prenotazione>();
		when(prenotazioneServiceMock.findByUtenteAcquirenteQuery(id)).thenReturn(prenotazioni);
		prenotazioni = prenotazioneServiceMock.findByUtenteAcquirenteQuery(id);
		
		assertThat(prenotazioni.size()).isNotNegative();
		
		
	}
*/
	
	
	
	
	
	
	
	
	
	
}
