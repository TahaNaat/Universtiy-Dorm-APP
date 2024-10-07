package tn.esprit.sae7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.sae7.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
}
