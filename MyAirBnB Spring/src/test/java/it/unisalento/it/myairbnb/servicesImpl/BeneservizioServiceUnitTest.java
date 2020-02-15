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
import it.unisalento.myairbnb.entities.Beneservizio;
import it.unisalento.myairbnb.entities.Commento;
import it.unisalento.myairbnb.entities.Utente;
import it.unisalento.myairbnb.exceptions.AdminNotFoundException;
import it.unisalento.myairbnb.exceptions.BeneservizioNotFoundException;
import it.unisalento.myairbnb.service.AcquirenteService;
import it.unisalento.myairbnb.service.BeneservizioService;


@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = BeneservizioService.class)

class BeneservizioServiceUnitTest {


	@Mock
	private BeneservizioService beneservizioServiceMock;
	private Beneservizio beneservizio;
	
	
	@BeforeEach
	private void setUp() {
		
        beneservizio = new Beneservizio();
        
        beneservizio.setDescrizione("descrizione_prova");
    	beneservizio.setCategoria("categoria_prova");
    	
       
	}
	
	
	
	
	@Test
	void saveBeneseriziotest() {
		
        when(beneservizioServiceMock.saveorUpdate(beneservizio)).thenReturn(beneservizio);
		
		int id = beneservizioServiceMock.saveorUpdate(beneservizio).getIdbeneservizio();
		
		assertThat(id).isNotNull();
		
		
	}
	
	
	@Test
	public void getByIdTest() throws BeneservizioNotFoundException {
		int id=1;
		when(beneservizioServiceMock.getById(id)).thenReturn(beneservizio);
		Beneservizio b = beneservizioServiceMock.getById(id);
		
		assertThat(b.getCategoria()).isNotNull();
		
		
	}
	
	
	
	@Test
	public void getAllTest(){
		
		java.util.List<Beneservizio> beneservizi = new ArrayList<Beneservizio>();
		
		when(beneservizioServiceMock.getAll()).thenReturn(beneservizi);
		
		beneservizi = beneservizioServiceMock.getAll();
		
		assertThat(beneservizi.size()).isNotNegative();
		
		
	}
	
	
	
	@Test
	public void getByCategoriaTest(){
		
		java.util.List<Beneservizio> beneservizi = new ArrayList<Beneservizio>();
		
		String categoriaPR = "escursione";
		
		when(beneservizioServiceMock.getByCategoria(categoriaPR)).thenReturn(beneservizi);
		
		beneservizi = beneservizioServiceMock.getByCategoria(categoriaPR);
		
		assertThat(beneservizi.size()).isNotNegative();
		
		
	}

}

//////


	