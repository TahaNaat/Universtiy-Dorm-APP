package tn.esprit.sae7.repository;

import tn.esprit.sae7.entity.Bloc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlocRepository extends JpaRepository<Bloc, Long> { }
