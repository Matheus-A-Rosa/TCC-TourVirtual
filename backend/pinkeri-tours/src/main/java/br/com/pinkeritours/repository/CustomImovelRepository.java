package br.com.pinkeritours.repository;

import br.com.pinkeritours.entity.ImovelEntity;
import java.util.List;

public interface CustomImovelRepository {

  List<ImovelEntity> find(String tipo, String status, String cidade, String bairro);
}
