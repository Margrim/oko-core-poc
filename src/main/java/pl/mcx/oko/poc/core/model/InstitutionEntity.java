package pl.mcx.oko.poc.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "institution", schema = "public", catalog = "oko")
public class InstitutionEntity {

    @Id
    @Column(name = "id_institution")
    @GeneratedValue(generator = "institution_id_generator")
    @SequenceGenerator(name = "institution_id_generator",
            sequenceName = "institution_id_sequence",
            allocationSize = 1
    )
    @NotNull
    private Long idInstitution;

    @Basic
    @Column(name = "name")
    @Size(max = 255)
    private String name;

    @Basic
    @Column(name = "nip")
    @Size(max = 10)
    private String nip;

    @OneToOne(mappedBy = "institution")
    private AddressEntity address;

    @ManyToOne
    @JoinColumn(name = "id_entity_type", referencedColumnName = "id_entity_type")
    private EntityTypeEntity entityType;

}
