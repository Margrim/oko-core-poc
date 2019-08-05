package pl.mcx.oko.poc.core.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mcx.oko.poc.core.model.AddressEntity;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

    Optional<AddressEntity> findByCity(String city);
}
