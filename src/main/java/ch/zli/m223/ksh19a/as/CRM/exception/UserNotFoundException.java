package ch.zli.m223.ksh19a.as.CRM.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        this("");
    }

    public UserNotFoundException(String message) {
        super(message, null, false, false);
    }
}
