package it.unisalento.it.myairbnb.servicesImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import it.unisalento.myairbnb.entities.Acquirente;
import it.unisalento.myairbnb.entities.Immagine;
import it.unisalento.myairbnb.entities.Pagamento;
import it.unisalento.myairbnb.entities.Prenotazione;
import it.unisalento.myairbnb.entities.Utente;
import it.unisalento.myairbnb.exceptions.ImmagineNotFoundException;
import it.unisalento.myairbnb.exceptions.PagamentoNotFoundException;
import it.unisalento.myairbnb.service.PagamentoService;
import it.unisalento.myairbnb.service.UtenteService;


@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = PagamentoService.class)


class PagamentoServiceUnitTest {
	
	
	@Mock
	private PagamentoService pagamentoServiceMock;
	private Pagamento pagamento;
	
	
	
	@BeforeEach
	private void setUp() {
		
        pagamento = new Pagamento();
        
    
        
       // pagamento.setImporto(43.67);
        pagamento.setMetodo("metodo_prova");
    
        Acquirente acquirente = new Acquirente();
     
	}
	
	

	@Test
	public void savePagamentoTest() {
			
		when(pagamentoServiceMock.saveorUpdate(pagamento)).thenReturn(pagamento);
		
		int id = pagamentoServiceMock.saveorUpdate(pagamento).getIdpagamento();
		
		assertThat(id).isNotNull();
		
	}
	


	@Test
	public void getByIdTest() throws PagamentoNotFoundException {
		int id=1;
		when(pagamentoServiceMock.getById(id)).thenReturn(pagamento);
		Pagamento p = pagamentoServiceMock.getById(id);
		
		assertThat(p.getImporto()).isNotNull();
	
	
}
	
	
	
	@Test
	public void getAllTest(){
		
		java.util.List<Pagamento> pagamenti = new ArrayList<Pagamento>();
		
		when(pagamentoServiceMock.getAll()).thenReturn(pagamenti);
		
		pagamenti = pagamentoServiceMock.getAll();
		
		assertThat(pagamenti.size()).isNotNegative();
		
		
	}
	
}
