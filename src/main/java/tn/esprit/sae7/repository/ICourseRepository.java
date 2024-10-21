package tn.esprit.sae7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.sae7.entity.Cours;

public interface ICourseRepository extends JpaRepository<Cours, Long> {
    Cours findByNom(String nom);
}
