package br.com.pinkeritours.repository;

import br.com.pinkeritours.entity.ImovelEntity;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

@Repository
public class ImovelRepositoryImpl implements CustomImovelRepository {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public List<ImovelEntity> find(String tipo, String status, String cidade, String bairro,
      Double valorInicial, Double valorFinal) {
    var jpql = new StringBuilder("from ImovelEntity i join fetch i.endereco "
        + "where i.tipo = :tipo and i.status = :status ");

    var parametros = new HashMap<String, Object>();
    parametros.put("tipo", tipo);
    parametros.put("status", status);

    if (StringUtils.hasLength(cidade)) {
      jpql.append("and i.endereco.cidade = :cidade ");
      parametros.put("cidade", cidade.toUpperCase());
    }

    if (StringUtils.hasLength(bairro)) {
      jpql.append("and i.endereco.bairro = :bairro ");
      parametros.put("bairro", bairro.toUpperCase());
    }

    if (Objects.nonNull(valorInicial)) {
      jpql.append("and i.valor >= :valorInicial ");
      parametros.put("valorInicial", valorInicial);
    }

    if (Objects.nonNull(valorFinal)) {
      jpql.append("and i.valor <= :valorFinal ");
      parametros.put("valorFinal", valorFinal);
    }

    jpql.append("order by i.id ");
    TypedQuery<ImovelEntity> query = entityManager.createQuery(jpql.toString(), ImovelEntity.class);
    parametros.forEach(query::setParameter);
    return query.getResultList();
  }

}
