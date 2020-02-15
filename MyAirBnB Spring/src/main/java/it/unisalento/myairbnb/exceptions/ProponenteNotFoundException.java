package it.unisalento.myairbnb.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND, reason = "Proponente Not Found")

public class ProponenteNotFoundException extends Exception{

}
