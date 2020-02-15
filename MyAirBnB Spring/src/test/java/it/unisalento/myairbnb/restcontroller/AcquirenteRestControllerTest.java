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
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.unisalento.myairbnb.entities.Acquirente;
import it.unisalento.myairbnb.entities.Admin;
import it.unisalento.myairbnb.entities.Utente;
import it.unisalento.myairbnb.restcontrollers.AcquirenteRestController;
import it.unisalento.myairbnb.restcontrollers.AdminRestController;
import it.unisalento.myairbnb.service.AcquirenteService;
import it.unisalento.myairbnb.service.AdminService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = AcquirenteRestController.class)
class AcquirenteRestControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	
	@MockBean
	private AcquirenteService acquirenteServicemock;
	
	
	@Autowired
	private ObjectMapper objectMapper;
	
	Acquirente acquirente;
	
	
	@BeforeEach
	private void setUp() {
		
        acquirente = new Acquirente();
        //u.setIdutente(1); non va fatto il set dell'id perché è autoincroment
      
        acquirente.setCap("5434");
        acquirente.setCitta("Verona");
        
	}
	
	
	@Test
	public void saveReturnOk() throws JsonProcessingException, Exception {
		
		
		mockMvc.perform(MockMvcRequestBuilders.post("acquirente/save")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(acquirente)))
				.andExpect(status().isOk());
		
	}
	
	@Test
	public void postOtuputResultOkTest() throws JsonProcessingException, Exception {
		
		MvcResult result = mockMvc.perform(post("/acquirente/save")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(acquirente)))
				.andReturn();
		
		String responseBody = result.getResponse().getContentAsString();
		
	Acquirente acquirenteReturned = objectMapper.readValue(responseBody, Acquirente.class);
		
		assertThat(acquirente.getTelefono().compareTo(acquirenteReturned.getTelefono()));
		
		
	}
	
	
	
	
	
	@Test
	public void getByIdAcquirenteReturnOkTest() throws Exception {
		
		mockMvc.perform(get("/acquirente/getByIdAcquirente/1")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
	
	}

	
	
	

	
	@Test
	public void getAllReturnOkTest() throws Exception {
		
		mockMvc.perform(get("/acquirente/getAll")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
	
	}
	
	
	
	@Test
	public void getByUsernameandPasswordReturnOkTest() throws Exception {
		
		mockMvc.perform(get("/acquirente/getByUsernamenandPassword/valeria/password4")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
	
	}
	
	
	
}
