package tn.esprit.sae7.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.sae7.entity.User;
import tn.esprit.sae7.repository.IUserRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {
    IUserRepository userRepository;

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
