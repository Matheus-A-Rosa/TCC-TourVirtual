package br.com.pinkeritours.enumeration;

import java.util.Optional;
import java.util.stream.Stream;
import lombok.Getter;

@Getter
public enum TipoImovelEnum {

  CASA,
  APARTAMENTO;

  public static Optional<TipoImovelEnum> findByTipoImovel(String tipo) {
    return Stream.of(values())
        .filter(status -> status.name().equalsIgnoreCase(tipo))
        .findFirst();
  }

}
