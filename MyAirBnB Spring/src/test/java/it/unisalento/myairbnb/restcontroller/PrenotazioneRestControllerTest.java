package it.unisalento.myairbnb.restcontroller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.math.MathContext;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.unisalento.myairbnb.entities.Acquirente;
import it.unisalento.myairbnb.entities.Prenotazione;
import it.unisalento.myairbnb.entities.Utente;
import it.unisalento.myairbnb.restcontrollers.PrenotazioneRestController;
import it.unisalento.myairbnb.restcontrollers.ProponenteRestController;
import it.unisalento.myairbnb.service.PrenotazioneService;
import it.unisalento.myairbnb.service.UtenteService;



@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = PrenotazioneRestController.class)
class PrenotazioneRestControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	
	@MockBean
	private PrenotazioneService prenotazioneServicemock;
	
	
	@Autowired
	private ObjectMapper objectMapper;
	
	Prenotazione prenotazione;
	
	
	@BeforeEach
	private void setUp() {
		
        prenotazione = new Prenotazione();
        //u.setIdutente(1); non va fatto il set dell'id perché è autoincroment
        Acquirente nAcquirente;
        nAcquirente = new Acquirente();
       prenotazione.setAcquirente(nAcquirente);
    
       double d = 7456456.49586;
       BigDecimal bigDecimal = new BigDecimal(d, new MathContext(1));
       d = bigDecimal.doubleValue();
       
       prenotazione.setCostotot(bigDecimal);
       
        
	}
	
	
	@Test
	public void getAllReturnOkTest() throws Exception {
		
		mockMvc.perform(get("/prenotazione/getAll")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
	
	}
	
	
	
	
	@Test
	public void getByIdAcquirenteReturnOkTest() throws Exception {
		
		mockMvc.perform(get("/prenotazione/getByIdAcquirente/1")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
		
		
		
	}
	
	
	
	
	
	@Test
	public void getByIdPropostaOkTest() throws Exception {
		
		mockMvc.perform(get("/prenotazione/getByIdProposta/1")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
		
		
		
	}
	
	
	
	
	
	
	@Test
	public void saveReturnOk() throws JsonProcessingException, Exception {
		
		
		mockMvc.perform(MockMvcRequestBuilders.post("/prenotazione/save")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(prenotazione)))
				.andExpect(status().isOk());
		
	}
	
	@Test
	public void postOtuputResultOkTest() throws JsonProcessingException, Exception {
		
		MvcResult result = mockMvc.perform(post("/prenotazione/save")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(prenotazione)))
				.andReturn();
		
		String responseBody = result.getResponse().getContentAsString();
		
		Prenotazione prenotazioneReturned = objectMapper.readValue(responseBody, Prenotazione.class);
		
		assertThat(prenotazione.getCostotot().compareTo(prenotazioneReturned.getCostotot()));
		
		
	}
	
	
	
	
	
	
	@Test
	public void updateReturnOkTest() throws JsonProcessingException, Exception {
		
		mockMvc.perform(put("prenotazione/update")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(prenotazione)))
				.andExpect(status().isOk());
		
		
		
	}
	
	
	
	@Test
	public void DeletePrenotazioneTest() throws Exception {
	    this.mockMvc.perform(MockMvcRequestBuilders
	            .delete("/prenotazione/1")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
