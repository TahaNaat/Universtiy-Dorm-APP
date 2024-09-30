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
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idBloc;
    String nomBloc;
    Long capaciteBloc;
    @ManyToOne
    Foyer foyer;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="bloc")
    private Set<Chambre> chambres;

}
