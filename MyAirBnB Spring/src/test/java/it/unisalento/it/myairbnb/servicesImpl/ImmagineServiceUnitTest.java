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
import it.unisalento.myairbnb.entities.Admin;
import it.unisalento.myairbnb.entities.Commento;
import it.unisalento.myairbnb.entities.Immagine;
import it.unisalento.myairbnb.entities.Prenotazione;
import it.unisalento.myairbnb.entities.Proposta;
import it.unisalento.myairbnb.entities.Utente;
import it.unisalento.myairbnb.exceptions.AdminNotFoundException;
import it.unisalento.myairbnb.exceptions.CommentoNotFoundException;
import it.unisalento.myairbnb.exceptions.ImmagineNotFoundException;
import it.unisalento.myairbnb.service.CommentoService;
import it.unisalento.myairbnb.service.ImmagineService;

@SpringBootTest(classes = ImmagineService.class)
@ExtendWith(MockitoExtension.class)

class ImmagineServiceUnitTest {
	
	@Mock
	private ImmagineService immagineServiceMock;
	private Immagine immagine;

	@BeforeEach
	private void setUp() {
		
        immagine = new Immagine();
        
        immagine.setPercorso("prova_percorso");

        Proposta proposta = new Proposta();
	}
	
	
	@Test
	public void saveImmagineTest() {
			
		when(immagineServiceMock.saveorUpdate(immagine)).thenReturn(immagine);
		
		int id = immagineServiceMock.saveorUpdate(immagine).getIdimmagine();
		
		assertThat(id).isNotNull();
		
	}
	
	
	@Test
	public void getByIdTest() throws ImmagineNotFoundException {
		int id=1;
		when(immagineServiceMock.getById(id)).thenReturn(immagine);
		Immagine i = immagineServiceMock.getById(id);
		
		assertThat(i.getPercorso()).isNotNull();
		
		
}
	
	
/*	@Test
	public void getByIdPropostaTest() throws ImmagineNotFoundException{
		
		int idProposta = 1;
		
		when(immagineServiceMock.getByIdProposta(idProposta)).thenReturn(immagine);
		
		Immagine i = immagineServiceMock.getByIdProposta(idProposta);
		
		 
		assertEquals("prova_percorso",i.getPercorso());
		
		
		
	}
	*/
	
	
	
	@Test
	public void getAllTest(){
		
		java.util.List<Immagine> immagini = new ArrayList<Immagine>();
		
		when(immagineServiceMock.getAll()).thenReturn(immagini);
		
		immagini = immagineServiceMock.getAll();
		
		assertThat(immagini.size()).isNotNegative();
		
		
	}
	
	
	
}

//

	
	

		
	
	
	
	
	

