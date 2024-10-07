package tn.esprit.sae7.restController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.sae7.entity.User;
import tn.esprit.sae7.service.IUserService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserRestController {
    IUserService userService;

    @PostMapping
    public User ajouterUser(@RequestBody User user) {
        return userService.ajouterUser(user);
    }

    @PutMapping("/{id}")
    public User modifierUser(@PathVariable Long id, @RequestBody User user) {
        if (id == null) {
            throw new RuntimeException("User ID must not be null for update.");
        }
        user.setIdUser(id);
        return userService.modifierUser(user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User with ID " + id + " has been deleted.";
    }

    @GetMapping
    public List<User> fetchUserList() {
        return userService.fetchUserList();
    }

    @GetMapping("/{id}")
    public User fetchUserById(@PathVariable Long id) {
        return userService.fetchUserById(id);
    }
}
