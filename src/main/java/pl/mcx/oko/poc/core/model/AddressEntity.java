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
@Table(name = "address", schema = "public", catalog = "oko")
public class AddressEntity {

    @Id
    @Column(name = "id_address")
    @GeneratedValue(generator = "address_id_generator")
    @SequenceGenerator(name = "address_id_generator",
            sequenceName = "address_id_sequence",
            allocationSize = 1
    )
    @NotNull
    private Long idAddress;

    @Basic
    @Column(name = "county")
    @Size(max = 100)
    private String county;

    @Basic
    @Column(name = "city")
    @Size(max = 100)
    private String city;

    @Basic
    @Column(name = "municipality")
    @Size(max = 100)
    private String municipality;

    @Basic
    @Column(name = "street")
    @Size(max = 100)
    private String street;

    @Basic
    @Column(name = "number")
    @Size(max = 20)
    private String number;

    @Basic
    @Column(name = "flat_number")
    @Size(max = 10)
    private String flatNumber;

    @Basic
    @Column(name = "postal_code")
    @Size(max = 6)
    private String postalCode;

    @OneToOne
    @JoinColumn(name = "id_institution", referencedColumnName = "id_institution")
    private InstitutionEntity institution;

    @ManyToOne
    @JoinColumn(name = "id_voivodeship", referencedColumnName = "id_voivodeship")
    private VoivodeshipEntity voivodeship;
}
