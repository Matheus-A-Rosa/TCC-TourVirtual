package br.com.pinkeritours.repository;

import br.com.pinkeritours.entity.ImovelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImovelRepository extends JpaRepository<ImovelEntity, Long> {

}
