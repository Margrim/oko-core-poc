package pl.mcx.oko.poc.core.resolver;

import lombok.AllArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Component;
import pl.mcx.oko.poc.core.model.AddressEntity;
import pl.mcx.oko.poc.core.model.InstitutionEntity;
import pl.mcx.oko.poc.core.model.VoivodeshipEntity;
import pl.mcx.oko.poc.core.repo.InstitutionRepository;
import pl.mcx.oko.poc.core.repo.VoivodeshipRepository;

import java.util.Optional;

@Component
@AllArgsConstructor
public class AddressResolver {

    private InstitutionRepository institutionRepository;
    private VoivodeshipRepository voivodeshipRepository;

    public InstitutionEntity getInstitutionFromAddress(AddressEntity entity) {
        Optional<InstitutionEntity> optional = institutionRepository
                .findById(entity
                        .getInstitution()
                        .getIdInstitution());
        return optional.orElseThrow(ResourceNotFoundException::new);
    }

    public VoivodeshipEntity getVoivodeshipFromAddress(AddressEntity entity) {
        Optional<VoivodeshipEntity> optional = voivodeshipRepository
                .findById(entity
                        .getVoivodeship()
                        .getIdVoivodeship());
        return optional.orElseThrow(ResourceNotFoundException::new);
    }
}
