package br.com.pinkeritours.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class StandardError {

  private final int status;
  private final String message;

}
