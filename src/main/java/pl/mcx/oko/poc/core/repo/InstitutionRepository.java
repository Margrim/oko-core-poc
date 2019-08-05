package pl.mcx.oko.poc.core.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mcx.oko.poc.core.model.InstitutionEntity;

import java.util.Optional;

@Repository
public interface InstitutionRepository extends JpaRepository <InstitutionEntity, Long>{

    Optional<InstitutionEntity> findByName(String name);

}
