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
@ToString
//@Data ; deconseille de lutiliser
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long idUser;
    String nom;
    String prenom;
    LocalDate dateNaissance;
    @Enumerated(EnumType.ORDINAL)
    StatuSocial status;
    @ManyToMany
    Set<Cours>cours;

    public void setStatuSocial(StatuSocial status) {
        this.status = status;

    }
}
