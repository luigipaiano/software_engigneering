package it.unisalento.myairbnb.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND, reason = "Acquirente Not Found")
		
public class AcquirenteNotFoundException extends Exception{

}
