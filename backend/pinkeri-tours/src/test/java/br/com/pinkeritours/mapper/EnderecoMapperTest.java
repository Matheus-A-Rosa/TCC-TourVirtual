package br.com.pinkeritours.mapper;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import br.com.pinkeritours.dto.EnderecoDTO;
import br.com.pinkeritours.entity.EnderecoEntity;
import br.com.pinkeritours.uttils.EnderecoUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EnderecoMapperTest {

  @InjectMocks
  private EnderecoMapper mapper;

  @Test
  void dtoToEntity() {
    EnderecoDTO dto = EnderecoUtils.getEnderecoDTO();
    EnderecoEntity entity = mapper.dtoToEntity(dto);

    assertAll(
        () -> assertEquals(entity.getCep(), dto.getCep()),
        () -> assertEquals(entity.getRua(), dto.getRua().toUpperCase()),
        () -> assertEquals(entity.getBairro(), dto.getBairro().toUpperCase()),
        () -> assertEquals(entity.getCidade(), dto.getCidade().toUpperCase()),
        () -> assertEquals(entity.getComplemento(), dto.getComplemento().toUpperCase())
    );

  }

  @Test
  void entityToDTO() {
    EnderecoEntity entity = EnderecoUtils.getEnderecoEntity();
    EnderecoDTO dto = mapper.entityToDTO(entity);

    assertAll(
        () -> assertEquals(dto.getCep(), entity.getCep()),
        () -> assertEquals(dto.getRua(), entity.getRua().toUpperCase()),
        () -> assertEquals(dto.getBairro(), entity.getBairro().toUpperCase()),
        () -> assertEquals(dto.getCidade(), entity.getCidade().toUpperCase()),
        () -> assertEquals(dto.getComplemento(), entity.getComplemento().toUpperCase())
    );
  }

  @Test
  void removerAcentoString() {
    assertEquals("aeio", EnderecoMapper.removerAcentoString("áèîõ"));
  }
}