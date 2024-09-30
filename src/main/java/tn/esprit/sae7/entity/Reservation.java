package tn.esprit.sae7.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Reservation {
    @Id
    String idReservation;
    LocalDate anneeUniversitaire;
    boolean estValide;
    @ManyToMany(mappedBy="reservations", cascade = CascadeType.ALL)
    private Set<Etudiant>etudiants;


}
