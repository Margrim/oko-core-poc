package pl.mcx.oko.poc.core.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.mcx.oko.poc.core.model.AddressEntity;
import pl.mcx.oko.poc.core.model.EntityTypeEntity;
import pl.mcx.oko.poc.core.model.InstitutionEntity;
import pl.mcx.oko.poc.core.model.VoivodeshipEntity;
import pl.mcx.oko.poc.core.repo.AddressRepository;
import pl.mcx.oko.poc.core.repo.InstitutionRepository;

@Component
@AllArgsConstructor
public class Mutation implements GraphQLMutationResolver {

    private InstitutionRepository institutionRepository;
    private AddressRepository addressRepository;

    public AddressEntity addAddress(String city, String street, String number, Integer idVoivodeship) {
        AddressEntity entity = AddressEntity
                .builder()
                .city(city)
                .street(street)
                .number(number)
                .voivodeship(VoivodeshipEntity
                        .builder()
                        .idVoivodeship(idVoivodeship)
                        .build())
                .build();
        return addressRepository.save(entity);
    }


    public InstitutionEntity addInstitution(String name,
                                            String nip,
                                            Integer idEntityType,
                                            String city,
                                            String street,
                                            String number,
                                            Integer idVoivodeship) {

        AddressEntity addressEntity = addAddress(city, street, number, idVoivodeship);
        addressRepository.save(addressEntity);

        InstitutionEntity institutionEntity = InstitutionEntity.builder()
                .name(name)
                .nip(nip)
                .entityType(EntityTypeEntity
                        .builder()
                        .idEntityType(idEntityType)
                        .build())
                .address(addressEntity)
                .build();
        institutionRepository.save(institutionEntity);

        addressEntity.setInstitution(InstitutionEntity
                .builder()
                .idInstitution(institutionEntity.getIdInstitution())
                .build());
        addressRepository.save(addressEntity);

        return institutionEntity;
    }

}
