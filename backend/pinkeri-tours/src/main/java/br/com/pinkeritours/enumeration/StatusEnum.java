package br.com.pinkeritours.enumeration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

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
