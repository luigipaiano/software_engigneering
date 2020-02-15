package it.unisalento.myairbnb.restcontroller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.security.Timestamp;
import java.sql.Date;
import java.text.SimpleDateFormat;

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

import it.unisalento.myairbnb.entities.Pagamento;
import it.unisalento.myairbnb.entities.Utente;
import it.unisalento.myairbnb.restcontrollers.PagamentoRestController;
import it.unisalento.myairbnb.restcontrollers.UtenteRestController;
import it.unisalento.myairbnb.service.PagamentoService;
import it.unisalento.myairbnb.service.UtenteService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = PagamentoRestController.class)
class PagamentoRestControllerTest {


	@Autowired
	private MockMvc mockMvc;
	
	
	@MockBean
	private PagamentoService pagamentoServicemock;
	
	
	@Autowired
	private ObjectMapper objectMapper;
	
	Pagamento pagamento;
	
	
	@BeforeEach
	private void setUp() {
		
        pagamento = new Pagamento();
        //u.setIdutente(1); non va fatto il set dell'id perché è autoincroment
      
        pagamento.setMetodo("metodo_prova");
        //pagamento.setImporto(649959604.456);
	}
	
	
	
	
	@Test
	public void saveReturnOk() throws JsonProcessingException, Exception {
		
		
		mockMvc.perform(MockMvcRequestBuilders.post("/pagamento/save")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(pagamento)))
				.andExpect(status().isOk());
		
	}
	
	@Test
	public void postOtuputResultOkTest() throws JsonProcessingException, Exception {
		
		MvcResult result = mockMvc.perform(post("/pagamento/save")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(pagamento)))
				.andReturn();
		
		String responseBody = result.getResponse().getContentAsString();
		
		Pagamento pagamentoReturned = objectMapper.readValue(responseBody, Pagamento.class);
		
		assertThat(pagamento.getMetodo().compareTo(pagamentoReturned.getMetodo()));
		
		
	}
	
	
	
	
	@Test
	public void getAllReturnOkTest() throws Exception {
		
		mockMvc.perform(get("/pagamento/getAll")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
	
	}
	
	
	
	
	@Test
	public void getByIdReturnOkTest() throws Exception {
		
		mockMvc.perform(get("/pagamento/getByIdPagamento/1")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
		
		
		
	}
	
}
