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
@Table(name = "entity_type", schema = "public", catalog = "oko")
public class EntityTypeEntity {

    @Id
    @Column(name = "id_entity_type")
    @GeneratedValue(generator = "entity_type_id_generator")
    @SequenceGenerator(name = "entity_type_id_generator",
            sequenceName = "entity_type_id_sequence",
            allocationSize = 1
    )
    @NotNull
    private Integer idEntityType;

    @Basic
    @Column(name = "entity_type")
    @Size(max = 255)
    private String entityType;

}
