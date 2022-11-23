package br.com.pinkeritours.service;

import static br.com.pinkeritours.uttils.UsuarioUtils.getUsuarioEntity;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import br.com.pinkeritours.exception.NotFoundException;
import br.com.pinkeritours.repository.UsuarioRepository;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

  @InjectMocks
  private UsuarioService service;


  @Mock
  private UsuarioRepository repository;


  @Test
  void quandoBuscarPorId_comIdInvalido_retornaErro() {
    Long id = anyLong();

    when(repository.findById(id))
        .thenReturn(Optional.empty());

    assertThatThrownBy(() -> service.buscarPorId(id))
        .isInstanceOf(NotFoundException.class)
        .hasMessage(String.format("Usuário %d não encontrado", id));

  }

  @Test
  void quandoBuscarUsuarioPorId_retornaSucesso() {
    Long id = anyLong();
    when(repository.findById(id))
        .thenReturn(Optional.of(getUsuarioEntity()));
    assertNotNull(service.buscarPorId(id));
  }

}