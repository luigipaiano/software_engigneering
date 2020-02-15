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

import it.unisalento.myairbnb.entities.Admin;
import it.unisalento.myairbnb.entities.Beneservizio;
import it.unisalento.myairbnb.entities.Utente;
import it.unisalento.myairbnb.restcontrollers.AdminRestController;
import it.unisalento.myairbnb.restcontrollers.BeneservizioRestController;
import it.unisalento.myairbnb.service.AdminService;
import it.unisalento.myairbnb.service.BeneservizioService;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = AdminRestController.class)
class AdminRestControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	
	@MockBean
	private AdminService adminServicemock;
	
	
	@Autowired
	private ObjectMapper objectMapper;
	
	Admin admin;
	
	@BeforeEach
	private void setUp() {
		
        admin = new Admin();
        //u.setIdutente(1); non va fatto il set dell'id perché è autoincroment
        Utente utente;
        utente = new Utente();
       
        admin.setUtente(utente);
        utente.setNome("nomep");
        
	}
	
	

	@Test
	public void saveReturnOk() throws JsonProcessingException, Exception {
		
		
		mockMvc.perform(MockMvcRequestBuilders.post("admin/save")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(admin)))
				.andExpect(status().isOk());
		
	}
	
	@Test
	public void postOtuputResultOkTest() throws JsonProcessingException, Exception {
		
		MvcResult result = mockMvc.perform(post("/admin/save")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(admin)))
				.andReturn();
		
		String responseBody = result.getResponse().getContentAsString();
		
	Admin adminReturned = objectMapper.readValue(responseBody, Admin.class);
		
		assertThat(admin.getUtente().getNome().compareTo(adminReturned.getUtente().getNome()));
		
		
	}
	
	
	
	
	@Test
	public void getByIdAdminReturnOkTest() throws Exception {
		
		mockMvc.perform(get("/admin/getByIdAdmin/1")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
	
	}
	
	
	
	
	
	@Test
	public void getAllReturnOkTest() throws Exception {
		
		mockMvc.perform(get("/admin/getAll")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
	
	}
	
	
	
	
	@Test
	public void getByUsernameandPasswordReturnOkTest() throws Exception {
		
		mockMvc.perform(get("/admin/getByUsernamenandPassword/andrea/password")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
	
	}
	
	
	
}
