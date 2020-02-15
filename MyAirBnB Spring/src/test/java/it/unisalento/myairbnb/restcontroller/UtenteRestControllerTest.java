package it.unisalento.myairbnb.restcontroller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
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

import it.unisalento.myairbnb.entities.Utente;
import it.unisalento.myairbnb.restcontrollers.UtenteRestController;
import it.unisalento.myairbnb.service.UtenteService;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = UtenteRestController.class)
class UtenteRestControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	
	@MockBean
	private UtenteService utenteServicemock;
	
	
	@Autowired
	private ObjectMapper objectMapper;
	
	Utente utente;
	
	
	@BeforeEach
	private void setUp() {
		
        utente = new Utente();
        //u.setIdutente(1); non va fatto il set dell'id perché è autoincroment
        utente.setNome("Mario");
        utente.setCognome("Rossi");
        utente.setUsername("mariorossi");
        utente.setPassword("ciaociao");
        utente.setEmail("mariorossi@gmail.com");
       
        
	}
	
	
	
	@Test
	public void getByIdReturnOkTest() throws Exception {
		
		mockMvc.perform(get("/utente/getByIdUtente/1")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
		
		
		
	}
	
	@Test
	public void saveReturnOk() throws JsonProcessingException, Exception {
		
		
		mockMvc.perform(MockMvcRequestBuilders.post("/utente/save")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(utente)))
				.andExpect(status().isOk());
		
	}
	
	@Test
	public void postOtuputResultOkTest() throws JsonProcessingException, Exception {
		
		MvcResult result = mockMvc.perform(post("/utente/save")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(utente)))
				.andReturn();
		
		String responseBody = result.getResponse().getContentAsString();
		
		Utente utenteReturned = objectMapper.readValue(responseBody, Utente.class);
		
		assertThat(utente.getNome().compareTo(utenteReturned.getNome()));
		
		
	}
	
	
	@Test
	public void updateReturnOkTest() throws JsonProcessingException, Exception {
		
		mockMvc.perform(put("utente/update")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(utente)))
				.andExpect(status().isOk());
		
		
		
	}
	
	
	

	@Test
	public void getAllReturnOkTest() throws Exception {
		
		mockMvc.perform(get("/utente/getAll")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
	
	}
		
	@Test
	public void getbyUsernameandPasswordReturnOkTest() throws Exception {
			
			mockMvc.perform(get("/utente/getbyUssernameandPassword/gigi/password2")
					.contentType(MediaType.APPLICATION_JSON_VALUE))
					.andExpect(status().isOk());
			
			
		
		
	}
	
	
	
	@Test
	public void DeleteUserTest() throws Exception {
	    this.mockMvc.perform(MockMvcRequestBuilders
	            .delete("/utente/1")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk());
	}
	
	
	
	
	
	
	

}
