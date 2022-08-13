package br.com.pinkeritours.exception;

import java.util.List;
import lombok.Getter;

@Getter
public class ValidationError extends StandardError {

  private final List<FieldMessage> errors;

  public ValidationError(int status, String message, List<FieldMessage> errors) {
    super(status, message);
    this.errors = errors;
  }
}
