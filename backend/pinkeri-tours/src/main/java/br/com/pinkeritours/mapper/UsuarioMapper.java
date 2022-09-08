package br.com.pinkeritours.mapper;

import br.com.pinkeritours.dto.UsuarioRequestDTO;
import br.com.pinkeritours.dto.UsuarioResponseDTO;
import br.com.pinkeritours.entity.UsuarioEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = EnderecoMapper.class)
public interface UsuarioMapper {

  UsuarioEntity requestDtoToEntity(UsuarioRequestDTO requestDTO);

  UsuarioResponseDTO entityToDTO(UsuarioEntity entity);

}
