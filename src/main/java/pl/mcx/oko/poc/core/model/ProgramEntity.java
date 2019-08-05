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
@Table(name = "program", schema = "public", catalog = "oko")
public class ProgramEntity {

    @Id
    @Column(name = "id_program", nullable = false)
    @GeneratedValue(generator = "program_id_generator")
    @SequenceGenerator(name = "program_id_generator",
            sequenceName = "program_id_sequence",
            allocationSize = 1
    )
    @NotNull
    private Integer idProgram;

    @Basic
    @Column(name = "name")
    @Size(max = 255)
    private String name;

}
