package daca.qma.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FOUND)
public class TutorRegistrationException extends Exception {
	
	public TutorRegistrationException (String message){
		super(message);
	}

}
