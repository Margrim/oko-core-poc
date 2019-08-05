package pl.mcx.oko.poc.core.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mcx.oko.poc.core.model.EntityTypeEntity;

import java.util.Optional;

@Repository
public interface EntityTypeRepository extends JpaRepository<EntityTypeEntity, Integer> {

    Optional<EntityTypeEntity> findByEntityType(String type);
}
