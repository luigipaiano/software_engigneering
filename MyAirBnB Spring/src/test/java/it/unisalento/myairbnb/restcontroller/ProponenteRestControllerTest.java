package it.unisalento.myairbnb.restcontroller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.unisalento.myairbnb.dto.ProponenteDTO;
import it.unisalento.myairbnb.dto.UtenteDTO;
import it.unisalento.myairbnb.entities.Proponente;
import it.unisalento.myairbnb.entities.Proposta;
import it.unisalento.myairbnb.entities.Utente;
import it.unisalento.myairbnb.restcontrollers.ProponenteRestController;
import it.unisalento.myairbnb.restcontrollers.UtenteRestController;
import it.unisalento.myairbnb.service.ProponenteService;
import it.unisalento.myairbnb.service.PropostaService;
import it.unisalento.myairbnb.service.UtenteService;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ProponenteRestController.class)
public class ProponenteRestControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	
	@MockBean
	private ProponenteService proponenteServicemock;
	
	
	@Autowired
	private ObjectMapper objectMapper;
	
	ProponenteDTO proponente;
	
	
	
	
	@BeforeEach
	private void setUp() {
		
        proponente = new ProponenteDTO();
        proponente.setUtente(new UtenteDTO());
        //u.setIdutente(1); non va fatto il set dell'id perché è autoincroment
        proponente.setTelefono("43453564");
        proponente.setCap("45654");
        
	}
	
	
	
	
	@Test
	public void saveReturnOk() throws JsonProcessingException, Exception {
		
		
		mockMvc.perform(MockMvcRequestBuilders.post("/proponente/save")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(proponente)))
				.andExpect(status().isOk());
		
	}
	
	/*@Test
	public void postOtuputResultOkTest() throws  Exception {
		
		MvcResult result = mockMvc.perform(post("/proponente/save")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(proponente)))
				.andReturn();
		
		String responseBody = result.getResponse().getContentAsString();
		
		Proponente proponenteReturned = objectMapper.readValue(responseBody, Proponente.class);
		
		assertThat(proponente.getIndirizzo().compareTo(proponenteReturned.getIndirizzo()));
		
		
	}*/
	
	
	
	
	@Test
	public void getByIdPronenteReturnOkTest() throws Exception {
			
			mockMvc.perform(get("/proponente/getByIdProponente/2")
					.contentType(MediaType.APPLICATION_JSON_VALUE))
					.andExpect(status().isOk());
			
			
		
		
	}
	
	
	
	@Test
	public void getAllReturnOkTest() throws Exception {
			
			mockMvc.perform(get("/proponente/getAll")
					.contentType(MediaType.APPLICATION_JSON_VALUE))
					.andExpect(status().isOk());
			
			
		
		
	}
	
	
	
	@Test
	public void getByUsernameandPasswordReturnOkTest() throws Exception {
			
			mockMvc.perform(get("/proponente/getByUsernameandPassword/giulia2/password3")
					.contentType(MediaType.APPLICATION_JSON_VALUE))
					.andExpect(status().isOk());

			

			
		
		
	}
	
	
	
	
	
	
	
	
}
