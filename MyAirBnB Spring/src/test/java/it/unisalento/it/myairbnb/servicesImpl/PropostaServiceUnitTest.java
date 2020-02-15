package it.unisalento.it.myairbnb.servicesImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import it.unisalento.myairbnb.entities.Beneservizio;
import it.unisalento.myairbnb.entities.Proponente;
import it.unisalento.myairbnb.entities.Proposta;
import it.unisalento.myairbnb.entities.Utente;
import it.unisalento.myairbnb.exceptions.PropostaNotFoundException;
import it.unisalento.myairbnb.exceptions.UtenteNotFoundException;
import it.unisalento.myairbnb.repositories.PropostaRepository;
import it.unisalento.myairbnb.service.PropostaService;
import it.unisalento.myairbnb.service.UtenteService;
import it.unisalento.myairbnb.serviceimpl.PropostaServiceImpl;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = PropostaService.class)



class PropostaServiceUnitTest {

	
	@Mock
	private PropostaRepository repo;
	
	@InjectMocks
	private PropostaServiceImpl propostaServiceMock;
	
	private Proposta proposta;
	
	
	
	@BeforeEach
	private void setUp() {
		
        proposta = new Proposta();
       
        BigDecimal n1 = new BigDecimal("1000.123482248908085303458975309348");
        
        
        proposta.setDescrizione("descrizione_prova");
        proposta.setNome("nome_prova");
        proposta.setDisponibilita(5);
        proposta.setCostounitario(n1);
        proposta.setPosizione("posizioneFake");
        proposta.setStato(1);
        
        Beneservizio beneservizio = new Beneservizio();
        Proponente proponente = new Proponente();
	}
	
	
	
	
	@Test
	public void savePropostaTest() {
			
		when(repo.save(proposta)).thenReturn(proposta);
		
		int id = propostaServiceMock.saveorUpdate(proposta).getIdproposta();
		
		assertThat(id).isNotNull();
		
	}
	
	
	@Test
	public void getByIdTest() throws PropostaNotFoundException {
		int id=1;
		when(repo.findById(id)).thenReturn(Optional.of(proposta));
		Proposta p = propostaServiceMock.getById(id);
		
		assertThat(p.getCostounitario()).isNotNull();
	
	
}
	
	@Test
	public void getAllTest(){
		
		java.util.List<Proposta> proposte = new ArrayList<Proposta>();
		
		when(repo.findAll()).thenReturn(proposte);
		
		proposte = propostaServiceMock.getAll();
		
		assertThat(proposte.size()).isNotNegative();
		
		
	}
	
	
	@Test
	public void getByIdBeneServizioTest(){
		
		int beneservizioID = 1;
		
		java.util.List<Proposta> proposte = new ArrayList<Proposta>();
		
	when(repo.findByIdBeneServizio(beneservizioID)).thenReturn(proposte);
		
		proposte = propostaServiceMock.getByIdBeneServizio(beneservizioID);
		
		assertThat(proposte.size()).isNotNegative();
		
		
		
	}
	
	
	@Test
	public void getByIdProponenteTest(){
		
		int proponenteID = 1;
		
		java.util.List<Proposta> proposte = new ArrayList<Proposta>();
		
	when(repo.findByIdProponente(proponenteID)).thenReturn(proposte);
		
		proposte = propostaServiceMock.getByIdProponente(proponenteID);
		
		assertThat(proposte.size()).isNotNegative();
		
	}

	
	
	@Test
	public void getByApprovedTest(){
		
		java.util.List<Proposta> proposte = new ArrayList<Proposta>();
		
		when(repo.findByApproved()).thenReturn(proposte);
		
		proposte = propostaServiceMock.getByApproved();
		
		assertThat(proposte.size()).isNotNegative();
		
		
	}
	
	
	
	
	@Test
	public void getByNonApprovedTest(){
		
		java.util.List<Proposta> proposte = new ArrayList<Proposta>();
		
		when(repo.findByNonApproved()).thenReturn(proposte);
		
		proposte = propostaServiceMock.getByNonApproved();
		
		assertThat(proposte.size()).isNotNegative();
		
		
	}
	
	
	
	
}
