package br.com.pinkeritours.repository;

import br.com.pinkeritours.entity.ImovelEntity;
import java.util.List;
import java.util.Objects;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

@Repository
public class ImovelRepositoryImpl implements CustomImovelRepository {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public List<ImovelEntity> find(String tipo, String status, String cidade, String bairro) {
    var jpql = new StringBuilder();
    jpql.append("from ImovelEntity i join fetch i.endereco "
        + "where i.tipo = :tipo and i.status = :status ");

    if (StringUtils.hasLength(cidade)) {
      jpql.append("and i.endereco.cidade = :cidade ");
    }

    if (StringUtils.hasLength(bairro)) {
      jpql.append("and i.endereco.bairro = :bairro ");
    }

    return entityManager.createQuery(jpql.toString(), ImovelEntity.class)
        .setParameter("tipo", tipo)
        .setParameter("status", status)
        .setParameter("cidade", cidade)
        .setParameter("bairro", bairro)
        .getResultList();
  }

}
