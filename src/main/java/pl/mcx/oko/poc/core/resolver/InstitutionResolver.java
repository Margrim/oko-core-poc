package pl.mcx.oko.poc.core.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import lombok.AllArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Component;
import pl.mcx.oko.poc.core.model.AddressEntity;
import pl.mcx.oko.poc.core.model.EntityTypeEntity;
import pl.mcx.oko.poc.core.model.InstitutionEntity;
import pl.mcx.oko.poc.core.repo.AddressRepository;
import pl.mcx.oko.poc.core.repo.EntityTypeRepository;

import java.util.Optional;

@Component
@AllArgsConstructor
public class InstitutionResolver implements GraphQLResolver<AddressEntity> {

    public AddressRepository addressRepository;
    public EntityTypeRepository entityTypeRepository;

//    public List<AddressEntity> getAddressFromInstitution(InstitutionEntity entity){
//        return entity.getAddressList()
//                .stream()
//                .map(a -> addressRepository
//                        .findById(a.getIdAddress())
//                        .orElseThrow(ResourceNotFoundException::new))
//                .collect(Collectors
//                        .toList());
//    }

    public AddressEntity getAddressFromInstitution(InstitutionEntity entity){
        Optional<AddressEntity> optional = addressRepository
                .findById(entity
                        .getAddress()
                        .getIdAddress());
        return optional.orElseThrow(ResourceNotFoundException::new);
    }

    public EntityTypeEntity getEntityTypeFromInstitution(InstitutionEntity entity){
        Optional<EntityTypeEntity> optional = entityTypeRepository
                .findById(entity.
                        getEntityType()
                        .getIdEntityType());
        return optional.orElseThrow(ResourceNotFoundException::new);
    }
}
