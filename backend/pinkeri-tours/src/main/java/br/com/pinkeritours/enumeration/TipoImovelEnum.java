package br.com.pinkeritours.enumeration;

import lombok.Getter;

import java.util.Optional;
import java.util.stream.Stream;

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
