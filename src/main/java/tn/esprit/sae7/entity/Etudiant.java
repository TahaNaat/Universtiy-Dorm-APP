package tn.esprit.sae7.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idEtudiant;
    String nomE;
    String prenomE;
    Long cin;
    String ecole;
    LocalDate dateNaissance;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Reservation> reservations ;

}
