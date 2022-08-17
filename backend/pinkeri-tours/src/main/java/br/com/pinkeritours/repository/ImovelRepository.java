package br.com.pinkeritours.repository;

import br.com.pinkeritours.entity.ImovelEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ImovelRepository extends JpaRepository<ImovelEntity, Long> {

  @Query(value = "from ImovelEntity i join fetch i.endereco",
      countQuery = "select count(i) from ImovelEntity i ")
  Page<ImovelEntity> listar(Pageable pageable);

}
