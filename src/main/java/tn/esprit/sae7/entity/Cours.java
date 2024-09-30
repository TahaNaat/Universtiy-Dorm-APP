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
//@ToString
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idCourse;
    String nom;
    @ManyToMany(mappedBy = "cours" )
    Set<User>users;
}
