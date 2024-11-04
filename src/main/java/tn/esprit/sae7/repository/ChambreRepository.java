package tn.esprit.sae7.repository;

import tn.esprit.sae7.entity.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {
    List<Chambre> findByNumeroChambreIn(List<Long> numeroChambre);
}
