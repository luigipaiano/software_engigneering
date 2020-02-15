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

import it.unisalento.myairbnb.entities.Immagine;
import it.unisalento.myairbnb.entities.Pagamento;
import it.unisalento.myairbnb.restcontrollers.ImmagineRestController;
import it.unisalento.myairbnb.restcontrollers.PagamentoRestController;
import it.unisalento.myairbnb.service.ImmagineService;
import it.unisalento.myairbnb.service.PagamentoService;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ImmagineRestController.class)
class ImmagineRestControllerTest {

	
	@Autowired
	private MockMvc mockMvc;
	
	
	@MockBean
	private ImmagineService immagineServicemock;
	
	
	@Autowired
	private ObjectMapper objectMapper;
	
	Immagine immagine;
	
	
	@BeforeEach
	private void setUp() {
		
        immagine = new Immagine();
        //u.setIdutente(1); non va fatto il set dell'id perché è autoincroment
        immagine.setPercorso("percorso_prova");
        
        
	}
	
	
	
	@Test
	public void getAllReturnOkTest() throws Exception {
		
		mockMvc.perform(get("/immagine/getAll")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
	
	}
	
	
	
	
	@Test
	public void getImmagineByIdPropostaReturnOkTest() throws Exception {
		
		mockMvc.perform(get("/immagine/getImmagineByIdProposta/1")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
		
		
		
	}
	
	
	
	
	@Test
	public void saveReturnOk() throws JsonProcessingException, Exception {
		
		
		mockMvc.perform(MockMvcRequestBuilders.post("/immagine/save")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(immagine)))
				.andExpect(status().isOk());
		
	}
	
	@Test
	public void postOtuputResultOkTest() throws JsonProcessingException, Exception {
		
		MvcResult result = mockMvc.perform(post("/immagine/save")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(immagine)))
				.andReturn();
		
		String responseBody = result.getResponse().getContentAsString();
		
		Immagine immagineReturned = objectMapper.readValue(responseBody, Immagine.class);
		
		assertThat(immagine.getPercorso().compareTo(immagineReturned.getPercorso()));
		
		
	}
	
	
	
	@Test
	public void updateReturnOkTest() throws JsonProcessingException, Exception {
		
		mockMvc.perform(put("immagine/update")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(immagine)))
				.andExpect(status().isOk());
		
		
		
	}
	
	
	
	@Test
	public void DeleteImmagineTest() throws Exception {
	    this.mockMvc.perform(MockMvcRequestBuilders
	            .delete("/immagine/cancellabyidproposta/1")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk());
	}
	
	
	
	
	


}
