package pl.mcx.oko.poc.core.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Component;
import pl.mcx.oko.poc.core.model.AddressEntity;
import pl.mcx.oko.poc.core.model.EntityTypeEntity;
import pl.mcx.oko.poc.core.model.InstitutionEntity;
import pl.mcx.oko.poc.core.model.ProgramEntity;
import pl.mcx.oko.poc.core.model.VoivodeshipEntity;
import pl.mcx.oko.poc.core.repo.AddressRepository;
import pl.mcx.oko.poc.core.repo.EntityTypeRepository;
import pl.mcx.oko.poc.core.repo.InstitutionRepository;
import pl.mcx.oko.poc.core.repo.ProgramRepository;
import pl.mcx.oko.poc.core.repo.VoivodeshipRepository;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class Query implements GraphQLQueryResolver {

    private final AddressRepository addressRepository;
    private final EntityTypeRepository entityTypeRepository;
    private final InstitutionRepository institutionRepository;
    private final ProgramRepository programRepository;
    private final VoivodeshipRepository voivodeshipRepository;

    //Address
    public AddressEntity findAddressById(Long idAddress) {
        Optional<AddressEntity> optional = addressRepository.findById(idAddress);
        return optional.orElseThrow(ResourceNotFoundException::new);
    }

    public AddressEntity findAddressByCity(String city) {
        Optional<AddressEntity> optional = addressRepository.findByCity(city);
        return optional.orElseThrow(ResourceNotFoundException::new);
    }

    //EntityType
    public List<EntityTypeEntity> findAllEntityTypes(){
        return entityTypeRepository.findAll();
    }

    public EntityTypeEntity findEntityTypeById(Integer idEntityType) {
        Optional<EntityTypeEntity> optional = entityTypeRepository.findById(idEntityType);
        return optional.orElseThrow(ResourceNotFoundException::new);
    }

    public EntityTypeEntity findEntityTypeByType(String entityType) {
        Optional<EntityTypeEntity> optional = entityTypeRepository.findByEntityType(entityType);
        return optional.orElseThrow(ResourceNotFoundException::new);
    }

    //Institution
    public List<InstitutionEntity> findAllInstitutions() {
        return institutionRepository.findAll();
    }

    public InstitutionEntity findInstitutionById(Long idInstituion){
        Optional<InstitutionEntity> optional = institutionRepository.findById(idInstituion);
        return optional.orElseThrow(ResourceNotFoundException::new);
    }

    public InstitutionEntity findInstitutionByName(String name) {
        Optional<InstitutionEntity> optional = institutionRepository.findByName(name);
        return optional.orElseThrow(ResourceNotFoundException::new);
    }

//Program
    public ProgramEntity findProgramById(Integer idProgram){
        Optional<ProgramEntity> optional = programRepository.findById(idProgram);
        return optional.orElseThrow(ResourceNotFoundException::new);
    }

    public ProgramEntity findProgramByName(String name){
        Optional<ProgramEntity> optional = programRepository.findByName(name);
        return  optional.orElseThrow(ResourceNotFoundException::new);
    }
//Voivodeship
    public List<VoivodeshipEntity> findAllVoivodeships(){
        return voivodeshipRepository.findAll();
    }

    public VoivodeshipEntity findVoivodeshipById(Integer idVoivodeship){
        Optional<VoivodeshipEntity> optional = voivodeshipRepository.findById(idVoivodeship);
        return optional.orElseThrow(ResourceNotFoundException::new);
    }

    public VoivodeshipEntity findVoivodeshipByName(String name){
        Optional<VoivodeshipEntity> optional = voivodeshipRepository.findByName(name);
        return optional.orElseThrow(ResourceNotFoundException::new);
    }
}
