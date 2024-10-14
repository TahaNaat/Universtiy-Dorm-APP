package tn.esprit.sae7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.sae7.entity.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    List<User> findByNomContainingIgnoreCase(String nom);

    Optional<Object> findByNomAndDateNaissance(String nom, LocalDate dateNaissance);
}
