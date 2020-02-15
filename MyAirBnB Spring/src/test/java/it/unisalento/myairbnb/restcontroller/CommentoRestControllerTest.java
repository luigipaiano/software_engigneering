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

import it.unisalento.myairbnb.entities.Commento;
import it.unisalento.myairbnb.entities.Immagine;
import it.unisalento.myairbnb.restcontrollers.CommentoRestController;
import it.unisalento.myairbnb.restcontrollers.ImmagineRestController;
import it.unisalento.myairbnb.service.CommentoService;
import it.unisalento.myairbnb.service.ImmagineService;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = CommentoRestController.class)
public class CommentoRestControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	
	@MockBean
	private CommentoService commentoServicemock;
	
	
	@Autowired
	private ObjectMapper objectMapper;
	
	Commento commento;
	
	
	@BeforeEach
	private void setUp() {
		
        commento = new Commento();
        //u.setIdutente(1); non va fatto il set dell'id perché è autoincroment
        
        commento.setDescrizione("descrizione_prova");
        commento.setTipo(4);
	}
	
	
	
	@Test
	public void getAllReturnOkTest() throws Exception {
		
		mockMvc.perform(get("/commento/getAll")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
	
	}
	
	
	
	@Test
	public void getByIdAcquirenteReturnOkTest() throws Exception {
		
		mockMvc.perform(get("/commento/getByIdAcquirente/1")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
	
	}
	
	
	
	
	@Test
	public void getByIdPropostaReturnOkTest() throws Exception {
		
		mockMvc.perform(get("/commento/getByIdProposta/1")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
	
	}
	
	
	
	@Test
	public void saveReturnOk() throws JsonProcessingException, Exception {
		
		
		mockMvc.perform(MockMvcRequestBuilders.post("/commento/save")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(commento)))
				.andExpect(status().isOk());
		
	}
	
	@Test
	public void postOtuputResultOkTest() throws JsonProcessingException, Exception {
		
		MvcResult result = mockMvc.perform(post("/commento/save")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(commento)))
				.andReturn();
		
		String responseBody = result.getResponse().getContentAsString();
		
	Commento commentoReturned = objectMapper.readValue(responseBody, Commento.class);
		
		assertThat(commento.getDescrizione().compareTo(commentoReturned.getDescrizione()));
		
		
	}
	
	
	
	
	@Test
	public void updateReturnOkTest() throws JsonProcessingException, Exception {
		
		mockMvc.perform(put("commmento/update")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(commento)))
				.andExpect(status().isOk());
		
		
		
	}
	
	
	
	
	@Test
	public void DeleteCommentoTest() throws Exception {
	    this.mockMvc.perform(MockMvcRequestBuilders
	            .delete("/commento/delete/1")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk());
	}
	
	
	
	
	
	

	@Test
	public void getByIdCommentoReturnOkTest() throws Exception {
		
		mockMvc.perform(get("/commento/getByIdCommento/1")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
		
		
		
	}
	
	
	
	@Test
	public void DeleteByIdCommentoTest() throws Exception {
	    this.mockMvc.perform(MockMvcRequestBuilders
	            .delete("/commento/cancellabyidproposta/1")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk());
	}
	
	
	
	
	
	

	
	
	
	
	

}
