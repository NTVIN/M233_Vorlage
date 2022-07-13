package ch.zli.m223.ksh19a.as.CRM.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException() {
        this("");
    }

    public UserAlreadyExistsException(String message) {
        super(message, null, false, false);
    }
}
