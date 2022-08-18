package br.com.pinkeritours.repository;

import br.com.pinkeritours.entity.ImovelEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface ImovelRepository
    extends JpaRepository<ImovelEntity, Long>, CustomImovelRepository {

  @Query(value = "from ImovelEntity i join fetch i.endereco",
      countQuery = "select count(i) from ImovelEntity i")
  Page<ImovelEntity> listar(Pageable pageable);

  @Query(value = "from ImovelEntity i "
      + "join fetch i.endereco "
      + "where i.tipo = :tipo and i.status = :status",
      countQuery = "select count(i) from ImovelEntity i where i.tipo = :tipo and i.status = :status")
  Page<ImovelEntity> buscarPorTipoImovelStatus(Pageable pageable,
      @RequestParam("tipo") String tipo,
      @RequestParam("status") String status);
}
