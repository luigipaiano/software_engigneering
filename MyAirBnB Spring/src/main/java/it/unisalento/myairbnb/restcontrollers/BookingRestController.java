package it.unisalento.myairbnb.restcontrollers;

import java.util.Date;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.unisalento.myairbnb.dto.BookingDTO;
import it.unisalento.myairbnb.dto.UserDTO;

@RestController
@RequestMapping("/booking")
public class BookingRestController {
	
	
	@RequestMapping(
			value="/get/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public BookingDTO get(@PathVariable int id) {
		BookingDTO bookingDTO = new BookingDTO();
		UserDTO user = new UserDTO();
		bookingDTO.setId(id);
		bookingDTO.setCheckin(new Date());
		bookingDTO.setDaynumber(4);
		bookingDTO.setPrice(40);
		user.setId(3232);
		user.setName("Epaminonda");
		user.setSurname("Diaz");
		bookingDTO.setUser(user);
		return bookingDTO;
	}

	
}
