package br.com.pinkeritours.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ResponseStatus(BAD_REQUEST)
public class ErrorBusinessException extends RuntimeException {

    public ErrorBusinessException(String message) {
        super(message);
    }
}
