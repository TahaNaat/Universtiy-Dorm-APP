package tn.esprit.sae7.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.sae7.entity.Cours;
import tn.esprit.sae7.entity.Foyer;
import tn.esprit.sae7.entity.Universite;
import tn.esprit.sae7.entity.User;
import tn.esprit.sae7.repository.ICourseRepository;
import tn.esprit.sae7.repository.IFoyerRepository;
import tn.esprit.sae7.repository.IUniversiteRepository;
import tn.esprit.sae7.repository.IUserRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {
    IUserRepository userRepository;
    ICourseRepository courseRepository;

    @Override
    public List<User> fetchUserList() {
        return userRepository.findAll();
    }

    @Override
    public User fetchUserById(Long idUser) {
        return userRepository.findById(idUser)
                .orElseThrow(() -> new RuntimeException("User with ID " + idUser + " does not exist."));
    }

    @Override
    public List<User> fetchUsersByName(String nom) {
        return userRepository.findByNomContainingIgnoreCase(nom);
    }

    @Override
    public User fetchUserByNomAndDateNaissance(String nom, LocalDate dateNaissance) {
        return (User) userRepository.findByNomAndDateNaissance(nom, dateNaissance)
                .orElseThrow(() -> new RuntimeException("User not found with the given name and birthdate."));
    }

    @Override
    public User addUserAndAssignToCourse(User user, String nomCours) {
        //1ere etape recuperation
        Cours cours = courseRepository.findByNom(nomCours);
        //affectation parent.setFils(fils)
        user.getCours().add(cours);
        //persister enregistrer
        return userRepository.save(user);
    }



    @Override
    public User ajouterUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User modifierUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long idUser) { // Changed from Void to void
        if (userRepository.existsById(idUser)) {
            userRepository.deleteById(idUser);
        } else {
            throw new RuntimeException("User with ID " + idUser + " does not exist.");
        }
    }
}
