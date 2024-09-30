package tn.esprit.sae7.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idFoyer;
    String nomFoyer;
    Long capaciteFoyer ;
    @OneToOne(mappedBy = "foyer")
    private Universite universite;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "foyer")
    Set<Bloc>blocs;

}
