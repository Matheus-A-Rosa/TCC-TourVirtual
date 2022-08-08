package br.com.pinkeritours.mapper;

import br.com.pinkeritours.dto.ImovelRequestDTO;
import br.com.pinkeritours.dto.ImovelResponseDTO;
import br.com.pinkeritours.entity.ImovelEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ImovelMapper {

    @Named("validarUF")
    static String validarUF(String uf) {
        return uf.toUpperCase();
    }

    @Mapping(source = "endereco.uf", target = "endereco.uf", qualifiedByName = "validarUF")
    ImovelEntity requestDtoToEntity(ImovelRequestDTO requestDTO);

    ImovelResponseDTO entityToResponseDTO(ImovelEntity entity);

}
