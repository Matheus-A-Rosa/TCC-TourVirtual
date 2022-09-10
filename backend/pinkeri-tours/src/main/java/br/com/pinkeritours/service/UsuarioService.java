package br.com.pinkeritours.service;

import br.com.pinkeritours.entity.UsuarioEntity;
import br.com.pinkeritours.exception.NotFoundException;
import br.com.pinkeritours.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsuarioService {

  private final UsuarioRepository repository;

  public UsuarioEntity findById(Long id) {
    return repository.findById(id)
        .orElseThrow(() -> new NotFoundException(String.format("Usuário %d não encontrado", id)));
  }
}
