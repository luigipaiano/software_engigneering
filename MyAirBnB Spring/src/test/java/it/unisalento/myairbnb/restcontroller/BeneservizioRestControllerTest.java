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

import it.unisalento.myairbnb.entities.Beneservizio;
import it.unisalento.myairbnb.entities.Commento;
import it.unisalento.myairbnb.restcontrollers.BeneservizioRestController;
import it.unisalento.myairbnb.restcontrollers.CommentoRestController;
import it.unisalento.myairbnb.service.BeneservizioService;
import it.unisalento.myairbnb.service.CommentoService;
import it.unisalento.myairbnb.service.ProponenteService;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = BeneservizioService.class)
class BeneservizioRestControllerTest {

	@Autowired
	private MockMvc mockMvc;
	

	@MockBean
	private BeneservizioService beneservizioService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	Beneservizio beneservizio;
	
	@BeforeEach
	private void setUp() {
		
        beneservizio = new Beneservizio();
        beneservizio.setCategoria("cat_prova");
        beneservizio.setDescrizione("descr_prova");
	}
	
	
	@Test
	public void getAllReturnOkTest() throws Exception {
		
		mockMvc.perform(get("/beneservizio/getAll")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
	
	}
	
	
	@Test
	public void getByCategoriaReturnOkTest() throws Exception {
		
		mockMvc.perform(get("/beneservizio/getByCategoria/appartamenti")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
	
	}
	
	
	
	@Test
	public void saveReturnOk() throws JsonProcessingException, Exception {
		
		
		mockMvc.perform(MockMvcRequestBuilders.post("beneservizio/save")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(beneservizio)))
				.andExpect(status().isOk());
		
	}
	
	@Test
	public void postOtuputResultOkTest() throws JsonProcessingException, Exception {
		
		MvcResult result = mockMvc.perform(post("/beneservizio/save")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(beneservizio)))
				.andReturn();
		
		String responseBody = result.getResponse().getContentAsString();
		
	Beneservizio beneservizioReturned = objectMapper.readValue(responseBody, Beneservizio.class);
		
		assertThat(beneservizio.getDescrizione().compareTo(beneservizioReturned.getDescrizione()));
		
		
	}
	
	
	
	
	@Test
	public void updateReturnOkTest() throws JsonProcessingException, Exception {
		
		mockMvc.perform(put("beneservizio/update")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(beneservizio)))
				.andExpect(status().isOk());
		
		
		
	}
	
	
	
	@Test
	public void DeleteBeneservizioTest() throws Exception {
	    this.mockMvc.perform(MockMvcRequestBuilders
	            .delete("/beneservizio/delete/1")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk());
	}
	
	
	
	
	
}
