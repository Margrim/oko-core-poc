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
@Table(name = "voivodeship", schema = "public", catalog = "oko")
public class VoivodeshipEntity {

    @Id
    @Column(name = "id_voivodeship", nullable = false)
    @GeneratedValue(generator = "voivodeship_id_generator")
    @SequenceGenerator(name = "voivodeship_id_generator",
            sequenceName = "voivodeship_id_sequence",
            allocationSize = 1
    )
    @NotNull
    private Integer idVoivodeship;

    @Basic
    @Column(name = "name")
    @Size(max = 20)
    private String name;

}
