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
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idChambre;
    Long numeroChambre;
    @Enumerated(EnumType.ORDINAL)
    TypeChmabre typeC;
    @OneToMany (cascade = CascadeType.ALL)
    private Set<Reservation> reservations;
    @ManyToOne
    Bloc bloc;


}
