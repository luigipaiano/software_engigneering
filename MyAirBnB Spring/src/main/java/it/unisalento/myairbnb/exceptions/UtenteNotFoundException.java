package it.unisalento.myairbnb.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND, reason = "Utente Not Found")
public class UtenteNotFoundException extends Exception {

}


