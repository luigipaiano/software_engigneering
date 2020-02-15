package it.unisalento.myairbnb.restcontroller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import it.unisalento.myairbnb.entities.Proposta;
import it.unisalento.myairbnb.entities.Utente;
import it.unisalento.myairbnb.restcontrollers.PropostaRestController;
import it.unisalento.myairbnb.restcontrollers.UtenteRestController;
import it.unisalento.myairbnb.service.PropostaService;
import it.unisalento.myairbnb.service.UtenteService;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = PropostaRestController.class)
class PropostaRestControllerTest {


	@Autowired
	private MockMvc mockMvc;
	
	
	@MockBean
	private PropostaService propostaServicemock;
	
	
	@Autowired
	private ObjectMapper objectMapper;
	
	Proposta proposta;
	
	
	
	@BeforeEach
	private void setUp() {
		
        proposta = new Proposta();
        //u.setIdutente(1); non va fatto il set dell'id perché è autoincroment
        proposta.setNome("proposta-prova");
        proposta.setDescrizione("descrizioneprova");
       
        
	}
	
	
	
	@Test
	public void getByIdBeneservizioReturnOkTest() throws Exception {
		
		mockMvc.perform(get("/proposta/getByIdBeneservizio/1")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
		
		
		
	}
	
	
	
	@Test
	public void getByIdProponenteOkTest() throws Exception {
		
		mockMvc.perform(get("/proposta/getByIdProponente/1")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
		
		
		
	}
	
	
	
	@Test
	public void saveReturnOk() throws JsonProcessingException, Exception {
		
		
		mockMvc.perform(MockMvcRequestBuilders.post("/proposta/save")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(proposta)))
				.andExpect(status().isOk());
		
	}
	
	@Test
	public void postOtuputResultOkTest() throws JsonProcessingException, Exception {
		
		MvcResult result = mockMvc.perform(post("/proposta/save")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(proposta)))
				.andReturn();
		
		String responseBody = result.getResponse().getContentAsString();
		
		Proposta propostaReturned = objectMapper.readValue(responseBody, Proposta.class);
		
		assertThat(proposta.getNome().compareTo(propostaReturned.getNome()));
		
		
	}
	
	
	
	
	@Test
	public void updateReturnOkTest() throws JsonProcessingException, Exception {
		
		mockMvc.perform(put("proposta/update")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(proposta)))
				.andExpect(status().isOk());
		
		
		
	}
	
	
	
	
	
	@Test
	public void DeleteUserTest() throws Exception {
	    this.mockMvc.perform(MockMvcRequestBuilders
	            .delete("/proposta/1")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk());
	}
	
	
	
	@Test
	public void getByIdPropostaReturnOkTest() throws Exception {
			
			mockMvc.perform(get("/proposta/getByIdProposta/2")
					.contentType(MediaType.APPLICATION_JSON_VALUE))
					.andExpect(status().isOk());
			
			
		
		
	}
	
	
	
	
	
	@Test
	public void getByNonApprovedReturnOkTest() throws Exception {
			
			mockMvc.perform(get("/proposta/getByNonApproved")
					.contentType(MediaType.APPLICATION_JSON_VALUE))
					.andExpect(status().isOk());
			
			
		
		
	}
	
	
	
	
	@Test
	public void getByApprovedReturnOkTest() throws Exception {
			
			mockMvc.perform(get("/proposta/getByApproved")
					.contentType(MediaType.APPLICATION_JSON_VALUE))
					.andExpect(status().isOk());
			
			
		
		
	}
	
	
	
	
	
	@Test
	public void approvapropostaReturnOkTest() throws JsonProcessingException, Exception {
		
		mockMvc.perform(put("proposta/approvaproposta/1")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(proposta)))
				.andExpect(status().isOk());
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
