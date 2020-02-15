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
import it.unisalento.myairbnb.entities.Beneservizio;
import it.unisalento.myairbnb.entities.Commento;
import it.unisalento.myairbnb.entities.Immagine;
import it.unisalento.myairbnb.entities.Proposta;
import it.unisalento.myairbnb.entities.Utente;
import it.unisalento.myairbnb.exceptions.BeneservizioNotFoundException;
import it.unisalento.myairbnb.exceptions.CommentoNotFoundException;
import it.unisalento.myairbnb.service.AcquirenteService;
import it.unisalento.myairbnb.service.CommentoService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = CommentoService.class)

class CommentoServiceUnitTest {
	
	@Mock
	private CommentoService commentoServiceMock;
	private Commento commento;

		
	@BeforeEach
	private void setUp() {
		
        commento = new Commento();
        
        commento.setTipo(1);
        commento.setDescrizione("descrizione_prova");
    
        Acquirente acquirente = new Acquirente();
        Proposta proposta = new Proposta();
	}
	
	
	
	@Test
	public void saveAcquirenteTest() {
			
		when(commentoServiceMock.saveorUpdate(commento)).thenReturn(commento);
		
		int id = commentoServiceMock.saveorUpdate(commento).getIdcommento();
		
		assertThat(id).isNotNull();
		
	}
	
	
	
	@Test
	public void getByIdTest() throws CommentoNotFoundException {
		int id=1;
		when(commentoServiceMock.getById(id)).thenReturn(commento);
		Commento c = commentoServiceMock.getById(id);
		
		assertThat(c.getTipo()).isNotNull();
		
		
}

	
	@Test
	public void getAllTest(){
		
		java.util.List<Commento> commenti = new ArrayList<Commento>();
		
		when(commentoServiceMock.getAll()).thenReturn(commenti);
		
		commenti = commentoServiceMock.getAll();
		
		assertThat(commenti.size()).isNotNegative();
		
		
	}
	
	@Test
	public void getByIdAcquirenteTest(){
		
		int acquirenteID = 1;
		
		java.util.List<Commento> commenti = new ArrayList<Commento>();
		
		when(commentoServiceMock.getByIdAcquirente(acquirenteID)).thenReturn(commenti);
		
		commenti = commentoServiceMock.getByIdAcquirente(acquirenteID);
		
		assertThat(commenti.size()).isNotNegative();
		
		
	}
	
	
	@Test
	public void getByIdPropostaTest(){
		
		int propostaID = 1;
		
		java.util.List<Commento> commenti = new ArrayList<Commento>();
		
		when(commentoServiceMock.getByIdProposta(propostaID)).thenReturn(commenti);
		
		commenti = commentoServiceMock.getByIdProposta(propostaID);
		
		assertThat(commenti.size()).isNotNegative();
		
		
	}
	

	
}



//////


	
	
	
	
	
		
	
	