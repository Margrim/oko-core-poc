package pl.mcx.oko.poc.core.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mcx.oko.poc.core.model.ProgramEntity;

import java.util.Optional;

@Repository
public interface ProgramRepository extends JpaRepository<ProgramEntity, Integer> {

    Optional<ProgramEntity> findByName(String name);
}
