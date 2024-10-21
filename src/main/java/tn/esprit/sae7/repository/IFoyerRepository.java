package tn.esprit.sae7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.sae7.entity.Foyer;

public interface IFoyerRepository extends JpaRepository<Foyer, Long> {
    Foyer findByIdFoyer(InternalError idFoyer);
}
