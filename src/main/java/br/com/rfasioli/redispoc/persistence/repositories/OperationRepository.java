package br.com.rfasioli.redispoc.persistence.repositories;

import br.com.rfasioli.redispoc.persistence.entities.OperationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OperationRepository extends CrudRepository<OperationEntity, UUID> {
}
