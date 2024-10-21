package tn.esprit.sae7.service;

import tn.esprit.sae7.entity.User;

import java.time.LocalDate;
import java.util.List;

public interface IUserService {
    User ajouterUser (User user);
    User modifierUser(User user);
    void deleteUser(Long idUser);
    List<User> fetchUserList();
    User fetchUserById(Long idUser);
    List<User> fetchUsersByName(String nom);

    User fetchUserByNomAndDateNaissance(String nom, LocalDate dateNaissance);
    User addUserAndAssignToCourse(User user,String nom);
}
