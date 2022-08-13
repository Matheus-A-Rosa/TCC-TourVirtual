package br.com.pinkeritours.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(BAD_REQUEST)
public class ErrorBusinessException extends RuntimeException {

  public ErrorBusinessException(String message) {
    super(message);
  }
}
