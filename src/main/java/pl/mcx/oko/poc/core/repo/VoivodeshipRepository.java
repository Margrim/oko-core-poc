package pl.mcx.oko.poc.core.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mcx.oko.poc.core.model.VoivodeshipEntity;

import java.util.Optional;

@Repository
public interface VoivodeshipRepository extends JpaRepository<VoivodeshipEntity, Integer> {

    Optional<VoivodeshipEntity> findByName(String name);
}
