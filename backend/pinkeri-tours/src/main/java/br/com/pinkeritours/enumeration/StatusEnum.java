package br.com.pinkeritours.enumeration;

import java.util.Optional;
import java.util.stream.Stream;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum StatusEnum {

  VENDA("Vende-se"),
  ALUGUEL("Aluga-se");

  private final String descricao;

  public static Optional<StatusEnum> findByStatus(String descricao) {
    return Stream.of(values())
        .filter(status -> status.name().equalsIgnoreCase(descricao))
        .findFirst();
  }

}
